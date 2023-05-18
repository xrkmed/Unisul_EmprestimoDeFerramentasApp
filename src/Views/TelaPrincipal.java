/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package Views;

import ViewsAmigos.TelaTabelaAmigos;
import ViewsEmprestimo.TelaCadastroEmprestimo;

/**
 *
 * @author arkmed
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenu1 = new javax.swing.JMenu();
        btnCadastrarAmigo = new javax.swing.JMenuItem();
        btnViewAmigosCad = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioAmigos = new javax.swing.JMenuItem();
        btnRankingAmigos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fileMenu5 = new javax.swing.JMenu();
        btnRealizarEmprestimo = new javax.swing.JMenuItem();
        btnRealizarEmprestimo1 = new javax.swing.JMenuItem();
        btnRealizarEmprestimo2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioEmprestimo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        fileMenu3 = new javax.swing.JMenu();
        btnCadastrarFerramenta = new javax.swing.JMenuItem();
        btnFerramentasCad = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioFerramentas = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        fileMenu6 = new javax.swing.JMenu();
        btnCadastrarFabricante = new javax.swing.JMenuItem();
        btnVisualizarFabricante = new javax.swing.JMenuItem();
        btnControleGastosFabricantes = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        btnRelatorioFabricantes = new javax.swing.JMenuItem();
        fileMenu4 = new javax.swing.JMenu();
        btnClose = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grupo Supimpa - Aplicativo de gerenciamento de emprestimo de ferramentas");

        fileMenu.setMnemonic('f');
        fileMenu.setText("Administrativo");

        fileMenu1.setMnemonic('f');
        fileMenu1.setText("Amigos");

        btnCadastrarAmigo.setMnemonic('x');
        btnCadastrarAmigo.setText("Cadastrar um novo amigo");
        btnCadastrarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAmigoActionPerformed(evt);
            }
        });
        fileMenu1.add(btnCadastrarAmigo);

        btnViewAmigosCad.setMnemonic('x');
        btnViewAmigosCad.setText("Visualizar amigos cadastrados");
        btnViewAmigosCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAmigosCadActionPerformed(evt);
            }
        });
        fileMenu1.add(btnViewAmigosCad);
        fileMenu1.add(jSeparator4);

        btnRelatorioAmigos.setMnemonic('x');
        btnRelatorioAmigos.setText("Relatorio de amigos");
        btnRelatorioAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioAmigosActionPerformed(evt);
            }
        });
        fileMenu1.add(btnRelatorioAmigos);

        btnRankingAmigos.setMnemonic('x');
        btnRankingAmigos.setText("Ranking de amigos");
        fileMenu1.add(btnRankingAmigos);

        fileMenu.add(fileMenu1);
        fileMenu.add(jSeparator1);

        fileMenu5.setMnemonic('f');
        fileMenu5.setText("Emprestimos");

        btnRealizarEmprestimo.setMnemonic('x');
        btnRealizarEmprestimo.setText("Cadastrar um novo emprestimo");
        btnRealizarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRealizarEmprestimo);

        btnRealizarEmprestimo1.setMnemonic('x');
        btnRealizarEmprestimo1.setText("Emprestimos em aberto");
        btnRealizarEmprestimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarEmprestimo1ActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRealizarEmprestimo1);

        btnRealizarEmprestimo2.setMnemonic('x');
        btnRealizarEmprestimo2.setText("Historico de Emprestimos");
        btnRealizarEmprestimo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarEmprestimo2ActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRealizarEmprestimo2);
        fileMenu5.add(jSeparator5);

        btnRelatorioEmprestimo.setMnemonic('x');
        btnRelatorioEmprestimo.setText("Controle financeiro");
        btnRelatorioEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRelatorioEmprestimo);

        fileMenu.add(fileMenu5);
        fileMenu.add(jSeparator2);

        fileMenu3.setMnemonic('f');
        fileMenu3.setText("Ferramentas");

        btnCadastrarFerramenta.setMnemonic('x');
        btnCadastrarFerramenta.setText("Cadastrar uma nova ferramenta");
        btnCadastrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFerramentaActionPerformed(evt);
            }
        });
        fileMenu3.add(btnCadastrarFerramenta);

        btnFerramentasCad.setMnemonic('x');
        btnFerramentasCad.setText("Visualizar todas as ferramentas");
        btnFerramentasCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFerramentasCadActionPerformed(evt);
            }
        });
        fileMenu3.add(btnFerramentasCad);
        fileMenu3.add(jSeparator6);

        btnRelatorioFerramentas.setMnemonic('x');
        btnRelatorioFerramentas.setText("Relatorio de ferramentas");
        btnRelatorioFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFerramentasActionPerformed(evt);
            }
        });
        fileMenu3.add(btnRelatorioFerramentas);
        fileMenu3.add(jSeparator7);

        fileMenu.add(fileMenu3);
        fileMenu.add(jSeparator8);

        fileMenu6.setMnemonic('f');
        fileMenu6.setText("Fabricantes");

        btnCadastrarFabricante.setMnemonic('x');
        btnCadastrarFabricante.setText("Cadastrar um fabricante");
        btnCadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnCadastrarFabricante);

        btnVisualizarFabricante.setMnemonic('x');
        btnVisualizarFabricante.setText("Visualizar fabricantes");
        btnVisualizarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnVisualizarFabricante);

        btnControleGastosFabricantes.setMnemonic('x');
        btnControleGastosFabricantes.setText("Controle de gastos");
        btnControleGastosFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleGastosFabricantesActionPerformed(evt);
            }
        });
        fileMenu6.add(btnControleGastosFabricantes);
        fileMenu6.add(jSeparator9);

        btnRelatorioFabricantes.setMnemonic('x');
        btnRelatorioFabricantes.setText("Relatorio de fabricantes");
        btnRelatorioFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioFabricantesActionPerformed(evt);
            }
        });
        fileMenu6.add(btnRelatorioFabricantes);

        fileMenu.add(fileMenu6);

        menuBar.add(fileMenu);

        fileMenu4.setMnemonic('f');
        fileMenu4.setText("Segurança");

        btnClose.setText("Sair do programa");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        fileMenu4.add(btnClose);
        fileMenu4.add(jSeparator3);

        menuBar.add(fileMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAmigoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsAmigos.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarAmigoActionPerformed

    private void btnViewAmigosCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAmigosCadActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaTabelaAmigos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnViewAmigosCadActionPerformed

    private void btnRealizarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarEmprestimoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRealizarEmprestimoActionPerformed

    private void btnCadastrarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFerramentaActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarFerramentaActionPerformed

    private void btnFerramentasCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFerramentasCadActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaTabelaFerramentas().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnFerramentasCadActionPerformed

    private void btnRelatorioAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioAmigosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatorioAmigosActionPerformed

    private void btnRelatorioEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatorioEmprestimoActionPerformed

    private void btnRelatorioFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFerramentasActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsTool.TelaRelatorioFerramentas().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRelatorioFerramentasActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCadastrarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFabricanteActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaCadastro().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnCadastrarFabricanteActionPerformed

    private void btnVisualizarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarFabricanteActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaTabelaFabricante().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnVisualizarFabricanteActionPerformed

    private void btnControleGastosFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleGastosFabricantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnControleGastosFabricantesActionPerformed

    private void btnRelatorioFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFabricantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRelatorioFabricantesActionPerformed

    private void btnRealizarEmprestimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarEmprestimo1ActionPerformed
         Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsEmprestimo.TelaEmprestimosAbertos().setVisible(true);
            }
        });

        newThread.start();
    }//GEN-LAST:event_btnRealizarEmprestimo1ActionPerformed

    private void btnRealizarEmprestimo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarEmprestimo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarEmprestimo2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCadastrarAmigo;
    private javax.swing.JMenuItem btnCadastrarFabricante;
    private javax.swing.JMenuItem btnCadastrarFerramenta;
    private javax.swing.JMenuItem btnClose;
    private javax.swing.JMenuItem btnControleGastosFabricantes;
    private javax.swing.JMenuItem btnFerramentasCad;
    private javax.swing.JMenuItem btnRankingAmigos;
    private javax.swing.JMenuItem btnRealizarEmprestimo;
    private javax.swing.JMenuItem btnRealizarEmprestimo1;
    private javax.swing.JMenuItem btnRealizarEmprestimo2;
    private javax.swing.JMenuItem btnRelatorioAmigos;
    private javax.swing.JMenuItem btnRelatorioEmprestimo;
    private javax.swing.JMenuItem btnRelatorioFabricantes;
    private javax.swing.JMenuItem btnRelatorioFerramentas;
    private javax.swing.JMenuItem btnViewAmigosCad;
    private javax.swing.JMenuItem btnVisualizarFabricante;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JMenu fileMenu3;
    private javax.swing.JMenu fileMenu4;
    private javax.swing.JMenu fileMenu5;
    private javax.swing.JMenu fileMenu6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
