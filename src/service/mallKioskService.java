package src.service;

import java.sql.*;
import java.util.*;
import src.dao.databaseConnection;
import src.dao.receiptDAO;
import src.dao.storeItemDAO;
import src.model.Receipt;
import src.model.StoreItem;
import src.model.outfitGenerator;


public class mallKioskService 
{
    private storeItemDAO myStoreItemDAO;
    private receiptDAO myReceiptDAO;
	private outfitGenerator myGenerator;

    //Constructor 
    public mallKioskService()
    {
        this.myStoreItemDAO = new storeItemDAO();
        this.myReceiptDAO = new receiptDAO();
		this.myGenerator = new outfitGenerator();
    }

    public List<StoreItem> generateOutfit(String gender, String occasion)
    {
        List<StoreItem> fullFilteredSet = getItemsFullDataWithFilters(gender, occasion);
        outfitGenerator generator = new outfitGenerator();
        return generator.generateFullOutfitList(fullFilteredSet);
    }

    private int createSession() 
    {
      String sql = "INSERT INTO session_tbl () VALUES ()";
      try (Connection conn = databaseConnection.getConnection();
           PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
          ps.executeUpdate();
          try (ResultSet keys = ps.getGeneratedKeys()) 
          {
              if (keys.next()) return keys.getInt(1);
          }
      } 
      catch (SQLException e) 
      {     
        e.printStackTrace(); 
    }
      return 0;
  }
    public Receipt generateReceipt(List<StoreItem> outfit) 
    {
        int sessionID = createSession();
        return generateReceipt(outfit, sessionID);
    }
    // public Receipt generateReceipt(List<StoreItem> outfit)
    // {
    //     double totalPrice = 0.0;
    //     for(StoreItem item: outfit)
    //     {
    //         totalPrice += item.getPrice();
    //     }

    //     //For now, we will just return a receipt with dummy data. 
    //     return new Receipt(1, 1, 1, totalPrice);
    // }



    public List<StoreItem> getStoreInfoForItem(int itemId)
    {
        return myStoreItemDAO.getInventoryByItem(itemId);
    }

    public List<StoreItem> getItemsFullDataWithFilters(String gender, String occasion) {
        return myStoreItemDAO.getItemsFullDataWithFilters(gender, occasion);
    }


    public List<StoreItem> getInventoryByStore(int storeID) 
    {
        List<StoreItem> inventory = new ArrayList<>();

        String sql = "SELECT storeID, itemID, inStock, price, aisle FROM inventory_tbl WHERE storeID = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) 
            {

                ps.setInt(1, storeID);

                try (ResultSet rs = ps.executeQuery()) 
                {
                    while (rs.next()) 
                    {
                        inventory.add(new StoreItem(
                                rs.getInt("storeID"),
                                rs.getInt("itemID"),
                                rs.getBoolean("inStock"),
                                rs.getDouble("price"),
                                rs.getString("aisle")
                            ));
                    }  
                }             

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return inventory;
    }
 //Get inventory for item by itemID.
    public List<StoreItem> getInventoryByItem(int itemID)
    {
        List<StoreItem> inventory = new ArrayList<>();

        String sql = "SELECT storeID, itemID, inStock, price, aisle FROM inventory_tbl WHERE itemID = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) 
            {

                ps.setInt(1, itemID);

                try (ResultSet rs = ps.executeQuery()) 
                {
                    while (rs.next()) 
                    {
                        inventory.add(new StoreItem(
                                rs.getInt("storeID"),
                                rs.getInt("itemID"),
                                rs.getBoolean("inStock"),
                                rs.getDouble("price"),
                                rs.getString("aisle")
                            ));
                    }  
                }             

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return inventory;   
    }
    
    public Receipt generateReceipt(List<StoreItem> outfit, int sessionID)
    {
        double totalPrice = 0.0;
        for (StoreItem item: outfit)
        {
            totalPrice += item.getPrice();
        }

        //Review constructor for Receipt class: 
        //public Receipt(int receiptID, int sessionID, int outfitID, double totalPrice)
        //Because receiptID and outfitID are auto-generated in the database, we can set them to 0.
        //MySQL will treat this as a signal to generate the next ID.

        Receipt receipt = new Receipt(0, sessionID, 0, totalPrice);//still need to figure out where the sessionID come from.
        myReceiptDAO.saveReceipt(receipt);
        return receipt;
    }   
    
    
    
}
