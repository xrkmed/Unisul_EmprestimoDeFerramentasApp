package DAO;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void addLoan(LoanModel e, FriendModel x) throws IllegalArgumentException{
        if(getLoan(e.getId()) != null){
            throw new IllegalArgumentException("Loan with id " + e.getId() + " already exists");
        }
        
        this.loans.put(e, x);
    }

    public void removeLoan(LoanModel e){
        this.loans.remove(e);
    }

    public LoanModel getLoan(int id){
        return loans.keySet().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public LoanModel getLoanByToolId(int id){
        return loans.keySet().stream().filter(e -> e.containsTool(id)).findFirst().orElse(null);
    }

    public FriendModel getFriendByLoanId(int id){
        return loans.get(getLoan(id));
    }

    public ArrayList<LoanModel> getLoans(){
        return new ArrayList<>(loans.keySet());
    }
    
}
