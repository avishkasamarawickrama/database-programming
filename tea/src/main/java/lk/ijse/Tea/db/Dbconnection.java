package lk.ijse.Tea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static Dbconnection dbConnection;
    private Connection connection;

    private Dbconnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tea",
                "root",
                "Ijse@123"
        );
    }
    public static Dbconnection getInstance() throws SQLException {
        return (dbConnection == null) ? dbConnection = new Dbconnection() : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
