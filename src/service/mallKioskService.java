package src.service;

import java.util.*;
import src.dao.storeItemDAO;
import src.model.StoreItem;


public class mallKioskService 
{
    private storeItemDAO myStoreItemDAO;

    //Constructor 
    public mallKioskService()
    {
        this.myStoreItemDAO = new storeItemDAO();
    }

    //Methods
    public List<StoreItem> getStoreInfoForItem(int itemId)
    {
        return myStoreItemDAO.getInventoryByItem(itemId);
    }

    public List<StoreItem> getAllItems()
    {
        List<StoreItem> inventory = new ArrayList<>();
        String sql = "SELECT * FROM inventory_tbl";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                StoreItem inItem = new StoreItem(
                    rs.getInt("storeID"),
                    rs.getInt("itemID"),
                    rs.getBoolean("inStock"),
                    rs.getDouble("price"),
                    rs.getString("aisle")
                );
                inventory.add(inItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventory;
        
    }

    public List<StoreItem> getItemsFullData() 
    {
        List<StoreItem> items = new ArrayList<>();
    
        String sql = "SELECT si.storeID, si.itemID, si.inStock, si.price, si.aisle, " +
                     "i.name, i.type, i.color, i.gender, i.occasion " +
                     "FROM inventory_tbl si " +
                     "JOIN items_tbl i ON si.itemID = i.ID " + 
                     "WHERE si.inStock = true"
                     ;
    
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) 
        {
    
            while (rs.next()) 
            {
                StoreItem item = new StoreItem(
                    rs.getInt("storeID"),
                    rs.getInt("itemID"),
                    rs.getBoolean("inStock"),
                    rs.getDouble("price"),
                    rs.getString("aisle"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("color"),
                    rs.getString("gender"),
                    rs.getString("occasion")
                );
                items.add(item);
            }

        } 
         catch (SQLException e) 
        {
        e.printStackTrace();
        }

    return items;
}

    public List<StoreItem> getItemsFullDataWithFilters(String gender, String occasion) {
    List<StoreItem> items = new ArrayList<>();

    String sql = "SELECT si.storeID, si.itemID, si.inStock, si.price, si.aisle, " +
                 "i.name, i.type, i.color, i.gender, i.occasion " +
                 "FROM inventory_tbl si " +
                 "JOIN items_tbl i ON si.itemID = i.ID " +  
                 "WHERE si.inStock = true " +
                 "AND (i.gender = ? OR i.gender = 'unisex' OR ? IS NULL) " +
                 "AND (i.occasion = ? OR ? IS NULL)";

    try (Connection conn = databaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Gender (used twice)
        ps.setString(1, gender);
        ps.setString(2, gender);

        // Occasion (used twice)
        ps.setString(3, occasion);
        ps.setString(4, occasion);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                StoreItem item = new StoreItem(
                    rs.getInt("storeID"),
                    rs.getInt("itemID"),
                    rs.getBoolean("inStock"),
                    rs.getDouble("price"),
                    rs.getString("aisle"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("color"),
                    rs.getString("gender"),
                    rs.getString("occasion")
                );
                items.add(item);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return items;
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

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) 
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
    
    // public List<StoreItem> generateOutfit(String gender, String occasion)
    // {
    //     List<StoreItem> candidates = myStoreItemDAO.getItemsByGenderAndOccasion(gender, occasion);
    //     List<StoreItem> outfit = new ArrayList<>();

    //     Map<String, List<StoreItem>> byType = new HashMap<>();

    //     for(StoreItem item: candidates)
    //     {
    //         //Check if the map already has a list for that type. 
    //         //If yes, use that list. If no, create a new empty list and put it in the map.
    
    //         String type = item.getItemType();
    //         if(!byType.containsKey(type))
    //         {
    //             byType.put(type, new ArrayList<>());
    //         }

    //         byType.get(type).add(item);
    //     }

    //     //Shuffle up each group of items to avoid picking the same item first. 
    //     //Purpose is to increase randomness for users. 
    //     for (List<StoreItem> group: byType.values())
    //     {
    //         //Loop through each list of same type items
    //         //byType.values() gives me the list of all items stores in the map
    //         //the shuffle function helps me randomly reorders the items inside that list.
    //         Collections.shuffle(group);
    //     }

    //     if(occasion.equalsIgnoreCase("formal") && gender.equalsIgnoreCase("women"))
    //     {
    //         StoreItem dress = pick(byType, "Dress");
    //         if(dress != null)
    //         {
    //             outfit.add(dress);
    //         }

    //         StoreItem shirt = pick(byType, "Shirt");
    //         if(shirt != null)
    //         {
    //             outfit.add(shirt);
    //         }

    //         StoreItem pants = pick(byType, "Pants");
    //         if(pants != null)
    //         {
    //             outfit.add(pants);
    //         }

    //         StoreItem jacket = pick(byType, "Jacket");
    //         if(jacket != null)
    //         {
    //             outfit.add(jacket);
    //         }

    //         StoreItem accessory = pick(byType, "Accessory");
    //         if(accessory != null)
    //         {
    //             outfit.add(accessory);
    //         }
    //     }
    //     else if(occasion.equalsIgnoreCase("formal") && gender.equalsIgnoreCase("men"))
    //     {
    //         StoreItem shirt = pick(byType, "Shirt");
    //         if(shirt != null)
    //         {
    //             outfit.add(shirt);
    //         }   

    //         StoreItem pants = pick(byType, "Pants");
    //         if(pants != null)
    //         {
    //             outfit.add(pants);
    //         }

    //         StoreItem suit = pick(byType, "Suit");
    //         if(suit != null)
    //         {
    //             outfit.add(suit);
    //         }

    //         StoreItem accessory = pick(byType, "Accessory");
    //         if(accessory != null)   
    //         {
    //             outfit.add(accessory);
    //         }
    //     }
    //     else  
    //     {
    //         //Casual - any gender
    //         StoreItem shirt = pick(byType, "Shirt");
    //         if(shirt != null)
    //         {
    //             outfit.add(shirt);
    //         }   

    //         StoreItem sweater = pick(byType, "Sweater");
    //         if(sweater != null)
    //         {
    //             outfit.add(sweater);
    //         }

    //         StoreItem pants = pick(byType, "Pants");
    //         if(pants != null)
    //         {
    //             outfit.add(pants);
    //         }

    //         StoreItem shorts = pick(byType, "shorts");
    //         if(shorts != null)
    //         {
    //             outfit.add(shorts);
    //         }

    //         StoreItem loungeWear = pick(byType, "loungeWear");
    //         if(loungeWear != null)
    //         {
    //             outfit.add(loungeWear);
    //         }

    //         StoreItem accessory = pick(byType, "Accessory");
    //         if(accessory != null)
    //         {
    //             outfit.add(accessory);
    //         }
    //     }

    //       return outfit;
    // }
   
   //Helper functions
   // private StoreItem pick(Map<String, List<StoreItem>> map, String type)
   // {
   //      //Look up items by type
   //      List<StoreItem> group = map.get(type);
   //      if (group == null || group.isEmpty())
   //      {
   //          //Return null if nothing exist. 
   //          return null;
   //      }
   //      //If any exist, we will take the first one.
   //      return group.get(0);
   // }


    
    
}
