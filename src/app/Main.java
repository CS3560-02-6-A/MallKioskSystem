package src.app;

import java.util.List;
import src.dao.itemDAO;
import src.dao.storeItemDAO;
import src.model.StoreItem;
import src.model.Item;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println(
            "\n\n---------------BEGIN MAIN TESTING------------");




        storeItemDAO dao = new storeItemDAO();
            //Testing for getting all items with full data paramaters, no filtering
            List<StoreItem> items = dao.getItemsFullData();
            //Testing for getting all items with full data paramaters, filtered
            List<StoreItem> filteredItems = dao.getItemsFullDataWithFilters("women", "casual");

            for (StoreItem i : filteredItems) {
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
    //          public int getStoreId() { return storeId; }
    // public int getItemId() { return itemId; }
    // public boolean isInStock() { return inStock; }
    // public double getPrice() { return price; }
    // public String getAisle() { return aisle; }
    // public int getItemID() { return itemId; }
    // public String getItemName() { return name; }
    // public String getItemType() { return type; }
    // public String getItemColor() { return color; }
    // public String getGender() { return gender; }
    // public String getOccasion() { return occasion; }
        }



        // List<StoreItem> items = dao.getAllItems();
            //TESTING FOR getItemsByGenderAndOccasion
            //Need to verify to use StoreItem or Item
        // List<Item> filteredItems = dao.getItemsByGenderAndOccasion("woman", "casual");

        // for(Item i : filteredItems)
        // {
        //     System.out.println(i.getItemName() + " - " + i.getGender() + " - " + i.getOccasion());
        // }


        // for (StoreItem inItem : items) {
        //     System.out.println(inItem.getItemId());
        // }

        //TESTING FOR storeDAO
        // storeDAO myStoreDAO = new storeDAO();
        // List<Store> stores = myStoreDAO.getAllStores();
        // for(Store s: stores)
        // {
        //     System.out.println(s.getStoreID() + " - " + s.getStoreName());
        //     System.out.println(s.getHours().printOperationHour());
        //     System.out.println();

        // }

    }
}