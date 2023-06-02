package Views.Screens;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Resources.DirectoryChooserFrame;
import Resources.ManufacturerResource;
import Views.TelaInicial;
import ViewsManufacturer.TelaCadastroFabricantes;
import com.itextpdf.text.Paragraph;

public class ScreenFabricantes extends ScreenEntity {

    private final String[] columnNames = {"ID", "Nome", "CNPJ", "Ferramentas", "Em Uso", "Valor total"};

    public ScreenFabricantes() {
        super();
    }

    public ScreenFabricantes(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Lista de Fabricantes";
    }

    @Override
    public void init() {
        getBtnCadastro().addActionListener(e -> {
            btnCadastro();
        });

        getBtnEditar().addActionListener(e -> {
            btnEditar();
        });

        getBtnDeletar().addActionListener(e -> {
            btnDeletar();
        });

        getBtnVisualizar().addActionListener(e -> {
            btnVisualizar();
        });

        getBtnExportar().addActionListener(e -> {
            btnExportar();
        });
    }

    // AQUI OCORRE O LOAD DA TABELA E A FORMATAÇÃO DOS DADOS
    @Override
    public void carregarDados() {
        try {
            StatusRenderer renderer = new StatusRenderer();

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            ;
            };

            getTable().setModel(model);

            ((DefaultTableModel) getTable().getModel()).setRowCount(0);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                getTable().getColumnModel().getColumn(1).setMinWidth(486);
                getTable().getColumnModel().getColumn(2).setMinWidth(169);
                getTable().getColumnModel().getColumn(2).setMaxWidth(169);
                getTable().getColumnModel().getColumn(3).setMinWidth(109);
                getTable().getColumnModel().getColumn(3).setMaxWidth(109);
                getTable().getColumnModel().getColumn(4).setMinWidth(78);
                getTable().getColumnModel().getColumn(4).setMaxWidth(78);
                getTable().getColumnModel().getColumn(5).setMinWidth(149);
                getTable().getColumnModel().getColumn(5).setMaxWidth(200);
            }

            ArrayList<Object[]> manufacturerData = ManufacturerDAO.getInstance().getFabricantesData();

            for (Object[] data : manufacturerData) {
                if (Integer.parseInt(data[3].toString()) == Integer.parseInt(data[4].toString())) {
                    if (Integer.parseInt(data[3].toString()) > 0) {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    } else {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightOrange);
                    }

                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }

                }

                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {
        new TelaCadastroFabricantes().setVisible(true);
    }

    public void btnEditar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {
        int id = (int)getTable().getValueAt(getTable().getSelectedRow(), 0);
        try {
            ManufacturerResource ManuDel = ManufacturerDAO.getInstance().getManufacturer(id);
            if (ManuDel != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o fabricante " + ManuDel.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (!ToolsDAO.getInstance().getToolsByManufacturer(ManuDel.getId()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não é possível remover um fabricante que possui ferramentas cadastradas!");
                        return;
                    }

                    ManufacturerDAO.getInstance().removeManufacturer(ManuDel.getId());
                    carregarDados();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fabricante", "Erro", JOptionPane.ERROR_MESSAGE);
        }    }

    public void btnVisualizar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnExportar() {
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame();

        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (directoryChooserFrame.getSelectedDirectory().length() > 0) {
                    try {
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATORIO", 10);
                        String fileName = "RelatorioFabricantes";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente novamente mais tarde...");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente selecionar um diretorio valido!");
                }
            }
        });
    }

}
