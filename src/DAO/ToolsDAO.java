package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.ToolModel;
import Resources.BRLFormat;
import Resources.DateResource;

public class ToolsDAO {

    //Singleton Class
    private static ToolsDAO instance;

    private ToolsDAO() {
    }

    public static ToolsDAO getInstance() {
        if (instance == null) {
            instance = new ToolsDAO();
        }
        return instance;
    }

    //Methods
    public ToolModel addTool(String nome, double price, int fabricanteId) throws IllegalArgumentException, DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_ferramentas (name, price, fabricante_id) VALUES (?, ?, ?);", nome.toUpperCase(), price, fabricanteId != -1 ? fabricanteId : null);
        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt(1), nome.toUpperCase(), (fabricanteId != -1 ? ManufacturerDAO.getInstance().getManufacturer(fabricanteId) : null), price);
            return tool;
        }

        return null;
    }

    public void removeTool(ToolModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_ferramentas WHERE id = '" + e.getId() + "';");
    }

    public ArrayList<ToolModel> getTools() throws SQLException, DatabaseResultQueryException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(f.fabricante_id, -1) as fabricante_id FROM tb_ferramentas AS f GROUP BY f.id;");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ToolModel getTool(int id) throws SQLException, DatabaseResultQueryException {
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(f.fabricante_id, -1) as fabricante_id FROM tb_ferramentas AS f WHERE f.id = ? GROUP BY f.id;", id);
        Integer toolId = 0, toolManufacturerId = 0;
        String toolName = "";
        Double toolPrice = 0.;
        while (result.next()) {
            toolId = result.getInt("id");
            toolName = result.getString("name").toUpperCase();
            toolManufacturerId = result.getInt("fabricante_id");
            toolPrice = result.getDouble("price");
        }

        return new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice);
    }

    public ToolModel getTool(String name) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(f.fabricante_id, -1) as fabricante_id FROM tb_ferramentas AS f WHERE f.name = ? GROUP BY f.id;", name);

        Integer toolId = 0, toolManufacturerId = 0;
        String toolName = "";
        Double toolPrice = 0.;
        while (result.next()) {
            toolId = result.getInt("id");
            toolName = result.getString("name").toUpperCase();
            toolManufacturerId = result.getInt("fabricante_id");
            toolPrice = result.getDouble("price");
        }

        return new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice);
    }

    public ArrayList<ToolModel> getToolsByManufacturer(int manufacturerId) throws DatabaseResultQueryException, SQLException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, f.fabricante_id, fe.emprestimo_id FROM tb_ferramentas AS f WHERE f.fabricante_id = ?;", manufacturerId);

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ArrayList<ToolModel> getToolsWithoutManufacturer() throws DatabaseResultQueryException, SQLException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, -1 as fabricante_id, fe.emprestimo_id FROM tb_ferramentas AS f WHERE f.fabricante_id IS NULL;");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), null, result.getDouble("price"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public void addToolToLoan(int toolId, int loanId) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("INSERT INTO tb_ferramentas_emprestimo (emprestimo_id, ferramenta_id) VALUES (?, ?);", loanId, toolId);
    }

    public void removeToolFromLoan(int loanId, int toolId) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_ferramentas_emprestimo WHERE emprestimo_id = ? AND ferramenta_id = ?", loanId, toolId);
    }

    public void updateManufacturer(int id, int manufacturerId) throws DatabaseResultQueryException {
		DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET tb_ferramentas.fabricante_id = ? WHERE tb_ferramentas.id = ?", (manufacturerId != -1 ? manufacturerId : null), id);
    }

    public void updateTool(Integer id, ToolModel reference) throws DatabaseResultQueryException {
        int manufacturerId = (reference.getManufacturer() != null ? reference.getManufacturer().getId() : -1);
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET name = ?, price = ?, fabricante_id = ? WHERE id = ?;", reference.getNome(), reference.getPrice(), manufacturerId, id);
    }

    public ArrayList<Object[]> getFerramentasValue() throws DatabaseResultQueryException, SQLException, ParseException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT ferr.id AS id, ferr.name AS nome, IFNULL(fab.razao_social, 'Sem fabricante') AS nome_fabricante, ferr.price AS preco_ferramenta, IFNULL(IF(em.dataFinalizado IS NOT NULL, 'Disponivel', amigo.nome), 'Disponivel') AS nome_amigo, IF(em.dataFinalizado IS NULL, IFNULL(em.previsaoDataEntrega, 'Disponivel'), 'Disponivel') AS dataPrevisaoDevolucao FROM tb_ferramentas AS ferr LEFT JOIN tb_fabricantes AS fab ON ferr.fabricante_id = fab.id LEFT JOIN ( SELECT fe.ferramenta_id, MAX(fe.emprestimo_id) AS max_emprestimo_id FROM tb_ferramentas_emprestimo AS fe GROUP BY fe.ferramenta_id ) AS max_fe ON ferr.id = max_fe.ferramenta_id LEFT JOIN tb_emprestimos AS em ON max_fe.max_emprestimo_id = em.id LEFT JOIN tb_amigos AS amigo ON em.amigo_id = amigo.id WHERE em.dataFinalizado IS NULL OR em.id IS NULL;");
        while (result.next()) {
            String date = !result.getString("dataPrevisaoDevolucao").equals("Disponivel") ? DateResource.convertDatabaseData(result.getString("dataPrevisaoDevolucao")) : "Disponivel";
            datas.add(new Object[]{result.getInt("id"), result.getString("nome").toUpperCase(), result.getString("nome_fabricante").toUpperCase(), BRLFormat.PRICE_FORMATTER.format(result.getDouble("preco_ferramenta")), result.getString("nome_amigo").toUpperCase(), date});
        }

        return datas;
    }
}
