package Controllers;

import javax.swing.JTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFEntity {

    public static Paragraph addParagraph(String content, int space) {
        Paragraph paragraph = new Paragraph(content);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(space);
        return paragraph;
    }

    public static void export(String directory, String filename, JTable table, Paragraph... extraParagraph) throws Exception {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream(directory + filename + ".pdf"));
        document.open();

        Font headerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        Font contentFont = new Font(Font.FontFamily.HELVETICA, 8);

        for (Paragraph paragraph : extraParagraph) {
            document.add(paragraph);
        }
        document.add(new Paragraph(" "));

        // Cabeçalho da tabela
        PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
        pdfTable.setWidthPercentage(100); // Define a largura da tabela como 100% do espaço disponível

        float[] columnWidths = new float[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); i++) {
            columnWidths[i] = 1f; // Define a largura de cada coluna como 1 unidade
        }
        pdfTable.setWidths(columnWidths);

        for (int i = 0; i < table.getColumnCount(); i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(i), headerFont));
            pdfTable.addCell(cell);
        }

        // Conteúdo da tabela
        for (int row = 0; row < table.getRowCount(); row++) {
            for (int column = 0; column < table.getColumnCount(); column++) {
                Object value = table.getValueAt(row, column);
                PdfPCell cell = new PdfPCell(new Paragraph(value != null ? value.toString() : "", contentFont));
                pdfTable.addCell(cell);
            }
        }
        document.add(pdfTable);

        // Texto final e data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());

        Font footerFont = new Font(Font.FontFamily.HELVETICA, 8);
        Paragraph footerParagraph = new Paragraph("Sistema de relatório do Grupo Supimpa\nData: " + currentDate, footerFont);
        footerParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(footerParagraph);

        document.close();
    }

}
