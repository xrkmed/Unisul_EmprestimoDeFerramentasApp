package Tests;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ToolsDAO;
import Database.Database;
import Views.TelaInicial;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class Main {

    public static LoansDAO loans = LoansDAO.getInstance();
    public static FriendsDAO friends = FriendsDAO.getInstance();
    public static ToolsDAO tools = ToolsDAO.getInstance();
    public static TelaInicial tela;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.tela = new TelaInicial();
        Main.tela.setVisible(true);

        //SMTP.send("particular.guilherme.martins@gmail.com", "noreply (A3 Grupo Supimpa)", "Seja bem vindo ao aplicativo!\nVoce tem <strong>3 emprestimos em aberto</strong> para gerenciar.");
        //Initialize Connection
        Database.getInstance().getConnection();
    }

}
