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

    
}
