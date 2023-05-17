/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author arkmed
 */
public class StatusRenderer  extends DefaultTableCellRenderer {
    
    private final HashMap<Integer, Color> highlightMap = new HashMap<>();

    public StatusRenderer(){
        super();
    }

    public void addHighlightedRow(int row, Color color){
        this.highlightMap.put(row, color);
    }

    public Color getHighlightedRow(int row){
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
            cellComponent.setBackground(highlightedColor);
        } else {
            // Defina a cor de fundo padrão para outras linhas
            cellComponent.setBackground(table.getBackground());
        }
        
        return cellComponent;
    }
}
