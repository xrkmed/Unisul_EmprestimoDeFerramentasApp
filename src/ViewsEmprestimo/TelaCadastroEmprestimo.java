package ViewsEmprestimo;

import java.util.Date;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import DAO.LoansDAO;
import DAO.ToolsDAO;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.DateDocument;
import Resources.DateResource;
import Resources.PriceDocument;
import Resources.ToolboxResource;
import ViewsAmigos.TelaTabelaAmigos;
import ViewsTool.TelaSelecionarFerramenta;

public class TelaCadastroEmprestimo extends javax.swing.JFrame {

    private ToolModel selectedTool = null;
    private FriendModel selectedFriend = null;
    private ToolboxResource toolsList = new ToolboxResource();

    private ToolboxResource parentToolsList = new ToolboxResource();
    private LoanModel emprestimo = null;

    public TelaCadastroEmprestimo() {
        initComponents();
        configFrame();
    }

    public TelaCadastroEmprestimo(LoanModel emprestimo) {
        this();
        this.emprestimo = emprestimo;
        try {
            setSelectedFriend(emprestimo.getFriend());
            loadTools(LoansDAO.getInstance().getTools(emprestimo.getId()));
            this.setVisible(true);
            textDataDevolucao.setText(new SimpleDateFormat("dd/MM/yyyy").format(emprestimo.getEndDate()));
            textValorReceber.setText(BRLResource.PRICE_FORMATTER.format(emprestimo.getPrice()));
            jLabel3.setText("Alterar emprestimo");
            btnCadastrarEmprestimo.setText("Alterar emprestimo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum erro interno aconteceu no sistema, tente novamente mais tarde ou contacte o administrador!");
            System.out.println(e.getMessage());
            this.dispose();
        }
    }

    public void loadTools(ToolboxResource toolbox) {
        parentToolsList = toolbox;
        for (ToolModel tool : toolbox.getTools()) {
            addFerramenta(tool);
        }
    }

