package Model;

import DAO.LoansDAO;
import Exceptions.DatabaseResultQueryException;
import java.sql.SQLException;
import java.util.Objects;

public class ToolModel {

    private Integer id;
    private ManufacturerModel manufacturer;
    private double price;
    private String nome;

    public ToolModel() {
    }

    public ToolModel(Integer id, String nome, ManufacturerModel manufacturer, double price) {
        this.id = id;
        this.nome = nome;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public ManufacturerModel getManufacturer() {
        return this.manufacturer;
    }

    public double getPrice() {
        return this.price;
    }

    public String getNome() {
        return this.nome;
    }

    public LoanModel getLoan() throws DatabaseResultQueryException, SQLException {
        return LoansDAO.getInstance().getLoanByToolId(id);
    }

    public boolean isAvailable() throws DatabaseResultQueryException, SQLException {
        return this.getLoan() == null;
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
