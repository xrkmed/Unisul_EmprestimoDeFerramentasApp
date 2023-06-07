package ViewsTool;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.ToolsDAO;
import Model.ToolModel;
import Model.ManufacturerModel;

public class TelaPainelFerramentas extends javax.swing.JFrame {

    private ToolModel selectedTool = null;
    private ManufacturerModel manufacturer = null;

    public TelaPainelFerramentas() {
        initComponents();
        configFrame();
    }

    public TelaPainelFerramentas(ManufacturerModel manufacturer) {
        this();
        this.manufacturer = manufacturer;
        this.setTitle("Ferramentas do Fabricante " + manufacturer.getName());
    }

    private void configFrame() {
        Thread pStart = new Thread(new Runnable() {
            @Override
            public void run() {
                ferramentasSemFab.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = ferramentasSemFab.getSelectedRow();
                        if (selectedRow != -1) {
                            try {
                                selectedTool = ToolsDAO.getInstance().getTool((int) ferramentasSemFab.getValueAt(selectedRow, 0));
                                ferramentasList.clearSelection();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Erro ao selecionar ferramenta: " + e.getMessage());
                            }
                        }
                    }
                });
                ((DefaultTableModel) ferramentasSemFab.getModel()).setRowCount(0);
                ferramentasSemFab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                ferramentasList.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = ferramentasList.getSelectedRow();
                        if (selectedRow != -1) {
                            try {
                                selectedTool = ToolsDAO.getInstance().getTool((int) ferramentasList.getValueAt(selectedRow, 0));
                                ferramentasSemFab.clearSelection();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Erro ao selecionar ferramenta: " + e.getMessage());
                            }
                        }
                    }
                });
                ((DefaultTableModel) ferramentasList.getModel()).setRowCount(0);
                ferramentasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                try {
                    loadList(ferramentasList, ToolsDAO.getInstance().getToolsByManufacturer(manufacturer.getId()));
                    loadList(ferramentasSemFab, ToolsDAO.getInstance().getToolsWithoutManufacturer());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar ferramentas: " + e.getMessage());
                }
            }
        });
        pStart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ferramentasSemFab = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        canvas2 = new java.awt.Canvas();
        jLabel8 = new javax.swing.JLabel();
        canvas4 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        btnRemFabricante = new javax.swing.JButton();
        btnCadFabricante = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ferramentasList = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        canvas3 = new java.awt.Canvas();
        jLabel9 = new javax.swing.JLabel();
        canvas5 = new java.awt.Canvas();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel de Ferramentas - Grupo Supimpa");
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ferramentasSemFab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ferramentasSemFab);
        if (ferramentasSemFab.getColumnModel().getColumnCount() > 0) {
            ferramentasSemFab.getColumnModel().getColumn(0).setResizable(false);
            ferramentasSemFab.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setText("Em uso por algum amigo");

        canvas2.setBackground(new java.awt.Color(255, 255, 224));

        jLabel8.setText("Em manutençao");

        canvas4.setBackground(new java.awt.Color(255, 0, 255));

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("FERRAMENTAS SEM FABRICANTES");

        btnRemFabricante.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        btnRemFabricante.setText("<");
        btnRemFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemFabricanteActionPerformed(evt);
            }
        });

        btnCadFabricante.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        btnCadFabricante.setText(">");
        btnCadFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(466, 524));

        ferramentasList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ferramentasList);
        if (ferramentasList.getColumnModel().getColumnCount() > 0) {
            ferramentasList.getColumnModel().getColumn(0).setResizable(false);
            ferramentasList.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setText("Em uso por algum amigo");

        canvas3.setBackground(new java.awt.Color(255, 255, 224));

        jLabel9.setText("Em manutençao");

        canvas5.setBackground(new java.awt.Color(255, 0, 255));

        jLayeredPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(canvas3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(canvas5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(canvas5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21))
        );

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("FERRAMENTAS DESTE FABRICANTE");

        jButton3.setText("Concluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                            .addComponent(jLayeredPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(btnCadFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFabricanteActionPerformed
        try {
            if (selectedTool != null && selectedTool.getManufacturer() == null) {
                ToolsDAO.getInstance().updateManufacturer(selectedTool.getId(), manufacturer.getId());
                loadList(ferramentasList, ToolsDAO.getInstance().getToolsByManufacturer(manufacturer.getId()));
                loadList(ferramentasSemFab, ToolsDAO.getInstance().getToolsWithoutManufacturer());
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma ferramenta sem fabricante para adicionar o fabricante selecionado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar fabricante: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCadFabricanteActionPerformed

    private void btnRemFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemFabricanteActionPerformed
        try {
            if (selectedTool != null && selectedTool.getManufacturer().getId() == manufacturer.getId()) {
                ToolsDAO.getInstance().updateManufacturer(selectedTool.getId(), -1);
                loadList(ferramentasList, ToolsDAO.getInstance().getToolsByManufacturer(manufacturer.getId()));
                loadList(ferramentasSemFab, ToolsDAO.getInstance().getToolsWithoutManufacturer());
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma ferramenta deste fabricante para remover o fabricante");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fabricante: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemFabricanteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void loadList(JTable table, ArrayList<ToolModel> tools) {
        StatusRenderer renderer = new StatusRenderer();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (ToolModel tool : tools) {
            if (!tool.isAvailable()) {
                renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
            }

            model.addRow(new Object[]{
                tool.getId(),
                tool.getNome()
            });
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPainelFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadFabricante;
    private javax.swing.JButton btnRemFabricante;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    private java.awt.Canvas canvas5;
    private javax.swing.JTable ferramentasList;
    private javax.swing.JTable ferramentasSemFab;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
