package ViewsTool;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

import Enums.ScreenSelectionType;
import DAO.ToolsDAO;
import Model.ToolModel;
import Resources.BRLFormat;
import Model.ManufacturerModel;
import Documents.PriceDocument;

public class TelaCadastroFerramentas extends javax.swing.JFrame {

    private ManufacturerModel selectedManufacturer = null;
    private ToolModel tool = null;

    public TelaCadastroFerramentas() {
        initComponents();
        initFrameConfig();
    }

    public TelaCadastroFerramentas(ToolModel tool, ScreenSelectionType viewType) {
        this();
        this.tool = tool;

        this.setTitle("Alteraçao da ferramenta " + tool.getNome());
        this.textFerramentaNome.setText(tool.getNome());
        this.textFerramentaValor.setText(BRLFormat.PRICE_FORMATTER.format(tool.getPrice()));
        this.selectedManufacturer = tool.getManufacturer();
        btnConcluirCad.setText("Concluir alteração");
        btnCancelarCad.setText("Cancelar alteração");

        if (this.selectedManufacturer != null) {
            this.textSelecionado.setText("Selecionado: " + this.selectedManufacturer.getName());
            this.btnRemoverFabricante.setEnabled(true);
        }

        if (viewType == ScreenSelectionType.SCREEN_TYPE_VIEW) {
            this.textFerramentaNome.setEditable(false);
            this.textFerramentaValor.setEditable(false);
            this.btnSelectFabricante.setEnabled(false);
            this.btnRemoverFabricante.setEnabled(false);
            this.btnConcluirCad.setEnabled(false);
            this.btnCancelarCad.setText("Voltar");
        }

    }

    private void initFrameConfig() {
        AbstractDocument document = (AbstractDocument) textFerramentaValor.getDocument();

        document.setDocumentFilter(new PriceDocument());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        textFerramentaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textFerramentaValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textSelecionado = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        btnCancelarCad = new javax.swing.JButton();
        btnConcluirCad = new javax.swing.JButton();
        btnSelectFabricante = new javax.swing.JButton();
        btnRemoverFabricante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Ferramenta - Grupo Supimpa");
        setPreferredSize(null);
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        textFerramentaNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textFerramentaNome.setToolTipText("Nome da Ferramenta");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Valor:");

        textFerramentaValor.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textFerramentaValor.setToolTipText("Valor da Ferramenta");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Fabricante:");
        jLabel4.setToolTipText("Selecione ou Remova nos Botões \"+\" e \"-\"");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("R$");

        textSelecionado.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textSelecionado.setText("Selecionado: Nenhum");
        textSelecionado.setToolTipText("Selecione ou Remova nos Botões \"+\" e \"-\"");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textFerramentaNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textFerramentaValor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textSelecionado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(textFerramentaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(textSelecionado)
                    .addComponent(jLabel3)
                    .addComponent(textFerramentaNome)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(textFerramentaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFerramentaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(textSelecionado)
                .addGap(10, 10, 10))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Cadastro Ferramentas");

        btnCancelarCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-minus-custom.png"))); // NOI18N
        btnCancelarCad.setToolTipText("Cancelar");
        btnCancelarCad.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadActionPerformed(evt);
            }
        });

        btnConcluirCad.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnConcluirCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-check-custom.png"))); // NOI18N
        btnConcluirCad.setToolTipText("Salvar Cadastro");
        btnConcluirCad.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnConcluirCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirCadActionPerformed(evt);
            }
        });

        btnSelectFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/plus-box-custom.png"))); // NOI18N
        btnSelectFabricante.setToolTipText("Selecionar Fabricante");
        btnSelectFabricante.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSelectFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFabricanteActionPerformed(evt);
            }
        });

        btnRemoverFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/minus-box-custom.png"))); // NOI18N
        btnRemoverFabricante.setToolTipText("Remover Fabricante");
        btnRemoverFabricante.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRemoverFabricante.setEnabled(false);
        btnRemoverFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCancelarCad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnConcluirCad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnSelectFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnRemoverFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnRemoverFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSelectFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnConcluirCad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnConcluirCad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane5))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void updateFabricante(ManufacturerModel e) {
        textSelecionado.setText(e.getName());
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

            double price = BRLFormat.PRICE_FORMATTER.parse(textFerramentaValor.getText()).doubleValue();
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, "O valor da ferramenta deve ser maior que 0!");
                return;
            }

            if (this.tool == null) {
                ToolsDAO.getInstance().addTool(textFerramentaNome.getText().toUpperCase(), price, (selectedManufacturer != null ? selectedManufacturer.getId() : -1));
                JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
                this.dispose();
            } else {
                ToolModel newTool = new ToolModel(0, textFerramentaNome.getText().toUpperCase(), selectedManufacturer, price);
                ToolsDAO.getInstance().updateTool(tool.getId(), newTool);
                JOptionPane.showMessageDialog(null, "Ferramenta alterada com sucesso!");
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor da ferramenta deve ser um número!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JTextField textFerramentaNome;
    private javax.swing.JTextField textFerramentaValor;
    private javax.swing.JLabel textSelecionado;
    // End of variables declaration//GEN-END:variables

}
