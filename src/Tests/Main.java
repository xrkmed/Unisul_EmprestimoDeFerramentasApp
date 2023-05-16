package Tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
import Database.DBQuery;
import Database.Database;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;
import Resources.AddressResource;
import Resources.ManufacturerResource;
import Views.TelaPrincipal;

public class Main {

    public static LoansDAO loans = LoansDAO.getInstance();
    public static FriendsDAO friends = FriendsDAO.getInstance();
    public static ToolsDAO tools = ToolsDAO.getInstance();

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);

        //Initialize Connection
        Database.getInstance().getConnection();
    }
    
}
