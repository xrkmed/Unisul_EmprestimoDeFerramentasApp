package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
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

    public Connection getConnection() throws DatabaseConnectException {
        try {
            if (conn == null || (conn != null && conn.isClosed())) {
                Properties prop = loadProperties();
                conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
            }
        } catch (SQLException e) {
            throw new DatabaseConnectException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return conn;
    }

    public void closeConnection() throws DatabaseCloseException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DatabaseCloseException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

    private static Properties loadProperties() throws PropertiesException {
        try (FileInputStream fs = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new PropertiesException("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
        }
    }

    // Pingar a database a cada 5 segundos para manter a conexão viva
    public void ping() throws DatabaseNotConnectedException {
        new EventScheduler().addEvent(5000, () -> getInstance().ping());

        try {
            if (conn != null) {
                if (conn.isClosed()) {
                    JOptionPane.showMessageDialog(null, "A conexao com o banco de dados se perdeu, tentando reconectar...");
                    conn = getConnection();
                    if (conn != null && !conn.isClosed()) {
                        JOptionPane.showMessageDialog(null, "Conexao com o banco de dados restabelecida.");
                    }
                    return;
                }
                DBQuery.executeQuery("SELECT 1;");
            }
        } catch (Exception e) {
            throw new DatabaseNotConnectedException();
        }
    }

}
