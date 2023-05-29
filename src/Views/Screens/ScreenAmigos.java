package Views.Screens;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.FriendsDAO;
import Views.TelaInicial;

public class ScreenAmigos extends ScreenEntity{

    private final String[] columnNames = {"ID", "Nome", "Telefone", "Endereço", "Empr. Abertos", "Empr. Atrasados"};
    
    public ScreenAmigos(){
        super();
    }

    public ScreenAmigos(TelaInicial telaInicial){
        super(telaInicial);
    }

    @Override
    public String getName(){
        return "Lista Amigos";
    }

    @Override
    public void init(){
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
    public void carregarDados(){
        try {
            StatusRenderer renderer = new StatusRenderer();
            //statusRed.addHighlightedRow(1, Color.RED);
            ArrayList<Object[]> amigosData = FriendsDAO.getInstance().loadFriendsTabela();

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames){
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                };
            };

            getTable().setModel(model);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                getTable().getColumnModel().getColumn(1).setPreferredWidth(350);
                getTable().getColumnModel().getColumn(2).setPreferredWidth(150);
                getTable().getColumnModel().getColumn(3).setPreferredWidth(400);
                getTable().getColumnModel().getColumn(4).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(4).setMaxWidth(110);
                getTable().getColumnModel().getColumn(5).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(5).setMaxWidth(110);
            }

            for (Object[] data : amigosData) {
                if (Integer.parseInt(data[4].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (Integer.parseInt(data[5].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
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
    public void btnCadastro(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnEditar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnVisualizar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnExportar(){
        JOptionPane.showMessageDialog(null, "working!");
    }
    
}