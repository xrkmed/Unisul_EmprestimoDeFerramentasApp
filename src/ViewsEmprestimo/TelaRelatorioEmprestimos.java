package ViewsEmprestimo;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Paragraph;
import Controllers.PDFEntity;
import DAO.LoansDAO;
import Resources.BRLResource;
import Resources.DirectoryChooserFrame;

public class TelaRelatorioEmprestimos extends javax.swing.JFrame {

    private String directory = null;

    public TelaRelatorioEmprestimos() {
        initComponents();
        configFrame();
    }

    private void configFrame() {
        Thread pStart = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    loadList(emprestimosRelatorio, LoansDAO.getInstance().relatorioEmprestimos());
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
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Empréstimos - Grupo Supimpa");
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        emprestimosRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amigo", "Data Início", "Data Devoluçõo", "Data Finalizado", "Observações", "Num. Ferramentas", "V. Total Ferramentas", "V. Recebido", "Ferramentas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            emprestimosRelatorio.getColumnModel().getColumn(0).setPreferredWidth(20);
            emprestimosRelatorio.getColumnModel().getColumn(1).setPreferredWidth(100);
            emprestimosRelatorio.getColumnModel().getColumn(2).setPreferredWidth(40);
            emprestimosRelatorio.getColumnModel().getColumn(3).setPreferredWidth(50);
            emprestimosRelatorio.getColumnModel().getColumn(4).setPreferredWidth(50);
            emprestimosRelatorio.getColumnModel().getColumn(5).setPreferredWidth(100);
            emprestimosRelatorio.getColumnModel().getColumn(6).setPreferredWidth(70);
            emprestimosRelatorio.getColumnModel().getColumn(7).setPreferredWidth(75);
            emprestimosRelatorio.getColumnModel().getColumn(8).setPreferredWidth(65);
            emprestimosRelatorio.getColumnModel().getColumn(9).setPreferredWidth(100);
        }

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("EMPRÉSTIMOS FINALIZADOS");

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Concluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Cancelar");

        jMenu2.setText("Exportar");

        jMenu4.setText("Exportar Relatório");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jLabel1)
                .addGap(328, 328, 328))
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
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    }//GEN-LAST:event_jButton4ActionPerformed

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
                        String fileName = "RelatorioEmprestimos";
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

    public void loadList(JTable table, ArrayList<Object[]> dataObject) throws ParseException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        double valorGastoTotal = 0.;
        for (Object[] data : dataObject) {
            //Object[] datas = new Object[]{result.getInt("emprestimo_id"), result.getString("nome"), sdf.format(result.getDate("startDate")), sdf.format(result.getDate("endDate")), sdf.format(result.getDate("finalizadoData")), result.getString("observacoes"), result.getInt("totalFerramentas"), result.getDouble("totalValorFerramentas"), result.getDouble("valorRecebido"), result.getBlob("ferramentasList")};
            model.addRow(data);
            double toolPrice = data[2] != null ? BRLResource.PRICE_FORMATTER.parse(data[2].toString().replaceAll("^R\\$", "").trim()).doubleValue() : 0.;
            valorGastoTotal += toolPrice;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable emprestimosRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
