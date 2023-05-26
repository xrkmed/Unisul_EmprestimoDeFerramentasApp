package Views;

import ViewsAmigos.TelaTabelaAmigos;
import ViewsEmprestimo.TelaCadastroEmprestimo;
import ViewsAmigos.TelaRelatorioAmigos;
import javax.swing.ToolTipManager;

import Controllers.ThemeController;
import Resources.Enum_Themes;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnMais = new javax.swing.JButton();
        btnAmigos = new javax.swing.JButton();
        btnEmprestimos = new javax.swing.JButton();
        bntFerramentas = new javax.swing.JButton();
        bntFabricantes = new javax.swing.JButton();
        bntSeguranca = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenu1 = new javax.swing.JMenu();
        btnCadastrarAmigo = new javax.swing.JMenuItem();
        btnViewAmigosCad = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioAmigos = new javax.swing.JMenuItem();
        btnRankingAmigos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fileMenu5 = new javax.swing.JMenu();
        btnCadastrarEmprestimo = new javax.swing.JMenuItem();
        btnEmprestimosEmAberto = new javax.swing.JMenuItem();
        btnRelatorioEmprestimo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        btnControleFinanceiro = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        fileMenu3 = new javax.swing.JMenu();
        btnCadastrarFerramenta = new javax.swing.JMenuItem();
        btnFerramentasCad = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioFerramentas = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        fileMenu6 = new javax.swing.JMenu();
        btnCadastrarFabricante = new javax.swing.JMenuItem();
        btnVisualizarFabricante = new javax.swing.JMenuItem();
        btnControleGastosFabricantes = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioFabricantes = new javax.swing.JMenuItem();
        fileMenu4 = new javax.swing.JMenu();
        btnClose = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        fileMenu2 = new javax.swing.JMenu();
        fileMenu7 = new javax.swing.JMenu();
        btnTemaDark = new javax.swing.JMenuItem();
        btnTemaLight = new javax.swing.JMenuItem();
        fileMenu8 = new javax.swing.JMenu();
        btnDevTela = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grupo Supimpa - ToolStock Manager");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/4781840_+_add_circle_create_expand_icon.png"))); // NOI18N
        btnMais.setToolTipText("Mais Opções");

        btnAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/3994366_friend_group_members_people_team_icon.png"))); // NOI18N
        btnAmigos.setToolTipText("Amigos");
        btnAmigos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnAmigosMouseDragged(evt);
            }
        });

        btnEmprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/6598164_donation_give_money_support_volunteer_icon-removebg-preview.png"))); // NOI18N
        btnEmprestimos.setToolTipText("Empréstimos");

        bntFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/8685618_ic_fluent_document_toolbox_filled_icon.png"))); // NOI18N
        bntFerramentas.setToolTipText("Ferramentas");
        bntFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFerramentasActionPerformed(evt);
            }
        });

        bntFabricantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/9070920_hammer_and_anvil_icon__1_-removebg-preview.png"))); // NOI18N
        bntFabricantes.setToolTipText("Fabricantes");

        bntSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/9004782_lock_security_secure_protect_icon.png"))); // NOI18N
        bntSeguranca.setToolTipText("Segurança");

        jLayeredPane1.setLayer(btnMais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnAmigos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bntFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bntFabricantes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bntSeguranca, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAmigos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bntFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bntFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bntSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Lucro / Dívidas");

        jLayeredPane3.setLayer(jSeparator10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Administrativo");

        fileMenu1.setMnemonic('f');
        fileMenu1.setText("Amigos");

        btnCadastrarAmigo.setMnemonic('x');
        btnCadastrarAmigo.setText("Cadastrar Novo Amigo");
        btnCadastrarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAmigoActionPerformed(evt);
            }
        });
        fileMenu1.add(btnCadastrarAmigo);

        btnViewAmigosCad.setMnemonic('x');
        btnViewAmigosCad.setText("Amigos Cadastrados");
        btnViewAmigosCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAmigosCadActionPerformed(evt);
            }
        });
        fileMenu1.add(btnViewAmigosCad);
        fileMenu1.add(jSeparator4);

        btnRelatorioAmigos.setMnemonic('x');
        btnRelatorioAmigos.setText("Relatório de Amigos");
        btnRelatorioAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioAmigosActionPerformed(evt);
            }
        });
        fileMenu1.add(btnRelatorioAmigos);

        btnRankingAmigos.setMnemonic('x');
        btnRankingAmigos.setText("Ranking de Amigos");
        btnRankingAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingAmigosActionPerformed(evt);
            }
        });
        fileMenu1.add(btnRankingAmigos);

        fileMenu.add(fileMenu1);
        fileMenu.add(jSeparator1);

        fileMenu5.setMnemonic('f');
        fileMenu5.setText("Empréstimos");

        btnCadastrarEmprestimo.setMnemonic('x');
        btnCadastrarEmprestimo.setText("Cadastrar Novo Empréstimo");
        btnCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnCadastrarEmprestimo);

        btnEmprestimosEmAberto.setMnemonic('x');
        btnEmprestimosEmAberto.setText("Empréstimos em Aberto");
        btnEmprestimosEmAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimosEmAbertoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnEmprestimosEmAberto);

        btnRelatorioEmprestimo.setMnemonic('x');
        btnRelatorioEmprestimo.setText("Relatório Empréstimos Finalizados");
        btnRelatorioEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRelatorioEmprestimo);
        fileMenu5.add(jSeparator5);

        btnControleFinanceiro.setMnemonic('x');
        btnControleFinanceiro.setText("Controle Financeiro");
        btnControleFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleFinanceiroActionPerformed(evt);
            }
        });
        fileMenu5.add(btnControleFinanceiro);

        fileMenu.add(fileMenu5);
        fileMenu.add(jSeparator2);

        fileMenu3.setMnemonic('f');
        fileMenu3.setText("Ferramentas");

        btnCadastrarFerramenta.setMnemonic('x');
        btnCadastrarFerramenta.setText("Cadastrar Ferramenta");
        btnCadastrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFerramentaActionPerformed(evt);
            }
        });
        fileMenu3.add(btnCadastrarFerramenta);

        btnFerramentasCad.setMnemonic('x');
        btnFerramentasCad.setText("Visualizar Ferramentas");
        btnFerramentasCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFerramentasCadActionPerformed(evt);
            }
        });
        fileMenu3.add(btnFerramentasCad);
        fileMenu3.add(jSeparator6);

        btnRelatorioFerramentas.setMnemonic('x');
        btnRelatorioFerramentas.setText("Relatório de Ferramentas");
        btnRelatorioFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFerramentasActionPerformed(evt);
            }
        });
        fileMenu3.add(btnRelatorioFerramentas);
        fileMenu3.add(jSeparator7);

        fileMenu.add(fileMenu3);
        fileMenu.add(jSeparator8);

        fileMenu6.setMnemonic('f');
        fileMenu6.setText("Fabricantes");

        btnCadastrarFabricante.setMnemonic('x');
        btnCadastrarFabricante.setText("Cadastrar Fabricante");
        btnCadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnCadastrarFabricante);

        btnVisualizarFabricante.setMnemonic('x');
        btnVisualizarFabricante.setText("Visualizar Fabricantes");
        btnVisualizarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnVisualizarFabricante);

        btnControleGastosFabricantes.setMnemonic('x');
        btnControleGastosFabricantes.setText("Controle de Gastos");
        btnControleGastosFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleGastosFabricantesActionPerformed(evt);
            }
        });
        fileMenu6.add(btnControleGastosFabricantes);
        fileMenu6.add(jSeparator9);

        btnRelatorioFabricantes.setMnemonic('x');
        btnRelatorioFabricantes.setText("Relatório de Fabricantes");
        btnRelatorioFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFabricantesActionPerformed(evt);
            }
        });
        fileMenu6.add(btnRelatorioFabricantes);

        fileMenu.add(fileMenu6);

        menuBar.add(fileMenu);

        fileMenu4.setMnemonic('f');
        fileMenu4.setText("Segurança");

        btnClose.setText("Sair do Programa");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        fileMenu4.add(btnClose);
        fileMenu4.add(jSeparator3);

        menuBar.add(fileMenu4);

        fileMenu2.setMnemonic('f');
        fileMenu2.setText("Visual");

        fileMenu7.setMnemonic('f');
        fileMenu7.setText("Temas");

        btnTemaDark.setMnemonic('x');
        btnTemaDark.setText("Escuro");
        btnTemaDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaDarkActionPerformed(evt);
            }
        });
        fileMenu7.add(btnTemaDark);

        btnTemaLight.setMnemonic('x');
        btnTemaLight.setText("Claro");
        btnTemaLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaLightActionPerformed(evt);
            }
        });
        fileMenu7.add(btnTemaLight);

        fileMenu2.add(fileMenu7);

        menuBar.add(fileMenu2);

        fileMenu8.setMnemonic('f');
        fileMenu8.setText("Desenvolvimento");

        btnDevTela.setText("Nova tela");
        btnDevTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevTelaActionPerformed(evt);
            }
        });
        fileMenu8.add(btnDevTela);
        fileMenu8.add(jSeparator11);

        menuBar.add(fileMenu8);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAmigoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsAmigos.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarAmigoActionPerformed

    private void btnViewAmigosCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAmigosCadActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaTabelaAmigos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnViewAmigosCadActionPerformed

    private void btnCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEmprestimoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarEmprestimoActionPerformed

    private void btnCadastrarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFerramentaActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarFerramentaActionPerformed

    private void btnFerramentasCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFerramentasCadActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaTabelaFerramentas().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnFerramentasCadActionPerformed

    private void btnRelatorioAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioAmigosActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaRelatorioAmigos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRelatorioAmigosActionPerformed

    private void btnControleFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleFinanceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnControleFinanceiroActionPerformed

    private void btnRelatorioFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFerramentasActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaRelatorioFerramentas().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRelatorioFerramentasActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCadastrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFabricanteActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarFabricanteActionPerformed

    private void btnVisualizarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarFabricanteActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaTabelaFabricante().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnVisualizarFabricanteActionPerformed

    private void btnControleGastosFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleGastosFabricantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnControleGastosFabricantesActionPerformed

    private void btnRelatorioFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFabricantesActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaRelatorioFabricante().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRelatorioFabricantesActionPerformed

    private void btnEmprestimosEmAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosEmAbertoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsEmprestimo.TelaEmprestimosAbertos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnEmprestimosEmAbertoActionPerformed

    private void btnRelatorioEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioEmprestimoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsEmprestimo.TelaRelatorioEmprestimos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRelatorioEmprestimoActionPerformed

    private void btnRankingAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingAmigosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRankingAmigosActionPerformed

    private void bntFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFerramentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntFerramentasActionPerformed

    private void btnAmigosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAmigosMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAmigosMouseDragged

    private void btnTemaLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaLightActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.LIGHT, this);
    }//GEN-LAST:event_btnTemaLightActionPerformed

    private void btnTemaDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaDarkActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.DARK, this);
    }//GEN-LAST:event_btnTemaDarkActionPerformed

    private void btnDevTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevTelaActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                TesteTela tela = new TesteTela();
                tela.setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnDevTelaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFabricantes;
    private javax.swing.JButton bntFerramentas;
    private javax.swing.JButton bntSeguranca;
    private javax.swing.JButton btnAmigos;
    private javax.swing.JMenuItem btnCadastrarAmigo;
    private javax.swing.JMenuItem btnCadastrarEmprestimo;
    private javax.swing.JMenuItem btnCadastrarFabricante;
    private javax.swing.JMenuItem btnCadastrarFerramenta;
    private javax.swing.JMenuItem btnClose;
    private javax.swing.JMenuItem btnControleFinanceiro;
    private javax.swing.JMenuItem btnControleGastosFabricantes;
    private javax.swing.JMenuItem btnDevTela;
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JMenuItem btnEmprestimosEmAberto;
    private javax.swing.JMenuItem btnFerramentasCad;
    private javax.swing.JButton btnMais;
    private javax.swing.JMenuItem btnRankingAmigos;
    private javax.swing.JMenuItem btnRelatorioAmigos;
    private javax.swing.JMenuItem btnRelatorioEmprestimo;
    private javax.swing.JMenuItem btnRelatorioFabricantes;
    private javax.swing.JMenuItem btnRelatorioFerramentas;
    private javax.swing.JMenuItem btnTemaDark;
    private javax.swing.JMenuItem btnTemaLight;
    private javax.swing.JMenuItem btnViewAmigosCad;
    private javax.swing.JMenuItem btnVisualizarFabricante;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JMenu fileMenu2;
    private javax.swing.JMenu fileMenu3;
    private javax.swing.JMenu fileMenu4;
    private javax.swing.JMenu fileMenu5;
    private javax.swing.JMenu fileMenu6;
    private javax.swing.JMenu fileMenu7;
    private javax.swing.JMenu fileMenu8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
