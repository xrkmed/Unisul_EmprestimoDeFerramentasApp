/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package ViewsEmprestimo;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import DAO.ToolsDAO;
import Model.FriendModel;
import Model.ToolModel;

import javax.swing.event.DocumentEvent;

import Resources.BRLResource;
import Resources.DateResource;
import ViewsAmigos.TelaSelecionarBeneficiado;
import ViewsTool.TelaSelecionarFerramenta;

/**
 *
 * @author arkmed
 */
public class TelaCadastroEmprestimo extends javax.swing.JFrame {

    private ToolModel selectedTool = null;
    private FriendModel selectedFriend = null;
    private ArrayList<ToolModel> toolsList = new ArrayList<>();
    /**
     * Creates new form TelaCadastroEmprestimo
     */
    public TelaCadastroEmprestimo() {
        initComponents();

        //today date in string format dd/MM/YYYY
        lblDataHoje.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        ToolsDAO dao = ToolsDAO.getInstance();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTable1.getSelectionModel().addListSelectionListener(x -> {
            if (!x.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    selectedTool = dao.getTool(((int) jTable1.getValueAt(selectedRow, 0)));
                    selecionadoNome.setText(selectedTool.getNome());
                    selecionadoFabricante.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    btnRemoverFerramenta.setEnabled(true);
                }else{
                    selectedTool = null;
                    selecionadoNome.setText("");
                    selecionadoFabricante.setText("");
                    btnRemoverFerramenta.setEnabled(false);
                }
            }
        });

        AbstractDocument document = (AbstractDocument) textValorReceber.getDocument();

        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void remove(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length) throws javax.swing.text.BadLocationException {
                replace(fb, offset, length, "", null);
            }

