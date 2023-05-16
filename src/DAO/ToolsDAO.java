package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Database.DBQuery;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.DateResource;

public class ToolsDAO {

    //Singleton Class
    private static ToolsDAO instance;

    private ToolsDAO(){

    }

    public static ToolsDAO getInstance(){
        if(instance == null){
            instance = new ToolsDAO();
        }
        return instance;
    }

    //Methods

    public ToolModel addTool(String nome, double price, int fabricanteId) throws IllegalArgumentException{
        try{
            String query = "INSERT INTO tb_ferramentas (name, price, fabricante_id) VALUES ('" + nome.toUpperCase() + "', '" + price + "', '" + fabricanteId + "');";

            if(fabricanteId == -1){
                query = "INSERT INTO tb_ferramentas (name, price) VALUES ('" + nome.toUpperCase() + "', '" + price + "');";
            }

            ResultSet result = DBQuery.insertOrUpdateQuery(query);
            while(result.next()){
                 ToolModel tool = new ToolModel(result.getInt(1), nome.toUpperCase(), (fabricanteId != -1 ? ManufacturerDAO.getInstance().getManufacturer(fabricanteId) : null), price, 0);
                return tool;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
    }

    public void removeTool(ToolModel e){
        try{
            DBQuery.executeQuery("DELETE FROM tb_ferramentas WHERE id = '" + e.getId() + "';");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ArrayList<ToolModel> getTools(){
        ArrayList<ToolModel> ferramentas = new ArrayList<>(); 
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas;");
 
            while(result.next()){
                ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name"), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
                ferramentas.add(tool);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return ferramentas;
    }

    public ToolModel getTool(int id){
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, name, fabricante_id, price, emprestimo_id FROM tb_ferramentas WHERE id = '" + id + "' LIMIT 1;");
            ToolModel tool = null;
            Integer toolId = 0, toolManufacturerId = 0, toolLoanId = 0;
            String toolName = "";
            Double toolPrice = 0.;
            while(result.next()){
                toolId = result.getInt("id");
                toolName = result.getString("name");
                toolManufacturerId = result.getInt("fabricante_id");
                toolPrice = result.getDouble("price");
                toolLoanId = result.getInt("emprestimo_id");
            }

            tool = new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice, toolLoanId);
            return tool;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public ToolModel getTool(String name){
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE name = '" + name.toUpperCase() + "' LIMIT 1;");

            ToolModel tool = null;
            Integer toolId = 0, toolManufacturerId = 0, toolLoanId = 0;
            String toolName = "";
            Double toolPrice = 0.;
            while(result.next()){
                toolId = result.getInt("id");
                toolName = result.getString("name");
                toolManufacturerId = result.getInt("fabricante_id");
                toolPrice = result.getDouble("price");
                toolLoanId = result.getInt("emprestimo_id");
            }

            tool = new ToolModel(toolId, toolName, ManufacturerDAO.getInstance().getManufacturer(toolManufacturerId), toolPrice, toolLoanId);
            return tool;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    public ArrayList<ToolModel> getToolsByManufacturer(int manufacturerId){
        ArrayList<ToolModel> ferramentas = new ArrayList<>(); 
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE fabricante_id = '" + manufacturerId +"';");
 
            while(result.next()){
                ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name"), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), result.getInt("emprestimo_id"));
                ferramentas.add(tool);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return ferramentas;
    }

    public ArrayList<ToolModel> getToolsWithoutManufacturer(){
        ArrayList<ToolModel> ferramentas = new ArrayList<>(); 
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, name, price, fabricante_id, emprestimo_id FROM tb_ferramentas WHERE IFNULL(fabricante_id, 'Sem Fabricante') = 'Sem Fabricante';");
            
            while(result.next()){
                ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name"), null, result.getDouble("price"), result.getInt("emprestimo_id"));
                ferramentas.add(tool);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return ferramentas;
    }

    public void addToolToLoan(int toolId, int loanId){
        try{
            DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET emprestimo_id = '" + loanId + "' WHERE id = '" + toolId + "';");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateManufacturer(int id, int manufacturerId){
        try{
            DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET fabricante_id = " + (manufacturerId == -1 ? "NULL" : "'" + manufacturerId + "'" ) + " WHERE id = '" + id + "';");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateTool(Integer id, ToolModel reference){
        try{
            DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET name = '" + reference.getNome() + "', price = '" + reference.getPrice() + "', fabricante_id = " + (reference.getManufacturer() != null ? "'" + reference.getManufacturer().getId() + "'" : "NULL") + " WHERE id = '" + id + "';");
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<Object[]> getFerramentasValue(){
        try{
            ArrayList<Object[]> datas = new ArrayList<>();
            ResultSet result = DBQuery.executeQuery("SELECT tb_ferramentas.id AS id_ferramenta, tb_ferramentas.name AS nome_ferramenta, IFNULL(tb_fabricantes.razao_social, 'Sem fabricante') AS nome_fabricante, tb_ferramentas.price AS preco_ferramenta, IFNULL(tb_amigos.nome, 'Disponivel') AS nome_amigo, IF(tb_ferramentas.emprestimo_id IS NOT NULL, tb_emprestimos.endDate, 'Disponivel') AS endDate FROM tb_ferramentas LEFT JOIN tb_fabricantes ON tb_ferramentas.fabricante_id = tb_fabricantes.id LEFT JOIN tb_emprestimos ON tb_ferramentas.emprestimo_id = tb_emprestimos.id LEFT JOIN tb_amigos ON tb_emprestimos.amigo_id = tb_amigos.id;");
            while(result.next()){
                String date = !result.getString("endDate").equals("Disponivel") ? DateResource.convertDatabaseData(result.getString("endDate")) : "Disponivel";
                datas.add(new Object[]{result.getInt("id_ferramenta"), "-", result.getString("nome_ferramenta"), result.getString("nome_fabricante"), BRLResource.PRICE_FORMATTER.format(result.getDouble("preco_ferramenta")), result.getString("nome_amigo"), date});
            }

            return datas;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return null;
    }

    
}
