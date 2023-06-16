package Model;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import Views.TelaInicial;
import javax.swing.JTextField;

public class ScreenModel {

    private TelaInicial tela;

    public ScreenModel() {
    }

    public ScreenModel(TelaInicial telaInicial) {
        this.tela = telaInicial;

        for (java.awt.event.ActionListener al : getBtnCadastro().getActionListeners()) {
            getBtnCadastro().removeActionListener(al);
        }

        for (java.awt.event.ActionListener al : getBtnEditar().getActionListeners()) {
            getBtnEditar().removeActionListener(al);
        }

        for (java.awt.event.ActionListener al : getBtnDeletar().getActionListeners()) {
            getBtnDeletar().removeActionListener(al);
        }

        for (java.awt.event.ActionListener al : getBtnVisualizar().getActionListeners()) {
            getBtnVisualizar().removeActionListener(al);
        }

        for (java.awt.event.ActionListener al : getBtnExportar().getActionListeners()) {
            getBtnExportar().removeActionListener(al);
        }

        init();
    }

    public String getName() {
        return "Lista Vazia";
    }

    public void carregarDados() {
    }

    public void init() {
        getBtnDeletar().setToolTipText("deletar");
        getBtnDeletar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Icons/file-document-remove-custom.png")));

    }

    public void atualizarDados() {
        carregarDados();
    }

    public final JTable getTable() {
        return tela.getTable();
    }

    public final ArrayList<Object[]> getTableData() {
        ArrayList<Object[]> tableData = new ArrayList<>();
        for (int row = 0; row < getTable().getRowCount(); row++) {
            Object[] rowData = new Object[getTable().getColumnCount()];
            for (int col = 0; col < getTable().getColumnCount(); col++) {
                rowData[col] = getTable().getValueAt(row, col);
            }
            tableData.add(rowData);
        }

        return tableData;
    }

    public DefaultComboBoxModel<FiltrosModel> get() {
        return new javax.swing.DefaultComboBoxModel<>(new FiltrosModel[]{new FiltrosModel("")});
    }

    public final JLabel getTitulo() {
        return tela.getTitulo();
    }

    public final JButton getBtnCadastro() {
        return tela.getBtnCadastro();
    }

    public final JButton getBtnEditar() {
        return tela.getBtnEditar();
    }

    public final JButton getBtnDeletar() {
        return tela.getBtnDeletar();
    }

    public final JButton getBtnVisualizar() {
        return tela.getBtnVisualizar();
    }

    public final JButton getBtnExportar() {
        return tela.getBtnExportar();
    }

    public final JPopupMenu getPopOpcoes() {
        return tela.getPopOpcoes();
    }

    public final JComboBox<FiltrosModel> getFiltros() {
        return tela.getComboBox();
    }

    public final JTextField getCampoNomeFiltroLupa() {
        return tela.getCampoNomeFiltroNome();
    }

    public Object getSelectedValue() {
        return null;
    }

}
