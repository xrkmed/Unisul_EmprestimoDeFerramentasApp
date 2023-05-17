package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.DBQuery;
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
    public ManufacturerResource addManufacturer(String razaoSocial, String CNPJ) throws IllegalArgumentException{
        if(!CNPJResource.validarCNPJ(CNPJ)){
            throw new IllegalArgumentException("Invalid CNPJ");
        }

        try{
            ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_fabricantes (razao_social, cnpj) VALUES ('" + razaoSocial.toUpperCase() + "', '" + CNPJ + "');");
            while(result.next()){
                ManufacturerResource manufacturer = new ManufacturerResource(result.getInt(1), razaoSocial.toUpperCase(), CNPJ + "");
                return manufacturer;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
    }

    public void removeManufacturer(ManufacturerResource e){
        getInstance().removeManufacturer(e.getId());
    }

    public void removeManufacturer(int id){
        try{
            DBQuery.insertOrUpdateQuery("DELETE FROM tb_fabricantes WHERE id = '" + id + "';");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<ManufacturerResource> getManufacturers(){
        ArrayList<ManufacturerResource> fabricantes = new ArrayList<>(); 
        try{
            ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes;");

            while(manufacturers.next()){
                ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
                fabricantes.add(manufacturer);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return fabricantes;
    }

    public ManufacturerResource getManufacturer(int id){
        try{
            ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE id = '" + id + "' LIMIT 1;");
 
            while(manufacturers.next()){
                ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
                return manufacturer;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public ManufacturerResource getManufacturer(String cnpj){
        if(CNPJResource.validarCNPJ(cnpj)){
            try{
                ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE cnpj = '" + cnpj + "' LIMIT 1;");

                while(manufacturers.next()){
                    ManufacturerResource manufacturer = new ManufacturerResource(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
                    return manufacturer;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        return null;
    }
}
