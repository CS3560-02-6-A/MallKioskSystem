package src.app;

import java.util.List;
import src.dao.itemDAO;
import src.dao.storeItemDAO;
import src.model.StoreItem;
import src.model.Item;
import src.doa.storeDAO;
import src.model.Store;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("BEGIN MAIN TESTING");
        System.out.println("TESTING storeItemDAO...");
        storeItemDAO dao = new storeItemDAO();
        

        //Testing for getting all items with full data paramaters, filtered.
        System.out.println("Testing for getting all items with full data paramaters, filtered.");
        List<StoreItem> filteredItems = dao.getItemsFullDataWithFilters("women", "casual");

        for (StoreItem i : filteredItems) 
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

        //Testing for getting all items with full data paramaters, no filtering.
        System.out.println("Testing for getting all items with full data paramaters, no filtering.");
        List<StoreItem> items = dao.getItemsFullData();
        
        System.out.println("Print out the first five items.");
        for(int i = 0; i < 5; ++i)
        {
             System.out.println("Item number " + (i+1));
             System.out.println(
               "Name: " + items.get(i).getItemName() +
            " | Type: " + items.get(i).getItemType() +
            " | Color: " + items.get(i).getItemColor() +
            " | Gender: " + items.get(i).getGender() +
            " | Occasion: " + items.get(i).getOccasion() +
            " | StoreID: " + items.get(i).getStoreId() +
            " | ItemID: " + items.get(i).getItemId() +
            " | Price: $" + items.get(i).getPrice() +
            " | InStock: " + items.get(i).isInStock() +
            " | Aisle: " + items.get(i).getAisle()
            );
        }
                

        //TESTING FOR storeDAO
        System.out.println("TESTING FOR storeDAO...");
        storeDAO myStoreDAO = new storeDAO();
        //Printing out all stores.
        List<Store> stores = myStoreDAO.getAllStores();
        for(Store s: stores)
        {
            System.out.println(s.getStoreID() + " - " + s.getStoreName());
            System.out.println(s.getHours().printOperationHour());
            System.out.println();
        }

    }
}
