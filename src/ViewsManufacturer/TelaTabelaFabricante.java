package ViewsManufacturer;

import ViewsTool.TelaPainelFerramentas;
import Controllers.ColorsRenderer;
import Controllers.StatusRenderer;
import ViewsAmigos.*;
import java.awt.Color;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.FriendsDAO;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Model.FriendModel;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.CEPResource;
import Resources.CNPJResource;
import Resources.ManufacturerResource;

public class TelaTabelaFabricante extends javax.swing.JFrame {

    private ManufacturerResource selectedManufacturer = null;

    /**
     * Creates new form java
     */
    public TelaTabelaFabricante() {
        initComponents();
        initTable();
    }

    private void initTable() {
        Thread loadValues = new Thread(new Runnable() {
            @Override
            public void run() {
                    jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
                    jTable2.getColumnModel().getColumn(0).setMinWidth(35);
                    jTable2.getColumnModel().getColumn(0).setMaxWidth(35);

                jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jTable2.getSelectionModel().addListSelectionListener(x -> {
                    if (!x.getValueIsAdjusting()) {
                        int selectedRow = jTable2.getSelectedRow();
                        try {
                            if (selectedRow != -1) {
                                selectedManufacturer = ManufacturerDAO.getInstance().getManufacturer(Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString()));
                                selecionadoNome.setText(selectedManufacturer.getName());
                                selecionadoCNPJ.setText(CNPJResource.returnCNPJFormat(selectedManufacturer.getCNPJ()));
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao selecionar fabricante: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                });

                ((DefaultTableModel) jTable2.getModel()).setRowCount(0);

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
        canvas1 = new java.awt.Canvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        canvas2 = new java.awt.Canvas();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        filtroFiltrarNome = new javax.swing.JCheckBox();
        textFiltrarNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar1 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        btnRemoverCadastro = new javax.swing.JButton();
        selecionadoCNPJ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRelatorioFerramentas = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de amigos cadastrados - Grupo Supimpa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNPJ", "Ferramentas", "Ferramentas em uso", "Valor total"
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
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        canvas1.setBackground(new java.awt.Color(255, 57, 57));

        jLabel1.setText("Fabricante Sem Ferramentas Disponiveis");
        jLabel1.setToolTipText("Exibe Somente Fabricantes Que Não Tenham Ferramentas DIsponíveis");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setText("STATUS");

        jLabel2.setText("Fabricante Sem Ferramentas Cadastradas");
        jLabel2.setToolTipText("Exibe Fabricantes Que Não Tenham Nenhuma Ferramenta Cadastrada ");

        canvas2.setBackground(new java.awt.Color(255, 57, 57));

        jLayeredPane1.setLayer(canvas1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(canvas2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(45, Short.MAX_VALUE))
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
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        filtroFiltrarNome.setText("Filtrar Por Nome");
        filtroFiltrarNome.setToolTipText("Busca Pelo Nome do Fabricante ");
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

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(filtroFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textFiltrarNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnBuscar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(filtroFiltrarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFiltrarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(230, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar1)
                .addGap(16, 16, 16))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar1)
                .addContainerGap())
        );

        jLayeredPane3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setText("OPÇÕES");

        jLabel4.setText("Razao Social");

        selecionadoNome.setEditable(false);

        btnRemoverCadastro.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverCadastro.setText("Remover cadastro");
        btnRemoverCadastro.setToolTipText("Remove o Fabricante do Sistema");
        btnRemoverCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCadastroActionPerformed(evt);
            }
        });

        selecionadoCNPJ.setEditable(false);

        jLabel5.setText("CNPJ");

        btnRelatorioFerramentas.setText("Painel de Ferramentas");
        btnRelatorioFerramentas.setToolTipText("Permite a Atribuição de Ferramentas Para O Fabricante Selecionado");
        btnRelatorioFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFerramentasActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRemoverCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(selecionadoCNPJ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnRelatorioFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(selecionadoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRelatorioFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoverCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(selecionadoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorioFerramentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoverCadastro)
                .addContainerGap())
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
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane3)
                    .addComponent(jLayeredPane1))
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

    private void textFiltrarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFiltrarNomeActionPerformed

    }//GEN-LAST:event_textFiltrarNomeActionPerformed

    private void loadValores() {
        selecionadoCNPJ.setText("");
        selecionadoNome.setText("");
        selectedManufacturer = null;
        try {
            StatusRenderer renderer = new StatusRenderer();
            ArrayList<Object[]> manufacturerData = ManufacturerDAO.getInstance().getFabricantesData();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);

            for (Object[] data : manufacturerData) {
                if (filtroFiltrarNome.isSelected() && textFiltrarNome.getText().trim().length() > 0) {
                    if (!data[1].toString().toUpperCase().contains(textFiltrarNome.getText().toUpperCase().trim())) {
                        continue;
                    }
                }

                if (Integer.parseInt(data[3].toString()) == Integer.parseInt(data[4].toString())) {
                    if (Integer.parseInt(data[3].toString()) > 0) {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    } else {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightOrange);
                    }

                    for (int i = 0; i < jTable2.getColumnCount(); i++) {
                        jTable2.getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }

                }

                model.addRow(data);
            }
        } catch (Exception e) {

        }
    }

    private void textFiltrarNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFiltrarNomeKeyReleased
    }//GEN-LAST:event_textFiltrarNomeKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnRemoverCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCadastroActionPerformed
        try {
            if (selectedManufacturer != null) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o fabricante " + selectedManufacturer.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    if (ToolsDAO.getInstance().getToolsByManufacturer(selectedManufacturer.getId()).size() > 0) {
                        JOptionPane.showMessageDialog(null, "Não é possível remover um fabricante que possui ferramentas cadastradas!");
                        return;
                    }

                    ManufacturerDAO.getInstance().removeManufacturer(selectedManufacturer.getId());
                    loadValores();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fabricante", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverCadastroActionPerformed

    private void btnRelatorioFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFerramentasActionPerformed
        if (selectedManufacturer != null) {
            TelaPainelFerramentas tela = new TelaPainelFerramentas(selectedManufacturer);
            tela.setVisible(true);

            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    loadValores();
                }
            });
        }
    }//GEN-LAST:event_btnRelatorioFerramentasActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        loadValores();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTabelaFabricante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnRelatorioFerramentas;
    private javax.swing.JButton btnRemoverCadastro;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
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
    private javax.swing.JTextField selecionadoCNPJ;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField textFiltrarNome;
    // End of variables declaration//GEN-END:variables

}
