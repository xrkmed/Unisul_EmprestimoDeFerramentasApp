package Resources;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class DirectoryChooserFrame extends JFrame {

    private String selectedDirectory = "";

    public DirectoryChooserFrame() {
        super();
        setTitle("Selecione o local para salvar seu arquivo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(0, 0);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int choice = fileChooser.showDialog(this, "Exportar aqui");
        if (choice == JFileChooser.APPROVE_OPTION) {
            selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            this.dispose();
        }
    }

    public final String getSelectedDirectory() {
        return selectedDirectory;
    }
}