            @Override
            public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, java.lang.String text, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                replace(fb, offset, 0, text, attr);
            }

            @Override
            public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, java.lang.String text, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                Document doc = fb.getDocument();
                StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
                sb.replace(offset, offset + length, text);
                
                String filteredText = sb.toString().replaceAll("[^\\d]", "");
                if(filteredText.length() > 9){
                    return;
                }
                
                try {
                    if (!filteredText.isEmpty()) {
                        double value = Double.parseDouble(filteredText) / 100.0;
                        String formattedText = BRLResource.PRICE_FORMATTER.format(value);
                        super.replace(fb, 0, doc.getLength(), formattedText, attr);
                    } else {
                        super.replace(fb, 0, doc.getLength(), "", attr);
                    }
                } catch (Exception ex) {
                    // Se ocorrer uma exceção ao converter ou formatar, mantém o valor antigo
                }
            }
        });

        document = (AbstractDocument) textDataDevolucao.getDocument();

        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void remove(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length) throws javax.swing.text.BadLocationException {
                replace(fb, offset, length, "", null);
            }

            @Override
            public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, java.lang.String text, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                replace(fb, offset, 0, text, attr);
            }

            @Override
            public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, java.lang.String text, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                Document doc = fb.getDocument();
                StringBuilder sb = new StringBuilder(doc.getText(0, doc.getLength()));
                sb.replace(offset, offset + length, text);

                String filteredText = DateResource.formatDateString(sb.toString());
            
                
                super.replace(fb, 0, doc.getLength(), filteredText, attr);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        btnSelecionarBeneficiado = new javax.swing.JButton();
        lblSelecionadoBeneficiado = new javax.swing.JLabel();
        btnRemoverBeneficiado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        selecionadoNome = new javax.swing.JTextField();
        selecionadoFabricante = new javax.swing.JTextField();
        btnRemoverFerramenta = new javax.swing.JButton();
        lblValorFerramentas = new javax.swing.JLabel();
        lblValorReceber = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textDataDevolucao = new javax.swing.JTextField();
        lblDataHoje = new javax.swing.JLabel();
        btnAdicionarFerramenta = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        textValorReceber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCadastrarEmprestimo = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo Supimpa - Cadastro de Emprestimo");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Cadastrar um novo emprestimo");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Beneficiado:");

        btnSelecionarBeneficiado.setText("Selecionar beneficiado");
        btnSelecionarBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarBeneficiadoActionPerformed(evt);
            }
        });

        lblSelecionadoBeneficiado.setText("Selecionado: Nenhum");

        btnRemoverBeneficiado.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverBeneficiado.setText("Remover beneficiado");
        btnRemoverBeneficiado.setEnabled(false);
        btnRemoverBeneficiado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverBeneficiadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Ferramentas emprestadas:");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Fabricante", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel6.setText("FERRAMENTA SELECIONADA");

        jLabel7.setText("Nome:");

        jLabel8.setText("Fabricante:");

        selecionadoNome.setEditable(false);

        selecionadoFabricante.setEditable(false);

        btnRemoverFerramenta.setBackground(new java.awt.Color(255, 102, 102));
        btnRemoverFerramenta.setText("Remover ferramenta");
        btnRemoverFerramenta.setEnabled(false);
        btnRemoverFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFerramentaActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(selecionadoNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(selecionadoFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnRemoverFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selecionadoFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(selecionadoNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoverFerramenta)))
                .addGap(22, 22, 22))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(selecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionadoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverFerramenta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblValorFerramentas.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblValorFerramentas.setText("Valor total das ferramentas emprestadas: R$ 0,00");

        lblValorReceber.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblValorReceber.setText("Valor a receber: R$ 0,00");

        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblValorFerramentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLayeredPane4)
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorReceber))
                        .addGap(17, 17, 17))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(lblValorFerramentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorReceber)
                        .addContainerGap(146, Short.MAX_VALUE))
                    .addComponent(jLayeredPane4)))
        );

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel9.setText("Data de inicio:");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setText("Data de devoluçao (dd/MM/YYYY):");

        textDataDevolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textDataDevolucaoKeyReleased(evt);
            }
        });

        lblDataHoje.setText("Data de hoje");

        btnAdicionarFerramenta.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        btnAdicionarFerramenta.setText("Adicionar ferramenta");
        btnAdicionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFerramentaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel15.setText("Valor a receber:");

        textValorReceber.setText("0,00");
        textValorReceber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textValorReceberKeyReleased(evt);
            }
        });

        jLabel16.setText("R$");

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSelecionarBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblSelecionadoBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnRemoverBeneficiado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textDataDevolucao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblDataHoje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnAdicionarFerramenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textValorReceber, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(btnSelecionarBeneficiado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSelecionadoBeneficiado))
                            .addComponent(jLabel2)
                            .addComponent(btnRemoverBeneficiado)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionarFerramenta)))
                        .addGap(47, 47, 47)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(lblDataHoje)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(120, 120, 120))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelecionarBeneficiado)
                            .addComponent(lblSelecionadoBeneficiado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverBeneficiado)
                        .addGap(23, 23, 23)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(btnAdicionarFerramenta)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDataHoje))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textValorReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCadastrarEmprestimo.setBackground(new java.awt.Color(153, 255, 153));
        btnCadastrarEmprestimo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnCadastrarEmprestimo.setText("Cadastrar emprestimo");
        btnCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEmprestimoActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrarEmprestimo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrarEmprestimo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void textDataDevolucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDataDevolucaoKeyReleased
        //textDataDevolucao.setText(DateResource.formatDateString(textDataDevolucao.getText()));
    }//GEN-LAST:event_textDataDevolucaoKeyReleased

    private void textValorReceberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorReceberKeyReleased
        lblValorReceber.setText("Valor a receber: R$ " + textValorReceber.getText());
    }//GEN-LAST:event_textValorReceberKeyReleased

    private void btnAdicionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFerramentaActionPerformed
        new TelaSelecionarFerramenta(this).setVisible(true);
    }//GEN-LAST:event_btnAdicionarFerramentaActionPerformed


    public void setSelectedFriend(FriendModel e){
        lblSelecionadoBeneficiado.setText("Selecionado: " + e.getName());
        selectedFriend = e;
        btnRemoverBeneficiado.setEnabled(true);
    }

    
    public ArrayList<ToolModel> getToolsList(){
        return toolsList;
    }

    public void loadFerramentasList(){;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        double totalValue = 0;
        for (ToolModel tool : toolsList) {
            model.addRow(new Object[]{
                tool.getId(),
                tool.getNome(),
                (tool.getManufacturer() != null ? tool.getManufacturer().getName() : "Sem fabricante"),
                BRLResource.PRICE_FORMATTER.format(tool.getPrice())
            });
            totalValue += tool.getPrice();
        }

        lblValorFerramentas.setText("Valor total das ferramentas emprestadas: R$" + BRLResource.PRICE_FORMATTER.format(totalValue));
    }

    private void btnRemoverFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFerramentaActionPerformed
        if(selectedTool != null){
            selecionadoFabricante.setText("");
            selecionadoNome.setText("");
            if(toolsList.contains(selectedTool)){
                toolsList.remove(selectedTool);
                loadFerramentasList();
            }
            selectedTool = null;
        }
    }//GEN-LAST:event_btnRemoverFerramentaActionPerformed

    private void btnRemoverBeneficiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverBeneficiadoActionPerformed
        if(selectedFriend != null){
            selectedFriend = null;
            lblSelecionadoBeneficiado.setText("Selecionado: Nenhum");
            btnRemoverBeneficiado.setEnabled(false);
        }
    }//GEN-LAST:event_btnRemoverBeneficiadoActionPerformed

    private void btnSelecionarBeneficiadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarBeneficiadoActionPerformed
        new TelaSelecionarBeneficiado(this).setVisible(true);
    }//GEN-LAST:event_btnSelecionarBeneficiadoActionPerformed

    private void btnCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEmprestimoActionPerformed
        if(selectedFriend != null){
            try{
            Date date = DateResource.unformatDateString(textDataDevolucao.getText());
            if(date.before(new Date())){
                JOptionPane.showMessageDialog(this, "A data de devolução não pode ser anterior a data de hoje!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(toolsList.isEmpty()){
                JOptionPane.showMessageDialog(this, "Você deve adicionar pelo menos uma ferramenta!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double valorReceber = BRLResource.PRICE_FORMATTER.parse(textValorReceber.getText()).doubleValue();
            if(valorReceber < 0){
                JOptionPane.showMessageDialog(this, "O valor a receber deve ser de no minimo zero reais.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, "Emprestimo criado com sucesso!");
            this.dispose();
        }catch(ParseException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
    }//GEN-LAST:event_btnCadastrarEmprestimoActionPerformed

    public void addFerramenta(ToolModel e){
        if(!toolsList.contains(e)){
            toolsList.add(e);
            loadFerramentasList();
        }
    }
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
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarFerramenta;
    private javax.swing.JButton btnCadastrarEmprestimo;
    private javax.swing.JButton btnRemoverBeneficiado;
    private javax.swing.JButton btnRemoverFerramenta;
    private javax.swing.JButton btnSelecionarBeneficiado;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDataHoje;
    private javax.swing.JLabel lblSelecionadoBeneficiado;
    private javax.swing.JLabel lblValorFerramentas;
    private javax.swing.JLabel lblValorReceber;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField selecionadoFabricante;
    private javax.swing.JTextField selecionadoNome;
    private javax.swing.JTextField textDataDevolucao;
    private javax.swing.JTextField textValorReceber;
    // End of variables declaration//GEN-END:variables

}
