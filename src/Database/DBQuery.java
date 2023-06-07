package Database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Exceptions.DatabaseResultQueryException;
import Tests.Main;

public class DBQuery {

    public static void startTransaction() throws SQLException {
        Database.getInstance().getConnection().setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        Database.getInstance().getConnection().commit();
    }

    public static void rollbackTransaction() throws SQLException {
        Database.getInstance().getConnection().rollback();
    }

    public static void endTransaction() throws SQLException {
        Database.getInstance().getConnection().setAutoCommit(true);
    }

    public static ResultSet executeQuery(String query, Object... params) throws DatabaseResultQueryException {
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            System.out.println(statement.toString());

            return statement.executeQuery();
        } catch (SQLException e) {
            throw new DatabaseResultQueryException(e.getMessage());
        }
    }

    public static ResultSet insertOrUpdateQuery(String query, Object... params) throws DatabaseResultQueryException {
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            System.out.println(statement.toString());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                Main.tela.getTelaAtual().atualizarDados();
                ResultSet result = statement.getGeneratedKeys();
                return result;
            }
        } catch (SQLException e) {
            throw new DatabaseResultQueryException(e.getMessage());
        }

        return null;
    }

    public static byte[] prepareBlob(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }
}
