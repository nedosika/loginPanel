package sample.database;

import java.sql.*;

public class DataBaseHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" + Config.DB_HOST  + ":" + Config.DB_PORT + "/" + Config.DB_NAME
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        dbConnection = DriverManager.getConnection(connectionString, Config.DB_USER, Config.DB_USER_PASSWORD);
        return dbConnection;
    }

    public boolean signInUser(User user){

        if(user.getLogin().equals("") || user.getPassword().equals("")){
            return false;
        }

        String queryString = "SELECT * FROM users WHERE login =? AND password =?";
        try (PreparedStatement prSt = getDbConnection().prepareStatement(queryString)) {
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            ResultSet resultSet = prSt.executeQuery();
            if(resultSet.next()){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
