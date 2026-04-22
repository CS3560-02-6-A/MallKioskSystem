package src.app;

import src.dao.itemDAO;
import src.model.Item;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        itemDAO dao = new itemDAO();
        List<Item> items = dao.getAllItems();

        for (Item item : items) {
            System.out.println(item.getItemName());
        }
    }
}