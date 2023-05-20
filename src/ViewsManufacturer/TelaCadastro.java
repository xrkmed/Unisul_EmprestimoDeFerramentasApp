package ViewsManufacturer;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
//import javax.xml.ws.http.HTTPException;

import Controllers.CNPJEntity;
import DAO.ManufacturerDAO;
import Exceptions.CNPJNotFound;
import Resources.CNPJDocument;
import Resources.CNPJResource;
import Resources.ManufacturerResource;

public class TelaCadastro extends javax.swing.JFrame {

    private CNPJEntity cnpjObject = null;

    public TelaCadastro() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        textoCNPJ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textoNomeFantasia = new javax.swing.JTextField();
        btnVerificarFabricante = new javax.swing.JButton();
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
        btnFinalizarCadastro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnPularVerificacao = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Supimpa - Cadastro de fabricante");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Nome Fantasia");

        textoCNPJ.setToolTipText("Insira o CNPJ da marca");

        jLabel3.setText("CNPJ");

        jLabel5.setText("Valor em ferramentas: R$ 0,00");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Consultar Fabricante");

        textoNomeFantasia.setToolTipText("Insira o nome da fabricante");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textoCNPJ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textoNomeFantasia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textoNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(textoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnVerificarFabricante.setText("Verificar fabricante");
        btnVerificarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarFabricanteActionPerformed(evt);
            }
        });

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane2.setFocusTraversalPolicyProvider(true);
        jLayeredPane2.setFocusable(false);

        textoStatus.setEditable(false);
        textoStatus.setToolTipText("Insira o nome da fabricante");

        jLabel7.setText("Status");

        CNPJLabel.setText("CNPJ");

        textoEndereco.setEditable(false);
        textoEndereco.setToolTipText("Insira o nome da fabricante");

        jLabel4.setText("Situaçao");

        textoSituacao.setEditable(false);
        textoSituacao.setToolTipText("Insira o nome da fabricante");

        jLabel8.setText("Capital Social");

        textoCapitalSocial.setEditable(false);
        textoCapitalSocial.setToolTipText("Insira o nome da fabricante");

        jLabel9.setText("Telefone");

        textoTelefone.setEditable(false);
        textoTelefone.setToolTipText("Insira o nome da fabricante");

        textoRazaoSocial.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        textoRazaoSocial.setForeground(new java.awt.Color(255, 0, 0));
        textoRazaoSocial.setText("NOME");

        btnFinalizarCadastro.setBackground(new java.awt.Color(153, 255, 153));
        btnFinalizarCadastro.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnFinalizarCadastro.setText("Finalizar cadastro");
        btnFinalizarCadastro.setEnabled(false);
        btnFinalizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCadastroActionPerformed(evt);
            }
        });

        jLabel10.setText("Endereço Matriz");

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
        jLayeredPane2.setLayer(btnFinalizarCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoEndereco)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(textoCapitalSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(textoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(textoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(CNPJLabel)
                            .addComponent(textoRazaoSocial))
                        .addGap(0, 390, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(textoRazaoSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CNPJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCapitalSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnFinalizarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPularVerificacao.setText("Cadastrar fabricante sem verificar status do CNPJ");
        btnPularVerificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPularVerificacaoActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Segurança");

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPularVerificacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPularVerificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerificarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void btnVerificarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarFabricanteActionPerformed
        btnFinalizarCadastro.setEnabled(false);
        if (textoNomeFantasia.getText().equals("") || textoCNPJ.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        if (CNPJResource.returnCNPJUnformat(textoCNPJ.getText()).length() != 14) {
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
                            btnFinalizarCadastro.setEnabled(true);
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

    private void btnFinalizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCadastroActionPerformed
        if (cnpjObject != null && cnpjObject.getStatus().equals("OK")) {
            try {
                ManufacturerResource manufacturer = ManufacturerDAO.getInstance().addManufacturer(cnpjObject.getNome(), CNPJResource.returnCNPJUnformat(cnpjObject.getCNPJ()));
                JOptionPane.showMessageDialog(null, "Fabricante " + cnpjObject.getNome() + " (" + cnpjObject.getCNPJ() + ") cadastrado com sucesso!");
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnFinalizarCadastroActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNPJLabel;
    private javax.swing.JButton btnFinalizarCadastro;
    private javax.swing.JButton btnPularVerificacao;
    private javax.swing.JButton btnVerificarFabricante;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenuBar menuBar;
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
