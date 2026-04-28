package src.dao;

import java.sql.*;
import java.util.*;
import src.model.StoreItem;
import src.model.Store;



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
}