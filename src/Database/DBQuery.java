package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exceptions.DatabaseResultQueryException;

public class DBQuery {

    public static ResultSet executeQuery(String query, Object... params) throws DatabaseResultQueryException{
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

    public static ResultSet insertOrUpdateQuery(String query, Object... params) throws DatabaseResultQueryException{
        try{
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
                ResultSet result = statement.getGeneratedKeys();
                return result;
            }
        }catch(SQLException e){
            throw new DatabaseResultQueryException(e.getMessage());
        }

        return null;
    }
}
