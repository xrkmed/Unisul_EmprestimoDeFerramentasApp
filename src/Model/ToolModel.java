package Model;

import DAO.LoansDAO;
import Resources.ManufacturerResource;
import java.util.Objects;

public class ToolModel {

    private Integer id;
    private ManufacturerResource manufacturer;
    private double price;
    private String nome;

    public ToolModel(){

    }

    public ToolModel(String nome, ManufacturerResource manufacturer, double price){
        this.nome = nome;
        this.manufacturer = manufacturer;
        this.setPrice(price);
    }

    public ToolModel(Integer id, String nome, ManufacturerResource manufacturer, double price){
        this.id = id;
        this.nome = nome;
        this.manufacturer = manufacturer;
        this.setPrice(price);
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(int id){
        if(this.id == null){
            this.id = id;
        }
    }

    public ManufacturerResource getManufacturer(){
        return this.manufacturer;
    }

    public void updateManufacturer(ManufacturerResource manufacturer){
        this.manufacturer = manufacturer;
    }

    public double getPrice(){
        return this.price;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String newName){
        this.nome = newName;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public LoanModel getLoan(){
        return LoansDAO.getInstance().getLoanByToolId(id);
    }

    public boolean isAvailable(){
        return getLoan() == null;
    }

    @Override
    public String toString() {
        return "ToolModel{" + "id=" + id + ", manufacturer=" + manufacturer + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToolModel other = (ToolModel) obj;
        return Objects.equals(this.id, other.id);
    }

    
}
