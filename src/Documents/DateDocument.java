package Documents;

import Resources.DateResource;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class DateDocument extends DocumentFilter {

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
}
