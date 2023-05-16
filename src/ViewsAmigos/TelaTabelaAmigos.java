/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.TelaTabelaAmigos to edit this template
 */
package ViewsAmigos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Model.LoanModel;
import Resources.CEPResource;
import Resources.EditFriendCadResource;
import Resources.PhoneValidResource;

/**
 *
 * @author arkmed
 */
public class TelaTabelaAmigos extends javax.swing.JFrame {

    private FriendModel selectedFriend = null;

    /**
     * Creates new form java
     */
    public TelaTabelaAmigos() {
        initComponents();


        jTable2.getColumnModel().getColumn(1).setPreferredWidth(35);
        jTable2.getColumnModel().getColumn(1).setMinWidth(35);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(35);

        jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable2.getColumnModel().getColumn(0).setMinWidth(35);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

        ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTable2.getSelectionModel().addListSelectionListener(x -> {
            if (!x.getValueIsAdjusting()) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    selectedFriend = FriendsDAO.getInstance().getFriend(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                    selecionadoNome.setText(selectedFriend.getName().toUpperCase());
                    selecionadoTelefone.setText(CEPResource.returnTelefoneFormat(selectedFriend.getPhone()));
                }else{
                    selectedFriend = null;
                    selecionadoNome.setText("");
                    selecionadoTelefone.setText("");
                }
            }
        });

        Thread loadValues = new Thread(new Runnable(){
            @Override
            public void run(){
                loadValores();
            }
        });

        loadValues.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        canvas2 = new java.awt.Canvas();
        jLabel7 = new javax.swing.JLabel();
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
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        btnVerTodosEmprestimos = new javax.swing.JButton();
        btnDadosCadastrais = new javax.swing.JButton();
        btnRemoverCadastro = new javax.swing.JButton();
        selecionadoTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRelatorioFerramentas = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de amigos cadastrados - Grupo Supimpa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "#", "Nome", "Telefone", "Endereço", "Ferramentas emprestadas", "Ferramentas devolvidas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(400);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        canvas1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("DEVOLVER FERRAMENTA");

        jLabel2.setText("Emprestimo em aberto");

