package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exceptions.DatabaseResultQueryException;

public class DBQuery {

    public static ResultSet executeQuery(String query) throws DatabaseResultQueryException{
        try{
            final Statement statement = Database.getInstance().getConnection().createStatement();

            return statement.executeQuery(query);
        }catch(SQLException e){
            throw new DatabaseResultQueryException(e.getMessage());
        }
    }

    public static ResultSet insertOrUpdateQuery(String query) throws DatabaseResultQueryException{
        try{
            final PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
