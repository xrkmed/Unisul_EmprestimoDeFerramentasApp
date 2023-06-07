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

        FriendModel _friend = null;
        try{
            DBQuery.startTransaction();
	
            int endId = _resAddress.getInt(1);
            ResultSet _insertAmigo = DBQuery.insertOrUpdateQuery("INSERT INTO tb_amigos (nome, telefone) VALUES (?, ?);", nome.toUpperCase(), telefone.toUpperCase());
    
            if(_insertAmigo.next()){
                _friend = new FriendModel(_insertAmigo.getInt(1), nome.toUpperCase(), address, telefone);
                DBQuery.insertOrUpdateQuery("INSERT INTO amigo_has_endereco (amigo_id, endereco_id, numero, complemento) VALUES (?, ?, ?, ?)", _friend.getId(), endId, address.getNumber(), address.getComplemento());
                address.setId(endId);
            }

            DBQuery.commitTransaction();
        }catch(SQLException e){
            try{
                DBQuery.rollbackTransaction();   
            }catch(SQLException ex){
                throw new DatabaseResultQueryException(ex.getMessage());
            }
        }finally{
            try{
                DBQuery.endTransaction();
            }catch(SQLException ex){
                throw new DatabaseResultQueryException(ex.getMessage());
            }
        }

        return _friend;
    }

    public void removeFriend(FriendModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_amigos WHERE id = ?;", e.getId());
    }

    public ArrayList<FriendModel> getFriends() throws DatabaseResultQueryException, SQLException {
        ArrayList<FriendModel> friends = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, AHE.numero, AHE.complemento, AHE.endereco_id AS endId, E.endereco, E.cep, B.bairro, CID.cidade, UF.uf FROM tb_amigos A LEFT JOIN amigo_has_endereco AHE ON AHE.amigo_id = A.id LEFT JOIN enderecos E ON E.id = AHE.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = E.cidade_id LEFT JOIN endereco_uf UF ON UF.id = E.uf_id;");

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("endereco"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            friends.add(friend);
        }
        return friends;
    }

    public FriendModel getFriend(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT A.id, A.nome, A.telefone, AHE.numero, AHE.complemento, AHE.endereco_id AS endId, E.endereco, E.cep, B.bairro, CID.cidade, UF.uf FROM tb_amigos A LEFT JOIN amigo_has_endereco AHE ON AHE.amigo_id = A.id LEFT JOIN enderecos E ON E.id = AHE.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = E.cidade_id LEFT JOIN endereco_uf UF ON UF.id = E.uf_id WHERE A.id = ?", id);

        while (result.next()) {
            AddressResource address = new AddressResource(result.getInt("endId"), result.getString("endereco"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
            FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome").toUpperCase(), address, result.getLong("telefone") + "");
            return friend;
        }

        return null;
    }

    public void updateFriend(FriendModel target, FriendModel reference) throws DatabaseResultQueryException, SQLException {
        if(!target.getName().equals(reference.getName()) || !target.getPhone().equals(reference.getPhone())){
            DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET nome = ?, telefone = ? WHERE id = '" + target.getId() + "';", reference.getName(), reference.getPhone());
        }
        
        if(!target.getAddress().toString().toLowerCase().equals(reference.getAddress().toString().toLowerCase())){
            int endId = AddressDAO.getInstance().updateAddress(target.getAddress().getId(), reference.getAddress());
            DBQuery.insertOrUpdateQuery("DELETE FROM amigo_has_endereco WHERE amigo_id = ?", target.getId());
            DBQuery.insertOrUpdateQuery("INSERT INTO amigo_has_endereco (amigo_id, endereco_id, numero, complemento) VALUES (?, ?, ?, ?)", target.getId(), endId, reference.getAddress().getNumber(), reference.getAddress().getComplemento());

            //DBQuery.insertOrUpdateQuery("UPDATE amigo_has_endereco SET endereco_id = ?, numero = ?, complemento = ? WHERE amigo_id = ?", endId, reference.getAddress().getNumber(), reference.getAddress().getComplemento(), target.getId());
        }
   }

    public ArrayList<Object[]> loadFriendsTabela() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datasObject = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT a.id AS ID, a.nome AS Nome, a.telefone AS Telefone, IFNULL(CONCAT(E.endereco, ', ', AHE.numero, ', ', B.bairro, ', ', CID.cidade, ', ', UF.uf, ' - CEP: ', E.cep, ' Complemento: ', AHE.complemento), 'Sem endereco') AS Endereco, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL THEN em.id END) AS `Emprestimos Abertos`, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL AND em.previsaoDataEntrega < CURDATE() THEN em.id END) AS `Emprestimos Atrasados` FROM tb_amigos AS a LEFT JOIN amigo_has_endereco AHE ON AHE.amigo_id = a.id LEFT JOIN enderecos E ON E.id = AHE.endereco_id LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = E.cidade_id LEFT JOIN endereco_uf UF ON UF.id = E.uf_id LEFT JOIN tb_emprestimos AS em ON a.id = em.amigo_id GROUP BY a.id, a.nome, a.telefone, E.endereco, AHE.numero, B.bairro, CID.cidade, UF.uf, E.cep;");
        while (result.next()) {
            Object[] data = {result.getInt("ID"), result.getString("Nome").toUpperCase(), PhoneValidResource.formatPhoneNumber(result.getLong("Telefone") + ""), result.getString("Endereco"), result.getInt("Emprestimos Abertos"), result.getInt("Emprestimos Atrasados")};

            datasObject.add(data);
        }
        return datasObject;
    }
}
