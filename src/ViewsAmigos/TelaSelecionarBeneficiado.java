/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.TelaTabelaAmigos to edit this template
 */
package ViewsAmigos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Model.LoanModel;
import Resources.CEPResource;
import Resources.PhoneValidResource;
import ViewsEmprestimo.TelaAlterarEmprestimo;
import ViewsEmprestimo.TelaCadastroEmprestimo;

/**
 *
 * @author arkmed
 */
public class TelaSelecionarBeneficiado extends javax.swing.JFrame {

    private FriendModel selectedFriend = null;
    private JFrame parent = null;

    /**
     * Creates new form java
     */
    public TelaSelecionarBeneficiado() {
        initComponents();
        configFrame();
    }

    public TelaSelecionarBeneficiado(JFrame parent) {
        this();
        this.parent = parent;
    }

    private void configFrame(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jTable2.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = jTable2.getSelectedRow();
                        try{
                            if (selectedRow != -1) {
                                selectedFriend = FriendsDAO.getInstance().getFriend(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                                if(selectedFriend != null){
                                    selecionadoNome.setText(selectedFriend.getName().toUpperCase());
                                    selecionadoTelefone.setText(CEPResource.returnTelefoneFormat(selectedFriend.getPhone()));
                                }
                            }else{
                                selectedFriend = null;
                                selecionadoNome.setText("");
                                selecionadoTelefone.setText("");
                            }
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                });
        
                jTable2.getColumnModel().getColumn(1).setPreferredWidth(35);
                jTable2.getColumnModel().getColumn(1).setMinWidth(35);
                jTable2.getColumnModel().getColumn(1).setMaxWidth(35);
        
                jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
                jTable2.getColumnModel().getColumn(0).setMinWidth(35);
                jTable2.getColumnModel().getColumn(0).setMaxWidth(35);
        
                ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
                
                loadValores();
            }
        }).start();
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
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        btnVerTodosEmprestimos = new javax.swing.JButton();
        selecionadoTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSelecionarBeneficiado = new javax.swing.JButton();
        btnRelatorioFerramentas1 = new javax.swing.JButton();
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
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de amigos cadastrados - Grupo Supimpa");
        setPreferredSize(new java.awt.Dimension(1373, 732));
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
                "ID", "#", "Nome", "Telefone", "Endereço", "Fer. Emprestadas", "Fer. Devolvidas"
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(280);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(550);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇÕES");
        jLabel6.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");
        jLabel4.setToolTipText("");

        selecionadoNome.setEditable(false);
        selecionadoNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        btnVerTodosEmprestimos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerTodosEmprestimos.setForeground(new java.awt.Color(51, 51, 51));
        btnVerTodosEmprestimos.setText("Visualizar Empréstimos");
        btnVerTodosEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosEmprestimosActionPerformed(evt);
            }
        });

        selecionadoTelefone.setEditable(false);
        selecionadoTelefone.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Telefone:");
        jLabel5.setToolTipText("");

        btnSelecionarBeneficiado.setBackground(new java.awt.Color(153, 255, 153));
        btnSelecionarBeneficiado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSelecionarBeneficiado.setForeground(new java.awt.Color(51, 51, 51));
        btnSelecionarBeneficiado.setText("Selecionar Amigo");
        btnSelecionarBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarBeneficiadoActionPerformed(evt);
            }
        });

        btnRelatorioFerramentas1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRelatorioFerramentas1.setForeground(new java.awt.Color(51, 51, 51));
        btnRelatorioFerramentas1.setText("Relatório de Ferramentas");

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnVerTodosEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnSelecionarBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRelatorioFerramentas1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(selecionadoTelefone)
                            .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(237, 237, 237)))
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerTodosEmprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(btnRelatorioFerramentas1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(btnSelecionarBeneficiado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel4))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(btnVerTodosEmprestimos)
                        .addGap(20, 20, 20)
                        .addComponent(btnRelatorioFerramentas1)))
                .addGap(10, 10, 10)
                .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionadoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarBeneficiado))
                .addGap(15, 15, 15))
        );

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EMPRÉSTIMOS EM ABERTO");
        jLabel2.setToolTipText("");

        canvas2.setBackground(new java.awt.Color(255, 204, 0));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EMPRÉSTIMOS ATRASADOS");

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
        filtroAmigosSemEmprestimoAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAmigosSemEmprestimoAbertoActionPerformed(evt);
            }
        });

        filtroAmigosDevolverFerramenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroAmigosDevolverFerramenta.setText("Apenas amigos que devem devolver alguma ferramenta.");
        filtroAmigosDevolverFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAmigosDevolverFerramentaActionPerformed(evt);
            }
        });

        filtroAmigosEmEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroAmigosEmEmprestimo.setText("Apenas amigos que estejam em um emprestimo.");

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
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(filtroAmigosSemEmprestimoAberto)
                    .addComponent(filtroAmigosDevolverFerramenta)
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
                                .addComponent(btnBuscar)))))
                .addGap(18, 18, 18))
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
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(filtroFiltrarNome)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textFiltrarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(filtroEndereco))
                .addGap(15, 15, 15))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opções");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void loadValores(){
        try{
            FriendsDAO dao = FriendsDAO.getInstance();
            ArrayList<FriendModel> friends = dao.getFriends();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //CONFIGURACOES DA TABELA
            model.setRowCount(0);
            selectedFriend = null;

            //StatusRenderer statusRed = new StatusRenderer();
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
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void btnVerTodosEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosEmprestimosActionPerformed
        if(selectedFriend != null){
            JOptionPane.showMessageDialog(null, selectedFriend);
        }
    }//GEN-LAST:event_btnVerTodosEmprestimosActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnSelecionarBeneficiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarBeneficiadoActionPerformed
        if(selectedFriend != null){
            if(parent != null){
                if(parent instanceof TelaCadastroEmprestimo){
                    ((TelaCadastroEmprestimo) parent).setSelectedFriend(selectedFriend);
                }

                if(parent instanceof TelaAlterarEmprestimo){
                    ((TelaAlterarEmprestimo) parent).setSelectedFriend(selectedFriend);
                }
            }
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um beneficiado");
        }
    }//GEN-LAST:event_btnSelecionarBeneficiadoActionPerformed

    private void filtroFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNomeActionPerformed
        if(filtroFiltrarNome.isSelected()){
            textFiltrarNome.setEnabled(true);
        }else{
            textFiltrarNome.setEnabled(false);
        }
    }//GEN-LAST:event_filtroFiltrarNomeActionPerformed

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased

    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void filtroAmigosSemEmprestimoAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAmigosSemEmprestimoAbertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroAmigosSemEmprestimoAbertoActionPerformed

    private void filtroAmigosDevolverFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAmigosDevolverFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroAmigosDevolverFerramentaActionPerformed

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

  
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (InstantiationException ex) {
            TelaSelecionarBeneficiado.util.logging.Logger.getLogger(TelaSelecionarBeneficiado.class.getName()).log(TelaSelecionarBeneficiado.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaSelecionarBeneficiado.util.logging.Logger.getLogger(TelaSelecionarBeneficiado.class.getName()).log(TelaSelecionarBeneficiado.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaSelecionarBeneficiado.util.logging.Logger.getLogger(TelaSelecionarBeneficiado.class.getName()).log(TelaSelecionarBeneficiado.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        //TelaSelecionarBeneficiado.awt.EventQueue.invokeLater(new Runnable() {
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSelecionarBeneficiado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRelatorioFerramentas1;
    private javax.swing.JButton btnSelecionarBeneficiado;
    private javax.swing.JButton btnVerTodosEmprestimos;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
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
