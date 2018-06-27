package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" + Config.DB_HOST  + ":" + Config.DB_PORT + "/" + Config.DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        dbConnection = DriverManager.getConnection(connectionString, Config.DB_USER, Config.DB_USER_PASSWORD);
        return dbConnection;
    }
}
