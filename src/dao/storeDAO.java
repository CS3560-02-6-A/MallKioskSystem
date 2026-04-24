package src.dao;

import java.sql.*;
import src.model.DateHour;
import src.model.OperationHour;

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
            e.printStackTrace();
        }

        return operationHour;
    }

    //getAllStores() and getStoreByID() will go here next. 

}
