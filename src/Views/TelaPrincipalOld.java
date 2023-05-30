package Views;

import ViewsAmigos.TelaTabelaAmigos;
import ViewsEmprestimo.TelaCadastroEmprestimo;
import ViewsAmigos.TelaRelatorioAmigos;
import Controllers.ThemeController;
import Resources.Enum_Themes;

public class TelaPrincipalOld extends javax.swing.JFrame {

    public TelaPrincipalOld() {
        initComponents();
    }

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
        btnCadastrarEmprestimo = new javax.swing.JMenuItem();
        btnEmprestimosEmAberto = new javax.swing.JMenuItem();
        btnRelatorioEmprestimo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        btnControleFinanceiro = new javax.swing.JMenuItem();
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
        fileMenu2 = new javax.swing.JMenu();
        fileMenu7 = new javax.swing.JMenu();
        btnTemaDark = new javax.swing.JMenuItem();
        btnTemaLight = new javax.swing.JMenuItem();
        fileMenu8 = new javax.swing.JMenu();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Supimpa - ToolStock Manager");

        fileMenu.setMnemonic('f');
        fileMenu.setText("Administrativo");

        fileMenu1.setMnemonic('f');
        fileMenu1.setText("Amigos");

        btnCadastrarAmigo.setMnemonic('x');
        btnCadastrarAmigo.setText("Cadastrar Novo Amigo");
        btnCadastrarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAmigoActionPerformed(evt);
            }
        });
        fileMenu1.add(btnCadastrarAmigo);

        btnViewAmigosCad.setMnemonic('x');
        btnViewAmigosCad.setText("Amigos Cadastrados");
        btnViewAmigosCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAmigosCadActionPerformed(evt);
            }
        });
        fileMenu1.add(btnViewAmigosCad);
        fileMenu1.add(jSeparator4);

        btnRelatorioAmigos.setMnemonic('x');
        btnRelatorioAmigos.setText("Relatório de Amigos");
        btnRelatorioAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioAmigosActionPerformed(evt);
            }
        });
        fileMenu1.add(btnRelatorioAmigos);

        btnRankingAmigos.setMnemonic('x');
        btnRankingAmigos.setText("Ranking de Amigos");
        btnRankingAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingAmigosActionPerformed(evt);
            }
        });
        fileMenu1.add(btnRankingAmigos);

        fileMenu.add(fileMenu1);
        fileMenu.add(jSeparator1);

        fileMenu5.setMnemonic('f');
        fileMenu5.setText("Empréstimos");

        btnCadastrarEmprestimo.setMnemonic('x');
        btnCadastrarEmprestimo.setText("Cadastrar Novo Empréstimo");
        btnCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnCadastrarEmprestimo);

        btnEmprestimosEmAberto.setMnemonic('x');
        btnEmprestimosEmAberto.setText("Empréstimos em Aberto");
        btnEmprestimosEmAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimosEmAbertoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnEmprestimosEmAberto);

        btnRelatorioEmprestimo.setMnemonic('x');
        btnRelatorioEmprestimo.setText("Relatório Empréstimos Finalizados");
        btnRelatorioEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioEmprestimoActionPerformed(evt);
            }
        });
        fileMenu5.add(btnRelatorioEmprestimo);
        fileMenu5.add(jSeparator5);

        btnControleFinanceiro.setMnemonic('x');
        btnControleFinanceiro.setText("Controle Financeiro");
        btnControleFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleFinanceiroActionPerformed(evt);
            }
        });
        fileMenu5.add(btnControleFinanceiro);

        fileMenu.add(fileMenu5);
        fileMenu.add(jSeparator2);

        fileMenu3.setMnemonic('f');
        fileMenu3.setText("Ferramentas");

        btnCadastrarFerramenta.setMnemonic('x');
        btnCadastrarFerramenta.setText("Cadastrar Ferramenta");
        btnCadastrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFerramentaActionPerformed(evt);
            }
        });
        fileMenu3.add(btnCadastrarFerramenta);

        btnFerramentasCad.setMnemonic('x');
        btnFerramentasCad.setText("Visualizar Ferramentas");
        btnFerramentasCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFerramentasCadActionPerformed(evt);
            }
        });
        fileMenu3.add(btnFerramentasCad);
        fileMenu3.add(jSeparator6);

        btnRelatorioFerramentas.setMnemonic('x');
        btnRelatorioFerramentas.setText("Relatório de Ferramentas");
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
        btnCadastrarFabricante.setText("Cadastrar Fabricante");
        btnCadastrarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnCadastrarFabricante);

        btnVisualizarFabricante.setMnemonic('x');
        btnVisualizarFabricante.setText("Visualizar Fabricantes");
        btnVisualizarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarFabricanteActionPerformed(evt);
            }
        });
        fileMenu6.add(btnVisualizarFabricante);

        btnControleGastosFabricantes.setMnemonic('x');
        btnControleGastosFabricantes.setText("Controle de Gastos");
        btnControleGastosFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleGastosFabricantesActionPerformed(evt);
            }
        });
        fileMenu6.add(btnControleGastosFabricantes);
        fileMenu6.add(jSeparator9);

        btnRelatorioFabricantes.setMnemonic('x');
        btnRelatorioFabricantes.setText("Relatório de Fabricantes");
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

        btnClose.setText("Sair do Programa");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        fileMenu4.add(btnClose);
        fileMenu4.add(jSeparator3);

        menuBar.add(fileMenu4);

        fileMenu2.setMnemonic('f');
        fileMenu2.setText("Visual");

        fileMenu7.setMnemonic('f');
        fileMenu7.setText("Temas");

        btnTemaDark.setMnemonic('x');
        btnTemaDark.setText("Escuro");
        btnTemaDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaDarkActionPerformed(evt);
            }
        });
        fileMenu7.add(btnTemaDark);

        btnTemaLight.setMnemonic('x');
        btnTemaLight.setText("Claro");
        btnTemaLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemaLightActionPerformed(evt);
            }
        });
        fileMenu7.add(btnTemaLight);

        fileMenu2.add(fileMenu7);

        menuBar.add(fileMenu2);

        fileMenu8.setMnemonic('f');
        fileMenu8.setText("Desenvolvimento");
        fileMenu8.add(jSeparator11);

        menuBar.add(fileMenu8);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAmigoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsAmigos.TelaCadastroAmigos().setVisible(true);
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

    private void btnCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEmprestimoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });
        newThread.start();
    }//GEN-LAST:event_btnCadastrarEmprestimoActionPerformed

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
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TelaRelatorioAmigos().setVisible(true);
            }
        });
        newThread.start();
    }//GEN-LAST:event_btnRelatorioAmigosActionPerformed

    private void btnControleFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleFinanceiroActionPerformed
    }//GEN-LAST:event_btnControleFinanceiroActionPerformed

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
                new ViewsManufacturer.TelaCadastroFerramentas().setVisible(true);
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
    }//GEN-LAST:event_btnControleGastosFabricantesActionPerformed

    private void btnRelatorioFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioFabricantesActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsManufacturer.TelaRelatorioFabricante().setVisible(true);
            }
        });
        newThread.start();
    }//GEN-LAST:event_btnRelatorioFabricantesActionPerformed

    private void btnEmprestimosEmAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosEmAbertoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsEmprestimo.TelaEmprestimosAbertos().setVisible(true);
            }
        });
        newThread.start();
    }//GEN-LAST:event_btnEmprestimosEmAbertoActionPerformed

    private void btnRelatorioEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioEmprestimoActionPerformed
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new ViewsEmprestimo.TelaRelatorioEmprestimos().setVisible(true);
            }
        });
        newThread.start();
    }//GEN-LAST:event_btnRelatorioEmprestimoActionPerformed

    private void btnRankingAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingAmigosActionPerformed
    }//GEN-LAST:event_btnRankingAmigosActionPerformed

    private void btnTemaLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaLightActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.LIGHT, this);
    }//GEN-LAST:event_btnTemaLightActionPerformed

    private void btnTemaDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemaDarkActionPerformed
        ThemeController.getInstance().setTheme(Enum_Themes.DARK, this);
    }//GEN-LAST:event_btnTemaDarkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalOld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCadastrarAmigo;
    private javax.swing.JMenuItem btnCadastrarEmprestimo;
    private javax.swing.JMenuItem btnCadastrarFabricante;
    private javax.swing.JMenuItem btnCadastrarFerramenta;
    private javax.swing.JMenuItem btnClose;
    private javax.swing.JMenuItem btnControleFinanceiro;
    private javax.swing.JMenuItem btnControleGastosFabricantes;
    private javax.swing.JMenuItem btnEmprestimosEmAberto;
    private javax.swing.JMenuItem btnFerramentasCad;
    private javax.swing.JMenuItem btnRankingAmigos;
    private javax.swing.JMenuItem btnRelatorioAmigos;
    private javax.swing.JMenuItem btnRelatorioEmprestimo;
    private javax.swing.JMenuItem btnRelatorioFabricantes;
    private javax.swing.JMenuItem btnRelatorioFerramentas;
    private javax.swing.JMenuItem btnTemaDark;
    private javax.swing.JMenuItem btnTemaLight;
    private javax.swing.JMenuItem btnViewAmigosCad;
    private javax.swing.JMenuItem btnVisualizarFabricante;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu1;
    private javax.swing.JMenu fileMenu2;
    private javax.swing.JMenu fileMenu3;
    private javax.swing.JMenu fileMenu4;
    private javax.swing.JMenu fileMenu5;
    private javax.swing.JMenu fileMenu6;
    private javax.swing.JMenu fileMenu7;
    private javax.swing.JMenu fileMenu8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator11;
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
