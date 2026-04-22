package src.dao;

import src.model.Item;
import java.sql.*;
import java.util.*;

public class itemDAO {

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();

        String sql = "SELECT * FROM items_tbl";

        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Item item = new Item(
                    rs.getInt("ID"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("color")
                );
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}