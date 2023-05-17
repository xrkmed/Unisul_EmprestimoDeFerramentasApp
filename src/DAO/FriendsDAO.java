package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.DBQuery;
import Model.FriendModel;
import Resources.AddressResource;
import Resources.PhoneValidResource;

public class FriendsDAO {

    //Singleton Class
    private static FriendsDAO instance;

    private FriendsDAO(){

    }

    public static FriendsDAO getInstance(){
        if(instance == null){
            instance = new FriendsDAO();
        }
        return instance;
    }
    

    //Methods
    public FriendModel addFriend(String nome, String telefone, AddressResource address) throws IllegalArgumentException{
        try{
            ResultSet searchComum = DBQuery.executeQuery("SELECT id FROM tb_amigos WHERE nome = '" + nome + "' OR telefone = '" + telefone + "' LIMIT 1;");
            if(searchComum.next()){
                throw new IllegalArgumentException("Já existe um amigo com esse nome ou telefone!");
            }

            ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_amigos (nome, telefone) VALUES ('" + nome + "', '" + telefone + "');");
            while(result.next()){
                FriendModel friend = new FriendModel(result.getInt(1), nome, address, telefone);
                DBQuery.insertOrUpdateQuery("INSERT INTO tb_enderecos (amigo_id, numero, rua, bairro, cidade, uf, complemento, cep) VALUES ('" + friend.getId()+ "', '" +
                address.getNumber() + "', '" +
                address.getStreet() + "', '" +
                address.getDistrict() + "', '" +
                address.getCity() + "', '" +
                address.getState() + "', '" +
                address.getComplemento() + "', '" +
                address.getCEP() + "');");

                return friend;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
    }

    public void removeFriend(FriendModel e){
        try{
            DBQuery.insertOrUpdateQuery("DELETE FROM tb_amigos WHERE id = '" + e.getId() + "';");
            DBQuery.insertOrUpdateQuery("DELETE FROM tb_enderecos WHERE amigo_id = '" + e.getId() + "';");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ArrayList<FriendModel> getFriends(){
        ArrayList<FriendModel> friends = new ArrayList<>(); 
         try{
         ResultSet result = DBQuery.executeQuery("SELECT tb_amigos.id, tb_amigos.nome, tb_amigos.telefone, tb_enderecos.numero, tb_enderecos.rua, tb_enderecos.bairro, tb_enderecos.cidade, tb_enderecos.uf, tb_enderecos.complemento, tb_enderecos.cep FROM tb_amigos JOIN tb_enderecos ON tb_amigos.id = tb_enderecos.amigo_id;");
 
            while(result.next()){
                AddressResource address = new AddressResource(result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
                FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome"), address, result.getLong("telefone") + "");
                friends.add(friend);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return friends;
    }

    public FriendModel getFriend(int id){
        try{
            ResultSet result = DBQuery.executeQuery("SELECT tb_amigos.id, tb_amigos.nome, tb_amigos.telefone, tb_enderecos.numero, tb_enderecos.rua, tb_enderecos.bairro, tb_enderecos.cidade, tb_enderecos.uf, tb_enderecos.complemento, tb_enderecos.cep FROM tb_amigos JOIN tb_enderecos ON tb_amigos.id = tb_enderecos.amigo_id WHERE tb_amigos.id = '" + id +"';");

            while(result.next()){
                AddressResource address = new AddressResource(result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
                FriendModel friend = new FriendModel(result.getInt("id"), result.getString("nome"), address, result.getLong("telefone") + "");
                return friend;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public void updateFriend(Integer id, FriendModel reference){
        try{
            DBQuery.insertOrUpdateQuery("UPDATE tb_amigos SET nome = '" + reference.getName() + "', telefone = '" + reference.getPhone() + "' WHERE id = '" + id + "';");
            DBQuery.insertOrUpdateQuery("UPDATE tb_enderecos SET numero = '" + reference.getAddress().getNumber() + "', rua = '" + reference.getAddress().getStreet() + "', bairro = '" + reference.getAddress().getDistrict() + "', cidade = '" + reference.getAddress().getCity() + "', uf = '" + reference.getAddress().getState() + "', complemento = '" + reference.getAddress().getComplemento() + "', cep = '" + reference.getAddress().getCEP() + "' WHERE amigo_id = '" + id + "';");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<Object[]> loadFriendsTabela(){
        ArrayList<Object[]> datasObject = new ArrayList<>(); 
         try{
         ResultSet result = DBQuery.executeQuery("SELECT tb_amigos.id, tb_amigos.nome, tb_amigos.telefone, tb_enderecos.numero, tb_enderecos.rua, tb_enderecos.bairro, tb_enderecos.cidade, tb_enderecos.uf, tb_enderecos.complemento, tb_enderecos.cep, COUNT(tb_emprestimos.id) AS quantidade_emprestimos, SUM(CASE WHEN tb_emprestimos.endDate < CURDATE() AND tb_emprestimos.finalizado = 0 THEN 1 ELSE 0 END) AS quantidade_emprestimos_atrasados FROM tb_amigos JOIN tb_enderecos ON tb_amigos.id = tb_enderecos.amigo_id LEFT JOIN tb_emprestimos ON tb_amigos.id = tb_emprestimos.amigo_id GROUP BY tb_amigos.id, tb_amigos.nome, tb_amigos.telefone, tb_enderecos.numero, tb_enderecos.rua, tb_enderecos.bairro, tb_enderecos.cidade, tb_enderecos.uf, tb_enderecos.complemento, tb_enderecos.cep;");
            while(result.next()){
                AddressResource address = new AddressResource(result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), result.getInt("numero"), result.getString("complemento"), result.getInt("cep"));
                Object[] data = {result.getInt("id"), "-", result.getString("nome"), PhoneValidResource.formatPhoneNumber(result.getLong("telefone") + ""), address, result.getInt("quantidade_emprestimos"), result.getInt("quantidade_emprestimos_atrasados")};
                datasObject.add(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return datasObject;
    }
}
