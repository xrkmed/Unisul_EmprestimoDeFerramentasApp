package Views.Screens;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controllers.ColorsRenderer;
import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import Controllers.Filtros.FiltrosGerar;
import Controllers.Filtros.FiltrosOrdenar;
import DAO.LoansDAO;
import Model.LoanModel;
import Resources.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsEmprestimo.TelaCadastroEmprestimo;
import ViewsEmprestimo.TelaFinalizarEmprestimo;
import com.itextpdf.text.Paragraph;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ScreenEmprestimos extends ScreenEntity {

    private final String[] columnNames = {"ID", "Amigo", "Data Início", "Data Devolução", "Dias Restantes", "A Receber", "Qtd. Ferramentas", "Valor Ferramentas"};

    public ScreenEmprestimos() {
        super();
    }

    public ScreenEmprestimos(TelaInicial telaInicial) {
        super(telaInicial);
    }

    @Override
    public String getName() {
        return "Empréstimos em Aberto";
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

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                };
            };

            getTable().setModel(model);

            ((DefaultTableModel) getTable().getModel()).setRowCount(0);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
            }

            if(getFiltros().getSelectedItem() != null){
                FiltrosClass f = (FiltrosClass) getFiltros().getSelectedItem();
                if(f.getType() == FiltrosEnum.FILTRO_GERAR){
                    f.run();
                    return;
                }
            }

            for (Object[] data : LoansDAO.getInstance().getEmprestimosEmAberto()) {
                if(data[4].toString().contains("Finalizado em")){
                    renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightGreen);
                    for (int i = 0; i < getTable().getColumnCount(); i++) {
                        getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                    }
                }else{
                    if(!getTitulo().getText().equalsIgnoreCase("emprestimos finalizados")){
                        if (Integer.parseInt(data[4].toString()) > 0 && Integer.parseInt(data[4].toString()) <= 7) {
                            renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightYellow);
                            for (int i = 0; i < getTable().getColumnCount(); i++) {
                                getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                            }
                        }
    
                        if (Integer.parseInt(data[4].toString()) < 0) {
                            renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                            for (int i = 0; i < getTable().getColumnCount(); i++) {
                                getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                            }
                        }
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
        new TelaCadastroEmprestimo().setVisible(true);
    }

    public void btnEditar() {
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar() {
        int id = (int) getTable().getValueAt(getTable().getSelectedRow(), 0);
        try {
            LoanModel loan = LoansDAO.getInstance().getLoan(id);
            TelaFinalizarEmprestimo tela = new TelaFinalizarEmprestimo(loan, getTable().getValueAt(getTable().getSelectedRow(), 1).toString());
            tela.setVisible(true);
            tela.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    carregarDados();
                }
            });

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
                        String fileName = "RelatorioEmprestimosEmAberto";
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
            new FiltrosGerar("Todos os emprestimos", () -> {
                try {            
                    StatusRenderer renderer = new StatusRenderer();
                    ((DefaultTableModel) getTable().getModel()).setRowCount(0);
                    ArrayList<Object[]> emprestimosEmAberto = LoansDAO.getInstance().getEmprestimosEmAberto();
                    ArrayList<Object[]> emprestimosFinalizados = LoansDAO.getInstance().relatorioEmprestimos();
                    ArrayList<Object[]> emprestimos = new ArrayList<>();
                    for(Object[] emprestimo : emprestimosEmAberto){
                        emprestimos.add(emprestimo);
                    }
                     for(Object[] emprestimo : emprestimosFinalizados){
                         emprestimos.add(new Object[]{emprestimo[0], emprestimo[1], emprestimo[2], emprestimo[3], "Finalizado em " + emprestimo[4], emprestimo[8], emprestimo[6], emprestimo[7]});
                     }
                     getTitulo().setText("Todos os emprestimos");
        
                    for (Object[] data : emprestimos) {
                        if(data[4].toString().contains("Finalizado em")){
                            renderer.addHighlightedRow(getTable().getModel().getRowCount(), ColorsRenderer.lightGreen);
                            for (int i = 0; i < getTable().getColumnCount(); i++) {
                                getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                            }
                        }else{
                            if (Integer.parseInt(data[4].toString()) > 0 && Integer.parseInt(data[4].toString()) <= 7) {
                                renderer.addHighlightedRow(getTable().getModel().getRowCount(), ColorsRenderer.lightYellow);
                                for (int i = 0; i < getTable().getColumnCount(); i++) {
                                    getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                                }
                            }
        
                            if (Integer.parseInt(data[4].toString()) < 0) {
                                renderer.addHighlightedRow(getTable().getModel().getRowCount(), ColorsRenderer.lightRed);
                                for (int i = 0; i < getTable().getColumnCount(); i++) {
                                    getTable().getColumnModel().getColumn(i).setCellRenderer(renderer);
                                }
                            }
                        }
        
                        ((DefaultTableModel) getTable().getModel()).addRow(data);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
                }

                return null;
            }),
            new FiltrosGerar("Emprestimos finalizados", () -> {
                try {            
                    String[] columnNames = {"ID", "Amigo", "Data Início", "Data Devoluçao", "Data Finalizado", "Observações", "Num. Ferramentas", "V. Total Ferramentas", "V. Recebido", "Ferramentas"};
                    DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames) {
                        boolean[] canEdit = new boolean[]{
                            false, false, false, false, false, false, false, false, false, false
                        };
        
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        };
                    };
        
                    getTable().setModel(model);
        
                    ((DefaultTableModel) getTable().getModel()).setRowCount(0);
        
                    if (getTable().getColumnModel().getColumnCount() > 0) {
                        getTable().getColumnModel().getColumn(0).setMinWidth(65);
                        getTable().getColumnModel().getColumn(0).setMaxWidth(65);
                    }

                    getTitulo().setText("Emprestimos finalizados");
        
                    for (Object[] data : LoansDAO.getInstance().relatorioEmprestimos()) {            
                        ((DefaultTableModel) getTable().getModel()).addRow(data);
        
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar os dados da tabela: " + e.getMessage());
                }

                return null;
            }),
        });
    }

}
