package Model;

import java.sql.Date;

import DAO.LoansDAO;
import Resources.ToolboxResource;
import java.util.Objects;

public class LoanModel {

    private Integer id;
    private ToolboxResource tools;
    private Date startDate;
    private Date endDate;
    private boolean returned;

    public LoanModel(){
    }

    public LoanModel(Integer id, Date startDate, Date endDate, boolean returned){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returned = returned;
        tools = new ToolboxResource();
    }

    public Integer getId(){
        return this.id;
    }

    public FriendModel getFriend(){
        return LoansDAO.getInstance().getFriendByLoanId(id);
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public boolean getReturned(){
        return this.returned;
    }

    public void setReturned(boolean returned){
        this.returned = returned;
    }

    public boolean needsReturn(){
        return getEndDate().before(new Date(System.currentTimeMillis()));
    }

    public void addTool(ToolModel e){
        this.tools.addTool(e);
    }

    public void removeTool(ToolModel e){
        this.tools.removeTool(e);
    }

    public boolean containsTool(int id){
        return this.tools.containsTool(id);
    }

    @Override
    public String toString() {
        return "LoanModel{" + "id=" + id + ", tools=" + tools + ", startDate=" + startDate + ", endDate=" + endDate + ", returned=" + returned + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final LoanModel other = (LoanModel) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
}
