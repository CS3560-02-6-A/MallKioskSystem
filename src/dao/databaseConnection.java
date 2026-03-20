package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    private static final String URL = "idk what the url is yet";
    private static final String USER = "idk what the username is yet";
    private static final String PASSWORD = "idk what the password is yet";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}