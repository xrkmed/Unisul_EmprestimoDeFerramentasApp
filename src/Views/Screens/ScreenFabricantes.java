package Views.Screens;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Exceptions.DatabaseResultQueryException;
import Resources.DirectoryChooserFrame;
import Resources.ManufacturerResource;
import Views.TelaInicial;
import ViewsManufacturer.TelaCadastroFabricantes;
import com.itextpdf.text.Paragraph;
import java.sql.SQLException;

public class ScreenFabricantes extends ScreenEntity {

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

            
            if(getFiltros().getSelectedItem() != null){
                FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                if(f.getType() == FiltrosEnum.FILTRO_GERAR){
                    f.run();
                    return;
                }
            }

            ArrayList<Object[]> manufacturerData = ManufacturerDAO.getInstance().getFabricantesData();

            if (getFiltros().getSelectedItem() != null) {
                FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                if (f.getType() == FiltrosEnum.FILTRO_ORDENAR) {
                    manufacturerData.sort((Object[] data1, Object[] data2) -> {
                        return f.compare(data1, data2);
                    });
                }
            }

            for (Object[] data : manufacturerData) {
                if (getFiltros().getSelectedItem() != null) {
                    FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                    if (f.getType() == FiltrosEnum.FILTRO_FILTRAR && !f.run(data)) {
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
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {
       
        try {
             int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ManufacturerResource ManuDel = ManufacturerDAO.getInstance().getManufacturer(id);
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
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Nada selecionado vei");
            e.printStackTrace();
        }catch( DatabaseResultQueryException e){
            System.out.println("Talvez o banco de dados explodiu, mas não retornou nada");
            e.printStackTrace();
        } catch( SQLException e){
            System.out.println("Os comandos enviados SQL enviados tem algum problema");
            e.printStackTrace();
        }
 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fabricante", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

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
    public DefaultComboBoxModel<FiltrosClass> get() {
        return new javax.swing.DefaultComboBoxModel<>(new FiltrosClass[]{
            new FiltrosOrdenar("ID"),
            new FiltrosOrdenar("Nome Crescente", (data1, data2) -> {
                String nome1 = (String) data1[1];
                String nome2 = (String) data2[1];
                return nome1.compareToIgnoreCase(nome2);
            })
        })
        ;
    }

}