        canvas2.setBackground(new java.awt.Color(255, 255, 51));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLayeredPane1.setLayer(canvas1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        filtroFiltrarNome.setText("Filtrar por nome");
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

        filtroAmigosSemEmprestimoAberto.setText("Apenas amigos sem emprestimos em aberto");

        filtroAmigosDevolverFerramenta.setText("Apenas amigos que devem devolver alguma ferramenta");

        filtroAmigosEmEmprestimo.setText("Apenas amigos que estejam em um emprestimo");

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

        filtroEndereco.setText("Endereço");
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

        jLayeredPane2.setLayer(filtroFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosSemEmprestimoAberto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosDevolverFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroAmigosEmEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarEndereco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroEndereco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroAmigosDevolverFerramenta)
                            .addComponent(filtroAmigosEmEmprestimo)
                            .addComponent(filtroAmigosSemEmprestimoAberto)
                            .addComponent(jLabel3)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(filtroFiltrarNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(filtroEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFiltrarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(14, 14, 14))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroAmigosEmEmprestimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroAmigosDevolverFerramenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroAmigosSemEmprestimoAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroFiltrarNome)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroEndereco)
                    .addComponent(textFiltrarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇOES");

        jLabel4.setText("Nome");

        selecionadoNome.setEditable(false);

        btnVerTodosEmprestimos.setText("Visualizar todos os emprestimos");
        btnVerTodosEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosEmprestimosActionPerformed(evt);
            }
        });

        btnDadosCadastrais.setText("Alterar dados cadastrais");
        btnDadosCadastrais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosCadastraisActionPerformed(evt);
            }
        });

        btnRemoverCadastro.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverCadastro.setText("Remover cadastro");
        btnRemoverCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCadastroActionPerformed(evt);
            }
        });

        selecionadoTelefone.setEditable(false);

        jLabel5.setText("Telefone");

        btnRelatorioFerramentas.setText("Relatorio de ferramentas");

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnVerTodosEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnDadosCadastrais, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRemoverCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRelatorioFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(selecionadoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDadosCadastrais)
                    .addComponent(btnVerTodosEmprestimos)
                    .addComponent(btnRemoverCadastro)
                    .addComponent(btnRelatorioFerramentas))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selecionadoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
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
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane3))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void filtroFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNomeActionPerformed
        if(filtroFiltrarNome.isSelected()){
            textFiltrarNome.setEnabled(true);
        }else{
            textFiltrarNome.setEnabled(false);
        }
    }//GEN-LAST:event_filtroFiltrarNomeActionPerformed

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed
      
    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void loadValores(){
        ArrayList<FriendModel> friends = FriendsDAO.getInstance().getFriends();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        //CONFIGURACOES DA TABELA
        model.setRowCount(0);
        selectedFriend = null;
        selecionadoNome.setText("");
        selecionadoTelefone.setText("");

        
        //StatusRenderer statusRed = new StatusRenderer();
        //statusRed.addHighlightedRow(1, Color.RED);
        //statusRed.addHighlightedRow(3, Color.YELLOW);
        //jTable2.getColumnModel().getColumn(1).setCellRenderer(statusRed);

                
        for(FriendModel friend : friends){
            if(filtroFiltrarNome.isSelected() && textFiltrarNome.getText().trim().length() > 0){
                if(!friend.getName().toUpperCase().contains(textFiltrarNome.getText().toUpperCase().trim())){
                    continue;
                }
            }

            if(filtroEndereco.isSelected() && textFiltrarEndereco.getText().trim().length() > 0){
                if(!friend.getAddress().toString().toUpperCase().contains(textFiltrarEndereco.getText().toUpperCase().trim())){
                    continue;
                }
            }

                    
             model.addRow(new Object[]{friend.getId(), "-", friend.getName(), PhoneValidResource.formatPhoneNumber(friend.getPhone()), friend.getAddress(), "0", "0"});
                    
        }
    }

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased
    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void btnVerTodosEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosEmprestimosActionPerformed
        if(selectedFriend != null){
            JOptionPane.showMessageDialog(null, selectedFriend);
        }
    }//GEN-LAST:event_btnVerTodosEmprestimosActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnDadosCadastraisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosCadastraisActionPerformed
        if(selectedFriend != null){
            EditFriendCadResource.editFriendCadResource(selectedFriend);
            loadValores();
        }
    }//GEN-LAST:event_btnDadosCadastraisActionPerformed

    private void textFiltrarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFiltrarEnderecoActionPerformed

    private void textFiltrarEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarEnderecoKeyReleased
    }//GEN-LAST:event_textFiltrarEnderecoKeyReleased

    private void filtroEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroEnderecoActionPerformed
        if(filtroEndereco.isSelected()){
            textFiltrarEndereco.setEnabled(true);
        }else{
            textFiltrarEndereco.setEnabled(false);
        }
    }//GEN-LAST:event_filtroEnderecoActionPerformed

    private void btnRemoverCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCadastroActionPerformed
        if(selectedFriend != null){
            int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja realmente remover o cadastro de " + selectedFriend.getName() + "?","Atenção",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                LoansDAO loansDAO = LoansDAO.getInstance();
                for(LoanModel loan : loansDAO.getAllLoans()){
                    if(loan.getFriend().getId() == selectedFriend.getId() && loan.getReturned() == false){
                        JOptionPane.showMessageDialog(null, "Não é possível remover o cadastro de " + selectedFriend.getName() + " pois ele possui empréstimos pendentes.");
                        return;
                    }
                }

                FriendsDAO dao = FriendsDAO.getInstance();
                dao.removeFriend(selectedFriend);
                loadValores();
            }
        }
    }//GEN-LAST:event_btnRemoverCadastroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            TelaTabelaAmigos.util.logging.Logger.getLogger(TelaTabelaAmigos.class.getName()).log(TelaTabelaAmigos.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaTabelaAmigos.util.logging.Logger.getLogger(TelaTabelaAmigos.class.getName()).log(TelaTabelaAmigos.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaTabelaAmigos.util.logging.Logger.getLogger(TelaTabelaAmigos.class.getName()).log(TelaTabelaAmigos.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaTabelaAmigos.util.logging.Logger.getLogger(TelaTabelaAmigos.class.getName()).log(TelaTabelaAmigos.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        TelaTabelaAmigos.awt.EventQueue.invokeLater(new Runnable() {
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
    private javax.swing.JButton btnVerTodosEmprestimos;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox filtroAmigosDevolverFerramenta;
    private javax.swing.JCheckBox filtroAmigosEmEmprestimo;
    private javax.swing.JCheckBox filtroAmigosSemEmprestimoAberto;
    private javax.swing.JCheckBox filtroEndereco;
    private javax.swing.JCheckBox filtroFiltrarNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField selecionadoTelefone;
    private javax.swing.JTextField textFiltrarEndereco;
    private javax.swing.JTextField textFiltrarNome;
    // End of variables declaration//GEN-END:variables

}
