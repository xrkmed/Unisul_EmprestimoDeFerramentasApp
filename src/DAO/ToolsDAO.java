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
        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_ferramentas (name, price) VALUES (?, ?);", nome.toUpperCase(), price);
        while (result.next()) {
            int ferramentaId = result.getInt(1);
            if(fabricanteId != -1){
                DBQuery.insertOrUpdateQuery("INSERT INTO ferramenta_has_fabricante (ferramenta_id, fabricante_id) VALUES (?, ?)", ferramentaId, fabricanteId);
            }

            ToolModel tool = new ToolModel(ferramentaId, nome.toUpperCase(), (fabricanteId != -1 ? ManufacturerDAO.getInstance().getManufacturer(fabricanteId) : null), price, 0);
            return tool;
        }

        return null;
    }

    public void removeTool(ToolModel e) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_ferramentas WHERE id = '" + e.getId() + "';");
    }

    public ArrayList<ToolModel> getTools() throws SQLException, DatabaseResultQueryException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(FHF.fabricante_id, -1) as fabricante_id, IFNULL(fe.emprestimo_id, 0) as emprestimo_id FROM tb_ferramentas AS f LEFT JOIN ferramenta_has_fabricante FHF ON FHF.ferramenta_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON f.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS e ON fe.emprestimo_id = e.id GROUP BY f.id, FHF.fabricante_id;");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ToolModel getTool(int id) throws SQLException, DatabaseResultQueryException {
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(FHF.fabricante_id, -1) as fabricante_id, IFNULL(fe.emprestimo_id, 0) as emprestimo_id FROM tb_ferramentas AS f LEFT JOIN ferramenta_has_fabricante FHF ON FHF.ferramenta_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON f.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS e ON fe.emprestimo_id = e.id WHERE f.id = ? GROUP BY f.id, FHF.fabricante_id;", id);
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
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, IFNULL(FHF.fabricante_id, -1) as fabricante_id, IFNULL(fe.emprestimo_id, 0) as emprestimo_id FROM tb_ferramentas AS f LEFT JOIN ferramenta_has_fabricante FHF ON FHF.ferramenta_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON f.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS e ON fe.emprestimo_id = e.id WHERE f.name = ? GROUP BY f.id, FHF.fabricante_id;", name);

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
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, fhf.fabricante_id, fe.emprestimo_id FROM tb_ferramentas AS f LEFT JOIN ferramenta_has_fabricante fhf ON fhf.ferramenta_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON f.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS e ON fe.emprestimo_id = e.id WHERE fhf.fabricante_id = ?;", manufacturerId);

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
            ferramentas.add(tool);
        }

        return ferramentas;
    }

    public ArrayList<ToolModel> getToolsWithoutManufacturer() throws DatabaseResultQueryException, SQLException {
        ArrayList<ToolModel> ferramentas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT f.id, f.name, f.price, -1 as fabricante_id, fe.emprestimo_id FROM tb_ferramentas AS f LEFT JOIN ferramenta_has_fabricante fhf ON fhf.ferramenta_id = f.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON f.id = fe.ferramenta_id LEFT JOIN tb_emprestimos AS e ON fe.emprestimo_id = e.id WHERE fhf.fabricante_id IS NULL;");

        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name").toUpperCase(), null, result.getDouble("price"), result.getInt("emprestimo_id"));
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
        DBQuery.insertOrUpdateQuery("DELETE FROM ferramenta_has_fabricante WHERE ferramenta_id = ?", id);

        if(manufacturerId != -1){
            DBQuery.insertOrUpdateQuery("INSERT INTO ferramenta_has_fabricante (ferramenta_id, fabricante_id) VALUES (?, ?)", id, manufacturerId);
        }
    }

    public void updateTool(Integer id, ToolModel reference) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET name = ?, price = ? WHERE id = ?;", reference.getNome(), reference.getPrice(), id);
        DBQuery.insertOrUpdateQuery("DELETE FROM ferramenta_has_fabricante WHERE ferramenta_id = ?", id);

        if(reference.getManufacturer() != null){
            DBQuery.insertOrUpdateQuery("INSERT INTO ferramenta_has_fabricante (ferramenta_id, fabricante_id) VALUES (?, ?)", id, reference.getManufacturer().getId());
        }
    }

    public ArrayList<Object[]> getFerramentasValue() throws DatabaseResultQueryException, SQLException, ParseException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT ferr.id AS id, ferr.name AS nome, IFNULL(fab.razao_social, 'Sem fabricante') AS nome_fabricante, ferr.price AS preco_ferramenta, IFNULL(IF(em.dataFinalizado IS NOT NULL, 'Disponivel', amigo.nome), 'Disponivel') AS nome_amigo, IF(em.dataFinalizado IS NULL, IFNULL(em.previsaoDataEntrega, 'Disponivel'), 'Disponivel') AS dataPrevisaoDevolucao FROM tb_ferramentas AS ferr LEFT JOIN ferramenta_has_fabricante fhf ON fhf.ferramenta_id = ferr.id LEFT JOIN tb_fabricantes AS fab ON fhf.fabricante_id = fab.id LEFT JOIN ( SELECT fe.ferramenta_id, MAX(fe.emprestimo_id) AS max_emprestimo_id FROM tb_ferramentas_emprestimo AS fe GROUP BY fe.ferramenta_id ) AS max_fe ON ferr.id = max_fe.ferramenta_id LEFT JOIN tb_emprestimos AS em ON max_fe.max_emprestimo_id = em.id LEFT JOIN tb_amigos AS amigo ON em.amigo_id = amigo.id WHERE em.dataFinalizado IS NULL OR em.id IS NULL;");
        while (result.next()) {
            String date = !result.getString("dataPrevisaoDevolucao").equals("Disponivel") ? DateResource.convertDatabaseData(result.getString("dataPrevisaoDevolucao")) : "Disponivel";
            datas.add(new Object[]{result.getInt("id"), result.getString("nome").toUpperCase(), result.getString("nome_fabricante").toUpperCase(), BRLResource.PRICE_FORMATTER.format(result.getDouble("preco_ferramenta")), result.getString("nome_amigo").toUpperCase(), date});
        }

        return datas;
    }
}
