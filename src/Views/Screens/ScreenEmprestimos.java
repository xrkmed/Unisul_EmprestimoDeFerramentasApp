package Views.Screens;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import Views.TelaInicial;
import ViewsEmprestimo.TelaRelatorioEmprestimos;

public class ScreenEmprestimos extends ScreenEntity{

    private final String[] columnNames = {"ID", "Amigo", "Data Início", "Data Devolução", "Dias Restantes", "A Receber", "Qtd. Ferramentas", "Valor Ferramentas"};
    
    public ScreenEmprestimos(){
        super();
    }

    public ScreenEmprestimos(TelaInicial telaInicial){
        super(telaInicial);
    }

    @Override
    public String getName(){
        return "Empréstimos em aberto";
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

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames){
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                };
            };

            getTable().setModel(model);

            ((DefaultTableModel) getTable().getModel()).setRowCount(0);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
            }

            for(Object[] data : LoansDAO.getInstance().getEmprestimosEmAberto()){
                if(Integer.parseInt(data[4].toString()) > 0 && Integer.parseInt(data[4].toString()) <= 7){
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for(int i = 0; i < getTable().getColumnCount(); i++){
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if(Integer.parseInt(data[4].toString()) < 0){
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    for(int i = 0; i < getTable().getColumnCount(); i++){
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
        //abrir um joptionpane para confirmar se o usuario quer exportar os emprestimos em aberto ou finalizado
        int i = JOptionPane.showOptionDialog(null, "Selecione o tipo de relatorio que voce deseja exportar", "Exportar",  1, 1, null, new Object[] {"Em aberto", "Finalizados"}, null);
        if(i == 0){
            //TODO
        }else if(i == 1){
          TelaRelatorioEmprestimos telaRelatorioEmprestimos = new TelaRelatorioEmprestimos();
          telaRelatorioEmprestimos.setVisible(true);
        }
    }
    
}