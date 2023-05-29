package ViewsManufacturer;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Paragraph;
import Controllers.PDFEntity;
import Resources.DirectoryChooserFrame;

public class TelaRelatorioFabricante extends javax.swing.JFrame {

    private String directory = null;

    public TelaRelatorioFabricante() {
        initComponents();
        configFrame();
    }

    private void configFrame() {
        Thread pStart = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loadList(emprestimosRelatorio, DAO.ManufacturerDAO.getInstance().getFabricantesData());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar lista de emprestimos: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        pStart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        emprestimosRelatorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bntCancelar = new javax.swing.JButton();
        bntCancelar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Fabricantes - Grupo Supimpa");
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        emprestimosRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CNPJ", "Qnt. Ferramentas", "Ferramentas Emprestadas", "Valor Total Ferramentas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        emprestimosRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emprestimosRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(emprestimosRelatorio);
        if (emprestimosRelatorio.getColumnModel().getColumnCount() > 0) {
            emprestimosRelatorio.getColumnModel().getColumn(0).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(0).setPreferredWidth(40);
            emprestimosRelatorio.getColumnModel().getColumn(1).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(1).setPreferredWidth(350);
            emprestimosRelatorio.getColumnModel().getColumn(2).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(2).setPreferredWidth(200);
            emprestimosRelatorio.getColumnModel().getColumn(3).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(3).setPreferredWidth(100);
            emprestimosRelatorio.getColumnModel().getColumn(4).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(4).setPreferredWidth(100);
            emprestimosRelatorio.getColumnModel().getColumn(5).setResizable(false);
            emprestimosRelatorio.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("RELATÓRIO FABRICANTES");

        bntCancelar.setBackground(new java.awt.Color(255, 102, 102));
        bntCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        bntCancelar.setForeground(new java.awt.Color(51, 51, 51));
        bntCancelar.setText("Cancelar");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        bntCancelar1.setBackground(new java.awt.Color(153, 255, 153));
        bntCancelar1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        bntCancelar1.setForeground(new java.awt.Color(51, 51, 51));
        bntCancelar1.setText("Exportar Relatório");
        bntCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelar1ActionPerformed(evt);
            }
        });

        jMenu2.setText("Exportar");

        jMenu4.setText("Exportar relatorio");

        jMenuItem1.setText("Exportar para PDF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(bntCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCancelar)
                    .addComponent(bntCancelar1))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCancelarActionPerformed

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame(this);

        // Funcao que roda quando a visibilidade do directoryChooserFrame é alterada
        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (directory != null) {
                    try {
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATORIO", 10);
                        String fileName = "RelatorioFabricante";
                        PDFEntity.export(directory + "/", fileName, emprestimosRelatorio, paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directory + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente novamente mais tarde...");
                    }
                }
            }
        });

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void emprestimosRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emprestimosRelatorioMouseClicked
        if (evt.getClickCount() == 2) {
            Object value = emprestimosRelatorio.getValueAt(emprestimosRelatorio.getSelectedRow(), emprestimosRelatorio.getSelectedColumn());

            JOptionPane.showMessageDialog(null, value.toString());
        }
    }//GEN-LAST:event_emprestimosRelatorioMouseClicked

    private void bntCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCancelar1ActionPerformed

    public void loadList(JTable table, ArrayList<Object[]> dataObject) throws ParseException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Object[] data : dataObject) {
            model.addRow(data);

        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioFabricante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntCancelar1;
    private javax.swing.JTable emprestimosRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
