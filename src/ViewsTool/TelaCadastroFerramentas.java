package ViewsTool;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

import DAO.ToolsDAO;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.ManufacturerResource;
import Resources.PriceDocument;

public class TelaCadastroFerramentas extends javax.swing.JFrame {

    private ManufacturerResource selectedManufacturer = null;
    private ToolModel tool = null;

    public TelaCadastroFerramentas() {
        initComponents();
        initFrameConfig();
    }

    public TelaCadastroFerramentas(ToolModel tool) {
        this();
        this.tool = tool;

        this.setTitle("Alteraçao da ferramenta " + tool.getNome());
        this.textFerramentaNome.setText(tool.getNome());
        this.textFerramentaValor.setText(BRLResource.PRICE_FORMATTER.format(tool.getPrice()));
        this.selectedManufacturer = tool.getManufacturer();
        btnConcluirCad.setText("Concluir alteração");
        btnCancelarCad.setText("Cancelar alteração");

        if (this.selectedManufacturer != null) {
            this.textSelecionado.setText("Selecionado: " + this.selectedManufacturer.getName());
            this.btnRemoverFabricante.setEnabled(true);
        }

    }

    private void initFrameConfig() {
        AbstractDocument document = (AbstractDocument) textFerramentaValor.getDocument();

        document.setDocumentFilter(new PriceDocument());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        textFerramentaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textFerramentaValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSelectFabricante = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textSelecionado = new javax.swing.JLabel();
        btnRemoverFabricante = new javax.swing.JButton();
        btnConcluirCad = new javax.swing.JButton();
        btnCancelarCad = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Ferramenta - Grupo Supimpa");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Cadastro de Ferramenta");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Nome da Ferramenta");

        textFerramentaNome.setToolTipText("Nome da ferramenta");

        jLabel3.setText("Valor da ferramenta");

        textFerramentaValor.setToolTipText("Valor pago na ferramenta");

        jLabel4.setText("Fabricante");

        btnSelectFabricante.setText("Selecionar um Fabricante");
        btnSelectFabricante.setToolTipText("Selecione um Fabrincante Para a Ferramenta");
        btnSelectFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFabricanteActionPerformed(evt);
            }
        });

        jLabel6.setText("R$");

        textSelecionado.setText("Selecionado: nenhum");

        btnRemoverFabricante.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverFabricante.setText("Remover o Fabricante Selecionado ");
        btnRemoverFabricante.setToolTipText("Remove o Fabricante Selecionado ");
        btnRemoverFabricante.setEnabled(false);
        btnRemoverFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textFerramentaNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textFerramentaValor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSelectFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textSelecionado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnRemoverFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFerramentaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(btnSelectFabricante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textSelecionado))
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(194, 194, 194))
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(textFerramentaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel4)
                            .addComponent(btnRemoverFabricante))))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFerramentaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFerramentaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectFabricante)
                    .addComponent(textSelecionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoverFabricante)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        btnConcluirCad.setBackground(new java.awt.Color(153, 255, 153));
        btnConcluirCad.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnConcluirCad.setText("Concluir Cadastro");
        btnConcluirCad.setToolTipText("Finaliza o Cadastro Com Sucesso ");
        btnConcluirCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirCadActionPerformed(evt);
            }
        });

        btnCancelarCad.setText("Cancelar cadastro");
        btnCancelarCad.setToolTipText("Descarta as Opções Selecionadas ");
        btnCancelarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(531, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLayeredPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelarCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluirCad)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluirCad)
                    .addComponent(btnCancelarCad))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    public void updateFabricante(ManufacturerResource e) {
        textSelecionado.setText("Selecionado: " + e.getName());
        this.selectedManufacturer = e;
        btnRemoverFabricante.setEnabled(true);
    }

    private void btnSelectFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFabricanteActionPerformed
        TelaSelecionarFabricante tela = new TelaSelecionarFabricante(this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnSelectFabricanteActionPerformed

    private void btnConcluirCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirCadActionPerformed
        try {
            if (textFerramentaNome.getText().length() == 0 || textFerramentaValor.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            if (textFerramentaNome.getText().length() < 5 || textFerramentaNome.getText().length() > 50) {
                JOptionPane.showMessageDialog(null, "O nome da ferramenta deve ter entre 5 e 50 caracteres!");
                return;
            }

            if (textFerramentaValor.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "O valor da ferramenta deve ter no máximo 10 caracteres!");
                return;
            }

            double price = BRLResource.PRICE_FORMATTER.parse(textFerramentaValor.getText()).doubleValue();
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, "O valor da ferramenta deve ser maior que 0!");
                return;
            }

            if (this.tool == null) {
                ToolsDAO.getInstance().addTool(textFerramentaNome.getText().toUpperCase(), price, (selectedManufacturer != null ? selectedManufacturer.getId() : -1));
                JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
                this.dispose();
            } else {
                ToolModel newTool = new ToolModel(0, textFerramentaNome.getText().toUpperCase(), selectedManufacturer, price, 0);
                ToolsDAO.getInstance().updateTool(tool.getId(), newTool);
                JOptionPane.showMessageDialog(null, "Ferramenta alterada com sucesso!");
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor da ferramenta deve ser um número!");
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }


    }//GEN-LAST:event_btnConcluirCadActionPerformed

    private void btnRemoverFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFabricanteActionPerformed
        textSelecionado.setText("Selecionado: Nenhum");
        this.selectedManufacturer = null;
        btnRemoverFabricante.setEnabled(false);
    }//GEN-LAST:event_btnRemoverFabricanteActionPerformed

    private void btnCancelarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarCadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFerramentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCad;
    private javax.swing.JButton btnConcluirCad;
    private javax.swing.JButton btnRemoverFabricante;
    private javax.swing.JButton btnSelectFabricante;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField textFerramentaNome;
    private javax.swing.JTextField textFerramentaValor;
    private javax.swing.JLabel textSelecionado;
    // End of variables declaration//GEN-END:variables

}
