package Views.Screens;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.FiltrosClass;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.ToolsDAO;
import Exceptions.DatabaseResultQueryException;
import Model.ToolModel;
import Resources.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsTool.TelaCadastroFerramentas;
import com.itextpdf.text.Paragraph;
import java.sql.SQLException;


public class ScreenFerramentas extends ScreenEntity {

    private final String[] columnNames = {"ID", "Nome", "Fabricante", "Preço", "Em Uso Por", "Data Devolução"};

    public ScreenFerramentas() {
        super();
    }

    public ScreenFerramentas(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Tela Ferramentas";
    }

    @Override
    public Object getSelectedValue() {
        return getTable().getValueAt(getTable().getSelectedRow(), 0);
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
            //statusRed.addHighlightedRow(1, Color.RED);
            ArrayList<Object[]> datas = ToolsDAO.getInstance().getFerramentasValue();

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

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                getTable().getColumnModel().getColumn(1).setWidth(300);
                getTable().getColumnModel().getColumn(1).setMinWidth(100);
                getTable().getColumnModel().getColumn(2).setWidth(250);
                getTable().getColumnModel().getColumn(2).setMinWidth(75);
                //getTable().getColumnModel().getColumn(3).setMinWidth(135);
                getTable().getColumnModel().getColumn(3).setMinWidth(135);
                getTable().getColumnModel().getColumn(3).setMaxWidth(135);
                getTable().getColumnModel().getColumn(4).setWidth(195);
                getTable().getColumnModel().getColumn(5).setMinWidth(110);
                getTable().getColumnModel().getColumn(5).setMaxWidth(110);

            }

            for (Object[] data : datas) {
                if (!data[4].toString().equalsIgnoreCase("disponivel")) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (data[2].toString().equalsIgnoreCase("sem fabricante")) {
                    if (renderer.getHighlightedRow(model.getRowCount()) == ColorsRenderer.lightYellow) {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightOrange);
                    } else {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    }

                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }

                }
//                  data[3] = "R$"+data[3].toString();
                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {
        new TelaCadastroFerramentas().setVisible(true);
    }

    public void btnEditar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {

        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ToolModel toolsDel = ToolsDAO.getInstance().getTool(id);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a ferramenta " + toolsDel.getNome() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (!toolsDel.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "Não é possível remover uma ferramenta que esta em uso por algum amigo.");
                    return;
                }
            }
            ToolsDAO.getInstance().removeTool(toolsDel);
            carregarDados();
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Nada selecionado vei");
            e.printStackTrace();
        }catch( DatabaseResultQueryException e){
            System.out.println("Talvez o banco de dados explodiu, mas não retornou nada");
            e.printStackTrace();
        } catch( SQLException e){
            System.out.println("Os comandos enviados SQL enviados tem algum problema");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro desconhecido\n"+ e.getMessage());
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
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATÓRIO FERRAMENTAS", 10);
                        String fileName = "RelatorioFerramentas";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Não foi possivel exportar o PDF, tente novamente mais tarde!");
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
        });
    }

}
