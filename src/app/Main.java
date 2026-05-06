package src.app;

import java.util.List;
import src.dao.storeItemDAO;
import src.model.Receipt;
import src.model.StoreItem;
import src.model.outfitGenerator;
import src.service.mallKioskService;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("BEGIN MAIN TESTING");

        mallKioskService service = new mallKioskService();
        outfitGenerator generator = new outfitGenerator();
        storeItemDAO dao = new storeItemDAO();

        List<StoreItem> outfit = service.generateOutfit("women", null);
        
        
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

        Receipt receipt = service.generateReceipt(outfit, 1);
        System.out.println("Receipt total: $" + receipt.getTotalPrice() + " | Generated at: " + receipt.getGeneratedAt());




        // System.out.println("TESTING storeItemDAO...");
        // storeItemDAO dao = new storeItemDAO();
        

        //Testing for getting all items with full data paramaters, filtered.
        // System.out.println("Testing for getting all items with full data paramaters, filtered.");
        // List<StoreItem> filteredItems = dao.getItemsFullDataWithFilters("men", null);
      
        // System.out.println("Testing for getting all items with full data paramaters, filtered.");
        // List<StoreItem> filteredItems = dao.getItemsFullDataWithFilters("women", "formal");

        // for (StoreItem i : outfit) 
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
