package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

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
        ResultSet result = DBQuery.executeQuery("SELECT E.id, IFNULL(E.endereco, 'Sem endereco') as endereco, E.cep, B.bairro, CID.cidade, UF.uf FROM enderecos E LEFT JOIN endereco_bairro B ON B.id = E.bairro_id LEFT JOIN endereco_cidade CID ON CID.id = E.cidade_id LEFT JOIN endereco_uf UF ON UF.id = E.uf_id WHERE E.cep = ? GROUP BY E.id, E.bairro_id, E.cidade_id, E.uf_id, E.cep;", cep);
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
            // mostrar um joptionpane para atualizar o cep
            int option = JOptionPane.showOptionDialog(null, "O endereço já existe no nosso banco de dados, deseja atualizar o cadastro no banco de dados?\n\nEndereco cadastrado: " + addressAlreadyExists, "Endereço já existe", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(option == JOptionPane.NO_OPTION){
                 throw new IllegalArgumentException("Endereço já existe no banco de dados!");
            }
        }

        int ufId = getUF(newAddress.getState());

        ResultSet _res = DBQuery.executeQuery("SELECT UF.id AS idUF, CID.id AS idCidade, B.id AS idBairro FROM endereco_uf UF LEFT JOIN endereco_cidade CID ON CID.cidade = ? LEFT JOIN endereco_bairro B ON B.bairro = ? WHERE UF.uf = ? GROUP BY UF.id, B.id, CID.id;", newAddress.getCity(), newAddress.getDistrict(), newAddress.getState());
        if(_res.next()){
            int cityId = _res.getObject("idCidade") == null ? cadastrarCidade(newAddress.getCity()) : _res.getInt("idCidade");
            int districtId = _res.getObject("idBairro") == null ? cadastrarBairro(newAddress.getDistrict()) : _res.getInt("idBairro");

            DBQuery.insertOrUpdateQuery("UPDATE enderecos SET endereco = ?, bairro_id = ?, cidade_id = ?, uf_id = ?, cep = ? WHERE id = ?", newAddress.getStreet(), districtId, cityId, ufId, newAddress.getCEP(), endId);
        }
        
        return endId;
    }

    public ResultSet insertAddress(AddressResource _add) throws DatabaseResultQueryException, SQLException {
        int ufId = getUF(_add.getState());
        ResultSet _res = DBQuery.executeQuery("SELECT UF.id AS idUF, CID.id AS idCidade, B.id AS idBairro FROM endereco_uf UF LEFT JOIN endereco_cidade CID ON CID.cidade = ? LEFT JOIN endereco_bairro B ON B.bairro = ? WHERE UF.uf = ? GROUP BY UF.id, B.id, CID.id;", _add.getCity(), _add.getDistrict(), _add.getState());
        if(_res.next()){
            int cityId = _res.getObject("idCidade") == null ? cadastrarCidade(_add.getCity()) : _res.getInt("idCidade");
            int districtId = _res.getObject("idBairro") == null ? cadastrarBairro(_add.getDistrict()) : _res.getInt("idBairro");
            ResultSet _return = DBQuery.insertOrUpdateQuery("INSERT INTO enderecos (endereco, bairro_id, cidade_id, uf_id, cep) VALUES (?, ?, ?, ?, ?)", _add.getStreet(), districtId, cityId, ufId, _add.getCEP());
            return _return;
        }

        return null;
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

    private int cadastrarCidade(String city) throws DatabaseResultQueryException, SQLException{
        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO endereco_cidade (cidade) VALUES (?)", city);
        if(_res.next()){
            return _res.getInt(1);
        }

        return -1;
    }

    private int cadastrarBairro(String district) throws DatabaseResultQueryException, SQLException{
        ResultSet _res = DBQuery.insertOrUpdateQuery("INSERT INTO endereco_bairro (bairro) VALUES (?)", district);
        if(_res.next()){
            return _res.getInt(1);
        }

        return -1;
    }

    
    private int getAmigosUsaEndereco(int id){
        try {
            ResultSet _res = DBQuery.executeQuery("SELECT COUNT(*) FROM amigo_has_endereco WHERE endereco_id = ?", id);
            if(_res.next()){
                return _res.getInt(1);
            }
        } catch (DatabaseResultQueryException | SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
}
