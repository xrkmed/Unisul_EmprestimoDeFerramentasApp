package ViewsAmigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.LocalidadesDAO;
import Model.FriendModel;
import Resources.AddressResource;
import Resources.CEPResource;
import Resources.PhoneDocument;
import Resources.PhoneValidResource;
import java.awt.event.FocusAdapter;

public class TelaCadastroAmigos extends javax.swing.JFrame {

    private FriendModel selectedFriend = null;

    public TelaCadastroAmigos() {
        initComponents();
        configFrame();
    }

    public TelaCadastroAmigos(FriendModel selectedFriend) {
        this();
        this.selectedFriend = selectedFriend;
        this.setTitle("Alterar cadastro de " + selectedFriend.getName().toUpperCase());
        textNome.setText(selectedFriend.getName());
        textCEP.setText("" + selectedFriend.getAddress().getCEP());
        selectEstado.setSelectedItem(selectedFriend.getAddress().getState());
        selectCidade.setSelectedItem(selectedFriend.getAddress().getCity());
        textRua.setText(selectedFriend.getAddress().getStreet());
        textBairro.setText(selectedFriend.getAddress().getDistrict());
        textComplemento.setText(selectedFriend.getAddress().getComplemento());
        textNumero.setText(selectedFriend.getAddress().getNumber() + "");
        textTelefone.setText(selectedFriend.getPhone());
        btnCadastrar.setText("Finalizar alteração");
        //jButton2.setText("Cancelar alteração");
    }

