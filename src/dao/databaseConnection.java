package src.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class databaseConnection 
{
    public static Connection getConnection() throws SQLException 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props = new Properties();

            InputStream input = databaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");

            if (input == null) 
            {
                throw new SQLException("db.properties not found");
            }

            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            if (url == null || user == null || password == null) 
            {
                throw new SQLException("Missing db.url, db.user, or db.password in db.properties");
            }

            return DriverManager.getConnection(url, user, password);
        } 
        catch (ClassNotFoundException e) 
        {
            throw new SQLException("MySQL JDBC driver not found", e);
        } 
        catch (Exception e) 
        {
            throw new SQLException("Failed to load database configuration", e);
        }
    }
}