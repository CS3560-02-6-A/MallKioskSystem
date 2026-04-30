package src.service;

import java.util.*;
import src.dao.itemDAO;
import src.dao.storeItemDAO;
import src.model.Item;
import src.model.StoreItem;


public class mallKioskService 
{
    private itemDAO myItemDAO;
    private storeItemDAO myStoreItemDAO;

    //Constructor 
    public mallKioskService()
    {
        this.myItemDAO = new itemDAO();
        this.myStoreItemDAO = new storeItemDAO();
    }

    public List<StoreItem> getStoreInfoForItem(int itemId)
    {
        return myStoreItemDAO.getInvetoryForItem(itemId);
    }
    public List<Item> generateOutfit(String gender, String occasion)
    {
        List<Item> candidates = myItemDAO.getItemsByGenderAndOccasion(gender, occasion);
        List<Item> outfit = new ArrayList<>();

        Map<String, List<Item>> byType = new HashMap<>();

        for(Item item: candidates)
        {
            //Check if the map already has a list for that type. 
            //If yes, use that list. If no, create a new empty list and put it in the map.
    
            String type = item.getItemType();
            if(!byType.containsKey(type))
            {
                byType.put(type, new ArrayList<>());
            }

            byType.get(type).add(item);
        }

        //Shuffle up each group of items to avoid picking the same item first. 
        //Purpose is to increase randomness for users. 
        for (List<Item> group: byType.values())
        {
            //Loop through each list of same type items
            //byType.values() gives me the list of all items stores in the map
            //the shuffle function helps me randomly reorders the items inside that list.
            Collections.shuffle(group);
        }

        if(occasion.equalsIgnoreCase("formal") && gender.equalsIgnoreCase("women"))
        {
            Item dress = pick(byType, "Dress");
            //Continue here. Stop at 6:49pm 04/27/2026 (Chau)
        }
          return outfit;
    }
   
   //Helper functions
   private Item pick(Map<String, List<Item>> map, String type)
   {
        //Look up items by type
        List<Item> group = map.get(type);
        if (group == null || group.isEmpty())
        {
            //Return null if nothing exist. 
            return null;
        }
        //If any exist, we will take the first one.
        return group.get(0);
   }
    
}
