package Resources;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import ViewsEmprestimo.TelaRelatorioEmprestimos;
import ViewsTool.TelaRelatorioFerramentas;

public class DirectoryChooserFrame extends JFrame {
    public DirectoryChooserFrame(){
        super();
    }
    public DirectoryChooserFrame(JFrame parent) {
        this();
        setTitle("Selecione o local para salvar seu arquivo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(0, 0);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showDialog(this, "Selecionar");
        if (choice == JFileChooser.APPROVE_OPTION) {
            String selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            if(parent instanceof TelaRelatorioFerramentas){
                ((TelaRelatorioFerramentas) parent).setDirectory(selectedDirectory);
                this.dispose();
            }
            if(parent instanceof TelaRelatorioEmprestimos){
                ((TelaRelatorioEmprestimos) parent).setDirectory(selectedDirectory);
                this.dispose();
            }
        }
    }
}
