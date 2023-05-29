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

        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.getSelectionModel().addListSelectionListener(x -> {
            if (!x.getValueIsAdjusting()) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    selecionadoNome.setText(jTable2.getValueAt(selectedRow, 1).toString());
                    selecionadoFabricante.setText(jTable2.getValueAt(selectedRow, 2).toString());
                    btnRemoverFerramenta.setEnabled(true);

                    for (ToolModel tool : toolsList.getTools()) {
                        if (tool.getId() == (int) jTable2.getValueAt(selectedRow, 0)) {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        lblSelecionadoBeneficiado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        selecionadoFabricante = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lblValorFerramentas = new javax.swing.JLabel();
        lblValorReceber = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        lblDataHoje = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textDataDevolucao = new javax.swing.JTextField();
        textValorReceber = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        btnCadastrarEmprestimo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSelecionarBeneficiado = new javax.swing.JButton();
        btnRemoverBeneficiado = new javax.swing.JButton();
        btnAdicionarFerramenta = new javax.swing.JButton();
        btnRemoverFerramenta = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Empréstimo - Grupo Supimpa");
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Beneficiado:");

        lblSelecionadoBeneficiado.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        lblSelecionadoBeneficiado.setText("Nenhum");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Ferramentas Emprestadas");

        jTable2.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(460);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(280);
        }

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel12.setText("Nome:");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel13.setText("Fabricante:");

        selecionadoNome.setEditable(false);
        selecionadoNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        selecionadoFabricante.setEditable(false);
        selecionadoFabricante.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        selecionadoFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionadoFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblValorFerramentas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblValorFerramentas.setText("Valor Total Empréstimo: R$ 0,00");

        lblValorReceber.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblValorReceber.setText("Valor a Receber: R$ 0,00");

        jLayeredPane2.setLayer(lblValorFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(lblValorReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblValorReceber)
                .addGap(10, 10, 10)
                .addComponent(lblValorFerramentas)
                .addGap(10, 10, 10))
        );

        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(selecionadoFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(selecionadoFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(selecionadoNome))
                .addGap(118, 118, 118)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(5, 5, 5)
                        .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(5, 5, 5)
                        .addComponent(selecionadoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Data Devolução:");

        lblDataHoje.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        lblDataHoje.setText("Data de Hoje");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel9.setText("Data Início:");

        textDataDevolucao.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textDataDevolucao.setToolTipText("Exemplo: (13/12/2023)");
        textDataDevolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textDataDevolucaoKeyReleased(evt);
            }
        });

        textValorReceber.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textValorReceber.setText("0,00");
        textValorReceber.setToolTipText("Caso Haja Um Retorno Monetário ");
        textValorReceber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textValorReceberKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel15.setText("Valor a Receber: R$");

        jLayeredPane3.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(lblDataHoje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(textDataDevolucao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(textValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(5, 5, 5)
                        .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataHoje)
                            .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDataHoje))
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setText("Ferramenta Selecionada");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblSelecionadoBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLayeredPane6))
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelecionadoBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(454, 454, 454)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(lblSelecionadoBeneficiado))
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Cadastro Empréstimo");

        btnCadastrarEmprestimo.setBackground(new java.awt.Color(153, 255, 153));
        btnCadastrarEmprestimo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnCadastrarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastrarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-check-custom.png"))); // NOI18N
        btnCadastrarEmprestimo.setToolTipText("Salvar");
        btnCadastrarEmprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmprestimoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-minus-custom.png"))); // NOI18N
        jButton1.setToolTipText("Cancelar");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSelecionarBeneficiado.setBackground(new java.awt.Color(153, 255, 153));
        btnSelecionarBeneficiado.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnSelecionarBeneficiado.setForeground(new java.awt.Color(51, 51, 51));
        btnSelecionarBeneficiado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/account-plus-custom.png"))); // NOI18N
        btnSelecionarBeneficiado.setToolTipText("Adicionar Tomador do Empréstimo");
        btnSelecionarBeneficiado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSelecionarBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarBeneficiadoActionPerformed(evt);
            }
        });

        btnRemoverBeneficiado.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverBeneficiado.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnRemoverBeneficiado.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverBeneficiado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/account-remove-custom.png"))); // NOI18N
        btnRemoverBeneficiado.setToolTipText("Remover Tomador do Empréstimo");
        btnRemoverBeneficiado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRemoverBeneficiado.setEnabled(false);
        btnRemoverBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverBeneficiadoActionPerformed(evt);
            }
        });

        btnAdicionarFerramenta.setBackground(new java.awt.Color(153, 255, 153));
        btnAdicionarFerramenta.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnAdicionarFerramenta.setForeground(new java.awt.Color(51, 51, 51));
        btnAdicionarFerramenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/toolbox-custom.png"))); // NOI18N
        btnAdicionarFerramenta.setToolTipText("Adicionar Ferramenta");
        btnAdicionarFerramenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAdicionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFerramentaActionPerformed(evt);
            }
        });

        btnRemoverFerramenta.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverFerramenta.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnRemoverFerramenta.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverFerramenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/tools-custom (1).png"))); // NOI18N
        btnRemoverFerramenta.setToolTipText("Remover Ferramenta da Lista");
        btnRemoverFerramenta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRemoverFerramenta.setEnabled(false);
        btnRemoverFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFerramentaActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCadastrarEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnSelecionarBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnRemoverBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnAdicionarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnRemoverFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(200, 200, 200)
                .addComponent(btnRemoverFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAdicionarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnRemoverBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSelecionarBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCadastrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRemoverFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverBeneficiado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane5)
                    .addComponent(jLayeredPane1))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

    private void selecionadoFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionadoFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selecionadoFabricanteActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
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
