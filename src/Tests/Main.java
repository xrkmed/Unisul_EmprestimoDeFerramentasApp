package Tests;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ManufacturerDAO;
import DAO.ToolsDAO;
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

        //ManufacturerResource(Int id, String name)
        ManufacturerResource manufacturerExample = new ManufacturerResource(1, "Braspress Matriz", "48740351000165");

        ManufacturerDAO.getInstance().addManufacturer(manufacturerExample);
        //ToolModel(Integer id, ManufacturerResource manufacturer, double price)
        ToolModel toolExample = new ToolModel(1, "Martelo", null, 10.0);

        //AddressResource(String street, String district, String city, String state, Integer number, String complemento, Integer CEP)
        AddressResource addressExample = new AddressResource("Rua 1", "Bairro 1", "Cidade 1", "Estado 1", 500, "Casa verde", 12345678);

        //FriendModel(Integer id, String name, AddressResource address, String phone)
        FriendModel friendExample = new FriendModel("Amigo 1", addressExample, "48996755251");
        FriendModel friendExample2 = new FriendModel("Amigo 2", addressExample, "48996755251");
        FriendModel friendExample3 = new FriendModel("Amigo 3", addressExample, "48996755251");
        FriendModel friendExample4 = new FriendModel("Amigo 4", addressExample, "48996755251");

        friends.addFriend(friendExample);
        friends.addFriend(friendExample2);
        friends.addFriend(friendExample3);
        friends.addFriend(friendExample4);

        tools.addTool(toolExample);

        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);


    }
    
}
