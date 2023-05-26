package Views;

public class NewTela extends javax.swing.JFrame {

    public NewTela() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        btnMais = new javax.swing.JButton();
        btnAmigos = new javax.swing.JButton();
        btnEmprestimos = new javax.swing.JButton();
        bntFerramentas = new javax.swing.JButton();
        bntFabricantes = new javax.swing.JButton();
        bntSeguranca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField1.setToolTipText("Busca por nome");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-plus-custom.png"))); // NOI18N
        jButton2.setToolTipText("Adicionar");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-eye-custom.png"))); // NOI18N
        jButton3.setToolTipText("Modo Leitura");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-remove-custom.png"))); // NOI18N
        jButton4.setToolTipText("Deletar");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-edit-custom.png"))); // NOI18N
        jButton5.setToolTipText("Editar");
        jButton5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/magnify-custom.png"))); // NOI18N
        jButton1.setToolTipText("Buscar");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "ID", "Nome", "Emp. Pendente" }));
        jComboBox1.setToolTipText("Selecione um filtro");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Filtros:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista Amigos");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-export-custom (2).png"))); // NOI18N
        jButton6.setToolTipText("Exportar Relatório");
        jButton6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLayeredPane1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/cog-custom.png"))); // NOI18N
        btnMais.setToolTipText("Mais Opções");
        btnMais.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/account-group-custom.png"))); // NOI18N
        btnAmigos.setToolTipText("Amigos");
        btnAmigos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAmigos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnAmigosMouseDragged(evt);
            }
        });

        btnEmprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/hand-coin-custom-removebg-preview.png"))); // NOI18N
        btnEmprestimos.setToolTipText("Empréstimos");
        btnEmprestimos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bntFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/tools-custom.png"))); // NOI18N
        bntFerramentas.setToolTipText("Ferramentas");
        bntFerramentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bntFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFerramentasActionPerformed(evt);
            }
        });

        bntFabricantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/anvil-custom.png"))); // NOI18N
        bntFabricantes.setToolTipText("Fabricantes");
        bntFabricantes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bntSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/lock-open-custom.png"))); // NOI18N
        bntSeguranca.setToolTipText("Segurança");
        bntSeguranca.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLayeredPane3.setLayer(btnMais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnAmigos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bntFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bntFabricantes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(bntSeguranca, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(btnAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Nome", "Telefone", "Endereço", "Emp. Abertos", "Emp. Atrasados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(65);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(65);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(110);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(110);
        }

        jMenu1.setText("Opções");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Relatórios");

        jMenuItem1.setText("Relatório Amigos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Relatório Ferramentas");
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Relatório Fabricantes");
        jMenu4.add(jMenuItem3);

        jMenuItem8.setText("Relatório Empréstimos Finalizados");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Financeiro");

        jMenuItem4.setText("Controle Financeiro Empréstimos");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Gastos Ferramentas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Personalização");

        jMenuItem6.setText("Visual Claro");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Visual Noturno");
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sair");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jLayeredPane1))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3)
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAmigosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAmigosMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAmigosMouseDragged

    private void bntFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFerramentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntFerramentasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewTela().setVisible(true);
            }
        });
    }

    private void loadValores() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //CONFIGURACOES DA TABELA
            model.setRowCount(0);
            selectedFriend = null;
            selecionadoNome.setText("");
            selecionadoTelefone.setText("");

            StatusRenderer renderer = new StatusRenderer();
            //statusRed.addHighlightedRow(1, Color.RED);
            ArrayList<Object[]> amigosData = FriendsDAO.getInstance().loadFriendsTabela();
            if (filtrarRanque.isSelected()) {
                switch (rankType.getSelectedItem().toString().toLowerCase()) {
                    case "nome": {
                        amigosData.sort((Object[] object1, Object[] object2) -> {
                            String s1 = (String) object1[1];
                            String s2 = (String) object2[1];
                            return s1.compareTo(s2);
                        });
                        break;
                    }
                    case "emprestimos em aberto": {
                        amigosData.sort((Object[] object1, Object[] object2) -> {
                            Integer i1 = (Integer) object1[4];
                            Integer i2 = (Integer) object2[4];
                            return i2.compareTo(i1);
                        });
                        break;
                    }
                    case "emprestimos atrasados": {
                        amigosData.sort((Object[] object1, Object[] object2) -> {
                            Integer i1 = (Integer) object1[5];
                            Integer i2 = (Integer) object2[5];
                            return i2.compareTo(i1);
                        });
                        break;
                    }
                    default:
                        break;
                }
            }

            for (Object[] data : amigosData) {
                if (filtroAmigosEmEmprestimo.isSelected() && data[4].toString().equals("0")) {
                    continue;
                }
                if (filtroAmigosDevolverFerramenta.isSelected() && data[5].toString().equals("0")) {
                    continue;
                }
                if (filtroAmigosSemEmprestimoAberto.isSelected() && !data[4].toString().equals("0") && !data[6].toString().equals("0")) {
                    continue;
                } else {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.white);
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }
                if (filtroFiltrarNome.isSelected() && textFiltrarNome.getText().trim().length() > 0) {
                    if (!data[1].toString().toUpperCase().contains(textFiltrarNome.getText().toUpperCase().trim())) {
                        continue;
                    }
                }

                if (filtroEndereco.isSelected() && textFiltrarEndereco.getText().trim().length() > 0) {
                    if (!data[3].toString().toUpperCase().contains(textFiltrarEndereco.getText().toUpperCase().trim())) {
                        continue;
                    }
                }

                if (Integer.parseInt(data[4].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (Integer.parseInt(data[5].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                model.addRow(data);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFabricantes;
    private javax.swing.JButton bntFerramentas;
    private javax.swing.JButton bntSeguranca;
    private javax.swing.JButton btnAmigos;
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
