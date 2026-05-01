package src.dao;

import java.sql.*;
import src.model.Receipt;

public class receiptDAO 
{
    public void saveReceipt(Receipt receipt) 
    { //save the receipt to the database
        String sql = "INSERT INTO receipt_tbl (SessionID, OutfitID, GeneratedAt, TotalPrice) VALUES (?, ?, ?, ?)";
         try (Connection connection = databaseConnection.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql)) 
        {     
             statement.setInt(1, receipt.getSessionID());
             statement.setInt(2, receipt.getOutfitID());
             statement.setTimestamp(3, Timestamp.valueOf(receipt.getGeneratedAt()));    
             statement.setDouble(4, receipt.getTotalPrice());
             statement.executeUpdate();
         } 
         catch (SQLException e) 
         {
             e.printStackTrace();
         }

        System.out.println("Saving receipt: " + receipt);
    }
}   