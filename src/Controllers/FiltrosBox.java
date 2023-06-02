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
                    try {            
                        StatusRenderer renderer = new StatusRenderer();
                        ((DefaultTableModel) screen.getTable().getModel()).setRowCount(0);
                        ArrayList<Object[]> emprestimosEmAberto = LoansDAO.getInstance().getEmprestimosEmAberto();
                        ArrayList<Object[]> emprestimosFinalizados = LoansDAO.getInstance().relatorioEmprestimos();
                        ArrayList<Object[]> emprestimos = new ArrayList<>();
                        for(Object[] emprestimo : emprestimosEmAberto){
                            emprestimos.add(emprestimo);
                        }
                         for(Object[] emprestimo : emprestimosFinalizados){
                             emprestimos.add(new Object[]{emprestimo[0], emprestimo[1], emprestimo[2], emprestimo[3], "Finalizado em " + emprestimo[4], emprestimo[8], emprestimo[6], emprestimo[7]});
                         }
                         screen.getTitulo().setText("Todos os emprestimos");
            
                        for (Object[] data : emprestimos) {
                            if(data[4].toString().contains("Finalizado em")){
                                renderer.addHighlightedRow(screen.getTable().getModel().getRowCount(), ColorsRenderer.lightGreen);
                                for (int i = 0; i < screen.getTable().getColumnCount(); i++) {
                                    screen.getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                                }
                            }else{
                                if (Integer.parseInt(data[4].toString()) > 0 && Integer.parseInt(data[4].toString()) <= 7) {
                                    renderer.addHighlightedRow(screen.getTable().getModel().getRowCount(), ColorsRenderer.lightYellow);
                                    for (int i = 0; i < screen.getTable().getColumnCount(); i++) {
                                        screen.getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                                    }
                                }
            
                                if (Integer.parseInt(data[4].toString()) < 0) {
                                    renderer.addHighlightedRow(screen.getTable().getModel().getRowCount(), ColorsRenderer.lightRed);
                                    for (int i = 0; i < screen.getTable().getColumnCount(); i++) {
                                        screen.getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                                    }
                                }
                            }
            
                            ((DefaultTableModel) screen.getTable().getModel()).addRow(data);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
                    }

                    return null;
                }),
                new FiltrosGerar("Emprestimos finalizados", () -> {
                    try {            
                        String[] columnNames = {"ID", "Amigo", "Data Início", "Data Devoluçao", "Data Finalizado", "Observações", "Num. Ferramentas", "V. Total Ferramentas", "V. Recebido", "Ferramentas"};
                        DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                            boolean[] canEdit = new boolean[]{
                                false, false, false, false, false, false, false, false, false, false
                            };
            
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                            };
                        };
            
                        screen.getTable().setModel(model);
            
                        ((DefaultTableModel) screen.getTable().getModel()).setRowCount(0);
            
                        if (screen.getTable().getColumnModel().getColumnCount() > 0) {
                            screen.getTable().getColumnModel().getColumn(0).setMinWidth(65);
                            screen.getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                        }

                        screen.getTitulo().setText("Emprestimos finalizados");
            
                        for (Object[] data : LoansDAO.getInstance().relatorioEmprestimos()) {            
                            ((DefaultTableModel) screen.getTable().getModel()).addRow(data);
            
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
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
