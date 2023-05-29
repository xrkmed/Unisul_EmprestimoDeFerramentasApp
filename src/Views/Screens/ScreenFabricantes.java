package Views.Screens;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllers.ColorsRenderer;
import Controllers.PDFEntity;
import Controllers.StatusRenderer;
import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ManufacturerDAO;
import Resources.DirectoryChooserFrame;
import Views.TelaInicial;
import ViewsEmprestimo.TelaRelatorioEmprestimos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ScreenFabricantes extends ScreenEntity{

    private final String[] columnNames = {"ID", "Nome", "CNPJ", "Ferramentas", "Ferramentas em uso", "Valor total"};
    
    public ScreenFabricantes(){
        super();
    }

    public ScreenFabricantes(TelaInicial telaInicial){
        super(telaInicial);
    }

    @Override
    public String getName(){
        return "Lista de Fabricantes";
    }

    @Override
    public void init(){
        getTitulo().setText(getName());

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
    public void carregarDados(){
        try {
            StatusRenderer renderer = new StatusRenderer();

            DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames){
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                };
            };

            getTable().setModel(model);

            ((DefaultTableModel) getTable().getModel()).setRowCount(0);

            if (getTable().getColumnModel().getColumnCount() > 0) {
                getTable().getColumnModel().getColumn(0).setMinWidth(65);
                getTable().getColumnModel().getColumn(0).setMaxWidth(65);
            }

            ArrayList<Object[]> manufacturerData = ManufacturerDAO.getInstance().getFabricantesData();

            for (Object[] data : manufacturerData) {
                if (Integer.parseInt(data[3].toString()) == Integer.parseInt(data[4].toString())) {
                    if (Integer.parseInt(data[3].toString()) > 0) {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightRed);
                    } else {
                        renderer.addHighlightedRow(model.getRowCount(), ColorsRenderer.lightOrange);
                    }

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
    public void btnCadastro(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnEditar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnDeletar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnVisualizar(){
        JOptionPane.showMessageDialog(null, "working!");
    }

    public void btnExportar(){
        DirectoryChooserFrame directoryChooserFrame = new DirectoryChooserFrame();

        directoryChooserFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if(directoryChooserFrame.getSelectedDirectory().length() > 0){
                    try{
                        Paragraph paragraphRelatorio = PDFEntity.addParagraph("RELATORIO", 10);
                        String fileName = "RelatorioFabricantes";
                        PDFEntity.export(directoryChooserFrame.getSelectedDirectory() + "/", fileName, getTable(), paragraphRelatorio);
                        JOptionPane.showMessageDialog(null, "PDF Exportado com sucesso em: " + directoryChooserFrame.getSelectedDirectory() + "/" + fileName + ".pdf");
                    }catch(Exception e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente novamente mais tarde...");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Nao foi possivel exportar o PDF, tente selecionar um diretorio valido!");
                }
            }
        });
    }
    
}