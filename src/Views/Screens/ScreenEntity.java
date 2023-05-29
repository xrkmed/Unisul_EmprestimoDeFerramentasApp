package Views.Screens;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

import Views.TelaInicial;

public class ScreenEntity {

    private TelaInicial tela;

    public ScreenEntity(){
    }

    public ScreenEntity(TelaInicial telaInicial){
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

    public String getName(){
        return "Lista vazia";
    }

    public void carregarDados(){
        //
    }

    public void init(){
        //
    }

    public final JTable getTable(){
        return tela.getTable();
    }

    public final JLabel getTitulo(){
        return tela.getTitulo();
    }

    public final JButton getBtnCadastro(){
        return tela.getBtnCadastro();
    }

    public final JButton getBtnEditar(){
        return tela.getBtnEditar();
    }

    public final JButton getBtnDeletar(){
        return tela.getBtnDeletar();
    }

    public final JButton getBtnVisualizar(){
        return tela.getBtnVisualizar();
    }

    public final JButton getBtnExportar(){
        return tela.getBtnExportar();
    }

    public Object getSelectedValue(){
        return null;
    }

    
}
