package src.app;

import java.util.List;
import src.model.StoreItem;
import src.service.mallKioskService;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Begin Main Testing");

        mallKioskService service = new mallKioskService();
        System.out.println("Generating outfit for women formal occasion...");
        List<StoreItem> outfit1 = service.generateOutfit("women", "formal");
        if(outfit1.isEmpty())
        {
            System.out.println("No items found for that outfit.");
            System.out.println("Check DB for gender='women' and occasion='formal' items.");
        }
        for(StoreItem item: outfit1)
        {
            System.out.println(
                item.getItemName() + " | " +
                item.getItemType() + " | " +
                item.getItemColor() + " | " +
                item.getOccasion() + " | " +
                item.getGender() + " | " +
                item.getPrice() + " | " +
                item.getAisle()
            );
        }

         if (!outfit1.isEmpty()) 
         {
            int testItemId = outfit1.get(0).getItemID();
            System.out.println("\n=== getStoreInfoForItem(" + testItemId + ") ===");
            List<StoreItem> stores = service.getStoreInfoForItem(testItemId);
            for (StoreItem si : stores) 
            {
                System.out.println(
                    "Store " + si.getStoreId() +
                    " | $" + si.getPrice() +
                    " | In Stock: " + si.isInStock() +
                    " | Aisle: " + si.getAisle()
                );
            }
         }
    }
}