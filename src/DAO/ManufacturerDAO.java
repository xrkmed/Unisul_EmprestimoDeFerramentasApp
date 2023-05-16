package DAO;

import java.util.ArrayList;

import Resources.ManufacturerResource;

public class ManufacturerDAO {

    //Simulated database
    private final ArrayList<ManufacturerResource> manufacturers = new ArrayList<>();

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
    public void addManufacturer(ManufacturerResource e) throws IllegalArgumentException{
        if(e.getId() == null){
            e.setId(manufacturers.size() + 1);
        }

        if(getManufacturer(e.getId()) != null){
            throw new IllegalArgumentException("Manufacturer with id " + e.getId() + " already exists");
        }

        if(getManufacturer(e.getCNPJ()) != null){
            throw new IllegalArgumentException("Manufacturer with CNPJ " + e.getCNPJ() + " already exists");
        }

        this.manufacturers.add(e);
    }

    public void removeManufacturer(ManufacturerResource e){
        this.manufacturers.remove(e);
    }

    public void removeManufacturer(int id){
        this.manufacturers.remove(getManufacturer(id));
    }
    
    public ArrayList<ManufacturerResource> getManufacturers(){
        return new ArrayList<>(this.manufacturers);
    }

    public ManufacturerResource getManufacturer(int id){
        return manufacturers.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public ManufacturerResource getManufacturer(String cnpj){
        return manufacturers.stream().filter(e -> e.getCNPJ().equals(cnpj)).findFirst().orElse(null);
    }
}
