package Views;

import Controllers.ThemeController;
import Resources.Enum_Themes;
import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEmprestimos;
import Views.Screens.ScreenEntity;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TelaInicial extends javax.swing.JFrame {
    
    private ScreenEntity telaAtual;

    public TelaInicial() {
        initComponents();
        telaAtual = new ScreenAmigos(this);
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                telaAtual.carregarDados();
            }
        });

        t.start();
    }

    public JTable getTable(){
        return tabelaPrincipal;
    }

    public JLabel getTitulo(){
        return labelListaNome;
    }

    public JButton getBtnCadastro(){
        return bntCadastrar;
    }

    public JButton getBtnEditar(){
        return btnEditar;
    }

    public JButton getBtnDeletar(){
        return btnDeletar;
    }

    public JButton getBtnVisualizar(){
        return btnVisualizar;
    }

    public JButton getBtnExportar(){
        return btnExportar;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        menuOpcoes = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        menuControleEmprestimos = new javax.swing.JMenuItem();
        menuGastosFerramentas = new javax.swing.JMenuItem();
        menuPersonalizacao = new javax.swing.JMenu();
        lightMode = new javax.swing.JMenuItem();
        darkMode = new javax.swing.JMenuItem();
        menuOldScreen = new javax.swing.JMenu();
        menuOldScreenOpen = new javax.swing.JMenuItem();

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
        bntCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(205, 205, 205));
        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-eye-custom.png"))); // NOI18N
        btnVisualizar.setToolTipText("Modo Leitura");
        btnVisualizar.setBorder(null);
        btnVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDeletar.setBackground(new java.awt.Color(205, 205, 205));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-remove-custom.png"))); // NOI18N
        btnDeletar.setToolTipText("Deletar");
        btnDeletar.setBorder(null);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditar.setBackground(new java.awt.Color(205, 205, 205));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-edit-custom.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bntBuscar.setBackground(new java.awt.Color(205, 205, 205));
        bntBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/magnify-custom.png"))); // NOI18N
        bntBuscar.setToolTipText("Buscar");
        bntBuscar.setBorder(null);
        bntBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "ID", "Nome", "Emp. Pendente" }));
        comboFiltros.setToolTipText("Selecione um filtro");
        comboFiltros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Filtros:");

        labelListaNome.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        labelListaNome.setForeground(new java.awt.Color(255, 51, 51));
        labelListaNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelListaNome.setText("Lista Amigos");

        btnExportar.setBackground(new java.awt.Color(205, 205, 205));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-export-custom (2).png"))); // NOI18N
        btnExportar.setToolTipText("Exportar Relatório");
        btnExportar.setBorder(null);
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAmigos.setBackground(new java.awt.Color(205, 205, 205));
        btnAmigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/account-group-custom.png"))); // NOI18N
        btnAmigos.setToolTipText("Amigos");
        btnAmigos.setBorder(null);
        btnAmigos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnEmprestimos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimosActionPerformed(evt);
            }
        });

        bntFerramentas.setBackground(new java.awt.Color(205, 205, 205));
        bntFerramentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/tools-custom.png"))); // NOI18N
        bntFerramentas.setToolTipText("Ferramentas");
        bntFerramentas.setBorder(null);
        bntFerramentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFerramentasActionPerformed(evt);
            }
        });

        bntFabricantes.setBackground(new java.awt.Color(205, 205, 205));
        bntFabricantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/anvil-custom.png"))); // NOI18N
        bntFabricantes.setToolTipText("Fabricantes");
        bntFabricantes.setBorder(null);
        bntFabricantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFabricantesActionPerformed(evt);
            }
        });

        bntSeguranca.setBackground(new java.awt.Color(205, 205, 205));
        bntSeguranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/lock-open-custom.png"))); // NOI18N
        bntSeguranca.setToolTipText("Segurança");
        bntSeguranca.setBorder(null);
        bntSeguranca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addComponent(btnAmigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnEmprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntFabricantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bntSeguranca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabelaPrincipal.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPrincipal.setToolTipText("");
        tabelaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaPrincipal.setShowGrid(true);
        tabelaPrincipal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaPrincipal);
        if (tabelaPrincipal.getColumnModel().getColumnCount() > 0) {
            tabelaPrincipal.getColumnModel().getColumn(0).setMinWidth(65);
            tabelaPrincipal.getColumnModel().getColumn(0).setMaxWidth(65);
            tabelaPrincipal.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabelaPrincipal.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaPrincipal.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabelaPrincipal.getColumnModel().getColumn(4).setPreferredWidth(110);
            tabelaPrincipal.getColumnModel().getColumn(4).setMaxWidth(110);
            tabelaPrincipal.getColumnModel().getColumn(5).setPreferredWidth(110);
            tabelaPrincipal.getColumnModel().getColumn(5).setMaxWidth(110);
        }

        menuOpcoes.setText("Opções");

        menuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/close-thick-custom (1).png"))); // NOI18N
        menuExit.setText("Fechar Sistema");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuExit);

        jMenuBar1.add(menuOpcoes);

        menuFinanceiro.setText("Financeiro");

        menuControleEmprestimos.setText("Controle Financeiro Empréstimos");
        menuFinanceiro.add(menuControleEmprestimos);

        menuGastosFerramentas.setText("Gastos Ferramentas");
        menuGastosFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGastosFerramentasActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuGastosFerramentas);

        jMenuBar1.add(menuFinanceiro);

        menuPersonalizacao.setText("Personalização");

        lightMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/white-balance-sunny-custom.png"))); // NOI18N
        lightMode.setText("Visual Claro");
        lightMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightModeActionPerformed(evt);
            }
        });
        menuPersonalizacao.add(lightMode);

        darkMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/moon-waning-crescent-custom.png"))); // NOI18N
        darkMode.setText("Visual Noturno");
        darkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeActionPerformed(evt);
            }
        });
        menuPersonalizacao.add(darkMode);

        jMenuBar1.add(menuPersonalizacao);

        menuOldScreen.setText("Antiga Tela Inicial");

        menuOldScreenOpen.setText("Abrir");
        menuOldScreenOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOldScreenOpenActionPerformed(evt);
            }
        });
        menuOldScreen.add(menuOldScreenOpen);

        jMenuBar1.add(menuOldScreen);

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
    }//GEN-LAST:event_bntFerramentasActionPerformed

    private void menuGastosFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGastosFerramentasActionPerformed
    }//GEN-LAST:event_menuGastosFerramentasActionPerformed

    private void btnAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmigosActionPerformed
    }//GEN-LAST:event_btnAmigosActionPerformed

    private void btnEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosActionPerformed
        ScreenEmprestimos flag = new ScreenEmprestimos();
        flag.carregarDados();
    }//GEN-LAST:event_btnEmprestimosActionPerformed

    private void bntFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFabricantesActionPerformed
    }//GEN-LAST:event_bntFabricantesActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        int flag = JOptionPane.showConfirmDialog(rootPane, "Deseja fechar o software?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION) {
            System.exit(-1);
        }    
    }//GEN-LAST:event_menuExitActionPerformed

    private void darkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.DARK, this);
    }//GEN-LAST:event_darkModeActionPerformed

    private void lightModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightModeActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.LIGHT, this);
    }//GEN-LAST:event_lightModeActionPerformed

    private void bntCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarActionPerformed
    }//GEN-LAST:event_bntCadastrarActionPerformed

    private void menuOldScreenOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOldScreenOpenActionPerformed
        new TelaPrincipalOld().setVisible(true);
    }//GEN-LAST:event_menuOldScreenOpenActionPerformed

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
    private javax.swing.JComboBox<String> comboFiltros;
    private javax.swing.JMenuItem darkMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelListaNome;
    private javax.swing.JMenuItem lightMode;
    private javax.swing.JMenuItem menuControleEmprestimos;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenuItem menuGastosFerramentas;
    private javax.swing.JMenu menuOldScreen;
    private javax.swing.JMenuItem menuOldScreenOpen;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenu menuPersonalizacao;
    private javax.swing.JTable tabelaPrincipal;
    // End of variables declaration//GEN-END:variables
}
