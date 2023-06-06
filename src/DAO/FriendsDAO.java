package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.FriendModel;
import Resources.AddressResource;
import Resources.PhoneValidResource;

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
    public FriendModel addFriend(String nome, String telefone, AddressResource address) throws IllegalArgumentException, DatabaseResultQueryException, SQLException {
        ResultSet searchComum = DBQuery.executeQuery("SELECT id FROM tb_amigos WHERE nome = ? OR telefone = ? LIMIT 1;", nome.toUpperCase(), telefone.toUpperCase());
        if (searchComum.next()) {
            throw new IllegalArgumentException("Já existe um amigo com esse nome ou telefone!");
        }

        ResultSet _resAddress = DBQuery.executeQuery("SELECT id FROM enderecos WHERE cep = ?", address.getCEP());
        if(!_resAddress.next()) {
            _resAddress = AddressDAO.getInstance().insertAddress(address);

            if(!_resAddress.next()){
                throw new IllegalArgumentException("Erro ao inserir o endereço!");
            }
        }

        ResultSet _insertAmigo = DBQuery.insertOrUpdateQuery("INSERT INTO tb_amigos (nome, telefone, endereco_id, numero, complemento) VALUES (?, ?, ?, ?, ?);", nome.toUpperCase(), telefone.toUpperCase(), _resAddress.getInt(1), address.getNumber(), address.getComplemento());
        while(_insertAmigo.next()){
            FriendModel _friend = new FriendModel(_insertAmigo.getInt(1), nome.toUpperCase(), address, telefone);

            return _friend;
        }

        return null;
    }

    public void removeFriend(FriendModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_amigos WHERE id = ?;", e.getId());
    }

    public ArrayList<FriendModel> getFriends() throws DatabaseResultQueryException, SQLException {
        ArrayList<FriendModel> friends = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, A.numero, A.complemento, E.id AS endId, IFNULL(E.endereco, 'Sem endereco') as endereco, E.cep, IFNULL(B.bairro, 'Sem bairro') as bairro, IFNULL(CID.cidade, 'Sem cidade') as cidade, IFNULL(UF.uf, 'SC') as uf FROM tb_amigos A LEFT JOIN enderecos E ON E.id = A.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = B.cidade_id LEFT JOIN endereco_uf UF ON UF.id = CID.uf_id;");

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("endereco"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            friends.add(friend);
        }
        return friends;
    }

    public FriendModel getFriend(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, A.numero, A.complemento, E.id AS endId, IFNULL(E.endereco, 'Sem endereco') as endereco, E.cep, IFNULL(B.bairro, 'Sem bairro') as bairro, IFNULL(CID.cidade, 'Sem cidade') as cidade, IFNULL(UF.uf, 'SC') as uf FROM tb_amigos A LEFT JOIN enderecos E ON E.id = A.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = B.cidade_id LEFT JOIN endereco_uf UF ON UF.id = CID.uf_id WHERE A.id = ?", id);

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("endereco"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            return friend;
        }

        return null;
    }

    public void updateFriend(FriendModel target, FriendModel reference) throws DatabaseResultQueryException, SQLException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET nome = ?, telefone = ?, numero = ?, complemento = ? WHERE id = '" + target.getId() + "';", reference.getName(), reference.getPhone(), reference.getAddress().getNumber(), reference.getAddress().getComplemento());
        
        if(!target.getAddress().toString().equals(reference.getAddress().toString())){
            int endId = AddressDAO.getInstance().updateAddress(target.getAddress().getId(), reference.getAddress());
            DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET endereco_id = ? WHERE id = ?", endId, target.getId());
        }
   }

    public ArrayList<Object[]> loadFriendsTabela() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datasObject = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT a.id AS ID, a.nome AS Nome, a.telefone AS Telefone, IFNULL(CONCAT(E.endereco, ', ', a.numero, ', ', B.bairro, ', ', CID.cidade, ', ', UF.uf, ' - CEP: ', E.cep, ' Complemento: ', a.complemento), 'Sem endereco') AS Endereco, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL THEN em.id END) AS `Emprestimos Abertos`, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL AND em.previsaoDataEntrega < CURDATE() THEN em.id END) AS `Emprestimos Atrasados` FROM tb_amigos AS a LEFT JOIN enderecos E ON E.id = a.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = B.cidade_id LEFT JOIN endereco_uf UF ON UF.id = CID.uf_id LEFT JOIN tb_emprestimos AS em ON a.id = em.amigo_id GROUP BY a.id, a.nome, a.telefone, E.endereco, a.numero, B.bairro, CID.cidade, UF.uf, E.cep;");
        while (result.next()) {
            Object[] data = {result.getInt("ID"), result.getString("Nome").toUpperCase(), PhoneValidResource.formatPhoneNumber(result.getLong("Telefone") + ""), result.getString("Endereco"), result.getInt("Emprestimos Abertos"), result.getInt("Emprestimos Atrasados")};

            datasObject.add(data);
        }
        return datasObject;
    }
}
