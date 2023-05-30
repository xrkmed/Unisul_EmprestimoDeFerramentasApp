package ViewsManufacturer;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import Controllers.CNPJEntity;
import DAO.ManufacturerDAO;
import Exceptions.CNPJNotFound;
import Resources.CNPJDocument;
import Resources.CNPJResource;
import Resources.ManufacturerResource;

public class TelaCadastroFabricantes extends javax.swing.JFrame {

    private CNPJEntity cnpjObject = null;

    public TelaCadastroFabricantes() {
        initComponents();
        configFrame();
    }

    private void configFrame() {
        AbstractDocument document = (AbstractDocument) textoCNPJ.getDocument();
        document.setDocumentFilter(new CNPJDocument());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        textoStatus = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CNPJLabel = new javax.swing.JLabel();
        textoEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textoSituacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textoCapitalSocial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textoTelefone = new javax.swing.JTextField();
        textoRazaoSocial = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        textoCNPJ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textoNomeFantasia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnVerificarFabricante = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        btnFinalizarCadastro1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPularVerificacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fabricantes - Grupo Supimpa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane2.setFocusTraversalPolicyProvider(true);
        jLayeredPane2.setFocusable(false);

        textoStatus.setEditable(false);
        textoStatus.setToolTipText("Insira o nome da fabricante");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel7.setText("Status:");

        CNPJLabel.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        CNPJLabel.setText("CNPJ");

        textoEndereco.setEditable(false);
        textoEndereco.setToolTipText("Insira o nome da fabricante");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Situação:");

        textoSituacao.setEditable(false);
        textoSituacao.setToolTipText("Insira o nome da fabricante");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Capital Social:");

        textoCapitalSocial.setEditable(false);
        textoCapitalSocial.setToolTipText("Insira o nome da fabricante");

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel9.setText("Telefone:");

        textoTelefone.setEditable(false);
        textoTelefone.setToolTipText("Insira o nome da fabricante");
        textoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTelefoneActionPerformed(evt);
            }
        });

        textoRazaoSocial.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        textoRazaoSocial.setText("NOME");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Endereço:");

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        textoCNPJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoCNPJ.setToolTipText("Insira o CNPJ da fabricante.");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("CNPJ");

        textoNomeFantasia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textoNomeFantasia.setToolTipText("Insira o nome da fabricante.");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Nome Fantasia");

        btnVerificarFabricante.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnVerificarFabricante.setForeground(new java.awt.Color(51, 51, 51));
        btnVerificarFabricante.setText("Consultar CNPJ");
        btnVerificarFabricante.setToolTipText("Realizar a Busca Automática Utilizando Somente o CNPJ");
        btnVerificarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(textoCNPJ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(textoNomeFantasia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(btnVerificarFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnVerificarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(textoNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(textoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnVerificarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLayeredPane2.setLayer(textoStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(CNPJLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textoEndereco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textoSituacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textoCapitalSocial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textoTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textoRazaoSocial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(194, 194, 194))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoEndereco)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane3)
                            .addComponent(textoCapitalSocial)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(CNPJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(textoStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoSituacao, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(textoRazaoSocial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(textoRazaoSocial)
                .addGap(15, 15, 15)
                .addComponent(CNPJLabel)
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(textoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoCapitalSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTelefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(textoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(textoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Cadastro Fabricantes");

        btnFinalizarCadastro1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnFinalizarCadastro1.setForeground(new java.awt.Color(51, 51, 51));
        btnFinalizarCadastro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-minus-custom.png"))); // NOI18N
        btnFinalizarCadastro1.setToolTipText("Cancelar");
        btnFinalizarCadastro1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnFinalizarCadastro1.setEnabled(false);
        btnFinalizarCadastro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastro1ActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-check-custom.png"))); // NOI18N
        btnCancelar.setToolTipText("Salvar Cadastro");
        btnCancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPularVerificacao.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnPularVerificacao.setForeground(new java.awt.Color(51, 51, 51));
        btnPularVerificacao.setText("Cadastro sem Verificação");
        btnPularVerificacao.setToolTipText("");
        btnPularVerificacao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnPularVerificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPularVerificacaoActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnFinalizarCadastro1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnPularVerificacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPularVerificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnFinalizarCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarCadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPularVerificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane5))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarFabricanteActionPerformed
        btnCancelar.setEnabled(false);
        if (textoNomeFantasia.getText().equals("") || textoCNPJ.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        if (!CNPJResource.validarCNPJ(textoCNPJ.getText())) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!");
            return;
        }

        if (textoNomeFantasia.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Nome do fabricante muito grande!");
            textoNomeFantasia.setText("");
            return;
        }

        if (textoNomeFantasia.getText().length() < 2) {
            JOptionPane.showMessageDialog(null, "Nome do fabricante muito pequeno!");
            textoNomeFantasia.setText("");
            return;
        }

        try {
            if (ManufacturerDAO.getInstance().getManufacturer(CNPJResource.returnCNPJUnformat(textoCNPJ.getText())) != null) {
                JOptionPane.showMessageDialog(null, "Fabricante com este CNPJ já cadastrado!");
                textoCNPJ.setText("");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (CNPJResource.validarCNPJ(CNPJResource.returnCNPJUnformat(textoCNPJ.getText()))) {
            Thread consultarCNPJ = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cnpjObject = CNPJResource.consultarCNPJ(CNPJResource.returnCNPJUnformat(textoCNPJ.getText()));

                        textoEndereco.setText(cnpjObject.getSampleAddress());
                        textoRazaoSocial.setText(cnpjObject.getNome());
                        textoTelefone.setText(cnpjObject.getTelefone());
                        textoStatus.setText(cnpjObject.getStatus());
                        textoCapitalSocial.setText("R$ " + cnpjObject.getCapitalSocial());
                        textoSituacao.setText(cnpjObject.getSituacao());
                        CNPJLabel.setText(cnpjObject.getCNPJ());

                        if (cnpjObject.getStatus().equals("OK")) {
                            btnCancelar.setEnabled(true);
                        }

                    } catch (IllegalArgumentException | CNPJNotFound e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            });
            consultarCNPJ.start();

            JOptionPane.showMessageDialog(null, "Aguarde enquanto consultamos o CNPJ informado...");

        }
    }//GEN-LAST:event_btnVerificarFabricanteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (cnpjObject != null && cnpjObject.getStatus().equals("OK")) {
            try {
                ManufacturerResource manufacturer = ManufacturerDAO.getInstance().addManufacturer(cnpjObject.getNome(), CNPJResource.returnCNPJUnformat(cnpjObject.getCNPJ()));
                JOptionPane.showMessageDialog(null, "Fabricante " + cnpjObject.getNome() + " (" + cnpjObject.getCNPJ() + ") cadastrado com sucesso!");
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void btnPularVerificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPularVerificacaoActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Pular a verificaçao de CNPJ pode resultar em dados incorretos do fabricante, voce tem certeza que deseja cadastrar sem buscar por mais informacoes?", "Confirmar escolha", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.NO_OPTION) {
            return;
        }

        if (textoNomeFantasia.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do fabricante!");
            return;
        }

        if (textoNomeFantasia.getText().length() < 3 || textoNomeFantasia.getText().length() > 50) {
            JOptionPane.showMessageDialog(null, "Nome do fabricante inválido!");
            return;
        }

        if (CNPJResource.validarCNPJ(textoCNPJ.getText())) {
            try {
                ManufacturerResource manufacturer = ManufacturerDAO.getInstance().addManufacturer(textoNomeFantasia.getText().toUpperCase(), CNPJResource.returnCNPJUnformat(textoCNPJ.getText()));
                JOptionPane.showMessageDialog(null, "Fabricante " + manufacturer.getName() + " (" + manufacturer.getCNPJ() + ") cadastrado com sucesso!");
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!");
        }
    }//GEN-LAST:event_btnPularVerificacaoActionPerformed

    private void btnFinalizarCadastro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarCadastro1ActionPerformed

    private void textoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTelefoneActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFabricantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNPJLabel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarCadastro1;
    private javax.swing.JButton btnPularVerificacao;
    private javax.swing.JButton btnVerificarFabricante;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JTextField textoCNPJ;
    private javax.swing.JTextField textoCapitalSocial;
    private javax.swing.JTextField textoEndereco;
    private javax.swing.JTextField textoNomeFantasia;
    private javax.swing.JLabel textoRazaoSocial;
    private javax.swing.JTextField textoSituacao;
    private javax.swing.JTextField textoStatus;
    private javax.swing.JTextField textoTelefone;
    // End of variables declaration//GEN-END:variables

}
