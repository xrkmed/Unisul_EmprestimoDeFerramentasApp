package Resources;

import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class PriceDocument extends DocumentFilter {
    // Esta classe serve para formatar o preco de uma ferramenta no formato de moeda brasileira

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
        if (filteredText.length() > 9) {
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
            super.replace(fb, 0, doc.getLength(), "", attr);
        }
    }
}
