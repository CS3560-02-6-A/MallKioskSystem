package src.service;

import java.util.*;
import src.dao.storeItemDAO;
import src.model.StoreItem;


public class mallKioskService 
{
    private storeItemDAO myStoreItemDAO;

    //Constructor 
    public mallKioskService()
    {
        this.myStoreItemDAO = new storeItemDAO();
    }

    public List<StoreItem> getStoreInfoForItem(int itemId)
    {
        return myStoreItemDAO.getInventoryByItem(itemId);
    }
    public List<StoreItem> generateOutfit(String gender, String occasion)
    {
        List<StoreItem> candidates = myStoreItemDAO.getItemsByGenderAndOccasion(gender, occasion);
        List<StoreItem> outfit = new ArrayList<>();

        Map<String, List<StoreItem>> byType = new HashMap<>();

        for(StoreItem item: candidates)
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
        for (List<StoreItem> group: byType.values())
        {
            //Loop through each list of same type items
            //byType.values() gives me the list of all items stores in the map
            //the shuffle function helps me randomly reorders the items inside that list.
            Collections.shuffle(group);
        }

        if(occasion.equalsIgnoreCase("formal") && gender.equalsIgnoreCase("women"))
        {
            StoreItem dress = pick(byType, "Dress");
            if(dress != null)
            {
                outfit.add(dress);
            }

            StoreItem shirt = pick(byType, "Shirt");
            if(shirt != null)
            {
                outfit.add(shirt);
            }

            StoreItem pants = pick(byType, "Pants");
            if(pants != null)
            {
                outfit.add(pants);
            }

            StoreItem jacket = pick(byType, "Jacket");
            if(jacket != null)
            {
                outfit.add(jacket);
            }

            StoreItem accessory = pick(byType, "Accessory");
            if(accessory != null)
            {
                outfit.add(accessory);
            }
        }
        else if(occasion.equalsIgnoreCase("formal") && gender.equalsIgnoreCase("men"))
        {
            StoreItem shirt = pick(byType, "Shirt");
            if(shirt != null)
            {
                outfit.add(shirt);
            }   

            StoreItem pants = pick(byType, "Pants");
            if(pants != null)
            {
                outfit.add(pants);
            }

            StoreItem suit = pick(byType, "Suit");
            if(suit != null)
            {
                outfit.add(suit);
            }

            StoreItem accessory = pick(byType, "Accessory");
            if(accessory != null)   
            {
                outfit.add(accessory);
            }
        }
        else  
        {
            //Casual - any gender
            StoreItem shirt = pick(byType, "Shirt");
            if(shirt != null)
            {
                outfit.add(shirt);
            }   

            StoreItem sweater = pick(byType, "Sweater");
            if(sweater != null)
            {
                outfit.add(sweater);
            }

            StoreItem pants = pick(byType, "Pants");
            if(pants != null)
            {
                outfit.add(pants);
            }

            StoreItem shorts = pick(byType, "shorts");
            if(shorts != null)
            {
                outfit.add(shorts);
            }

            StoreItem loungeWear = pick(byType, "loungeWear");
            if(loungeWear != null)
            {
                outfit.add(loungeWear);
            }

            StoreItem accessory = pick(byType, "Accessory");
            if(accessory != null)
            {
                outfit.add(accessory);
            }
        }

          return outfit;
    }
   
   //Helper functions
   private StoreItem pick(Map<String, List<StoreItem>> map, String type)
   {
        //Look up items by type
        List<StoreItem> group = map.get(type);
        if (group == null || group.isEmpty())
        {
            //Return null if nothing exist. 
            return null;
        }
        //If any exist, we will take the first one.
        return group.get(0);
   }
    
}
