package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Database.DBQuery;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;

public class LoansDAO {

    //Simulated database
    private final HashMap<LoanModel, FriendModel> loans = new HashMap<>();

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
    public LoanModel addLoan(Date startDate, Date endDate, double valorReceber, int friendId) throws IllegalArgumentException{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_emprestimos (startDate, endDate, finalizado, valor_receber, amigo_id) VALUES ('" + sdf.format(startDate) + "', '" + sdf.format(endDate) + "', '0', '" + valorReceber + "', '" + friendId +"');");
            while(result.next()){
                LoanModel loan = new LoanModel(result.getInt(1), startDate, endDate, false, valorReceber);
                return loan;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public void removeLoan(int id){
        try{
            DBQuery.insertOrUpdateQuery("DELETE FROM tb_emprestimos WHERE id = '" + id + "';");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public LoanModel getLoan(int id){
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, startDate, endDate, finalizado, valor_receber FROM tb_emprestimos WHERE id = '" + id + "';");

            while(result.next()){
                LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
                return loan;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public LoanModel getLoanByToolId(int id){
       try{
        ResultSet result = DBQuery.executeQuery("SELECT tb_emprestimos.id, tb_emprestimos.startDate, tb_emprestimos.endDate, tb_emprestimos.finalizado, tb_emprestimos.valor_receber FROM tb_ferramentas JOIN tb_emprestimos ON tb_ferramentas.emprestimo_id = tb_emprestimos.id WHERE tb_ferramentas.id = '" + id + "';");
 
            while(result.next()){
                LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
                return loan;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public FriendModel getFriendByLoanId(int id){
       try{
            ResultSet result = DBQuery.executeQuery("SELECT tb_emprestimos.amigo_id FROM tb_emprestimos WHERE tb_emprestimos.id = '" + id + "';");
    
            while(result.next()){
                return FriendsDAO.getInstance().getFriend(result.getInt("amigo_id"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<LoanModel> getAllLoans(){
        ArrayList<LoanModel> loans = new ArrayList<>();
        try{
            ResultSet result = DBQuery.executeQuery("SELECT id, startDate, endDate, finalizado, valor_receber FROM tb_emprestimos;");
   
            while(result.next()){
                LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("endDate"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
                loans.add(loan);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return loans;
    }
    
}
