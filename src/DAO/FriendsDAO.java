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

        ResultSet _resAddress = DBQuery.executeQuery("SELECT id FROM tb_enderecos WHERE cep = ?", address.getCEP());
        if(!_resAddress.next()) {
            _resAddress = AddressDAO.getInstance().insertAddress(address);
        }

        
        if(_resAddress.next()){
            ResultSet _insertAmigo = DBQuery.insertOrUpdateQuery("INSERT INTO tb_amigos (nome, telefone, endereco_id, numero, complemento) VALUES (?, ?, ?, ?, ?);", nome.toUpperCase(), telefone.toUpperCase(), _resAddress.getInt(1), address.getNumber(), address.getComplemento());
            while(_insertAmigo.next()){
                FriendModel _friend = new FriendModel(_insertAmigo.getInt(1), nome.toUpperCase(), address, telefone);

                return _friend;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar o amigo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public void removeFriend(FriendModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_amigos WHERE id = ?;", e.getId());
    }

    public ArrayList<FriendModel> getFriends() throws DatabaseResultQueryException, SQLException {
        ArrayList<FriendModel> friends = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, E.id AS endId, E.rua, E.bairro, E.cidade, E.uf, E.cep, A.numero, A.complemento FROM tb_amigos A LEFT JOIN tb_enderecos E ON E.id = A.endereco_id;");

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            friends.add(friend);
        }
        return friends;
    }

    public FriendModel getFriend(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, E.id AS endId, E.rua, E.bairro, E.cidade, E.uf, E.cep, A.numero, A.complemento FROM tb_amigos A LEFT JOIN tb_enderecos E ON E.id = A.endereco_id WHERE A.id = ?", id);

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            return friend;
        }

        return null;
    }

    public void updateFriend(FriendModel target, FriendModel reference) throws DatabaseResultQueryException, SQLException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET nome = ?, telefone = ?, numero = ?, complemento = ? WHERE id = '" + target.getId() + "';", reference.getName(), reference.getPhone(), reference.getAddress().getNumber(), reference.getAddress().getComplemento());
        
        if(target.getAddress().toString() != reference.getAddress().toString()){
            AddressResource _address = AddressDAO.getInstance().getAddress(reference.getAddress().getCEP());
            if(_address == null){
                ResultSet _newAddress = AddressDAO.getInstance().insertAddress(reference.getAddress());
                while(_newAddress.next()){
                    DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET endereco_id = ? WHERE id = ?", _newAddress.getInt(1), target.getId());
                    break;
                }
            }else{
                DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET endereco_id = ? WHERE id = ?", _address.getId(), target.getId());
            }
        }
   }

    public ArrayList<Object[]> loadFriendsTabela() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datasObject = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT a.id AS ID, a.nome AS Nome, a.telefone AS Telefone, CONCAT(e.rua, ', ', a.numero, ', ', e.bairro, ', ', e.cidade, ', ', e.uf, ' - CEP: ', e.cep, ' Complemento: ', a.complemento) AS Endereco, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL THEN em.id END) AS `Emprestimos Abertos`, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL AND em.previsaoDataEntrega < CURDATE() THEN em.id END) AS `Emprestimos Atrasados` FROM tb_amigos AS a LEFT JOIN tb_enderecos AS e ON a.endereco_id = e.id LEFT JOIN tb_emprestimos AS em ON a.id = em.amigo_id GROUP BY a.id, a.nome, a.telefone, e.rua, a.numero, e.bairro, e.cidade, e.uf, e.cep;");
        while (result.next()) {
            Object[] data = {result.getInt("ID"), result.getString("Nome").toUpperCase(), PhoneValidResource.formatPhoneNumber(result.getLong("Telefone") + ""), result.getString("Endereco"), result.getInt("Emprestimos Abertos"), result.getInt("Emprestimos Atrasados")};

            datasObject.add(data);
        }
        return datasObject;
    }
}
