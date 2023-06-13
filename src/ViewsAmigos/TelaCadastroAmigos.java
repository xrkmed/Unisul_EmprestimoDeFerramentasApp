package ViewsAmigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import Enums.ScreenSelectionType;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Documents.PhoneDocument;
import Resources.PhoneResource;

public class TelaCadastroAmigos extends javax.swing.JFrame {

    private FriendModel selectedFriend = null;

    public TelaCadastroAmigos() {
        initComponents();
        configFrame();

    }

    public TelaCadastroAmigos(FriendModel selectedFriend, ScreenSelectionType screenType) {
        this();
        this.selectedFriend = selectedFriend;
        this.setTitle((screenType == ScreenSelectionType.SCREEN_TYPE_EDIT ? "Alterar" : "Visualizar") + " cadastro de " + selectedFriend.getName().toUpperCase());
        textNome.setText(selectedFriend.getName());
        textTelefone.setText(selectedFriend.getPhone());
        if (screenType == ScreenSelectionType.SCREEN_TYPE_VIEW) {
            btnCadastrar.setEnabled(false);
            btnCriarEmprestimo.setEnabled(false);
            textNome.setEditable(false);
            textTelefone.setEditable(false);
        }
    }

    private void configFrame() {

        AbstractDocument document = (AbstractDocument) textTelefone.getDocument();

        document.setDocumentFilter(new PhoneDocument());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        btnVisualizarEmprestimos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCriarEmprestimo = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados Cadastrais - Grupo Supimpa");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Nome Completo:");

        textNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textNome.setToolTipText("Digite o Nome Completo Do Seu Amigo");
        textNome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textNome.setInheritsPopupMenu(true);
        textNome.setName(""); // NOI18N
        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });
        textNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNomeKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Telefone:");

        textTelefone.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textTelefone.setToolTipText("Digite o Telefone Do Seu Amigo");
        textTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefoneActionPerformed(evt);
            }
        });
        textTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTelefoneKeyPressed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(textNome))
                .addGap(15, 15, 15))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addGap(15, 15, 15))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnVisualizarEmprestimos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/eye-custom.png"))); // NOI18N
        btnVisualizarEmprestimos.setToolTipText("Visualizar Empréstimos");
        btnVisualizarEmprestimos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnVisualizarEmprestimos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVisualizarEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarEmprestimosActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-minus-custom.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Dados Cadastrais");

        btnCadastrar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-check-custom.png"))); // NOI18N
        btnCadastrar.setToolTipText("Salvar Cadastro");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCriarEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/plus-custom.png"))); // NOI18N
        btnCriarEmprestimo.setToolTipText("Criar Novo Empréstimo");
        btnCriarEmprestimo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCriarEmprestimo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCriarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarEmprestimoActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(btnVisualizarEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCadastrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnCriarEmprestimo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnCriarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnVisualizarEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizarEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void textTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneActionPerformed

    private void textNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeKeyPressed

    }//GEN-LAST:event_textNomeKeyPressed

    private void textTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefoneKeyPressed

    }//GEN-LAST:event_textTelefoneKeyPressed

    private void btnCriarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarEmprestimoActionPerformed
        new ViewsEmprestimo.TelaCadastroEmprestimo(selectedFriend).setVisible(true);
    }//GEN-LAST:event_btnCriarEmprestimoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ArrayList<String> erros = new ArrayList<String>();

        if (!PhoneResource.verificarNomeCompleto(textNome.getText())) {
            erros.add("Nome Inválido! Digite o nome completo (Ex: João da Silva)");
            textNome.setText("");
            textNome.setEnabled(true);
        }

        if (!PhoneResource.isValidPhoneNumber(PhoneResource.unformatPhoneNumber(textTelefone.getText()))) {
            erros.add("Telefone Inválido! Use o formato (DDD) 9.1234-1234");
            textTelefone.setText("");
            textTelefone.setEnabled(true);
        }

        if (erros.size() > 0) {
            String mensagem = "";
            for (String erro : erros) {
                mensagem += erro + "\n";
            }
            JOptionPane.showMessageDialog(null, "[+] Alguns erros foram encontrados: \n\n\n" + mensagem);
        } else {
            if (selectedFriend == null) {
                try {
                    FriendModel friendModel = FriendsDAO.getInstance().addFriend(textNome.getText().toUpperCase(), PhoneResource.unformatPhoneNumber(textTelefone.getText()));
                    JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso! (" + friendModel.getId() + ")");
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                try {
                    FriendModel friendModel = FriendsDAO.getInstance().getFriend(selectedFriend.getId());
                    if (friendModel == null) {
                        throw new Exception("Amigo não encontrado");
                    }

                    friendModel.setName(textNome.getText().toUpperCase());
                    friendModel.setPhone(PhoneResource.unformatPhoneNumber(textTelefone.getText()));
                    FriendsDAO.getInstance().updateFriend(selectedFriend, friendModel);
                    JOptionPane.showMessageDialog(null, "Amigo alterado com sucesso!");
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked

    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVisualizarEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarEmprestimosActionPerformed
        if (selectedFriend != null) {
            try {
                ArrayList<Object[]> datas = LoansDAO.getInstance().getEmprestimosEmAberto(selectedFriend.getName());
                String mensagem = "";
                for (Object[] data : datas) {
                    mensagem += data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4] + " " + data[5] + " " + data[6] + " " + data[7] + "\n";
                    JOptionPane.showMessageDialog(null, mensagem);
                    return;
                }
                JOptionPane.showMessageDialog(null, "não tem imprestimos ativos");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnVisualizarEmprestimosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriarEmprestimo;
    private javax.swing.JButton btnVisualizarEmprestimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables

}
