package ViewsTool;

import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import ViewsEmprestimo.TelaCadastroEmprestimo;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import DAO.ToolsDAO;
import Model.ToolModel;

public class TelaSelecionarFerramenta extends javax.swing.JFrame {

    private ToolModel selectedTool = null;
    private JFrame parent = null;

    public TelaSelecionarFerramenta() {
        initComponents();
        initFrameConfig();
    }

    public TelaSelecionarFerramenta(JFrame parent) {
        this();
        this.parent = parent;
    }

    private void initFrameConfig() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ((DefaultTableModel) jTable2.getModel()).setRowCount(0);

                jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jTable2.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = jTable2.getSelectedRow();
                        try {
                            if (selectedRow != -1) {
                                selecionadoNome.setText(jTable2.getValueAt(selectedRow, 2).toString());
                                selecionadoManufacturer.setText(jTable2.getValueAt(selectedRow, 3).toString());

                                selectedTool = ToolsDAO.getInstance().getTool(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                            } else {
                                selectedTool = null;
                                selecionadoNome.setText("");
                                selecionadoManufacturer.setText("");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                });

                jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
                jTable2.getColumnModel().getColumn(0).setMinWidth(35);
                jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

                loadValores();
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        textFiltrarNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSelecionarFerramenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrarFerramenta = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        selecionadoManufacturer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Ferramenta - Grupo Supimpa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Fabricante", "Preço", "Em uso por", "Data de devoluçao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jLayeredPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Selecinar Ferramenta");

        textFiltrarNome.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        textFiltrarNome.setToolTipText("Busca por Nome");
        textFiltrarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFiltrarNomeActionPerformed(evt);
            }
        });
        textFiltrarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarNomeKeyReleased(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/magnify-custom.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSelecionarFerramenta.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnSelecionarFerramenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/check-bold-custom.png"))); // NOI18N
        btnSelecionarFerramenta.setToolTipText("Selecionar Ferramenta");
        btnSelecionarFerramenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSelecionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarFerramentaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Fabricante:");

        btnCadastrarFerramenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/tools-custom (1).png"))); // NOI18N
        btnCadastrarFerramenta.setToolTipText("Cadastrar Ferramenta");
        btnCadastrarFerramenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCadastrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFerramentaActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnSelecionarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCadastrarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnCadastrarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSelecionarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSelecionarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        selecionadoManufacturer.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Fabricante");

        selecionadoNome.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Ferramenta");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Ferramenta Selecionada");

        jLayeredPane1.setLayer(selecionadoManufacturer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selecionadoManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionadoManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadValores() {
        try {
            ArrayList<Object[]> datas = ToolsDAO.getInstance().getFerramentasValue();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            StatusRenderer statusRenderer = new StatusRenderer();
            //new Object[]{result.getInt("id"), "-", result.getString("name"), result.getString("razao_social"), BRLResource.PRICE_FORMATTER.format(result.getDouble("price")), result.getString("nome"), new SimpleDateFormat("dd/MM/yyyy").format(result.getDate("endDate").toString())});
            for (Object[] data : datas) {

                if (textFiltrarNome.getText().trim().length() > 0) {
                    if (!data[2].toString().toLowerCase().contains(textFiltrarNome.getText().toLowerCase())) {
                        continue;
                    }
                }

                if (!data[5].toString().equals("Disponivel")) {
                    continue;
                }

                if (data[3].toString().equalsIgnoreCase("sem fabricante")) {
                    statusRenderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);

                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(statusRenderer);
                    }
                }

                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnSelecionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarFerramentaActionPerformed
        if (selectedTool != null) {
            if (parent != null) {
                if (parent instanceof TelaCadastroEmprestimo) {
                    ((TelaCadastroEmprestimo) parent).addFerramenta(selectedTool);
                }
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma ferramenta", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarFerramentaActionPerformed

    private void filtroFiltrarNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroFiltrarNome1ActionPerformed

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased

    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCadastrarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFerramentaActionPerformed
        new TelaCadastroFerramentas().setVisible(true);
    }//GEN-LAST:event_btnCadastrarFerramentaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelecionarFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrarFerramenta;
    private javax.swing.JButton btnSelecionarFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField selecionadoManufacturer;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField textFiltrarNome;
    // End of variables declaration//GEN-END:variables

}
