package src.model;

public class StoreItem 
{
    private int storeId;
    private int itemId;
    private boolean inStock;
    private double price;
    private String aisle;
    // from item attributes for complete item info
    private String name;
    private String type;
    private String color;
    private String gender;
    private String occasion;

    public StoreItem(int storeId, int itemId, boolean inStock, double price, String aisle) 
    {
        this.storeId = storeId;
        this.itemId = itemId;
        this.inStock = inStock;
        this.price = price;
        this.aisle = aisle;
    }

     public StoreItem(int storeId, int itemId, boolean inStock, double price, String aisle, 
        String name, String type, String color, String gender, String occasion) 
    {
        this.storeId = storeId;
        this.itemId = itemId;
        this.inStock = inStock;
        this.price = price;
        this.aisle = aisle;
        this.name = name;
        this.type = type;
        this.color = color;
        this.gender = gender;
        this.occasion = occasion;
    }

    public int getStoreId() { return storeId; }
    public int getItemId() { return itemId; }
    public boolean isInStock() { return inStock; }
    public double getPrice() { return price; }
    public String getAisle() { return aisle; }
    public int getItemID() { return itemId; }
    public String getItemName() { return name; }
    public String getItemType() { return type; }
    public String getItemColor() { return color; }
    public String getGender() { return gender; }
    public String getOccasion() { return occasion; }
}