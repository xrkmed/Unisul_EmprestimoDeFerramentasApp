package Views.Screens;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.ToolsDAO;
import Views.TelaInicial;

public class ScreenFerramentas extends ScreenEntity {

    private final String[] columnNames = {"ID", "Nome", "Fabricante", "Preço", "Em uso por", "Data de devoluçao"};

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
        getTitulo().setText(getName());

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
                getTable().getColumnModel().getColumn(0).setPreferredWidth(35);
                getTable().getColumnModel().getColumn(0).setMinWidth(35);
                getTable().getColumnModel().getColumn(0).setMaxWidth(35);
                getTable().getColumnModel().getColumn(0).setResizable(false);
                getTable().getColumnModel().getColumn(1).setResizable(false);
                getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
                getTable().getColumnModel().getColumn(2).setResizable(false);
                getTable().getColumnModel().getColumn(3).setResizable(false);
                getTable().getColumnModel().getColumn(4).setResizable(false);
                getTable().getColumnModel().getColumn(4).setPreferredWidth(100);
                getTable().getColumnModel().getColumn(5).setResizable(false);
                getTable().getColumnModel().getColumn(5).setPreferredWidth(100);
            }

            for (Object[] data : datas) {
                if (!data[4].toString().equals("Disponivel")) {
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

                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnEditar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnVisualizar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnExportar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

}