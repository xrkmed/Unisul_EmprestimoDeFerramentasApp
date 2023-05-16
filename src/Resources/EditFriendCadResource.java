package Resources;

import Model.FriendModel;
import ViewsAmigos.TelaAlterarCadastro;

public class EditFriendCadResource {

    public static void editFriendCadResource(FriendModel e){
        TelaAlterarCadastro tela = new TelaAlterarCadastro(e);
        tela.setVisible(true);
    }
    
}
