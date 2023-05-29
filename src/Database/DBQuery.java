package Database;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Exceptions.DatabaseResultQueryException;

public class DBQuery {

    public static ResultSet executeQuery(String query, Object... params) throws DatabaseResultQueryException {
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

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

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
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
