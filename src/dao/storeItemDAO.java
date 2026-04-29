package src.dao;

import java.sql.*;
import java.util.*;
import src.model.StoreItem;
import src.model.Item;



public class storeItemDAO {

    public List<StoreItem> getAllItems() {
        List<StoreItem> inventory = new ArrayList<StoreItem>();

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
}