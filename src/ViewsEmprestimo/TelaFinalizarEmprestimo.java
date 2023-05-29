package ViewsEmprestimo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import DAO.LoansDAO;
import Model.LoanModel;

public class TelaFinalizarEmprestimo extends javax.swing.JFrame {

    private LoanModel loan = null;

    public TelaFinalizarEmprestimo() {
        initComponents();
    }

    public TelaFinalizarEmprestimo(LoanModel loan, String nome) {
        this();
        this.loan = loan;

        jTextArea1.setBackground(jLayeredPane1.getBackground());
        jTextArea1.setText(jTextArea1.getText().replaceAll("\\{name\\}", nome));
        jTextArea1.setText(jTextArea1.getText().replaceAll("\\{date\\}", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textObservacoes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnFinalizarEmprestimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar Empréstimo - Grupo Supimpa ");
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("ATENÇÃO");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(18);
        jTextArea1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Prezado(a) Cleudesvaldo,\n\nGostaríamos de informar que o empréstimo das suas ferramentas, que foram disponibilizas ao(a) amigo(a) {name}, \nestá sendo finalizado na data de {date}. Dessa forma, todas as ferramentas foram devolvidas e quaisquer débitos \npendentes relacionados a esse empréstimo foram devidamente quitados.\n\nAgradecemos a sua disposição em emprestar suas ferramentas e cuidar desse processo por meio do nosso software \nde organização de empréstimos. É importante que você confirme os detalhes abaixo referentes ao encerramento do \nempréstimo:\n\n1 - Estado final de conservação das ferramentas devolvidas:\n\n2 - Observações adicionais sobre o(a) amigo(a) {name} para futuros empréstimos:\n\nSolicitamos que revise as informações acima e confirme sua concordância clicando no botão de confirmação abaixo.\n");
        jScrollPane1.setViewportView(jTextArea1);

        textObservacoes.setColumns(20);
        textObservacoes.setRows(5);
        jScrollPane2.setViewportView(textObservacoes);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Observações:");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar A solicitação de Finalização");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFinalizarEmprestimo.setBackground(new java.awt.Color(153, 255, 153));
        btnFinalizarEmprestimo.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnFinalizarEmprestimo.setForeground(new java.awt.Color(51, 51, 51));
        btnFinalizarEmprestimo.setText("Finalizar Empréstimo");
        btnFinalizarEmprestimo.setToolTipText("Finalizar o Empréstimo de Forma Segura");
        btnFinalizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarEmprestimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(btnFinalizarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinalizarEmprestimo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarEmprestimoActionPerformed
        if (this.loan != null) {
            try {
                LoansDAO.getInstance().finalizarEmprestimo(this.loan, textObservacoes.getText());
                JOptionPane.showMessageDialog(null, "Emprestimo finalizado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nao foi possivel finalizar o emprestimo por algum erro interno, contacte o administrador do sistema.");
            }

            this.dispose();
        }
    }//GEN-LAST:event_btnFinalizarEmprestimoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFinalizarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea textObservacoes;
    // End of variables declaration//GEN-END:variables
}