    private void configFrame() {
        AbstractDocument document = (AbstractDocument) textValorReceber.getDocument();

        document.setDocumentFilter(new PriceDocument());
        document = (AbstractDocument) textDataDevolucao.getDocument();
        document.setDocumentFilter(new DateDocument());
        lblDataHoje.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getSelectionModel().addListSelectionListener(x -> {
            if (!x.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    selecionadoNome.setText(jTable1.getValueAt(selectedRow, 1).toString());
                    selecionadoFabricante.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    btnRemoverFerramenta.setEnabled(true);

                    for (ToolModel tool : toolsList.getTools()) {
                        if (tool.getId() == (int) jTable1.getValueAt(selectedRow, 0)) {
                            selectedTool = tool;
                            break;
                        }
                    }
                } else {
                    selectedTool = null;
                    selecionadoNome.setText("");
                    selecionadoFabricante.setText("");
                    btnRemoverFerramenta.setEnabled(false);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrarEmprestimo = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        btnSelecionarBeneficiado = new javax.swing.JButton();
        lblSelecionadoBeneficiado = new javax.swing.JLabel();
        btnRemoverBeneficiado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        selecionadoFabricante = new javax.swing.JTextField();
        btnRemoverFerramenta = new javax.swing.JButton();
        lblValorFerramentas = new javax.swing.JLabel();
        lblValorReceber = new javax.swing.JLabel();
        btnAdicionarFerramenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textDataDevolucao = new javax.swing.JTextField();
        lblDataHoje = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textValorReceber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Empréstimo - Grupo Supimpa");

        btnCadastrarEmprestimo.setBackground(new java.awt.Color(153, 255, 153));
        btnCadastrarEmprestimo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnCadastrarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastrarEmprestimo.setText("Cadastrar Empréstimo");
        btnCadastrarEmprestimo.setToolTipText("Finaliza o Processo de Empréstimo ");
        btnCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmprestimoActionPerformed(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Beneficiado:");

        btnSelecionarBeneficiado.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnSelecionarBeneficiado.setForeground(new java.awt.Color(51, 51, 51));
        btnSelecionarBeneficiado.setText("Selecionar ");
        btnSelecionarBeneficiado.setToolTipText("Seleciona um Amigo Para Realizar o Empréstimo");
        btnSelecionarBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarBeneficiadoActionPerformed(evt);
            }
        });

        lblSelecionadoBeneficiado.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        lblSelecionadoBeneficiado.setText("Nenhum");

        btnRemoverBeneficiado.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverBeneficiado.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnRemoverBeneficiado.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverBeneficiado.setText("Remover");
        btnRemoverBeneficiado.setToolTipText("Descarta o Amigo Selecionado Para Este Emprestimo ");
        btnRemoverBeneficiado.setEnabled(false);
        btnRemoverBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverBeneficiadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Ferramentas Emprestadas");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Fabricante", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(460);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(280);
        }

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("Ferramenta Selecionada");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel7.setText("Nome:");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Fabricante:");

        selecionadoNome.setEditable(false);
        selecionadoNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        selecionadoFabricante.setEditable(false);
        selecionadoFabricante.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        selecionadoFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionadoFabricanteActionPerformed(evt);
            }
        });

        btnRemoverFerramenta.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverFerramenta.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnRemoverFerramenta.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverFerramenta.setText("Remover Ferramenta");
        btnRemoverFerramenta.setToolTipText("Descarta a Ferramenta Selecionada Para Este Empréstimo");
        btnRemoverFerramenta.setEnabled(false);
        btnRemoverFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFerramentaActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(selecionadoFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnRemoverFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(selecionadoNome)
                    .addComponent(selecionadoFabricante))
                .addGap(15, 15, 15))
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jLayeredPane4Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnRemoverFerramenta))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addGap(116, 116, 116))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addComponent(selecionadoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnRemoverFerramenta)
                .addGap(15, 15, 15))
        );

        lblValorFerramentas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblValorFerramentas.setText("Valor Total Empréstimo: R$ 0,00");

        lblValorReceber.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblValorReceber.setText("Valor a Receber: R$ 0,00");

        btnAdicionarFerramenta.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnAdicionarFerramenta.setForeground(new java.awt.Color(51, 51, 51));
        btnAdicionarFerramenta.setText("Adicionar Ferramenta");
        btnAdicionarFerramenta.setToolTipText("Selecionar Uma Ferramenta da Lista");
        btnAdicionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFerramentaActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblValorFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnAdicionarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(btnAdicionarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValorReceber)
                                    .addComponent(lblValorFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(10, 10, 10))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(btnAdicionarFerramenta)
                        .addGap(150, 150, 150)
                        .addComponent(lblValorFerramentas)
                        .addGap(10, 10, 10)
                        .addComponent(lblValorReceber))
                    .addComponent(jLayeredPane4))
                .addGap(10, 10, 10))
        );

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel9.setText("Data Início:");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Data Devolução (Dia/Mês/Ano):");

        textDataDevolucao.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textDataDevolucao.setToolTipText("Defina Uma Data Prevista de Devolução");
        textDataDevolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textDataDevolucaoKeyReleased(evt);
            }
        });

        lblDataHoje.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        lblDataHoje.setText("Data de Hoje");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel15.setText("Valor a Receber:");

        textValorReceber.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textValorReceber.setText("0,00");
        textValorReceber.setToolTipText("Caso Haja Um Retorno Monetário ");
        textValorReceber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textValorReceberKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel16.setText("R$");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSelecionarBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblSelecionadoBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnRemoverBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textDataDevolucao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblDataHoje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(5, 5, 5)
                                .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)
                                .addComponent(jLabel15)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16)
                                .addGap(5, 5, 5)
                                .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(5, 5, 5)
                                        .addComponent(lblSelecionadoBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(5, 5, 5)
                                        .addComponent(lblDataHoje)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSelecionarBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnRemoverBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(304, 304, 304)))
                .addGap(0, 0, 0))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(lblSelecionadoBeneficiado)
                    .addComponent(btnSelecionarBeneficiado)
                    .addComponent(btnRemoverBeneficiado))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDataHoje))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Cancelar Alteração");
        jButton1.setToolTipText("Cancela o Emprestimo Atual, Descartando Todas Alterações Feitas ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Cadastrar Empréstimo");

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opções");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(250, 250, 250)
                            .addComponent(btnCadastrarEmprestimo))
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarEmprestimo)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    public void setSelectedFriend(FriendModel e) {
        lblSelecionadoBeneficiado.setText(e.getName().toUpperCase());
        selectedFriend = e;
        btnRemoverBeneficiado.setEnabled(true);
    }

    public ArrayList<ToolModel> getToolsList() {
        return toolsList.getTools();
    }

    public void loadFerramentasList() {;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        double totalValue = 0;
        for (ToolModel tool : toolsList.getTools()) {
            model.addRow(new Object[]{
                tool.getId(),
                tool.getNome(),
                (tool.getManufacturer() != null ? tool.getManufacturer().getName() : "Sem fabricante"),
                BRLResource.PRICE_FORMATTER.format(tool.getPrice())
            });
            totalValue += tool.getPrice();
        }

        lblValorFerramentas.setText("Valor Total Empréstimo: R$" + BRLResource.PRICE_FORMATTER.format(totalValue));
    }

    private void btnCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEmprestimoActionPerformed
        if (selectedFriend != null) {
            try {
                Date endDate = DateResource.unformatDateString(textDataDevolucao.getText());
                if (endDate.before(new Date())) {
                    JOptionPane.showMessageDialog(this, "A data de devolução não pode ser anterior a data de hoje!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (toolsList.size() == 0) {
                    JOptionPane.showMessageDialog(this, "Você deve adicionar pelo menos uma ferramenta!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double valorReceber = BRLResource.PRICE_FORMATTER.parse(textValorReceber.getText()).doubleValue();
                if (valorReceber < 0) {
                    JOptionPane.showMessageDialog(this, "O valor a receber deve ser de no minimo zero reais.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (this.emprestimo == null) {
                    //LoanModel(Date startDate, Date endDate, boolean returned)
                    LoanModel loan = LoansDAO.getInstance().addLoan(new Date(), endDate, valorReceber, selectedFriend.getId());
                    for (ToolModel tool : toolsList.getTools()) {
                        ToolsDAO.getInstance().addToolToLoan(tool.getId(), loan.getId());
                    }

                    JOptionPane.showMessageDialog(this, "Emprestimo finalizado com sucesso!");
                    this.dispose();
                } else {
                    LoanModel loan = LoansDAO.getInstance().updateLoan(this.emprestimo, new Date(), endDate, valorReceber, selectedFriend.getId());

                    for (ToolModel tool : parentToolsList.getTools()) {
                        if (!toolsList.containsTool(tool.getId())) {
                            ToolsDAO.getInstance().removeToolFromLoan(tool.getId());
                        }
                    }
                    for (ToolModel tool : toolsList.getTools()) {
                        ToolsDAO.getInstance().addToolToLoan(tool.getId(), loan.getId());
                    }

                    JOptionPane.showMessageDialog(this, "Emprestimo finalizado com sucesso!");
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadastrarEmprestimoActionPerformed

    private void btnSelecionarBeneficiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarBeneficiadoActionPerformed
        TelaTabelaAmigos tela = new TelaTabelaAmigos(this);
        tela.setVisible(true);

        tela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (tela.getSelectedFriend() != null) {
                    setSelectedFriend(tela.getSelectedFriend());
                    btnRemoverBeneficiado.setEnabled(true);
                }
            }
        });
    }//GEN-LAST:event_btnSelecionarBeneficiadoActionPerformed

    private void btnRemoverBeneficiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverBeneficiadoActionPerformed
        if (selectedFriend != null) {
            selectedFriend = null;
            lblSelecionadoBeneficiado.setText("Nenhum");
            btnRemoverBeneficiado.setEnabled(false);
        }
    }//GEN-LAST:event_btnRemoverBeneficiadoActionPerformed

    private void selecionadoFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionadoFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionadoFabricanteActionPerformed

    private void btnRemoverFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFerramentaActionPerformed
        if (selectedTool != null) {
            selecionadoFabricante.setText("");
            selecionadoNome.setText("");
            if (toolsList.containsTool(selectedTool.getId())) {
                toolsList.removeTool(selectedTool);
                loadFerramentasList();
            }
            selectedTool = null;
        }
    }//GEN-LAST:event_btnRemoverFerramentaActionPerformed

    private void textDataDevolucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDataDevolucaoKeyReleased
        //textDataDevolucao.setText(DateResource.formatDateString(textDataDevolucao.getText()));
    }//GEN-LAST:event_textDataDevolucaoKeyReleased

    private void btnAdicionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFerramentaActionPerformed
        new TelaSelecionarFerramenta(this).setVisible(true);
    }//GEN-LAST:event_btnAdicionarFerramentaActionPerformed

    private void textValorReceberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorReceberKeyReleased
        lblValorReceber.setText("Valor a receber: R$ " + textValorReceber.getText());
    }//GEN-LAST:event_textValorReceberKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void addFerramenta(ToolModel e) {
        if (!toolsList.containsTool(e.getId())) {
            toolsList.addTool(e);
            loadFerramentasList();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarFerramenta;
    private javax.swing.JButton btnCadastrarEmprestimo;
    private javax.swing.JButton btnRemoverBeneficiado;
    private javax.swing.JButton btnRemoverFerramenta;
    private javax.swing.JButton btnSelecionarBeneficiado;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDataHoje;
    private javax.swing.JLabel lblSelecionadoBeneficiado;
    private javax.swing.JLabel lblValorFerramentas;
    private javax.swing.JLabel lblValorReceber;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField selecionadoFabricante;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField textDataDevolucao;
    private javax.swing.JTextField textValorReceber;
    // End of variables declaration//GEN-END:variables

}
