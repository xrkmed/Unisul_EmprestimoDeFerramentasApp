package Views.Screens;

import Model.ScreenModel;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Model.FiltrosModel;
import Enums.Filtros;
import Controllers.PDFEntity;
import Enums.ScreenSelectionType;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Exceptions.DatabaseResultQueryException;
import Controllers.DirectoryChooserFrame;
import Model.ManufacturerModel;
import Views.TelaInicial;
import ViewsManufacturer.TelaCadastroFabricantes;
import com.itextpdf.text.Paragraph;
import java.sql.SQLException;

public class ScreenFabricantes extends ScreenModel {

    private final String[] columnNames = {"ID", "Nome", "CNPJ", "Ferramentas", "Em Uso", "Valor Total"};

    public ScreenFabricantes() {
        super();
    }

    public ScreenFabricantes(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Fabricantes";
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

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_GERAR) {
                    f.run();
                    return;
                }
            }

            ArrayList<Object[]> manufacturerData = ManufacturerDAO.getInstance().getFabricantesData();

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_ORDENAR) {
                    manufacturerData.sort((Object[] data1, Object[] data2) -> {
                        return f.compare(data1, data2);
                    });
                }
            }

            for (Object[] data : manufacturerData) {
                if (getFiltros().getSelectedItem() != null) {
                    FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                    if (f.getType() == Filtros.FILTRO_FILTRAR && !f.run(data)) {
                        continue;
                    }
                }
                if(!getCampoNomeFiltroLupa().getText().equals("")){        
                    if(!data[1].toString().trim().contains(getCampoNomeFiltroLupa().getText().toUpperCase().trim())){
                        continue;
                    }
                }

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
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ManufacturerModel selectedManufacturer = ManufacturerDAO.getInstance().getManufacturer(id);
            new TelaCadastroFabricantes(selectedManufacturer, ScreenSelectionType.SCREEN_TYPE_EDIT).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeletar() {

        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ManufacturerModel ManuDel = ManufacturerDAO.getInstance().getManufacturer(id);
            if (ManuDel != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja remover o fabricante " + ManuDel.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (!ToolsDAO.getInstance().getToolsByManufacturer(ManuDel.getId()).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não é possível remover um fabricante que possui ferramentas cadastradas!");
                        return;
                    }

                    ManufacturerDAO.getInstance().removeManufacturer(ManuDel.getId());
                    carregarDados();
                }
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnVisualizar() {
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ManufacturerModel selectedManufacturer = ManufacturerDAO.getInstance().getManufacturer(id);
            new TelaCadastroFabricantes(selectedManufacturer, ScreenSelectionType.SCREEN_TYPE_VIEW).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnExportar() {
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame();

        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (directoryChooserFrame.getSelectedDirectory().length() > 0) {
                    try {
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATÓRIO FABRICANTES", 10);
                        String fileName = "RelatorioFabricantes";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Não foi possível exportar o PDF, tente novamente mais tarde!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível exportar o PDF, tente selecionar um diretório válido!");
                }
            }
        });
    }

    /* FILTROS */
    @Override
    public DefaultComboBoxModel<FiltrosModel> get() {
        return new javax.swing.DefaultComboBoxModel<>(new FiltrosModel[]{
            new FiltrosOrdenar("ID"),
            new FiltrosOrdenar("Nome Crescente", (data1, data2) -> {
                String nome1 = (String) data1[1];
                String nome2 = (String) data2[1];
                return nome1.compareToIgnoreCase(nome2);
            })
        });
    }

}
