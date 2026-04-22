package src.model;

public class StoreItem 
{
    private int storeId;
    private int itemId;
    private boolean inStock;
    private double price;
    private String aisle;

    public StoreItem(int storeId, int itemId, boolean inStock, double price, String aisle) 
    {
        this.storeId = storeId;
        this.itemId = itemId;
        this.inStock = inStock;
        this.price = price;
        this.aisle = aisle;
    }

    public int getStoreId() { return storeId; }
    public int getItemId() { return itemId; }
    public boolean isInStock() { return inStock; }
    public double getPrice() { return price; }
    public String getAisle() { return aisle; }
}