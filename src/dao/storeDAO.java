package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.model.DateHour;
import src.model.OperationHour;
import src.model.Store;

public class storeDAO 
{
    public OperationHour getHoursForStore(int storeID)
    {
        OperationHour operationHour = new OperationHour();
        String sql = "SELECT dayOfWeek, openTime, closeTime FROM storeHours_tbl WHERE storeID = ?";

        try(Connection myConnection = databaseConnection.getConnection();
            PreparedStatement myStatement = myConnection.prepareStatement(sql))
        {
            myStatement.setInt(1, storeID);
            try(ResultSet myResultSet = myStatement.executeQuery())
            {
                while(myResultSet.next())
                {
                    String range = myResultSet.getString("openTime") + " - " + myResultSet.getString("closeTime");
                    operationHour.addDateHour(new DateHour(myResultSet.getString("dayOfWeek"), range));
                }
            }
        }
        catch (SQLException e)
        {
           throw new RuntimeException("Error retrieving stores from database", e);
        }

        return operationHour;
    }

    //getAllStores() and getStoreByID() will go here next. 
    public List<Store> getAllStores()
    {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT ID, name, telephone FROM stores_tbl";

        try(Connection myConnection = databaseConnection.getConnection();
            PreparedStatement myStatement = myConnection.prepareStatement(sql))
        {
            try(ResultSet myResultSet = myStatement.executeQuery())
            {
                while(myResultSet.next())
                {
                    OperationHour hours = getHoursForStore(myResultSet.getInt("ID"));
                    stores.add(new Store(myResultSet.getInt("ID"), myResultSet.getString("name"), myResultSet.getString("telephone"), hours));
                }
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Error retrieving stores from database", e);
        }
        return stores;

    }

    //and getStoreByID() will go here next. 
    public Store getStoreById(int storeID)
    {
        Store myStore = null;
        String sql = "SELECT ID, name, telephone FROM stores_tbl WHERE ID = ?";
        try(Connection myConnection = databaseConnection.getConnection();
            PreparedStatement myStatement = myConnection.prepareStatement(sql))
        {
            myStatement.setInt(1, storeID);
            try(ResultSet myResultSet = myStatement.executeQuery())
            {
                //Expect one row. Use if instead of while loop like above.
               if(myResultSet.next())
               {
                    OperationHour hours = getHoursForStore(storeID);
                    myStore = new Store(myResultSet.getInt("ID"), myResultSet.getString("name"), myResultSet.getString("telephone"), hours);
               }
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Error retrieving stores from database", e);
        }
        return myStore;
    }
}
