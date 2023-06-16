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
import DAO.ToolsDAO;
import Model.ToolModel;
import Controllers.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsTool.TelaCadastroFerramentas;
import com.itextpdf.text.Paragraph;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScreenFerramentas extends ScreenModel {

    private final String[] columnNames = {"ID", "Nome", "Fabricante", "Preço", "Em Uso Por", "Data Devolução"};

    public ScreenFerramentas() {
        super();
    }

    public ScreenFerramentas(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Ferramentas";
    }

    @Override
    public Object getSelectedValue() {
        return getTable().getValueAt(getTable().getSelectedRow(), 0);
    }

    @Override
    public void init() {
        super.init();
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

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_GERAR) {
                    f.run();
                    return;
                }
            }

            ArrayList<Object[]> datas = ToolsDAO.getInstance().getFerramentasValue();

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_ORDENAR) {
                    datas.sort((Object[] data1, Object[] data2) -> {
                        return f.compare(data1, data2);
                    });
                }
            }

            for (Object[] data : datas) {
                if (getFiltros().getSelectedItem() != null) {
                    FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                    if (f.getType() == Filtros.FILTRO_FILTRAR && !f.run(data)) {
                        continue;
                    }
                }
                if (!getCampoNomeFiltroLupa().getText().equals("")) {
                    if (!data[1].toString().trim().contains(getCampoNomeFiltroLupa().getText().toUpperCase().trim())) {
                        continue;
                    }
                }

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

                if (!data[5].toString().equalsIgnoreCase("disponivel")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = sdf.parse(data[5].toString());
                    Date now = new Date();
                    if (date.before(now)) {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                        for (int i = 0; i < getTable().getColumnCount(); i++) {
                            getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                        }
                    }
                }

                data[3] = "R$" + data[3].toString();
                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Os Dados Da Tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {
        new TelaCadastroFerramentas().setVisible(true);
    }

    public void btnEditar() {
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ToolModel selectedTool = ToolsDAO.getInstance().getTool(id);
            new TelaCadastroFerramentas(selectedTool, ScreenSelectionType.SCREEN_TYPE_EDIT).setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Selecione Uma Ferramenta Primeiro");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeletar() {

        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ToolModel toolsDel = ToolsDAO.getInstance().getTool(id);

            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Realmente Remover a Ferramenta" + toolsDel.getNome() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.NO_OPTION) {

                return;
            }

            if (!toolsDel.isAvailable()) {
                JOptionPane.showMessageDialog(null, "Não é Possível Remover Uma Ferramenta Que Esta Em Uso Por Algum Amigo.");
                return;
            }

            ToolsDAO.getInstance().removeTool(toolsDel);
            carregarDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnVisualizar() {
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            ToolModel selectedTool = ToolsDAO.getInstance().getTool(id);
            new TelaCadastroFerramentas(selectedTool, ScreenSelectionType.SCREEN_TYPE_VIEW).setVisible(true);
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
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATÓRIO FERRAMENTAS", 10);
                        String fileName = "RelatorioFerramentas";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado Com Sucesso Em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Não Foi Possível Exportar o PDF, Tente Novamente Mais Tarde!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não Foi Possível Exportar o PDF, Tente Selecionar Um Diretório Válido!");
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
                return ((String) data1[1]).compareTo((String) data2[1]);
            }),});
    }

}
