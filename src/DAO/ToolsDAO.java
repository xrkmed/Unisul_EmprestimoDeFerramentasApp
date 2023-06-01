package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.ToolModel;
import Resources.BRLResource;
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
        String query = "INSERT INTO tb_ferramentas (name, price, fabricante_id) VALUES (?, ?, ?);";

        if (fabricanteId == -1) {
            query = "INSERT INTO tb_ferramentas (name, price) VALUES (?, ?);";
        }

        ResultSet result = DBQuery.insertOrUpdateQuery(query, nome.toUpperCase(), price, (fabricanteId != -1 ? fabricanteId : null));
        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt(1), nome.toUpperCase(), (fabricanteId != -1 ? ManufacturerDAO.getInstance().getManufacturer(fabricanteId) : null), price, 0);
            return tool;
        }

        return null;
    }

    public void removeTool(ToolModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_ferramentas WHERE id = '" + e.getId() + "';");
    }

    public ArrayList<ToolModel> getTools() throws SQLException, DatabaseResultQueryException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas;");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ToolModel getTool(int id) throws SQLException, DatabaseResultQueryException {
        ResultSet result = DBQuery.executeQuery("SELECT id, name, fabricante_id, price, emprestimo_id FROM tb_ferramentas WHERE id = '" + id + "' LIMIT 1;");
        ToolModel tool = null;
        Integer toolId = 0, toolManufacturerId = 0, toolLoanId = 0;
        String toolName = "";
        Double toolPrice = 0.;
        while (result.next()) {
            toolId = result.getInt("id");
            toolName = result.getString("name").toUpperCase();
            toolManufacturerId = result.getInt("fabricante_id");
            toolPrice = result.getDouble("price");
            toolLoanId = result.getInt("emprestimo_id");
        }

        tool = new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice, toolLoanId);
        return tool;
    }

    public ToolModel getTool(String name) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE name = '" + name.toUpperCase() + "' LIMIT 1;");

        ToolModel tool = null;
        Integer toolId = 0, toolManufacturerId = 0, toolLoanId = 0;
        String toolName = "";
        Double toolPrice = 0.;
        while (result.next()) {
            toolId = result.getInt("id");
            toolName = result.getString("name").toUpperCase();
            toolManufacturerId = result.getInt("fabricante_id");
            toolPrice = result.getDouble("price");
            toolLoanId = result.getInt("emprestimo_id");
        }

        tool = new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice, toolLoanId);
        return tool;
    }

    public ArrayList<ToolModel> getToolsByManufacturer(int manufacturerId) throws DatabaseResultQueryException, SQLException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE fabricante_id = '" + manufacturerId + "';");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ArrayList<ToolModel> getToolsWithoutManufacturer() throws DatabaseResultQueryException, SQLException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE IFNULL(fabricante_id, 'Sem Fabricante') = 'Sem Fabricante';");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), null, result.getDouble("price"), result.getInt("emprestimo_id"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public void addToolToLoan(int toolId, int loanId) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET emprestimo_id = '" + loanId + "' WHERE id = '" + toolId + "';");
    }

    public void removeToolFromLoan(int toolId) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET emprestimo_id = NULL WHERE id = '" + toolId + "';");
    }

    public void updateManufacturer(int id, int manufacturerId) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET fabricante_id = " + (manufacturerId == -1 ? null : "'" + manufacturerId + "'") + " WHERE id = '" + id + "';");
    }

    public void updateTool(Integer id, ToolModel reference) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET name = ?, price = ?, fabricante_id = ? WHERE id = ?;", reference.getNome(), reference.getPrice(), (reference.getManufacturer() != null ? reference.getManufacturer().getId() : null), id);
    }

    public ArrayList<Object[]> getFerramentasValue() throws DatabaseResultQueryException, SQLException, ParseException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT tb_ferramentas.id AS id_ferramenta, tb_ferramentas.name AS nome_ferramenta, IFNULL(tb_fabricantes.razao_social, 'Sem fabricante') AS nome_fabricante, tb_ferramentas.price AS preco_ferramenta, IFNULL(tb_amigos.nome, 'Disponivel') AS nome_amigo, IF(tb_ferramentas.emprestimo_id IS NOT NULL, tb_emprestimos.endDate, 'Disponivel') AS endDate FROM tb_ferramentas LEFT JOIN tb_fabricantes ON tb_ferramentas.fabricante_id = tb_fabricantes.id LEFT JOIN tb_emprestimos ON tb_ferramentas.emprestimo_id = tb_emprestimos.id LEFT JOIN tb_amigos ON tb_emprestimos.amigo_id = tb_amigos.id;");
        while (result.next()) {
            String date = !result.getString("endDate").equals("Disponivel") ? DateResource.convertDatabaseData(result.getString("endDate")) : "Disponivel";
            datas.add(new Object[]{result.getInt("id_ferramenta"), result.getString("nome_ferramenta").toUpperCase(), result.getString("nome_fabricante").toUpperCase(), BRLResource.PRICE_FORMATTER.format(result.getDouble("preco_ferramenta")), result.getString("nome_amigo").toUpperCase(), date});
       }

        return datas;
    }

    public ArrayList<Object[]> getRelatorioObjectTools() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT tb_ferramentas.id, tb_ferramentas.name, tb_ferramentas.price, SUM(CASE WHEN tb_emprestimos.id > 0 THEN 1 ELSE 0 END) as total_loans FROM tb_ferramentas LEFT JOIN tb_emprestimos ON tb_ferramentas.emprestimo_id = tb_emprestimos.id GROUP BY tb_ferramentas.id, tb_ferramentas.name, tb_ferramentas.price, tb_emprestimos.id;");
        while (result.next()) {
            datas.add(new Object[]{result.getInt("id"), result.getString("name").toUpperCase(), "R$ " + BRLResource.PRICE_FORMATTER.format(result.getDouble("price")), result.getInt("total_loans")});
        }

        return datas;
    }
}
