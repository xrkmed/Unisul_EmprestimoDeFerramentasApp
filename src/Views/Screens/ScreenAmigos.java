package Views.Screens;

import Model.ScreenModel;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Model.FiltrosModel;
import Enums.Filtros;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosFiltrar;
import Controllers.Filtros.FiltrosOrdenar;
import Enums.ScreenSelectionType;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Model.LoanModel;
import Controllers.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsAmigos.TelaCadastroAmigos;
import com.itextpdf.text.Paragraph;

public class ScreenAmigos extends ScreenModel {

    private final String[] columnNames = {"ID", "Nome", "Telefone", "Empr. Abertos", "Empr. Atrasados"};

    public ScreenAmigos() {
        super();
    }

    public ScreenAmigos(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Amigos";
    }

    @Override
    public Object getSelectedValue() {
        return getTable().getValueAt(getTable().getSelectedRow(), 0);
    }

    @Override
    public void init() {
      super.init();
        getBtnCadastro().addActionListener(e -> {
            btnCadastro();
        });

        getBtnEditar().addActionListener(e -> {
            btnEditar();
        });

        getBtnDeletar().addActionListener(e -> {
            btnDeletar();
        });

        getBtnDeletar().setToolTipText("Deletar");
        getBtnDeletar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-remove-custom.png")));

        getBtnVisualizar().addActionListener(e -> {
            btnVisualizar();
        });

        getBtnExportar().addActionListener(e -> {
            btnExportar();
        });
    }

    // AQUI OCORRE O LOAD DA TABELA E A FORMATAÇÃO DOS DADOS
    @Override
    public void carregarDados() {
        try {
            StatusRenderer renderer = new StatusRenderer();
            //statusRed.addHighlightedRow(1, Color.RED);

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            ;
            };

            getTable().setModel(model);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                getTable().getColumnModel().getColumn(1).setPreferredWidth(350);
                getTable().getColumnModel().getColumn(2).setPreferredWidth(150);
                getTable().getColumnModel().getColumn(3).setPreferredWidth(400);
                getTable().getColumnModel().getColumn(3).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(3).setMaxWidth(110);
                getTable().getColumnModel().getColumn(4).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(4).setMaxWidth(110);
            }

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_GERAR) {
                    f.run();
                    return;
                }
            }

            ArrayList<Object[]> amigosData = FriendsDAO.getInstance().loadFriendsTabela();

            if (getFiltros().getSelectedItem() != null) {
                FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                if (f.getType() == Filtros.FILTRO_ORDENAR) {
                    amigosData.sort((Object[] data1, Object[] data2) -> {
                        return f.compare(data1, data2);
                    });
                }
            }

            for (Object[] data : amigosData) {
                if (getFiltros().getSelectedItem() != null) {
                    FiltrosModel f = (FiltrosModel) getFiltros().getSelectedItem();
                    if (f.getType() == Filtros.FILTRO_FILTRAR && !f.run(data)) {
                        continue;
                    }
                }
                if (!getCampoNomeFiltroLupa().getText().equals("")) {
                    if (!data[1].toString().trim().contains(getCampoNomeFiltroLupa().getText().toUpperCase().trim())) {
                        continue;
                    }
                }

                if (Integer.parseInt(data[3].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (Integer.parseInt(data[4].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Carregar Os Dados Da Tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {
        new TelaCadastroAmigos().setVisible(true);
    }

    public void btnEditar() {
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            FriendModel selectedFriend = FriendsDAO.getInstance().getFriend(id);
            new TelaCadastroAmigos(selectedFriend, ScreenSelectionType.SCREEN_TYPE_EDIT).setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Voce deve selecionar um amigo.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void btnDeletar() {

        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            FriendModel friendsDel = FriendsDAO.getInstance().getFriend(id);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja Realmente Remover o Cadastro De " + friendsDel.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                LoansDAO loansDAO = LoansDAO.getInstance();
                for (LoanModel loan : loansDAO.getAllLoans()) {
                    if (loan.getFriend().getId() == friendsDel.getId() && loan.getReturned() == false) {
                        JOptionPane.showMessageDialog(null, "Não é Possível Remover o Cadastro De " + friendsDel.getName() + " Pois Ele Possui Empréstimos Pendentes.");
                        return;
                    }
                }
                FriendsDAO dao = FriendsDAO.getInstance();
                dao.removeFriend(friendsDel);
                carregarDados();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnVisualizar() {
        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            FriendModel selectedFriend = FriendsDAO.getInstance().getFriend(id);
            new TelaCadastroAmigos(selectedFriend, ScreenSelectionType.SCREEN_TYPE_VIEW).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnExportar() {
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame();

        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (directoryChooserFrame.getSelectedDirectory().length() > 0) {
                    try {
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATÓRIO AMIGOS", 10);
                        String fileName = "RelatorioAmigos";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Não Foi Possível Exportar o PDF, Tente Novamente Mais Tarde!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não Foi Possível Exportar o PDF, Tente Selecionar Um Diretório Válido!");
                }
            }
        });
    }

    /* FILTROS */
    @Override
    public DefaultComboBoxModel<FiltrosModel> get() {
        return new DefaultComboBoxModel<FiltrosModel>(new FiltrosModel[]{
            new FiltrosOrdenar("ID"),
            new FiltrosFiltrar("Empréstimos em Aberto", (Object[] data) -> {
                return (int) data[3] > 0;
            }),
            new FiltrosFiltrar("Empréstimos em Atraso", (Object[] data) -> {
                return (int) data[4] > 0;
            }),
            new FiltrosOrdenar("Nome Crescente", (data1, data2) -> {
                return ((String) data1[1]).compareTo((String) data2[1]);
            }),
            new FiltrosOrdenar("Nome Decrescente", (data1, data2) -> {
                return -((String) data1[1]).compareTo((String) data2[1]);
            }),});
    }

}