    private void configFrame() {

        AbstractDocument document = (AbstractDocument) textTelefone.getDocument();

        document.setDocumentFilter(new PhoneDocument());

        //evitar travamento de janela ao carregar os dados
        Thread pThread = new Thread(new Runnable() {
            @Override
            public void run() {
                selectEstado.removeAllItems();
                for (Object estado : LocalidadesDAO.getEstados()) {
                    selectEstado.addItem(estado.toString());
                }
            }
        });
        pThread.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textComplemento = new javax.swing.JTextField();
        textNumero = new javax.swing.JTextField();
        textRua = new javax.swing.JTextField();
        textBairro = new javax.swing.JTextField();
        selectCidade = new javax.swing.JComboBox<>();
        selectEstado = new javax.swing.JComboBox<>();
        textCEP = new javax.swing.JTextField();
        btnBuscarCep = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        btnVisualizarEmprestimos = new javax.swing.JButton();
        btnDeletar2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCriarEmprestimo = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados Cadastrais - Grupo Supimpa");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("CEP:");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setText("Cidade:");

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel11.setText("Bairro:");

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel8.setText("Rua:");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel10.setText("Número:");

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel7.setText("Complemento:");

        textComplemento.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textComplemento.setToolTipText("Descreva um Complemento");
        textComplemento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textComplementoActionPerformed(evt);
            }
        });
        textComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textComplementoKeyPressed(evt);
            }
        });

        textNumero.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textNumero.setToolTipText("Digite o Numero da Casa");
        textNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textNumero.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textNumeroInputMethodTextChanged(evt);
            }
        });
        textNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumeroActionPerformed(evt);
            }
        });
        textNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNumeroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNumeroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNumeroKeyTyped(evt);
            }
        });

        textRua.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textRua.setToolTipText("Digite o nome da rua");
        textRua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textRuaKeyPressed(evt);
            }
        });

        textBairro.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textBairro.setToolTipText("Digite o nome da rua");
        textBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBairroActionPerformed(evt);
            }
        });
        textBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBairroKeyTyped(evt);
            }
        });

        selectCidade.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        selectCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a sua cidade" }));
        selectCidade.setToolTipText("Selecione a sua cidade");
        selectCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectCidade.setEnabled(false);
        selectCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCidadeActionPerformed(evt);
            }
        });

        selectEstado.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        selectEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Seu Estado" }));
        selectEstado.setToolTipText("Escolha o Estado Desejado ");
        selectEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEstadoActionPerformed(evt);
            }
        });

        textCEP.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textCEP.setToolTipText("Insira CEP do seu amigo");
        textCEP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCEPActionPerformed(evt);
            }
        });
        textCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCEPKeyPressed(evt);
            }
        });

        btnBuscarCep.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnBuscarCep.setText("Buscar CEP");
        btnBuscarCep.setToolTipText("Sera Realizada uma Busca Automatica Para Preencher Cidade, Estado e Bairro");
        btnBuscarCep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCepActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textComplemento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textNumero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textRua, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textBairro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(selectCidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(selectEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textCEP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnBuscarCep, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69)))
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textRua)
                    .addComponent(textBairro)
                    .addComponent(textComplemento)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(textNumero)
                        .addGap(168, 168, 168))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selectCidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 190, Short.MAX_VALUE)
                            .addComponent(textCEP, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(textCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCep))
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(selectEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(selectCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(textBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(textRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(textNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(textComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Nome Completo:");

        textNome.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        textNome.setToolTipText("Digite o nome completo do seu amigo");
        textNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        textTelefone.setToolTipText("Digite o telefone do seu amigo");
        textTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                    .addComponent(textTelefone)
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
        btnVisualizarEmprestimos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisualizarEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarEmprestimosActionPerformed(evt);
            }
        });

        btnDeletar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/content-save-minus-custom.png"))); // NOI18N
        btnDeletar2.setToolTipText("Cancelar");
        btnDeletar2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnDeletar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletar2ActionPerformed(evt);
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
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnCriarEmprestimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCriarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarEmprestimoActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(btnVisualizarEmprestimos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(btnDeletar2, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCriarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnVisualizarEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDeletar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnDeletar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLayeredPane1)
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
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ArrayList<String> erros = new ArrayList<String>();

        if (!CEPResource.verificarNomeCompleto(textNome.getText())) {
            erros.add("Nome inválido. Digite o nome completo (Ex: João da Silva)");
            textNome.setText("");
            textNome.setEnabled(true);
        }

        if (!CEPResource.verificarCEP(textCEP.getText())) {
            erros.add("CEP inválido. Digite apenas números (Ex: 12345678)");
            textCEP.setText("");
            textCEP.setEnabled(true);
        }

        if (!CEPResource.verificarNumeroCasa(textNumero.getText())) {
            erros.add("Número inválido. Digite apenas números (Ex: 123)");
            textNumero.setText("");
            textNumero.setEnabled(true);
        }

        if (!CEPResource.verificarBairro(textBairro.getText())) {
            erros.add("Bairro inválido. Digite apenas o nome do bairro (Ex: Jardim Paulista)");
            textBairro.setText("");
            textBairro.setEnabled(true);
        }

        if (!CEPResource.verificarCidade(selectCidade.getSelectedItem().toString())) {
            erros.add("Cidade inválida. Digite apenas o nome da cidade (Ex: São Paulo)");
            selectCidade.setEnabled(true);
        }

        if (!CEPResource.verificarEstado(selectEstado.getSelectedItem().toString())) {
            erros.add("Estado inválido. Digite apenas a sigla do estado (Ex: SP)");
        }

        if (!CEPResource.verificarRua(textRua.getText())) {
            erros.add("Rua inválida. Digite apenas o nome da rua (Ex: Rua Paulista)");
            textRua.setText("");
            textRua.setEnabled(true);
        }

        if (!PhoneValidResource.isValidPhoneNumber(PhoneValidResource.unformatPhoneNumber(textTelefone.getText()))) {
            erros.add("Telefone inválido. Digite apenas números (Ex: 11912345678)");
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
                    AddressResource address = new AddressResource(textRua.getText(), textBairro.getText(), selectCidade.getSelectedItem().toString(), selectEstado.getSelectedItem().toString(), Integer.parseInt(textNumero.getText()), textComplemento.getText(), Integer.parseInt(textCEP.getText()));
                    FriendModel friendModel = FriendsDAO.getInstance().addFriend(textNome.getText().toUpperCase(), PhoneValidResource.unformatPhoneNumber(textTelefone.getText()), address);
                    JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso! (" + friendModel.getId() + ")");
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                try {
                    AddressResource address = new AddressResource(textRua.getText(), textBairro.getText(), selectCidade.getSelectedItem().toString(), selectEstado.getSelectedItem().toString(), Integer.parseInt(textNumero.getText()), textComplemento.getText(), Integer.parseInt(textCEP.getText()));
                    FriendModel friendModel = FriendsDAO.getInstance().getFriend(selectedFriend.getId());
                    if (friendModel == null) {
                        throw new Exception("Amigo não encontrado");
                    }

                    friendModel.setName(textNome.getText().toUpperCase());
                    friendModel.setPhone(PhoneValidResource.unformatPhoneNumber(textTelefone.getText()));
                    friendModel.updateAddress(address);

                    FriendsDAO.getInstance().updateFriend(friendModel.getId(), friendModel);
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

    private void textComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textComplementoActionPerformed

    private void textNumeroInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textNumeroInputMethodTextChanged

    }//GEN-LAST:event_textNumeroInputMethodTextChanged

    private void textNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumeroActionPerformed

    private void textNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumeroKeyPressed
        btnVisualizarEmprestimos.setEnabled(false);
        btnCriarEmprestimo.setEnabled(false);
    }//GEN-LAST:event_textNumeroKeyPressed

    private void textNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumeroKeyReleased

    }//GEN-LAST:event_textNumeroKeyReleased

    private void textNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumeroKeyTyped

    }//GEN-LAST:event_textNumeroKeyTyped

    private void selectCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCidadeActionPerformed

    }//GEN-LAST:event_selectCidadeActionPerformed

    private void selectEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEstadoActionPerformed
        if (selectEstado.getSelectedItem() != null && selectEstado.getSelectedItem().toString().length() == 2) {
            selectCidade.setEnabled(false);
            textBairro.setText("");
            textRua.setText("");
            textNumero.setText("");
            textComplemento.setText("");

            if (textCEP.getText().length() == 0) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        selectCidade.setEnabled(true);
                        selectCidade.removeAllItems();
                        for (Object cidade : LocalidadesDAO.obterCidades(selectEstado.getSelectedItem().toString())) {
                            selectCidade.addItem(cidade.toString());
                        }

                    }
                });
                thread.start();
            } else {
                selectCidade.setEnabled(true);
                selectCidade.removeAllItems();
                for (Object cidade : LocalidadesDAO.obterCidades(selectEstado.getSelectedItem().toString())) {
                    selectCidade.addItem(cidade.toString());
                }
            }
        }
    }//GEN-LAST:event_selectEstadoActionPerformed

    private void textCEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCEPKeyPressed
        
       btnVisualizarEmprestimos.setEnabled(false);
            btnCriarEmprestimo.setEnabled(false);

        if (textCEP.getText().length() > 8) {
            JOptionPane.showMessageDialog(null, "CEP inválido (Digite apenas números)");
            textCEP.setText("");
            textCEP.requestFocus();
            return;
        }

        // press enter or tab
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            if (textCEP.getText().length() != 8) {
                JOptionPane.showMessageDialog(null, "CEP inválido (Digite apenas números)");
                textCEP.setText("");
                textCEP.requestFocus();
                return;
            }
        }
    }//GEN-LAST:event_textCEPKeyPressed

    private void btnBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCepActionPerformed
        if (textCEP.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "CEP inválido (Digite apenas números)");
            textCEP.setText("");
            textCEP.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(null, "Aguarde enquanto o CEP é consultado...", "Aguarde", JOptionPane.INFORMATION_MESSAGE);

        try {
            int opcao = JOptionPane.showConfirmDialog(this, "Para buscar um CEP, voce precisa ter uma conexao estavel com a internet, deseja procurar um CEP?", "Confirmar busca", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.NO_OPTION) {
                return;
            }

            AddressResource cepBuscado = CEPResource.buscarCEP(Integer.parseInt(textCEP.getText()));

            selectEstado.setSelectedItem(cepBuscado.getState());
            selectCidade.removeAllItems();
            selectCidade.addItem(cepBuscado.getCity());
            selectCidade.setSelectedItem(cepBuscado.getCity());
            selectCidade.setEnabled(false);

            if (cepBuscado.getDistrict().length() > 0) {
                textBairro.setText(cepBuscado.getDistrict());
                textBairro.setEnabled(false);
            }

            if (cepBuscado.getStreet().length() > 0) {
                textRua.setText(cepBuscado.getStreet());
                textRua.setEnabled(false);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CEP em formato invalido (Digite apenas números)");
            textCEP.requestFocus();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "CEP não encontrado");
            textCEP.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            textCEP.requestFocus();

        }
    }//GEN-LAST:event_btnBuscarCepActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void btnDeletar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDeletar2ActionPerformed

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

    private void textTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneActionPerformed

    private void btnCriarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarEmprestimoActionPerformed
       if(!textNome.getText().equals("")){
       
       }
    }//GEN-LAST:event_btnCriarEmprestimoActionPerformed

    private void textCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCEPActionPerformed

    private void textRuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRuaKeyPressed
  btnVisualizarEmprestimos.setEnabled(false);
            btnCriarEmprestimo.setEnabled(false);
    }//GEN-LAST:event_textRuaKeyPressed

    private void textComplementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textComplementoKeyPressed
       btnVisualizarEmprestimos.setEnabled(false);
            btnCriarEmprestimo.setEnabled(false);
    }//GEN-LAST:event_textComplementoKeyPressed

    private void textNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeKeyPressed

    }//GEN-LAST:event_textNomeKeyPressed

    private void textTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefoneKeyPressed

    }//GEN-LAST:event_textTelefoneKeyPressed

    private void textBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBairroKeyTyped
 btnVisualizarEmprestimos.setEnabled(false);
            btnCriarEmprestimo.setEnabled(false);
    }//GEN-LAST:event_textBairroKeyTyped

    private void textBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBairroActionPerformed
 
    }//GEN-LAST:event_textBairroActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCep;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCriarEmprestimo;
    private javax.swing.JButton btnDeletar2;
    private javax.swing.JButton btnVisualizarEmprestimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox<String> selectCidade;
    private javax.swing.JComboBox<String> selectEstado;
    private javax.swing.JTextField textBairro;
    private javax.swing.JTextField textCEP;
    private javax.swing.JTextField textComplemento;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textRua;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables

}
