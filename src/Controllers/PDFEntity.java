package Controllers;

import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFEntity {
    public static Paragraph addParagraph(String content, int space){
        Paragraph paragraph = new Paragraph(content);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(space);
        return paragraph;
    }

    public static void export(String directory, String filename, JTable table, Paragraph... extraParagraph){
        try {
            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, new FileOutputStream(directory + filename + ".pdf"));
            document.open();

            for(Paragraph paragraph : extraParagraph){
                document.add(paragraph);
            }
            document.add(new Paragraph(" "));

            // Cabeçalho da tabela
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(i)));
                pdfTable.addCell(cell);
            }

            // Conteúdo da tabela
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int column = 0; column < table.getColumnCount(); column++) {
                    Object value = table.getValueAt(row, column);
                    PdfPCell cell = new PdfPCell(new Paragraph(value != null ? value.toString() : ""));
                    pdfTable.addCell(cell);
                }
            }
            document.add(pdfTable);

            
            


            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
