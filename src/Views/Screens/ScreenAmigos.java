package Views.Screens;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosFiltrar;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import Model.FriendModel;
import Model.LoanModel;
import Resources.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsAmigos.TelaCadastroAmigos;
import com.itextpdf.text.Paragraph;

public class ScreenAmigos extends ScreenEntity {

    private final String[] columnNames = {"ID", "Nome", "Telefone", "Endereço", "Empr. Abertos", "Empr. Atrasados"};

    public ScreenAmigos() {
        super();
    }

    public ScreenAmigos(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Tela Amigos";
    }

    @Override
    public Object getSelectedValue() {
        return getTable().getValueAt(getTable().getSelectedRow(), 0);
    }

    @Override
    public void init() {
        getBtnCadastro().addActionListener(e -> {
            btnCadastro();
        });

        getBtnEditar().addActionListener(e -> {
            btnEditar();
        });

        getBtnDeletar().addActionListener(e -> {
            btnDeletar();
        });

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
            ArrayList<Object[]> amigosData = FriendsDAO.getInstance().loadFriendsTabela();

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
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
                getTable().getColumnModel().getColumn(4).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(4).setMaxWidth(110);
                getTable().getColumnModel().getColumn(5).setPreferredWidth(110);
                getTable().getColumnModel().getColumn(5).setMaxWidth(110);
            }

            if (getFiltros().getSelectedItem() != null) {
                FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                if (f.getType() == FiltrosEnum.FILTRO_ORDENAR) {
                    amigosData.sort((Object[] data1, Object[] data2) -> {
                        return f.compare(data1, data2);
                    });
                }
            }

            for (Object[] data : amigosData) {
                if (getFiltros().getSelectedItem() != null) {
                    FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                    if (f.getType() == FiltrosEnum.FILTRO_FILTRAR && !f.run(data)) {
                        continue;
                    }
                }

                if (Integer.parseInt(data[4].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                if (Integer.parseInt(data[5].toString()) > 0) {
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }

                ((DefaultTableModel) getTable().getModel()).addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
        }
    }


    /* FUNCOES DOS BOTOES */
    public void btnCadastro() {

        try {
            int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
            FriendModel selectedFriend = FriendsDAO.getInstance().getFriend(id);
            new TelaCadastroAmigos(selectedFriend).setVisible(true);
        } catch (Exception e) {
            new TelaCadastroAmigos().setVisible(true);
        }

    }

    public void btnEditar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {

        int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);

        try {
            FriendModel friendsDel = FriendsDAO.getInstance().getFriend(id);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o cadastro de " + friendsDel.getName() + "?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                LoansDAO loansDAO = LoansDAO.getInstance();
                for (LoanModel loan : loansDAO.getAllLoans()) {
                    if (loan.getFriend().getId() == friendsDel.getId() && loan.getReturned() == false) {
                        JOptionPane.showMessageDialog(null, "Não é possível remover o cadastro de " + friendsDel.getName() + " pois ele possui empréstimos pendentes.");
                        return;
                    }
                }
                FriendsDAO dao = FriendsDAO.getInstance();
                dao.removeFriend(friendsDel);
                carregarDados();
            }
        } catch (Exception e) {
            //TODO
        }
    }

    public void btnVisualizar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnExportar() {
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame();

        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (directoryChooserFrame.getSelectedDirectory().length() > 0) {
                    try {
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATORIO", 10);
                        String fileName = "RelatorioAmigos";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente novamente mais tarde...");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente selecionar um diretorio valido!");
                }
            }
        });
    }

    /* FILTROS */

    @Override
    public DefaultComboBoxModel<FiltrosClass> get() {
        return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
            new FiltrosOrdenar("Ordenar por ID"),
            new FiltrosFiltrar("Empréstimos em Aberto", (Object[] data) -> {
                return (int) data[4] > 0;
            }),
            new FiltrosFiltrar("Empréstimos em Atraso", (Object[] data) -> {
                return (int) data[5] > 0;
            }),
            new FiltrosOrdenar("Nome Crescente", (data1, data2) -> {
                return ((String) data1[1]).compareTo((String) data2[1]);
            }),
            new FiltrosOrdenar("Nome Decrescente", (data1, data2) -> {
                return -((String) data1[1]).compareTo((String) data2[1]);
            }),});
    }

}
