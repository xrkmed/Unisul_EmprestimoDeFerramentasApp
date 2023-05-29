package Controllers;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StatusRenderer extends DefaultTableCellRenderer {

    private final HashMap<Integer, Color> highlightMap = new HashMap<>();

    public StatusRenderer() {
        super();
    }

    public void addHighlightedRow(int row, Color color) {
        this.highlightMap.put(row, color);
    }

    public Color getHighlightedRow(int row) {
        return this.highlightMap.getOrDefault(row, null);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifique se a linha atual está no HashMap de linhas destacadas
        if (highlightMap.containsKey(row)) {
            // Obtenha a cor correspondente da linha destacada
            Color highlightedColor = highlightMap.get(row);
            // Defina a cor de fundo para a cor destacada
            if (isSelected) {
                highlightedColor = highlightedColor.darker();
            }

            cellComponent.setBackground(highlightedColor);
            cellComponent.setForeground(Color.BLACK);
        } else {
            if (isSelected) {
                cellComponent.setBackground(table.getSelectionBackground());
                cellComponent.setForeground(table.getSelectionForeground());
            } else {
                cellComponent.setBackground(table.getBackground());
                cellComponent.setForeground(table.getForeground());
            }
        }

        return cellComponent;
    }
}
