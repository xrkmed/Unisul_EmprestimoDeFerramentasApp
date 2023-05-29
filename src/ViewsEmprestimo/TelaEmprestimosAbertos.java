package ViewsEmprestimo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.LoansDAO;
import Model.LoanModel;

public class TelaEmprestimosAbertos extends javax.swing.JFrame {

    private LoanModel selectedLoan = null;

    public TelaEmprestimosAbertos() {
        initComponents();
        configFrame();
    }

    private void configFrame() {
        Thread loadValues = new Thread(new Runnable() {
            @Override
            public void run() {
                jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
                jTable2.getColumnModel().getColumn(0).setMinWidth(35);
                jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

                ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
                jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jTable2.getSelectionModel().addListSelectionListener(x -> {
                    try {
                        if (!x.getValueIsAdjusting()) {
                            int selectedRow = jTable2.getSelectedRow();
                            if (selectedRow != -1) {
                                selecionadoAmigo.setText(jTable2.getValueAt(selectedRow, 1).toString());
                                selecionadoDataDevolucao.setText(jTable2.getValueAt(selectedRow, 3).toString());

                                selectedLoan = LoansDAO.getInstance().getLoan(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                            } else {
                                selectedLoan = null;
                                selecionadoAmigo.setText("");
                                selecionadoDataDevolucao.setText("");
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                });

                loadValores();
            }
        });

        loadValues.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        canvas3 = new java.awt.Canvas();
        jLabel9 = new javax.swing.JLabel();
        canvas2 = new java.awt.Canvas();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selecionadoAmigo = new javax.swing.JTextField();
        btnAlterarEmprestimo = new javax.swing.JButton();
        selecionadoDataDevolucao = new javax.swing.JTextField();
        btnRemoverCadastro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnFinalizarEmprestimo = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        filtroFiltrarNome = new javax.swing.JCheckBox();
        textFiltrarNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empréstimos Abertos - Grupo Supimpa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amigo", "Data Início", "Data Devolução", "Dias Restantes", "A Receber", "Qtd. Ferramentas", "Valor Ferramentas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(280);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("EMPRÉSTIMOS ATRASADOS");

        canvas3.setBackground(new java.awt.Color(255, 57, 57));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("VENCIMENTO EM SETE DIAS");
        jLabel9.setToolTipText("Exibe Somente Ferramentas Que Vencem em Sete Dias");

        canvas2.setBackground(new java.awt.Color(255, 255, 224));

        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addGap(92, 92, 92))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇÕES");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Amigo:");

        selecionadoAmigo.setEditable(false);

        btnAlterarEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAlterarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        btnAlterarEmprestimo.setText("Alterar Empréstimo");
        btnAlterarEmprestimo.setToolTipText("Abre um Menu Para Alterar As Informações do Empréstimo");
        btnAlterarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarEmprestimoActionPerformed(evt);
            }
        });

        selecionadoDataDevolucao.setEditable(false);

        btnRemoverCadastro.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemoverCadastro.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverCadastro.setText("Cancelar Empréstimo");
        btnRemoverCadastro.setToolTipText("Encerra o Empréstimo Sem Nenhuma Confirmação");
        btnRemoverCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCadastroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Data Devolução:");

        btnFinalizarEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinalizarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        btnFinalizarEmprestimo.setText("Finalizar Empréstimo");
        btnFinalizarEmprestimo.setToolTipText("Encerra o Empréstimo ");
        btnFinalizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarEmprestimoActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoAmigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnAlterarEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoDataDevolucao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRemoverCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnFinalizarEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selecionadoDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(selecionadoAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnFinalizarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(btnAlterarEmprestimo))
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnFinalizarEmprestimo))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)))
                .addGap(10, 10, 10)
                .addComponent(selecionadoAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionadoDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverCadastro))
                .addGap(15, 15, 15))
        );

        jLayeredPane2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        filtroFiltrarNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroFiltrarNome.setText("Filtrar por nome:");
        filtroFiltrarNome.setToolTipText("Buscar Por Uma Ferramenta em Especifico");
        filtroFiltrarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroFiltrarNomeActionPerformed(evt);
            }
        });

        textFiltrarNome.setEnabled(false);
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

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("FILTROS");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(filtroFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(filtroFiltrarNome)
                        .addGap(10, 10, 10)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(btnBuscar)))))
                .addGap(18, 18, 18))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filtroFiltrarNome)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addComponent(btnBuscar)
                .addGap(15, 15, 15))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opçoes");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLayeredPane1)
                        .addGap(15, 15, 15)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane2))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void loadValores() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //CONFIGURACOES DA TABELA
            model.setRowCount(0);
            selectedLoan = null;
            selecionadoAmigo.setText("");
            selecionadoDataDevolucao.setText("");

            StatusRenderer renderer = new StatusRenderer();
            //statusRed.addHighlightedRow(1, Color.RED);

            for (Object[] data : LoansDAO.getInstance().getEmprestimosEmAberto()) {
                if (filtroFiltrarNome.isSelected() && textFiltrarNome.getText().trim().length() > 0) {
                    if (!data[1].toString().toUpperCase().contains(textFiltrarNome.getText().toUpperCase().trim())) {
                        continue;
                    }
                }

                if (Integer.parseInt(data[4].toString()) > 0 && Integer.parseInt(data[4].toString()) <= 7) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (Integer.parseInt(data[4].toString()) < 0) {
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnAlterarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarEmprestimoActionPerformed
        if (selectedLoan != null) {
            TelaCadastroEmprestimo tela = new TelaCadastroEmprestimo(selectedLoan);
            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadValores();
                }
            });
        }
    }//GEN-LAST:event_btnAlterarEmprestimoActionPerformed

    private void btnRemoverCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCadastroActionPerformed
        try {
            if (selectedLoan != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o emprestimo de " + jTable2.getValueAt(jTable2.getSelectedRow(), 1) + "?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    LoansDAO dao = LoansDAO.getInstance();
                    dao.removeLoan(selectedLoan.getId());
                    loadValores();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o emprestimo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemoverCadastroActionPerformed

    private void btnFinalizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarEmprestimoActionPerformed
        if (selectedLoan != null) {
            TelaFinalizarEmprestimo tela = new TelaFinalizarEmprestimo(selectedLoan, jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
            tela.setVisible(true);
            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadValores();
                }
            });
        }
    }//GEN-LAST:event_btnFinalizarEmprestimoActionPerformed

    private void filtroFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNomeActionPerformed
        if (filtroFiltrarNome.isSelected()) {
            textFiltrarNome.setEnabled(true);
        } else {
            textFiltrarNome.setEnabled(false);
        }
    }//GEN-LAST:event_filtroFiltrarNomeActionPerformed

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased

    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimosAbertos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarEmprestimo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFinalizarEmprestimo;
    private javax.swing.JButton btnRemoverCadastro;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox filtroFiltrarNome;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField selecionadoAmigo;
    private javax.swing.JTextField selecionadoDataDevolucao;
    private javax.swing.JTextField textFiltrarNome;
    // End of variables declaration//GEN-END:variables

}
