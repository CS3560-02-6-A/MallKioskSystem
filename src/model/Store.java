package src.model;
package src.dao;


import src.model.Store;
import src.model.OperationHour;
import src.model.DateHour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Store 
{
    //INSTANCE VARIABLES
    private int storeID;
    private String name;
    private String telephone;
    private OperationHour hours;

    //CONSTRUCTOR 
    public Store(int id, String name, String telephone, OperationHour hours) 
    {
        this.storeID = id;
        this.name = name;
        this.telephone = telephone;
        this.hours = hours;
    }

    //GETTER
    public int getStoreID() 
    { 
        return this.storeID; 
    }
    public String getStoreName() 
    { 
        return this.name; 
    }
    public String getStoreTelephone() 
    { 
        return this.telephone;
    }
    public OperationHour getHours(int storeID)
    {
        this.hours= new OperationHour();
        String sql = "SELECT dayOfWeek, openTime, closeTime FROM storeHours_tbl WHERE storeID = ?";

        try (Connection conn = databaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) 
         {

            stmt.setInt(1, storeID);
            try (ResultSet rs = stmt.executeQuery()) 
            {
                while (rs.next()) 
                {
                    String range = rs.getString("openTime") + " - " + rs.getString("closeTime");
                    this.hours.addDateHour(new DateHour(rs.getString("dayOfWeek"), range));
                }
        }

    } 
    catch (SQLException e) 
    {
        e.printStackTrace();
    }

    return this.hours;


    }


    //SETTER
    public void setID(int id) 
    {
        this.storeID = id;
    }
    public void setStoreName(String name)
    { 
        this.name = name; 
    }
    public void setStoreTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
