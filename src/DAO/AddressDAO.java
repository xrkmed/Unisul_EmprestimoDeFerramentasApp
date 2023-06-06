package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Resources.AddressResource;

public class AddressDAO {

    //Singleton class
    private static AddressDAO instance;

    private AddressDAO() {
    }

    public static AddressDAO getInstance() {
        if (instance == null) {
            instance = new AddressDAO();
        }
        return instance;
    }

    //Methods

    public AddressResource getAddress(int cep) throws SQLException, DatabaseResultQueryException {
        ResultSet result = DBQuery.executeQuery("SELECT E.id, IFNULL(E.endereco, 'Sem endereco') as endereco, E.cep, IFNULL(B.bairro, 'Sem bairro') as bairro, IFNULL(CID.cidade, 'Sem cidade') as cidade, IFNULL(UF.uf, 'SC') as uf FROM enderecos E LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = B.cidade_id LEFT JOIN endereco_uf UF ON UF.id = CID.uf_id WHERE E.cep = ? GROUP BY E.id;", cep);
        while(result.next()){
            AddressResource _res = new AddressResource(result.getInt("id"), result.getString("endereco"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), null, null, result.getInt("cep"));
            return _res;
        }

        return null;
    }

    public int updateAddress(int endId, AddressResource newAddress) throws DatabaseResultQueryException, SQLException{
        boolean enderecoUsado = getAmigosUsaEndereco(endId) > 1;
        if(enderecoUsado){
            ResultSet _res = insertAddress(newAddress);
            if(_res.next()){
                return _res.getInt(1);
            }

            throw new IllegalArgumentException("Erro ao inserir o endereço!");
        }

        AddressResource addressAlreadyExists = getAddress(newAddress.getCEP());
        if(addressAlreadyExists != null){
            return addressAlreadyExists.getId();
        }

        int ufId = getUF(newAddress.getState());
        int cityId = getCity(newAddress.getCity(), ufId);
        int districtId = getDistrict(newAddress.getDistrict(), cityId);
        DBQuery.insertOrUpdateQuery("UPDATE enderecos SET endereco = ?, bairro_id = ?, cep = ? WHERE id = ?", newAddress.getStreet(), districtId, newAddress.getCEP(), endId);

        return endId;
    }

    public ResultSet insertAddress(AddressResource _add) throws DatabaseResultQueryException, SQLException {
        int ufId = getUF(_add.getState());
        int cityId = getCity(_add.getCity(), ufId);
        int districtId = getDistrict(_add.getDistrict(), cityId);
        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO enderecos (endereco, bairro_id, cep) VALUES (?, ?, ?)", _add.getStreet(), districtId, _add.getCEP());
        return _res;
    }

    private int getUF(String UF) throws DatabaseResultQueryException, SQLException{
        ResultSet _result = DBQuery.executeQuery("SELECT id FROM endereco_uf WHERE uf = ?", UF);
        if(_result.next()){
            return _result.getInt(1);
        }

        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO endereco_uf (uf) VALUES (?)", UF);
        if(_res.next()){
            return _res.getInt(1);
        }

        return -1;
    }

    private int getCity(String city, int ufId) throws DatabaseResultQueryException, SQLException{
        ResultSet _result = DBQuery.executeQuery("SELECT id FROM endereco_cidade WHERE cidade = ? AND uf_id = ?", city, ufId);
        if(_result.next()){
            return _result.getInt(1);
        }

        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO endereco_cidade (cidade, uf_id) VALUES (?, ?)", city, ufId);
        if(_res.next()){
            return _res.getInt(1);
        }

        return -1;
    }

    private int getDistrict(String district, int cityId) throws DatabaseResultQueryException, SQLException{
        ResultSet _result = DBQuery.executeQuery("SELECT id FROM endereco_bairro WHERE bairro = ? AND cidade_id = ?", district, cityId);
        if(_result.next()){
            return _result.getInt(1);
        }

        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO endereco_bairro (bairro, cidade_id) VALUES (?, ?)", district, cityId);
        if(_res.next()){
            return _res.getInt(1);
        }

        return -1;
    }

    
    private int getAmigosUsaEndereco(int id){
        try {
            ResultSet _res = DBQuery.executeQuery("SELECT COUNT(*) FROM tb_amigos WHERE endereco_id = ?", id);
            if(_res.next()){
                return _res.getInt(1);
            }
        } catch (DatabaseResultQueryException | SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
}
