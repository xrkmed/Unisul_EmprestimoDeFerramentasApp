package ViewsAmigos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Model.LoanModel;
import Resources.PhoneValidResource;

public class TelaTabelaAmigos extends javax.swing.JFrame {

    private FriendModel selectedFriend = null;
    private JFrame parent = null;

    public TelaTabelaAmigos() {
        initComponents();
        configFrame();
        btnSelecionar.setVisible(false);
    }

    public TelaTabelaAmigos(JFrame parent) {
        this();
        this.parent = parent;
        btnSelecionar.setVisible(true);
        btnSelecionar.setEnabled(true);
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
                                selectedFriend = FriendsDAO.getInstance().getFriend(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                                selecionadoNome.setText(selectedFriend.getName().toUpperCase());
                                selecionadoTelefone.setText(PhoneValidResource.formatPhoneNumber(selectedFriend.getPhone()));
                            } else {
                                selectedFriend = null;
                                selecionadoNome.setText("");
                                selecionadoTelefone.setText("");
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

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        canvas2 = new java.awt.Canvas();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        canvas3 = new java.awt.Canvas();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        filtroFiltrarNome = new javax.swing.JCheckBox();
        textFiltrarNome = new javax.swing.JTextField();
        filtroAmigosSemEmprestimoAberto = new javax.swing.JCheckBox();
        filtroAmigosDevolverFerramenta = new javax.swing.JCheckBox();
        filtroAmigosEmEmprestimo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        textFiltrarEndereco = new javax.swing.JTextField();
        filtroEndereco = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        filtrarRanque = new javax.swing.JCheckBox();
        rankType = new javax.swing.JComboBox<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        btnVerTodosEmprestimos = new javax.swing.JButton();
        btnDadosCadastrais = new javax.swing.JButton();
        btnRemoverCadastro = new javax.swing.JButton();
        btnRelatorioFerramentas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        selecionadoTelefone = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Amigos - Grupo Supimpapo Supimpa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "Endereço", "Empr. Abertos", "Empr. Atrasados"
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
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
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
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(550);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMPRÉSTIMOS EM ABERTO");
        jLabel2.setToolTipText("Exibe Somente Amigos com Emprestimos Em Aberto");

        canvas2.setBackground(new java.awt.Color(255, 204, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EMPRÉSTIMOS ATRASADOS");
        jLabel8.setToolTipText("Exibe Somente os Amigos Com Emprestimos Atrasados ");

        canvas3.setBackground(new java.awt.Color(255, 57, 57));

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel7))
                .addGap(92, 92, 92))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLayeredPane2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        filtroFiltrarNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroFiltrarNome.setText("Filtrar por nome:");
        filtroFiltrarNome.setToolTipText("Buscar Por Um Nome Especifico");
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

        filtroAmigosSemEmprestimoAberto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroAmigosSemEmprestimoAberto.setText("Apenas amigos sem emprestimos em aberto.");
        filtroAmigosSemEmprestimoAberto.setToolTipText("Apenas Amigos sem nenhuma pêndencia");
        filtroAmigosSemEmprestimoAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAmigosSemEmprestimoAbertoActionPerformed(evt);
            }
        });

        filtroAmigosDevolverFerramenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroAmigosDevolverFerramenta.setText("Apenas amigos que devem devolver alguma ferramenta.");
        filtroAmigosDevolverFerramenta.setToolTipText("Apenas Amigos Atrasados ");
        filtroAmigosDevolverFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAmigosDevolverFerramentaActionPerformed(evt);
            }
        });

        filtroAmigosEmEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroAmigosEmEmprestimo.setText("Apenas amigos que estejam em um emprestimo.");
        filtroAmigosEmEmprestimo.setToolTipText("Exibe Apenas Amigos que tem algo emprestado ");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("FILTROS");

        textFiltrarEndereco.setEnabled(false);
        textFiltrarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFiltrarEnderecoActionPerformed(evt);
            }
        });
        textFiltrarEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarEnderecoKeyReleased(evt);
            }
        });

        filtroEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroEndereco.setText("Endereço:");
        filtroEndereco.setToolTipText("Busca Amigos Pelo Endereço ");
        filtroEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroEnderecoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        filtrarRanque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtrarRanque.setText("Ranquear amigos ");
        filtrarRanque.setToolTipText("Lista os Amigos que Mais Fizeram Emprestimos");
        filtrarRanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarRanqueActionPerformed(evt);
            }
        });

        rankType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Emprestimos em aberto", "Emprestimos Atrasados" }));
        rankType.setEnabled(false);
        rankType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankTypeActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(filtroFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosSemEmprestimoAberto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosDevolverFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosEmEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarEndereco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroEndereco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtrarRanque, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(rankType, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(filtrarRanque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rankType, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroAmigosSemEmprestimoAberto)
                            .addComponent(filtroAmigosEmEmprestimo)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filtroEndereco)
                                    .addComponent(filtroFiltrarNome))
                                .addGap(10, 10, 10)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(textFiltrarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar))))
                            .addComponent(filtroAmigosDevolverFerramenta)
                            .addComponent(jLabel3))
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(filtroAmigosEmEmprestimo)
                .addGap(10, 10, 10)
                .addComponent(filtroAmigosDevolverFerramenta)
                .addGap(10, 10, 10)
                .addComponent(filtroAmigosSemEmprestimoAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtrarRanque)
                    .addComponent(rankType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filtroFiltrarNome)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textFiltrarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(filtroEndereco))
                .addContainerGap())
        );

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇÕES");

        btnVerTodosEmprestimos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerTodosEmprestimos.setForeground(new java.awt.Color(51, 51, 51));
        btnVerTodosEmprestimos.setText("Visualizar Empréstimos");
        btnVerTodosEmprestimos.setToolTipText("Exibe Somente Amigos que Tenham Feito ou Ja Fizeram Algum Empréstimo ");
        btnVerTodosEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosEmprestimosActionPerformed(evt);
            }
        });

        btnDadosCadastrais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDadosCadastrais.setForeground(new java.awt.Color(51, 51, 51));
        btnDadosCadastrais.setText("Alterar Dados Cadastrais");
        btnDadosCadastrais.setToolTipText("Modifica os Dados de um Amigo Já Cadastrado ");
        btnDadosCadastrais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosCadastraisActionPerformed(evt);
            }
        });

        btnRemoverCadastro.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemoverCadastro.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoverCadastro.setText("Remover Cadastro");
        btnRemoverCadastro.setToolTipText("Exclui O Amigo Selecionado ");
        btnRemoverCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCadastroActionPerformed(evt);
            }
        });
        btnRemoverCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnRemoverCadastroKeyReleased(evt);
            }
        });

        btnRelatorioFerramentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelatorioFerramentas.setForeground(new java.awt.Color(51, 51, 51));
        btnRelatorioFerramentas.setText("Relatório de Ferramentas");
        btnRelatorioFerramentas.setToolTipText("Exibe o Relátório de Ferramentas Que Já Foram Emprestadas ");
        btnRelatorioFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFerramentasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");
        jLabel4.setToolTipText("");

        selecionadoNome.setEditable(false);
        selecionadoNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Telefone:");
        jLabel5.setToolTipText("");

        selecionadoTelefone.setEditable(false);
        selecionadoTelefone.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        btnSelecionar.setBackground(new java.awt.Color(102, 255, 102));
        btnSelecionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelecionar.setForeground(new java.awt.Color(51, 51, 51));
        btnSelecionar.setText("Selecionar amigo");
        btnSelecionar.setEnabled(false);
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        btnSelecionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSelecionarKeyReleased(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnVerTodosEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnDadosCadastrais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRemoverCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRelatorioFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnSelecionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(selecionadoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRelatorioFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerTodosEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoverCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selecionadoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionar)))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnVerTodosEmprestimos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRelatorioFerramentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDadosCadastrais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverCadastro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jMenuItem1.setText("Legenda");
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void filtroFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNomeActionPerformed
        if (filtroFiltrarNome.isSelected()) {
            textFiltrarNome.setEnabled(true);
        } else {
            textFiltrarNome.setEnabled(false);
        }
    }//GEN-LAST:event_filtroFiltrarNomeActionPerformed

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void btnVerTodosEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosEmprestimosActionPerformed
        if (selectedFriend != null) {
            JOptionPane.showMessageDialog(null, selectedFriend);
        }
    }//GEN-LAST:event_btnVerTodosEmprestimosActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    public FriendModel getSelectedFriend() {
        return selectedFriend;
    }

    private void btnDadosCadastraisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosCadastraisActionPerformed
        if (selectedFriend != null) {
            TelaCadastroAmigos tela = new TelaCadastroAmigos(selectedFriend);
            tela.setVisible(true);

            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadValores();
                }
            });
        }
    }//GEN-LAST:event_btnDadosCadastraisActionPerformed

    private void filtroEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroEnderecoActionPerformed
        if (filtroEndereco.isSelected()) {
            textFiltrarEndereco.setEnabled(true);
        } else {
            textFiltrarEndereco.setEnabled(false);
        }
    }//GEN-LAST:event_filtroEnderecoActionPerformed

    private void btnRemoverCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCadastroActionPerformed
        try {
            if (selectedFriend != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o cadastro de " + selectedFriend.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    LoansDAO loansDAO = LoansDAO.getInstance();
                    for (LoanModel loan : loansDAO.getAllLoans()) {
                        if (loan.getFriend().getId() == selectedFriend.getId() && loan.getReturned() == false) {
                            JOptionPane.showMessageDialog(null, "Não é possível remover o cadastro de " + selectedFriend.getName() + " pois ele possui empréstimos pendentes.");
                            return;
                        }
                    }

                    FriendsDAO dao = FriendsDAO.getInstance();
                    dao.removeFriend(selectedFriend);
                    loadValores();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover o cadastro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemoverCadastroActionPerformed

    private void btnRemoverCadastroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRemoverCadastroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverCadastroKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased

    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void textFiltrarEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarEnderecoKeyReleased

    }//GEN-LAST:event_textFiltrarEnderecoKeyReleased

    private void textFiltrarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFiltrarEnderecoActionPerformed

    private void filtrarRanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarRanqueActionPerformed
        if (filtrarRanque.isSelected()) {
            rankType.setEnabled(true);
        } else {
            rankType.setEnabled(false);
        }
    }//GEN-LAST:event_filtrarRanqueActionPerformed

    private void rankTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankTypeActionPerformed

    private void filtroAmigosDevolverFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAmigosDevolverFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroAmigosDevolverFerramentaActionPerformed

    private void filtroAmigosSemEmprestimoAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAmigosSemEmprestimoAbertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroAmigosSemEmprestimoAbertoActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (selectedFriend != null) {
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um beneficiado");
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSelecionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSelecionarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelecionarKeyReleased

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2PropertyChange

    private void btnRelatorioFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFerramentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatorioFerramentasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTabelaAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDadosCadastrais;
    private javax.swing.JButton btnRelatorioFerramentas;
    private javax.swing.JButton btnRemoverCadastro;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnVerTodosEmprestimos;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox filtrarRanque;
    private javax.swing.JCheckBox filtroAmigosDevolverFerramenta;
    private javax.swing.JCheckBox filtroAmigosEmEmprestimo;
    private javax.swing.JCheckBox filtroAmigosSemEmprestimoAberto;
    private javax.swing.JCheckBox filtroEndereco;
    private javax.swing.JCheckBox filtroFiltrarNome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox<String> rankType;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField selecionadoTelefone;
    private javax.swing.JTextField textFiltrarEndereco;
    private javax.swing.JTextField textFiltrarNome;
    // End of variables declaration//GEN-END:variables

}
