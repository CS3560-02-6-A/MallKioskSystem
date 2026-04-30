package src.dao;

import java.sql.*;
import java.util.*;
import src.model.Item;
import src.model.StoreItem;



public class storeItemDAO {

    public List<StoreItem> getAllItems() {
        List<StoreItem> inventory = new ArrayList<>();

//        USE THIS IF WE WANT FULL ITEM DETAILS IN THE STOREITEM OBJECT.
//        e_ String sql = 
//        "SELECT * FROM itemsInStortbl si " +
//        "JOIN allClothingItems_tbl i ON si.itemID = i.ID";

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

    //This will filter items based on the gender and occasion but unisex will be included in any gender choice.
    
    /* 
    Need to verify using StoreItem or Item for the return type since
    - if we use StoreItem we can also prioritize inStock and store is open
    - if we use Item we can get more details about the item but we won't know if it's in stock or not
    */
    public List<Item> getItemsByGenderAndOccasion(String gender, String occasion) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT ID, name, type, color, gender, occasion " +
                     "FROM items_tbl " +
                     "WHERE (gender = ? OR gender = 'unisex') AND occasion = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, gender);
            ps.setString(2, occasion);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                        rs.getInt("ID"),
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

    public List<StoreItem> getItemsFullData() {
    List<StoreItem> items = new ArrayList<>();

    String sql = "SELECT si.storeID, si.itemID, si.inStock, si.price, si.aisle, " +
                 "i.name, i.type, i.color, i.gender, i.occasion " +
                 "FROM inventory_tbl si " +
                 "JOIN items_tbl i ON si.itemID = i.ID " + 
                 "WHERE si.inStock = true"
                 ;

    try (Connection conn = databaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

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

    } catch (SQLException e) {
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

}