package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;
import Resources.BRLResource;
import Resources.ToolboxResource;

public class LoansDAO {
    //Singleton class
    private static LoansDAO instance;

    private LoansDAO(){

    }

    public static LoansDAO getInstance(){
        if(instance == null){
            instance = new LoansDAO();
        }
        return instance;
    }

    //Methods
    public LoanModel addLoan(Date startDate, Date endDate, double valorReceber, int friendId) throws IllegalArgumentException, DatabaseResultQueryException, SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_emprestimos (startDate, endDate, finalizado, valor_receber, amigo_id) VALUES (?, ?, ?, ?, ?);", sdf.format(startDate), sdf.format(endDate), false, valorReceber, friendId);
        while(result.next()){
            LoanModel loan = new LoanModel(result.getInt(1), startDate, endDate, false, valorReceber);
            return loan;
        }

        return null;
    }

    public void removeLoan(int id) throws DatabaseResultQueryException{
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_emprestimos WHERE id = ?;", id);
        DBQuery.insertOrUpdateQuery("UPDATE tb_ferramentas SET emprestimo_id = 0 WHERE emprestimo_id = ?", id);
    }

    public LoanModel getLoan(int id) throws DatabaseResultQueryException, SQLException{
        ResultSet result = DBQuery.executeQuery("SELECT id, startDate, endDate, finalizado, valor_receber FROM tb_emprestimos WHERE id = ?;", id);

        while(result.next()){
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
            return loan;
        }

        return null;
    }

    public LoanModel getLoanByToolId(int id) throws DatabaseResultQueryException, SQLException{
        ResultSet result = DBQuery.executeQuery("SELECT tb_emprestimos.id, tb_emprestimos.startDate, tb_emprestimos.endDate, tb_emprestimos.finalizado, tb_emprestimos.valor_receber FROM tb_ferramentas JOIN tb_emprestimos ON tb_ferramentas.emprestimo_id = tb_emprestimos.id WHERE tb_ferramentas.id = ?;", id);
 
        while(result.next()){
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
            return loan;
        }

        return null;
    }

    public FriendModel getFriendByLoanId(int id) throws DatabaseResultQueryException, SQLException{
        ResultSet result = DBQuery.executeQuery("SELECT tb_emprestimos.amigo_id FROM tb_emprestimos WHERE tb_emprestimos.id = ?;", id);

        while(result.next()){
            return FriendsDAO.getInstance().getFriend(result.getInt("amigo_id"));
        }

        return null;
    }

    public ArrayList<LoanModel> getAllLoans() throws DatabaseResultQueryException, SQLException{
        ArrayList<LoanModel> loans = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT id, startDate, endDate, finalizado, valor_receber FROM tb_emprestimos;");

        while(result.next()){
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
            loans.add(loan);
        }

        return loans;
    }

    public ArrayList<Object[]> getEmprestimosEmAberto() throws DatabaseResultQueryException, SQLException{
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT E.id AS id_emprestimo, A.nome AS nome_amigo, E.startDate, E.endDate, DATEDIFF(E.endDate, CURDATE()) AS dias_restantes, E.valor_receber AS valor_emprestimo, COALESCE(SUM(F.price), 0) AS soma_valor_ferramentas, COUNT(F.id) AS quantidade_ferramentas FROM tb_emprestimos E JOIN tb_amigos A ON E.amigo_id = A.id LEFT JOIN tb_ferramentas F ON E.id = F.emprestimo_id WHERE E.finalizado = 0 GROUP BY E.id, A.nome, E.startDate, E.endDate, E.valor_receber;");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(result.next()){
            datas.add(new Object[]{result.getInt("id_emprestimo"), result.getString("nome_amigo"), sdf.format(result.getDate("startDate")), sdf.format(result.getDate("endDate")), result.getInt("dias_restantes"), "R$ " + BRLResource.PRICE_FORMATTER.format(result.getDouble("valor_emprestimo")), result.getInt("quantidade_ferramentas"), "R$ " + BRLResource.PRICE_FORMATTER.format(result.getDouble("soma_valor_ferramentas"))});
        }

        return datas;
    }

    public void finalizarEmprestimo(int loanId, String observacoes) throws DatabaseResultQueryException{
        DBQuery.insertOrUpdateQuery("UPDATE tb_emprestimos SET finalizado = true WHERE id = ?;", loanId);
        DBQuery.insertOrUpdateQuery("INSERT INTO tb_emprestimos_historico (emprestimo_id, finalizadoData, observacoes) VALUES (?, ?, ?)", loanId, new Date(), observacoes);
    }

    public ToolboxResource getTools(int loanId) throws DatabaseResultQueryException, SQLException{
        ResultSet result = DBQuery.executeQuery("SELECT F.id, F.name, F.price, F.fabricante_id, F.emprestimo_id FROM tb_ferramentas F WHERE F.emprestimo_id = ?;", loanId);
        ToolboxResource data = new ToolboxResource();
        while(result.next()){
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name"), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"), loanId);
            data.addTool(tool);
        }

        return data;

    }

    public LoanModel updateLoan(LoanModel origin, Date startDate, Date endDate, double valorReceber, int friendId) throws DatabaseResultQueryException, SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet result = DBQuery.insertOrUpdateQuery("UPDATE tb_emprestimos SET startDate = ?, endDate = ?, finalizado = ?, valor_receber = ?, amigo_id = ? WHERE id = ?", sdf.format(startDate), sdf.format(endDate), origin.getReturned(), valorReceber, friendId, origin.getId());
        while(result.next()){
            origin = new LoanModel(origin.getId(), startDate, endDate, origin.getReturned(), valorReceber);
        }

        return origin;
    }
    
}
