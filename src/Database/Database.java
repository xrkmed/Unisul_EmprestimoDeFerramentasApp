package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Controllers.EventScheduler;
import Exceptions.DatabaseCloseException;
import Exceptions.DatabaseConnectException;
import Exceptions.DatabaseNotConnectedException;
import Exceptions.PropertiesException;

public class Database {

    private Connection conn = null;

    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            instance.ping();
        }
        return instance;
    }

    public Connection getConnection(){
        try{
            if(conn == null || (conn != null && conn.isClosed())){
                Properties prop = loadProperties();
                conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
            }
        }catch(SQLException e){
            throw new DatabaseConnectException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return conn;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            throw new DatabaseCloseException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("config.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch(IOException e){
            throw new PropertiesException("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
        }
    }

    // Pingar a database a cada 5 segundos para manter a conexão viva
    public void ping(){
        try{
            if(conn != null){
             DBQuery.executeQuery("SELECT 1;");
            }
            new EventScheduler().addEvent(5000, () -> getInstance().ping());
        }catch(Exception e){
            throw new DatabaseNotConnectedException("Erro ao verificar a conexão com o banco de dados: " + e.getMessage());
        }
    }

}
