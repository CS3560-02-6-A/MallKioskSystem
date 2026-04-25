package src.app;

import java.util.List;
import src.dao.itemDAO;
import src.model.Item;

public class Main 
{
    public static void main(String[] args) 
    {

        itemDAO dao = new itemDAO();
        List<Item> items = dao.getAllItems();

        for (Item item : items) {
            System.out.println(item.getItemName());
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