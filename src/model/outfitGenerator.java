package src.model;

import java.util.ArrayList;
import java.util.List;
import src.model.StoreItem;
import src.model.Outfit;
import java.util.Random;

public class outfitGenerator {

    public List<StoreItem> getAccessoryList(List<StoreItem> items) {
            List<StoreItem> accessoryList = new ArrayList<StoreItem>();
            for (StoreItem item : items) {
                if (item.getItemType().equalsIgnoreCase("accessory") ||
                    item.getItemType().equalsIgnoreCase("jacket") ||
                    item.getItemType().equalsIgnoreCase("sweater")) {
                    accessoryList.add(item);
                }
            }
            return accessoryList;
    }

    public List<StoreItem> getTopsList(List<StoreItem> items) {
            List<StoreItem> topsList = new ArrayList<StoreItem>();
            for (StoreItem item : items) {
                if (item.getItemType().equalsIgnoreCase("Shirt") ||
                    item.getItemType().equalsIgnoreCase("Dress") ||
                    item.getItemType().equalsIgnoreCase("Suit") ||
                    item.getItemType().equalsIgnoreCase("Robe")) {
                    topsList.add(item);
                }
            }
            return topsList;
    }

      public List<StoreItem> getBottomsList(List<StoreItem> items) {
            List<StoreItem> bottomsList = new ArrayList<StoreItem>();
            for (StoreItem item : items) {
                if (item.getItemType().equalsIgnoreCase("Pants") ||
                    item.getItemType().equalsIgnoreCase("Skirt") ||
                    item.getItemType().equalsIgnoreCase("Shorts")) {
                    bottomsList.add(item);
                }
            }
            return bottomsList;
    }

      public List<StoreItem> getShoesList(List<StoreItem> items) {
            List<StoreItem> shoesList = new ArrayList<StoreItem>();
            for (StoreItem item : items) {
                if (item.getItemType().equalsIgnoreCase("heels") ||
                item.getItemType().equalsIgnoreCase("sandals") ||
                    item.getItemType().equalsIgnoreCase("sneakers") ||
                    item.getItemType().equalsIgnoreCase("dressShoe")) {
                    shoesList.add(item);
                }
            }
            return shoesList;
    }

    public List<StoreItem> generateFullOutfitList(List<StoreItem> items) {
    List<StoreItem> outfit = new ArrayList<>();
    Random rand = new Random();

    List<StoreItem> accessories = getAccessoryList(items);
    List<StoreItem> tops = getTopsList(items);
    List<StoreItem> bottoms = getBottomsList(items);
    List<StoreItem> shoes = getShoesList(items);

    if (!accessories.isEmpty())
        outfit.add(accessories.get(rand.nextInt(accessories.size())));

    if (!tops.isEmpty())
        outfit.add(tops.get(rand.nextInt(tops.size())));

    if (!bottoms.isEmpty())
        outfit.add(bottoms.get(rand.nextInt(bottoms.size())));

    if (!shoes.isEmpty())
        outfit.add(shoes.get(rand.nextInt(shoes.size())));

    return outfit;
}




    // public List<StoreItem> getTopList(List<StoreItem> items) {
    //         List<StoreItem> topList = new ArrayList<StoreItem>();
    //         for (StoreItem item : items) {
    //             if (item.getType().equalsIgnoreCase("top")) {
    //                 topList.add(item);
    //             }
    //         }
    //         return topList;
    // }


    //  public Outfit generateRandomOutfit(List<StoreItem> tops, List<StoreItem> bottoms,
    //                 List<StoreItem> shoes, List<StoreItem> accessories, int occasionID) {
    //     StoreItem top = getRandomByType(items, "top");
    //     StoreItem bottom = getRandomByType(items, "bottom");
    //     StoreItem shoes = getRandomByType(items, "shoes");
    //     StoreItem accessory = getRandomByType(items, "accessory");

    //     return new Outfit(
    //         0, // outfitID if not saved yet
    //         occasionID,
    //         top.getItemId(),
    //         bottom.getItemId(),
    //         shoes.getItemId(),
    //         accessory.getItemId()
    //     );
    // }
}
