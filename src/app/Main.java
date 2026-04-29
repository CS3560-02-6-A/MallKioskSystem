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
        List<StoreItem> items = dao.getAllItems();
            //TESTING FOR getItemsByGenderAndOccasion
            //Need to verify to use StoreItem or Item
        List<Item> filteredItems = dao.getItemsByGenderAndOccasion("woman", "casual");

        for(Item i : filteredItems)
        {
            System.out.println(i.getItemName() + " - " + i.getGender() + " - " + i.getOccasion());
        }


        for (StoreItem inItem : items) {
            System.out.println(inItem.getItemId());
        }

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