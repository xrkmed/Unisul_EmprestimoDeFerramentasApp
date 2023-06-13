package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.FriendModel;
import Resources.PhoneResource;

public class FriendsDAO {

    //Singleton Class
    private static FriendsDAO instance;

    private FriendsDAO() {
    }

    public static FriendsDAO getInstance() {
        if (instance == null) {
            instance = new FriendsDAO();
        }
        return instance;
    }

    //Methods
    public FriendModel addFriend(String nome, String telefone) throws IllegalArgumentException, DatabaseResultQueryException, SQLException {
        ResultSet searchComum = DBQuery.executeQuery("SELECT id FROM tb_amigos WHERE nome = ? OR telefone = ? LIMIT 1;", nome.toUpperCase(), telefone.toUpperCase());
        if (searchComum.next()) {
            throw new IllegalArgumentException("Já existe um amigo com esse nome ou telefone!");
        }

        FriendModel _friend = null;
        ResultSet _insertAmigo = DBQuery.insertOrUpdateQuery("INSERT INTO tb_amigos (nome, telefone) VALUES (?, ?);", nome.toUpperCase(), telefone.toUpperCase());
        if (_insertAmigo.next()) {
            _friend = new FriendModel(_insertAmigo.getInt(1), nome.toUpperCase(), telefone);
        }

        return _friend;
    }

    public void removeFriend(FriendModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_amigos WHERE id = ?;", e.getId());
    }

    public ArrayList<FriendModel> getFriends() throws DatabaseResultQueryException, SQLException {
        ArrayList<FriendModel> friends = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone FROM tb_amigos A;");

        while (result.next()) {
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), result.getLong("telefone") + "");
            friends.add(friend);
        }
        return friends;
    }

    public FriendModel getFriend(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone FROM tb_amigos A WHERE A.id = ?", id);

        while (result.next()) {
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), result.getLong("telefone") + "");
            return friend;
        }

        return null;
    }

    public void updateFriend(FriendModel target, FriendModel reference) throws DatabaseResultQueryException, SQLException {
        if (!target.getName().equals(reference.getName()) || !target.getPhone().equals(reference.getPhone())) {
            DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET nome = ?, telefone = ? WHERE id = '" + target.getId() + "';", reference.getName(), reference.getPhone());
        }
    }

    public ArrayList<Object[]> loadFriendsTabela() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datasObject = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT a.id AS ID, a.nome AS Nome, a.telefone AS Telefone, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL THEN em.id END) AS `Emprestimos Abertos`, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL AND em.previsaoDataEntrega < CURDATE() THEN em.id END) AS `Emprestimos Atrasados` FROM tb_amigos AS a LEFT JOIN tb_emprestimos AS em ON a.id = em.amigo_id GROUP BY a.id, a.nome, a.telefone;");
        while (result.next()) {
            Object[] data = {result.getInt("ID"), result.getString("Nome").toUpperCase(), PhoneResource.formatPhoneNumber(result.getLong("Telefone") + ""), result.getInt("Emprestimos Abertos"), result.getInt("Emprestimos Atrasados")};

            datasObject.add(data);
        }
        return datasObject;
    }
}
