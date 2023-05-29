package Resources;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import ViewsEmprestimo.TelaRelatorioEmprestimos;
import ViewsTool.TelaRelatorioFerramentas;
import ViewsAmigos.TelaRelatorioAmigos;
import ViewsManufacturer.TelaRelatorioFabricante;

public class DirectoryChooserFrame extends JFrame {

    private String selectedDirectory = "";

    public DirectoryChooserFrame() {
        super();
        setTitle("Selecione o local para salvar seu arquivo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(0, 0);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showDialog(this, "Selecionar");
        if (choice == JFileChooser.APPROVE_OPTION) {
            selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            this.dispose();
        }
    }

    public DirectoryChooserFrame(JFrame parent) {
        super();
        setTitle("Selecione o local para salvar seu arquivo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(0, 0);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showDialog(this, "Selecionar");
        if (choice == JFileChooser.APPROVE_OPTION) {
            selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            if (parent instanceof TelaRelatorioFerramentas) {
                ((TelaRelatorioFerramentas) parent).setDirectory(selectedDirectory);
                this.dispose();
            }
            if (parent instanceof TelaRelatorioEmprestimos) {
                ((TelaRelatorioEmprestimos) parent).setDirectory(selectedDirectory);
                this.dispose();
            }
            if (parent instanceof TelaRelatorioAmigos) {
                ((TelaRelatorioAmigos) parent).setDirectory(selectedDirectory);
                this.dispose();
            }
            if (parent instanceof TelaRelatorioFabricante) {
                ((TelaRelatorioFabricante) parent).setDirectory(selectedDirectory);
                this.dispose();
            }


        }
    }

    public final String getSelectedDirectory() {
        return selectedDirectory;
    }
}
