package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        ResultSet result = DBQuery.executeQuery("SELECT * FROM tb_enderecos WHERE cep = ?", cep);
        while(result.next()){
            AddressResource _res = new AddressResource(result.getInt("id"), result.getString("rua"), result.getString("bairro"), result.getString("cidade"), result.getString("uf"), null, null, result.getInt("cep"));
            return _res;
        }

        return null;
    }

    public ResultSet insertAddress(AddressResource _add) throws DatabaseResultQueryException {
        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO tb_enderecos (rua, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?)", _add.getStreet(), _add.getDistrict(), _add.getCity(), _add.getState(), _add.getCEP());
        return _res;
    }
    
}
