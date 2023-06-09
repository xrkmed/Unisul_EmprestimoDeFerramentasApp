package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Resources.BRLFormat;
import Resources.CNPJResource;
import Model.ManufacturerModel;

public class ManufacturerDAO {

    //Singleton class
    private static ManufacturerDAO instance;

    private ManufacturerDAO() {
    }

    public static ManufacturerDAO getInstance() {
        if (instance == null) {
            instance = new ManufacturerDAO();
        }
        return instance;
    }

    //Methods
    public ManufacturerModel addManufacturer(String razaoSocial, String CNPJ) throws IllegalArgumentException, SQLException, DatabaseResultQueryException {
        if (!CNPJ.equals("00000000000000") && !CNPJResource.validarCNPJ(CNPJ)) {
            throw new IllegalArgumentException("Invalid CNPJ");
        }

        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_fabricantes (razao_social, cnpj) VALUES (?, ?);", razaoSocial.toUpperCase(), CNPJ + "");
        while (result.next()) {
            ManufacturerModel manufacturer = new ManufacturerModel(result.getInt(1), razaoSocial.toUpperCase(), CNPJ + "");
            return manufacturer;
        }
        return null;
    }

    public void removeManufacturer(ManufacturerModel e) throws DatabaseResultQueryException {
        getInstance().removeManufacturer(e.getId());
    }

    public void removeManufacturer(int id) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_fabricantes WHERE id = ?;", id);
    }

    public ArrayList<ManufacturerModel> getManufacturers() throws SQLException, DatabaseResultQueryException {
        ArrayList<ManufacturerModel> fabricantes = new ArrayList<>();
        ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes;");

        while (manufacturers.next()) {
            ManufacturerModel manufacturer = new ManufacturerModel(manufacturers.getInt("id"), manufacturers.getString("razao_social").toUpperCase(), manufacturers.getLong("cnpj") + "");
            fabricantes.add(manufacturer);
        }
        return fabricantes;
    }

    public ManufacturerModel getManufacturer(int id) throws SQLException, DatabaseResultQueryException {
        ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE id = ? LIMIT 1;", id);

        while (manufacturers.next()) {
            ManufacturerModel manufacturer = new ManufacturerModel(manufacturers.getInt("id"), manufacturers.getString("razao_social"), manufacturers.getLong("cnpj") + "");
            return manufacturer;
        }

        return null;
    }

    public void updateManufacturer(ManufacturerModel origin, ManufacturerModel updated) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_fabricantes SET razao_social = ?, cnpj = ? WHERE id = ?", updated.getName().toUpperCase(), CNPJResource.returnCNPJUnformat(updated.getCNPJ()), origin.getId());
    }

    public ManufacturerModel getManufacturer(String cnpj) throws DatabaseResultQueryException, SQLException {
        if (CNPJResource.validarCNPJ(cnpj)) {
            ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE cnpj = ? LIMIT 1;", cnpj);

            while (manufacturers.next()) {
                ManufacturerModel manufacturer = new ManufacturerModel(manufacturers.getInt("id"), manufacturers.getString("razao_social").toUpperCase(), manufacturers.getLong("cnpj") + "");
                return manufacturer;
            }
        }

        return null;
    }

    public ManufacturerModel getManufacturerByNome(String nomeFantasia) throws DatabaseResultQueryException, SQLException {
        ResultSet manufacturers = DBQuery.executeQuery("SELECT id, razao_social, cnpj FROM tb_fabricantes WHERE razao_social = ? LIMIT 1;", nomeFantasia.toUpperCase());

        while (manufacturers.next()) {
            ManufacturerModel manufacturer = new ManufacturerModel(manufacturers.getInt("id"), manufacturers.getString("razao_social").toUpperCase(), manufacturers.getLong("cnpj") + "");
            return manufacturer;
        }

        return null;
    }

    public ArrayList<Object[]> getFabricantesData() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id AS id, f.razao_social AS nome, f.cnpj AS cnpj, COUNT(DISTINCT ferr.id) AS `quantidade_ferramentas`, COUNT(DISTINCT CASE WHEN em.dataFinalizado IS NULL THEN fe.ferramenta_id END) AS `em_uso`, SUM(ferr.price) AS `valor_total_ferramentas` FROM tb_fabricantes AS f LEFT JOIN tb_ferramentas AS ferr ON ferr.fabricante_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON ferr.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS em ON fe.emprestimo_id = em.id AND em.dataFinalizado IS NULL GROUP BY f.id, f.razao_social, f.cnpj;");
        while (result.next()) {
            datas.add(new Object[]{result.getInt("id"), result.getString("nome").toUpperCase(), CNPJResource.returnCNPJFormat(result.getString("cnpj")), result.getInt("quantidade_ferramentas"), result.getInt("em_uso"), "R$ " + BRLFormat.PRICE_FORMATTER.format(result.getLong("valor_total_ferramentas"))});
        }

        return datas;
    }
}
