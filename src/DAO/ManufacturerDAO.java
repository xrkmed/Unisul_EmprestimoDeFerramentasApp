package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.DBQuery;
import Database.DBTreatment;
import Database.Database;
import Exceptions.DatabaseResultQueryException;
import Resources.CNPJResource;
import Resources.ManufacturerResource;

public class ManufacturerDAO {

    //Singleton class
    private static ManufacturerDAO instance;

    private ManufacturerDAO(){

    }

    public static ManufacturerDAO getInstance(){
        if(instance == null){
            instance = new ManufacturerDAO();
        }
        return instance;
    }
    
    //methods
    public ManufacturerResource addManufacturer(String razaoSocial, String CNPJ) throws IllegalArgumentException, SQLException, DatabaseResultQueryException{
        if(!CNPJResource.validarCNPJ(CNPJ)){
            throw new IllegalArgumentException("Invalid CNPJ");
        }

        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_fabricantes (razao_social, cnpj) VALUES (?, ?);", razaoSocial.toUpperCase(), CNPJ + "");
        while(result.next()){
            ManufacturerResource manufacturer = new ManufacturerResource(result.getInt(1), razaoSocial.toUpperCase(), CNPJ + "");
            return manufacturer;
        }

        return null;
    }

    public void removeManufacturer(ManufacturerResource e) throws DatabaseResultQueryException{
        getInstance().removeManufacturer(e.getId());
    }

    public void removeManufacturer(int id) throws DatabaseResultQueryException{
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_fabricantes WHERE id = ?;", id);
    }
    
    public ArrayList<ManufacturerResource> getManufacturers() throws SQLException, DatabaseResultQueryException{
        ArrayList<ManufacturerResource> fabricantes = new ArrayList<>(); 
        ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes;");

        while(manufacturers.next()){
            ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
            fabricantes.add(manufacturer);
        }

        return fabricantes;
    }

    public ManufacturerResource getManufacturer(int id) throws SQLException, DatabaseResultQueryException{
        ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE id = ? LIMIT 1;", id);

        while(manufacturers.next()){
            ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
            return manufacturer;
        }

        return null;
    }

    public ManufacturerResource getManufacturer(String cnpj) throws DatabaseResultQueryException, SQLException{
        if(CNPJResource.validarCNPJ(cnpj)){
            ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE cnpj = ? LIMIT 1;", cnpj);

            while(manufacturers.next()){
                ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
                return manufacturer;
            }
        }

        return null;
    }
}
