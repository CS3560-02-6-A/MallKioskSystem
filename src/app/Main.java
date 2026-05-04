package src.app;

import java.sql.ResultSet;
import java.util.List;
import src.dao.itemDAO;
import src.dao.storeItemDAO;
import src.model.StoreItem;
import src.model.Item;
import src.dao.storeDAO;
import src.model.Store;
import src.model.outfitGenerator;
import java.sql.Connection;
import java.sql.Statement;
import src.dao.databaseConnection;
import src.service.mallKioskService;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("BEGIN MAIN TESTING");
        // System.out.println("TESTING storeItemDAO...");
        // storeItemDAO dao = new storeItemDAO();
        

        //Testing for getting all items with full data paramaters, filtered.
        // System.out.println("Testing for getting all items with full data paramaters, filtered.");
        
        mallKioskService service = new mallKioskService();
        List<StoreItem> outfit = service.generateOutfit(null, null);

        for (StoreItem i : outfit) 
        {
            System.out.println(
               "Name: " + i.getItemName() +
            " | Type: " + i.getItemType() +
            " | Color: " + i.getItemColor() +
            " | Gender: " + i.getGender() +
            " | Occasion: " + i.getOccasion() +
            " | StoreID: " + i.getStoreId() +
            " | ItemID: " + i.getItemId() +
            " | Price: $" + i.getPrice() +
            " | InStock: " + i.isInStock() +
            " | Aisle: " + i.getAisle()
            );
        }

    //  try (Connection conn = databaseConnection.getConnection();
    //          Statement s = conn.createStatement();
    //          ResultSet rs = s.executeQuery("SELECT DATABASE(), @@hostname, @@port")) {

    //         System.out.println("URL: " + conn.getMetaData().getURL());

    //         while (rs.next()) {
    //             System.out.println("Database: " + rs.getString(1));
    //             System.out.println("Host: " + rs.getString(2));
    //             System.out.println("Port: " + rs.getInt(3));
    //         }

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }


        // Testing for getting just accessories with full data paramaters, filtered.
        // System.out.println("Testing for getting just accessories with full data paramaters, filtered.");
        // outfitGenerator generator = new outfitGenerator();
        // List<StoreItem> outfit = generator.generateFullOutfitList(filteredItems);
        
        //   for (StoreItem i : outfit)
        // {
        //     System.out.println(
        //        "Name: " + i.getItemName() +
        //     " | Type: " + i.getItemType() +
        //     " | Color: " + i.getItemColor() +
        //     " | Gender: " + i.getGender() +
        //     " | Occasion: " + i.getOccasion() +
        //     " | StoreID: " + i.getStoreId() +
        //     " | ItemID: " + i.getItemId() +
        //     " | Price: $" + i.getPrice() +
        //     " | InStock: " + i.isInStock() +
        //     " | Aisle: " + i.getAisle()
        //     );
        // }

        //TESTING FOR storeDAO
        // System.out.println("TESTING FOR storeDAO...");
        // storeDAO myStoreDAO = new storeDAO();
        //Printing out all stores.
        // List<Store> stores = myStoreDAO.getAllStores();
        // for(Store s: stores)
        // {
        //     System.out.println(s.getStoreID() + " - " + s.getStoreName());
        //     System.out.println(s.getHours().printOperationHour());
        //     System.out.println();
        // }

    }

    }
