package Views;

import Model.FiltrosModel;
import Controllers.ThemeController;
import Enums.Themes;
import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEmprestimos;
import Model.ScreenModel;
import Views.Screens.ScreenFabricantes;
import Views.Screens.ScreenFerramentas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TelaInicial extends javax.swing.JFrame {

    private ScreenModel telaAtual;
    private Thread actualThread;

    public TelaInicial() {
        initComponents();
        updateTela(new ScreenAmigos(this));


        menuEditar.setText(btnEditar.getToolTipText());
        menuDeletar.setText(btnDeletar.getToolTipText());
        menuVisualizar.setText(btnVisualizar.getToolTipText());
        
        menuEditar.addActionListener(l -> {
            if(telaAtual.getBtnEditar().getActionListeners().length > 0){
                telaAtual.getBtnEditar().getActionListeners()[0].actionPerformed(null);
            }
        });

        menuDeletar.addActionListener(l -> {
            if(telaAtual.getBtnDeletar().getActionListeners().length > 0){
                telaAtual.getBtnDeletar().getActionListeners()[0].actionPerformed(null);
            }
        });

        menuVisualizar.addActionListener(l -> {
            if(telaAtual.getBtnVisualizar().getActionListeners().length > 0){
                telaAtual.getBtnVisualizar().getActionListeners()[0].actionPerformed(null);
            }
        });
    }

    public JPopupMenu getPopOpcoes(){
        return popOpcoes;
    }

    public ScreenModel getTelaAtual() {
        return telaAtual;
    }

    public JTable getTable() {
        return tabelaPrincipal;
    }

    public JComboBox<FiltrosModel> getComboBox() {
        return comboFiltros;
    }

    public JLabel getTitulo() {
        return labelListaNome;
    }

    public JButton getBtnCadastro() {
        return bntCadastrar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnDeletar() {
        return btnDeletar;
    }

    public JButton getBtnVisualizar() {
        return btnVisualizar;
    }

    public JButton getBtnExportar() {
        return btnExportar;
    }

    public void updateTela(ScreenModel e) {
        if (actualThread != null && actualThread.isAlive()) {
            JOptionPane.showMessageDialog(null, "Aguarde alguns instantes...");
            return;
        }

        btnAmigos.setBackground(new Color(205, 205, 205));
        btnEmprestimos.setBackground(new Color(205, 205, 205));
        bntFerramentas.setBackground(new Color(205, 205, 205));
        bntFabricantes.setBackground(new Color(205, 205, 205));
        bntSeguranca.setBackground(new Color(205, 205, 205));
        btnConfig.setBackground(new Color(205, 205, 205));

        comboFiltros.setModel(e.get());
        comboFiltros.setSelectedIndex(0);

        if (e instanceof ScreenAmigos) {
            btnAmigos.setBackground(new Color(155, 155, 155));
        } else if (e instanceof ScreenEmprestimos) {
            btnEmprestimos.setBackground(new Color(155, 155, 155));
        } else if (e instanceof ScreenFerramentas) {
            bntFerramentas.setBackground(new Color(155, 155, 155));
        } else if (e instanceof ScreenFabricantes) {
            bntFabricantes.setBackground(new Color(155, 155, 155));
        }

        telaAtual = e;
        getTitulo().setText(e.getName());
        ((DefaultTableModel) getTable().getModel()).setRowCount(0);

        actualThread = new Thread(new Runnable() {
            @Override
            public void run() {
                e.carregarDados();
            }
        });

        actualThread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popOpcoes = new javax.swing.JPopupMenu();
        menuDeletar = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenuItem();
        menuVisualizar = new javax.swing.JMenuItem();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        campoFiltroNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bntCadastrar = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        bntBuscar = new javax.swing.JButton();
        comboFiltros = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        labelListaNome = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        btnConfig = new javax.swing.JButton();
        btnAmigos = new javax.swing.JButton();
        btnEmprestimos = new javax.swing.JButton();
        bntFerramentas = new javax.swing.JButton();
        bntFabricantes = new javax.swing.JButton();
        bntSeguranca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPrincipal = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        menuDeletar.setText("btnDeletar");
        popOpcoes.add(menuDeletar);

        menuEditar.setText("btnEditar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        popOpcoes.add(menuEditar);

        menuVisualizar.setText("btnVisualizar");
        popOpcoes.add(menuVisualizar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grupo Supimpa - ToolStock Manager");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        campoFiltroNome.setToolTipText("Busca por nome");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        bntCadastrar.setBackground(new java.awt.Color(205, 205, 205));
        bntCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-plus-custom.png"))); // NOI18N
        bntCadastrar.setToolTipText("Adicionar");
        bntCadastrar.setBorder(null);
        bntCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(205, 205, 205));
        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-eye-custom.png"))); // NOI18N
        btnVisualizar.setToolTipText("Modo Leitura");
        btnVisualizar.setBorder(null);
        btnVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(205, 205, 205));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-remove-custom.png"))); // NOI18N
        btnDeletar.setToolTipText("Deletar");
        btnDeletar.setBorder(null);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnEditar.setBackground(new java.awt.Color(205, 205, 205));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-edit-custom.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        bntBuscar.setBackground(new java.awt.Color(205, 205, 205));
        bntBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/magnify-custom.png"))); // NOI18N
        bntBuscar.setToolTipText("Buscar");
        bntBuscar.setBorder(null);
        bntBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new FiltrosModel[] { new FiltrosModel("")  }));
        comboFiltros.setToolTipText("Selecione um filtro");
        comboFiltros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        comboFiltros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFiltrosItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Filtros:");

        labelListaNome.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        labelListaNome.setForeground(new java.awt.Color(255, 51, 51));
        labelListaNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelListaNome.setText("Lista Amigos");

        btnExportar.setBackground(new java.awt.Color(205, 205, 205));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-pdf-box-custom.png"))); // NOI18N
        btnExportar.setToolTipText("Exportar Relatório da Lista Exibida");
        btnExportar.setBorder(null);
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLayeredPane1.setLayer(campoFiltroNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bntCadastrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnVisualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnDeletar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bntBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(comboFiltros, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(labelListaNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnExportar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(bntCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(labelListaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(bntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(campoFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(campoFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bntCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(labelListaNome)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnConfig.setBackground(new java.awt.Color(205, 205, 205));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/cog-custom.png"))); // NOI18N
        btnConfig.setToolTipText("Mais Opções");
        btnConfig.setBorder(null);
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnAmigos.setBackground(new java.awt.Color(205, 205, 205));
        btnAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/account-group-custom.png"))); // NOI18N
        btnAmigos.setToolTipText("Amigos");
        btnAmigos.setBorder(null);
        btnAmigos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAmigos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnAmigosMouseDragged(evt);
            }
        });
        btnAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmigosActionPerformed(evt);
            }
        });

        btnEmprestimos.setBackground(new java.awt.Color(205, 205, 205));
        btnEmprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/hand-coin-custom-removebg-preview.png"))); // NOI18N
        btnEmprestimos.setToolTipText("Empréstimos");
        btnEmprestimos.setBorder(null);
        btnEmprestimos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimosActionPerformed(evt);
            }
        });

        bntFerramentas.setBackground(new java.awt.Color(205, 205, 205));
        bntFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/tools-custom.png"))); // NOI18N
        bntFerramentas.setToolTipText("Ferramentas");
        bntFerramentas.setBorder(null);
        bntFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFerramentasActionPerformed(evt);
            }
        });

        bntFabricantes.setBackground(new java.awt.Color(205, 205, 205));
        bntFabricantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/anvil-custom.png"))); // NOI18N
        bntFabricantes.setToolTipText("Fabricantes");
        bntFabricantes.setBorder(null);
        bntFabricantes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFabricantesActionPerformed(evt);
            }
        });

        bntSeguranca.setBackground(new java.awt.Color(205, 205, 205));
        bntSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/lock-open-custom.png"))); // NOI18N
        bntSeguranca.setToolTipText("Segurança");
        bntSeguranca.setBorder(null);
        bntSeguranca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntSeguranca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSegurancaActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(btnConfig, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                    .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(btnAmigos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnEmprestimos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFerramentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFabricantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntSeguranca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnConfig)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabelaPrincipal.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPrincipal.setToolTipText("");
        tabelaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaPrincipal.getTableHeader().setReorderingAllowed(false);
        tabelaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPrincipalMouseClicked(evt);
            }
        });
        tabelaPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaPrincipalKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPrincipal);

        jMenu1.setText("Opções");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/close-thick-custom (1).png"))); // NOI18N
        jMenuItem2.setText("Fechar Sistema");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

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

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/white-balance-sunny-custom.png"))); // NOI18N
        jMenuItem6.setText("Visual Claro");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/moon-waning-crescent-custom.png"))); // NOI18N
        jMenuItem7.setText("Visual Noturno");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Antiga Tela Inicial");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Legendas");

        jMenuItem3.setText("Cores da Tabela");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

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
    }//GEN-LAST:event_btnAmigosMouseDragged

    private void bntFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFerramentasActionPerformed
        if (!(telaAtual instanceof ScreenFerramentas)) {
            updateTela(new ScreenFerramentas(this));
        }
        campoFiltroNome.setText(null);
    }//GEN-LAST:event_bntFerramentasActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmigosActionPerformed
        if (!(telaAtual instanceof ScreenAmigos)) {
            updateTela(new ScreenAmigos(this));
        }
        campoFiltroNome.setText(null);
    }//GEN-LAST:event_btnAmigosActionPerformed

    private void btnEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosActionPerformed
        if (!(telaAtual instanceof ScreenEmprestimos)) {
            updateTela(new ScreenEmprestimos(this));
        }
        campoFiltroNome.setText(null);
    }//GEN-LAST:event_btnEmprestimosActionPerformed

    private void bntFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFabricantesActionPerformed
        if (!(telaAtual instanceof ScreenFabricantes)) {
            updateTela(new ScreenFabricantes(this));
        }
        campoFiltroNome.setText(null);
    }//GEN-LAST:event_bntFabricantesActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int flag = JOptionPane.showConfirmDialog(rootPane, "Deseja fechar o software?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            System.exit(-1);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ThemeController.getInstance().setTheme(Themes.DARK, this);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ThemeController.getInstance().setTheme(Themes.LIGHT, this);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void bntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarActionPerformed
    }//GEN-LAST:event_bntCadastrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new TelaPrincipalOld().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void bntSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSegurancaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSegurancaActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigActionPerformed

    private void comboFiltrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFiltrosItemStateChanged
        FiltrosModel selecionado = (FiltrosModel) comboFiltros.getSelectedItem();
        if (selecionado != null) {
            ((DefaultTableModel) getTable().getModel()).setRowCount(0);
            telaAtual.carregarDados();
        }
    }//GEN-LAST:event_comboFiltrosItemStateChanged

    private void tabelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPrincipalMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = tabelaPrincipal.rowAtPoint(evt.getPoint());

            if (row >= 0 && row < tabelaPrincipal.getRowCount()) {
                tabelaPrincipal.setRowSelectionInterval(row, row);
                popOpcoes.show(tabelaPrincipal, evt.getX(), evt.getY());
            }
        }else{
            if(evt.getClickCount() == 2){
                if(getBtnVisualizar().getActionListeners().length > 0){
                    getBtnVisualizar().getActionListeners()[0].actionPerformed(null);
                }
            }
        }
    }//GEN-LAST:event_tabelaPrincipalMouseClicked

    private void tabelaPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPrincipalKeyPressed

    }//GEN-LAST:event_tabelaPrincipalKeyPressed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEditarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String mensagem = "Cores e seus significados:\n\n" +
                "Fundo vermelho:\n" +
                "- Linhas de tabela com fundo vermelho indicam que:\n" +
                "   - Na tabela de emprestimos: Um empréstimo está atrasado;\n" +
                "   - Na tabela de ferramenta: Uma ferramenta deveria ter sido devolvida;\n" +
                "   - Na tabela de amigos: Um amigo está com um empréstimo atrasado;\n" +
                "   - Na tabela de fabricante: Uma fabricante está com todas as ferramentas em uso.\n\n" +
                "Fundo amarelo:\n" +
                "- Linhas de tabela com fundo amarelo indicam que:\n" +
                "   - Na tabela de empréstimos: este empréstimo ira vencer dentro de 7 dias.\n\n" +
                "   - Na tabela de amigos: este amigo esta com pelo menos um emprestimo em aberto.\n\n" +
                "Fundo laranja claro:\n" +
                "- Linhas de tabela com fundo laranja claro indicam que:\n" +
                "   - Na tabela de fabricante: A fabricante não tem nenhuma ferramenta cadastrada.";

        JOptionPane.showMessageDialog(null, mensagem, "Legenda de Cores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscar;
    private javax.swing.JButton bntCadastrar;
    private javax.swing.JButton bntFabricantes;
    private javax.swing.JButton bntFerramentas;
    private javax.swing.JButton bntSeguranca;
    private javax.swing.JButton btnAmigos;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JTextField campoFiltroNome;
    private javax.swing.JComboBox<FiltrosModel> comboFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelListaNome;
    private javax.swing.JMenuItem menuDeletar;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuVisualizar;
    private javax.swing.JPopupMenu popOpcoes;
    private javax.swing.JTable tabelaPrincipal;
    // End of variables declaration//GEN-END:variables
}
