package DAO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Database.DBQuery;
import Exceptions.DatabaseResultQueryException;
import Model.FriendModel;
import Model.LoanModel;
import Model.ToolModel;
import Resources.BRLFormat;
import Model.ToolboxModel;

public class LoansDAO {

    //Singleton class
    private static LoansDAO instance;

    private LoansDAO() {
    }

    public static LoansDAO getInstance() {
        if (instance == null) {
            instance = new LoansDAO();
        }
        return instance;
    }

    //Methods
    public LoanModel addLoan(Date startDate, Date endDate, double valorReceber, int friendId) throws IllegalArgumentException, DatabaseResultQueryException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet result = DBQuery.insertOrUpdateQuery("INSERT INTO tb_emprestimos (startDate, previsaoDataEntrega, valorEmprestimo, amigo_id) VALUES (?, ?, ?, ?);", sdf.format(startDate), sdf.format(endDate), valorReceber, friendId);
        while (result.next()) {
            LoanModel loan = new LoanModel(result.getInt(1), startDate, endDate, false, valorReceber);
            return loan;
        }
        return null;
    }

    public void removeLoan(int id) throws DatabaseResultQueryException {
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_ferramentas_emprestimo WHERE emprestimo_id = ?;", id);
        DBQuery.insertOrUpdateQuery("DELETE FROM tb_emprestimos WHERE id = ?;", id);
    }

    public LoanModel getLoan(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT id, startDate, previsaoDataEntrega, dataFinalizado IS NOT NULL AS finalizado, valorEmprestimo FROM tb_emprestimos WHERE id = ?;", id);

        while (result.next()) {
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("previsaoDataEntrega"), result.getBoolean("finalizado"), result.getDouble("valorEmprestimo"));
            return loan;
        }
        return null;
    }

    public LoanModel getLoanByToolId(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT emp.id, emp.amigo_id, emp.startDate, emp.previsaoDataEntrega, emp.valorEmprestimo FROM tb_emprestimos AS emp LEFT JOIN tb_ferramentas_emprestimo AS fe ON emp.id = fe.emprestimo_id WHERE fe.ferramenta_id = ?;", id);

        while (result.next()) {
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("previsaoDataEntrega"), result.getBoolean("finalizado"), result.getDouble("valor_receber"));
            return loan;
        }
        return null;
    }

    public FriendModel getFriendByLoanId(int id) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT tb_emprestimos.amigo_id FROM tb_emprestimos WHERE tb_emprestimos.id = ?;", id);

        while (result.next()) {
            return FriendsDAO.getInstance().getFriend(result.getInt("amigo_id"));
        }
        return null;
    }

    public ArrayList<LoanModel> getAllLoans() throws DatabaseResultQueryException, SQLException {
        ArrayList<LoanModel> loans = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT id, startDate, previsaoDataEntrega, dataFinalizado IS NOT NULL AS finalizado, valorEmprestimo FROM tb_emprestimos;");

        while (result.next()) {
            LoanModel loan = new LoanModel(result.getInt("id"), result.getDate("startDate"), result.getDate("previsaoDataEntrega"), result.getBoolean("finalizado"), result.getDouble("valorEmprestimo"));
            loans.add(loan);
        }
        return loans;
    }

    public ArrayList<Object[]> getEmprestimosEmAberto() throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datas = new ArrayList<>();
        ResultSet result = DBQuery.executeQuery("SELECT e.id AS `id_emprestimo`, a.nome AS `nome_amigo`, e.startDate, e.previsaoDataEntrega AS `endDate`, DATEDIFF(e.previsaoDataEntrega, CURDATE()) AS `dias_restantes`, e.valorEmprestimo AS `valor_emprestimo`, COUNT(DISTINCT fe.ferramenta_id) AS `quantidade_ferramentas`, SUM(f.price) AS `soma_valor_ferramentas` FROM tb_emprestimos AS e LEFT JOIN tb_amigos AS a ON e.amigo_id = a.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON e.id = fe.emprestimo_id LEFT JOIN tb_ferramentas AS f ON fe.ferramenta_id = f.id WHERE e.dataFinalizado IS NULL GROUP BY e.id, a.nome, e.startDate, e.previsaoDataEntrega;");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (result.next()) {
            datas.add(new Object[]{result.getInt("id_emprestimo"), result.getString("nome_amigo").toUpperCase(), sdf.format(result.getDate("startDate")), sdf.format(result.getDate("endDate")), result.getInt("dias_restantes"), "R$ " + BRLFormat.PRICE_FORMATTER.format(result.getDouble("valor_emprestimo")), result.getInt("quantidade_ferramentas"), "R$ " + BRLFormat.PRICE_FORMATTER.format(result.getDouble("soma_valor_ferramentas"))});
        }
        return datas;
    }

    public ArrayList<Object[]> getEmprestimosEmAberto(String amigoNome) throws DatabaseResultQueryException, SQLException {
        ArrayList<Object[]> datas = new ArrayList<>();

        for (Object[] data : getEmprestimosEmAberto()) {
            if (data[1].equals(amigoNome)) {
                datas.add(data);
            }
        }
        return datas;
    }

    public void finalizarEmprestimo(LoanModel e, String observacoes) throws DatabaseResultQueryException, SQLException {
        DBQuery.insertOrUpdateQuery("UPDATE tb_emprestimos SET dataFinalizado = ?, observacoes = ? WHERE id = ?;", new Date(), observacoes, e.getId());
    }

    public ToolboxModel getTools(int loanId) throws DatabaseResultQueryException, SQLException {
        ResultSet result = DBQuery.executeQuery("SELECT ferr.id, ferr.name, ferr.price, FHF.fabricante_id FROM tb_ferramentas AS ferr LEFT JOIN ferramenta_has_fabricante FHF ON FHF.ferramenta_id = ferr.id LEFT JOIN tb_ferramentas_emprestimo AS fe ON ferr.id = fe.ferramenta_id; AND fe.emprestimo_id = ?;", loanId);
        ToolboxModel data = new ToolboxModel();
        while (result.next()) {
            ToolModel tool = new ToolModel(result.getInt("id"), result.getString("name"), ManufacturerDAO.getInstance().getManufacturer(result.getInt("fabricante_id")), result.getDouble("price"));
            data.addTool(tool);
        }

        return data;

    }

    public LoanModel updateLoan(LoanModel origin, Date startDate, Date endDate, double valorReceber, int friendId) throws DatabaseResultQueryException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet result = DBQuery.insertOrUpdateQuery("UPDATE tb_emprestimos SET startDate = ?, previsaoDataEntrega = ?, valorEmprestimo = ?, amigo_id = ? WHERE id = ?", sdf.format(startDate), sdf.format(endDate), valorReceber, friendId, origin.getId());
        while (result.next()) {
            origin = new LoanModel(origin.getId(), startDate, endDate, origin.getReturned(), valorReceber);
        }
        return origin;
    }

    public ArrayList<Object[]> relatorioEmprestimos() throws DatabaseResultQueryException, SQLException, IOException, ClassNotFoundException {
        ResultSet result = DBQuery.executeQuery("SELECT em.id AS emprestimo_id, em.dataFinalizado AS finalizadoData, em.observacoes, COUNT(fe.ferramenta_id) AS total_ferramentas, SUM(ferr.price) AS totalValorFerramentas, GROUP_CONCAT(ferr.name SEPARATOR ', ') AS ferramentas_emprestadas, em.valorEmprestimo AS valorRecebido, amigo.nome AS nome_amigo, em.startDate AS data_inicio, em.previsaoDataEntrega AS dataPrevisaoEntrega FROM tb_emprestimos AS em LEFT JOIN tb_ferramentas_emprestimo AS fe ON em.id = fe.emprestimo_id LEFT JOIN tb_ferramentas AS ferr ON fe.ferramenta_id = ferr.id LEFT JOIN tb_amigos AS amigo ON em.amigo_id = amigo.id GROUP BY em.id;");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Object[]> relatorio = new ArrayList<>();
        while (result.next()) {
            Object[] datas = new Object[]{result.getInt("emprestimo_id"), result.getString("nome_amigo").toUpperCase(), sdf.format(result.getDate("data_inicio")), sdf.format(result.getDate("dataPrevisaoEntrega")), sdf.format(result.getDate("finalizadoData")), result.getString("observacoes").toUpperCase(), result.getInt("total_ferramentas"), "R$ " + BRLFormat.PRICE_FORMATTER.format(result.getDouble("totalValorFerramentas")), "R$ " + BRLFormat.PRICE_FORMATTER.format(result.getDouble("valorRecebido")), result.getString("ferramentas_emprestadas").toUpperCase()};
            relatorio.add(datas);
        }

        return relatorio;
    }

}
