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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);

        //Initialize Connection
        Database.getInstance().getConnection();
    }

}
