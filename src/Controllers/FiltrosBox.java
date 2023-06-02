package Controllers;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controllers.Filtros.FiltrosFiltrar;
import Controllers.Filtros.FiltrosGerar;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.LoansDAO;
import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEmprestimos;
import Views.Screens.ScreenEntity;

public class FiltrosBox {

    public static DefaultComboBoxModel<FiltrosClass> get(ScreenEntity screen) {
        if (screen instanceof ScreenAmigos) {
            return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
                new FiltrosFiltrar("Empréstimos em Aberto", (Object[] data) -> {
                    return (int) data[4] > 0;
                }),
                new FiltrosFiltrar("Empréstimos em Atraso", (Object[] data) -> {
                    return (int) data[5] > 0;
                }),
                new FiltrosOrdenar("Nome Crescente", (data1, data2) -> {
                    return ((String) data1[1]).compareTo((String) data2[1]);
                }),
                new FiltrosOrdenar("Nome Decrescente", (data1, data2) -> {
                    return -((String) data1[1]).compareTo((String) data2[1]);
                }),});
        }

        if (screen instanceof ScreenEmprestimos) {
            return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
                new FiltrosGerar("Todos os emprestimos", () -> {
                    try{
                        ArrayList<Object[]> emprestimosEmAberto = LoansDAO.getInstance().getEmprestimosEmAberto();
                        ArrayList<Object[]> emprestimosFinalizados = LoansDAO.getInstance().relatorioEmprestimos();

                        ArrayList<Object[]> emprestimos = new ArrayList<>();

                        for(Object[] emprestimo : emprestimosEmAberto){
                            emprestimos.add(emprestimo);
                        }

                         for(Object[] emprestimo : emprestimosFinalizados){
                             emprestimos.add(new Object[]{emprestimo[0], emprestimo[1], emprestimo[2], emprestimo[3], "Finalizado em " + emprestimo[4], emprestimo[8], emprestimo[6], emprestimo[7]});
                         }

                         screen.getTable().getColumnModel().getColumn(4).setWidth(360);
                         screen.getTitulo().setText("Todos os emprestimos");

                        return emprestimos;
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
                    }

                    return null;
                }),
                new FiltrosGerar("Emprestimos finalizados", () -> {
                    try{
                        ArrayList<Object[]> emprestimosFinalizados = LoansDAO.getInstance().relatorioEmprestimos();

                         screen.getTable().getColumnModel().getColumn(4).setWidth(360);
                         String[] columnNames = {"ID", "Amigo", "Data Início", "Data Devoluçao", "Data Finalizado", "Observações", "Num. Ferramentas", "V. Total Ferramentas", "V. Recebido", "Ferramentas"};
                         screen.getTable().setModel(new DefaultTableModel(new Object[0][0], columnNames){
                            boolean[] canEdit = new boolean[]{
                                false, false, false, false, false, false, false, false, false, false
                            };
            
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                            };
                         });

                         screen.getTable().getColumnModel().getColumn(0).setMaxWidth(35);

                         screen.getTitulo().setText("Emprestimos finalizados");

                        return emprestimosFinalizados;
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
                    }

                    return null;
                }),
            });
        }

        /*here*/
        return new javax.swing.DefaultComboBoxModel<>(new FiltrosClass[]{new FiltrosClass("")});
    }

}

// if(screen instanceof ScreenEmprestimos){
        //     return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
        //         new FiltrosClass(screen, "Filtrar por nome", (ScreenEntity s) -> {
        //             //funcao aqui
        //             return null;
        //         }),
        //     });
        // }
