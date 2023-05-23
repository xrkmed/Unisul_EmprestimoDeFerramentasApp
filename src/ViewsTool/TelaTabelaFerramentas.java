package ViewsTool;

import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import ViewsManufacturer.*;
import ViewsAmigos.*;
import java.awt.Color;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.CEPResource;
import Resources.CNPJResource;
import Resources.ManufacturerResource;

public class TelaTabelaFerramentas extends javax.swing.JFrame {

    private ToolModel selectedTool = null;

    public TelaTabelaFerramentas() {
        initComponents();
        initFrameConfig();
    }

    private void initFrameConfig() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ((DefaultTableModel) jTable2.getModel()).setRowCount(0);

                jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jTable2.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = jTable2.getSelectedRow();
                        try {
                            if (selectedRow != -1) {
                                selecionadoNome.setText(jTable2.getValueAt(selectedRow, 2).toString());
                                selecionadoManufacturer.setText(jTable2.getValueAt(selectedRow, 3).toString());

                                selectedTool = ToolsDAO.getInstance().getTool(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                            } else {
                                selectedTool = null;
                                selecionadoNome.setText("");
                                selecionadoManufacturer.setText("");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                });

                ArrayList<Integer> lowestSize = new ArrayList<>(Arrays.asList(0, 1));
                for (Integer i : lowestSize) {
                    jTable2.getColumnModel().getColumn(i).setPreferredWidth(35);
                    jTable2.getColumnModel().getColumn(i).setMinWidth(35);
                    jTable2.getColumnModel().getColumn(i).setMaxWidth(35);
                }

                loadValores();
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        canvas2 = new java.awt.Canvas();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        canvas3 = new java.awt.Canvas();
        canvas4 = new java.awt.Canvas();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        filtroFiltrarNome = new javax.swing.JCheckBox();
        textFiltrarNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        filtroFiltrarUso = new javax.swing.JCheckBox();
        textFiltrarUso = new javax.swing.JTextField();
        filtroFabricante = new javax.swing.JCheckBox();
        textFiltrarFabricante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        btnRemoverCadastro = new javax.swing.JButton();
        selecionadoManufacturer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAlterarFerramenta = new javax.swing.JButton();
        btnEstadoFerramenta = new javax.swing.JButton();
        btnHistoricoUso = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de ferramentas cadastradas - Grupo Supimpa");
        setResizable(false);
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
                "ID", "#", "Nome", "Fabricante", "Preço", "Em uso por", "Data de devoluçao"
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
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(400);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLabel1.setText("Sem fabricante");

        canvas1.setBackground(new java.awt.Color(255, 57, 57));

        canvas2.setBackground(new java.awt.Color(255, 255, 224));

        jLabel2.setText("Em uso por algum amigo");

        jLabel8.setText("Em manutençao");

        canvas3.setBackground(new java.awt.Color(255, 224, 255));

        canvas4.setBackground(new java.awt.Color(255, 160, 122));

        jLabel10.setText("Sem fabricante e em uso");

        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))))
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
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

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("FILTROS");

        filtroFiltrarUso.setText("Em uso por");
        filtroFiltrarUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroFiltrarUsoActionPerformed(evt);
            }
        });

        textFiltrarUso.setEnabled(false);
        textFiltrarUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFiltrarUsoActionPerformed(evt);
            }
        });
        textFiltrarUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarUsoKeyReleased(evt);
            }
        });

        filtroFabricante.setText("Fabricante");
        filtroFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroFabricanteActionPerformed(evt);
            }
        });

        textFiltrarFabricante.setEnabled(false);
        textFiltrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFiltrarFabricanteActionPerformed(evt);
            }
        });
        textFiltrarFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFiltrarFabricanteKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Utilize \"sem fabricante\" para procurar ferramentas sem fabricantes");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(filtroFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroFiltrarUso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarUso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(filtroFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(filtroFiltrarNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(filtroFiltrarUso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFiltrarUso, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addComponent(filtroFabricante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFiltrarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroFiltrarNome)
                    .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroFiltrarUso)
                    .addComponent(textFiltrarUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroFabricante)
                    .addComponent(textFiltrarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇOES");

        jLabel4.setText("Ferramenta");

        selecionadoNome.setEditable(false);

        btnRemoverCadastro.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverCadastro.setText("Remover ferramenta");
        btnRemoverCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCadastroActionPerformed(evt);
            }
        });

        selecionadoManufacturer.setEditable(false);

        jLabel5.setText("Fabricante");

        btnAlterarFerramenta.setText("Alterar ferramenta");
        btnAlterarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFerramentaActionPerformed(evt);
            }
        });

        btnEstadoFerramenta.setText("Estado da ferramenta");
        btnEstadoFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoFerramentaActionPerformed(evt);
            }
        });

        btnHistoricoUso.setText("Historico de uso");
        btnHistoricoUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoUsoActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRemoverCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoManufacturer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnAlterarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnEstadoFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnHistoricoUso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(selecionadoManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverCadastro)
                            .addComponent(btnAlterarFerramenta)
                            .addComponent(btnEstadoFerramenta)
                            .addComponent(btnHistoricoUso)))))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(btnEstadoFerramenta)
                        .addGap(7, 7, 7)
                        .addComponent(btnHistoricoUso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterarFerramenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverCadastro))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selecionadoManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void filtroFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNomeActionPerformed
        if (filtroFiltrarNome.isSelected()) {
            textFiltrarNome.setEnabled(true);
        } else {
            textFiltrarNome.setEnabled(false);
        }

    }//GEN-LAST:event_filtroFiltrarNomeActionPerformed

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void loadValores() {
        try {
            selectedTool = null;
            selecionadoNome.setText("");
            selecionadoManufacturer.setText("");

            ArrayList<Object[]> datas = ToolsDAO.getInstance().getFerramentasValue();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            StatusRenderer statusRenderer = new StatusRenderer();
            //new Object[]{result.getInt("id"), "-", result.getString("name"), result.getString("razao_social"), BRLResource.PRICE_FORMATTER.format(result.getDouble("price")), result.getString("nome"), new SimpleDateFormat("dd/MM/yyyy").format(result.getDate("endDate").toString())});
            for (Object[] data : datas) {
                if (filtroFiltrarNome.isSelected() && textFiltrarNome.getText().trim().length() > 0) {
                    if (!data[2].toString().toLowerCase().contains(textFiltrarNome.getText().toLowerCase())) {
                        continue;
                    }
                }

                if (filtroFiltrarUso.isSelected() && textFiltrarUso.getText().trim().length() > 0) {
                    if (!data[5].toString().toLowerCase().contains(textFiltrarUso.getText().toLowerCase())) {
                        continue;
                    }
                }

                if (filtroFabricante.isSelected() && textFiltrarFabricante.getText().trim().length() > 0) {
                    if (!data[3].toString().toLowerCase().contains(textFiltrarFabricante.getText().toLowerCase())) {
                        continue;
                    }
                }

                if (!data[5].toString().equals("Disponivel")) {
                    statusRenderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(statusRenderer);
                    }
                }

                if (data[3].toString().equalsIgnoreCase("sem fabricante")) {
                    if (statusRenderer.getHighlightedRow(model.getRowCount()) == ColorsRenderer.lightYellow) {
                        statusRenderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightOrange);
                    } else {
                        statusRenderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    }

                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(statusRenderer);
                    }
                }

                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased
    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnRemoverCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCadastroActionPerformed
        if (selectedTool != null) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a ferramenta " + selectedTool.getNome() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (!selectedTool.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "Não é possível remover uma ferramenta que esta em uso por algum amigo.");
                    return;
                }

                try {
                    ToolsDAO.getInstance().removeTool(selectedTool);
                    ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
                    selectedTool = null;
                    selecionadoNome.setText("");
                    selecionadoManufacturer.setText("");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadValores();
                        }
                    }).start();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnRemoverCadastroActionPerformed

    private void btnAlterarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFerramentaActionPerformed
        if (selectedTool != null) {
            TelaCadastro tela = new TelaCadastro(selectedTool);
            tela.setVisible(true);
            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
                    selectedTool = null;
                    selecionadoNome.setText("");
                    selecionadoManufacturer.setText("");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            loadValores();
                        }
                    }).start();
                }
            });
        }
    }//GEN-LAST:event_btnAlterarFerramentaActionPerformed

    private void filtroFiltrarNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFiltrarNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroFiltrarNome1ActionPerformed

    private void textFiltrarUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFiltrarUsoActionPerformed

    private void textFiltrarUsoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarUsoKeyReleased
    }//GEN-LAST:event_textFiltrarUsoKeyReleased

    private void btnEstadoFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstadoFerramentaActionPerformed

    private void btnHistoricoUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoricoUsoActionPerformed

    private void filtroFabricanteActionPerformed(java.awt.event.ActionEvent evt) {
        if (filtroFabricante.isSelected()) {
            textFiltrarFabricante.setEnabled(true);
        } else {
            textFiltrarFabricante.setEnabled(false);
        }
    }

    private void filtroFiltrarUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroFabricanteActionPerformed
        if (filtroFiltrarUso.isSelected()) {
            textFiltrarUso.setEnabled(true);
        } else {
            textFiltrarUso.setEnabled(false);
        }
    }//GEN-LAST:event_filtroFabricanteActionPerformed


    private void textFiltrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarFabricanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFiltrarFabricanteActionPerformed

    private void textFiltrarFabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarFabricanteKeyReleased
    }//GEN-LAST:event_textFiltrarFabricanteKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaTabelaFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarFerramenta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEstadoFerramenta;
    private javax.swing.JButton btnHistoricoUso;
    private javax.swing.JButton btnRemoverCadastro;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox filtroFabricante;
    private javax.swing.JCheckBox filtroFiltrarNome;
    private javax.swing.JCheckBox filtroFiltrarUso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField selecionadoManufacturer;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField textFiltrarFabricante;
    private javax.swing.JTextField textFiltrarNome;
    private javax.swing.JTextField textFiltrarUso;
    // End of variables declaration//GEN-END:variables

}
