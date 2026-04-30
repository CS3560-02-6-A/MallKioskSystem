package src.model;

public class StoreLocation 
{
    //Instance variables
    private int storeID;
    private int mapX;
    private int mapY;
    private String mallPos;

    //Constructor
    public StoreLocation(int storeID, int mapX, int mapY, String mallPos) 
    {
        this.storeID = storeID;
        this.mapX = mapX;
        this.mapY = mapY;
        this.mallPos = mallPos;
    }

    //Getters
    public int getStoreID() { return storeID; }
    public int getMapX() { return mapX; }
    public int getMapY() { return mapY; }
    public String getMallPos() { return mallPos; }

    //Setters
    public void setStoreID(int storeID)
    {
        this.storeID = storeID;
    }

    public void setMapX(int x)
    {
        this.mapX = x;
    }

    public void setMapY(int y)
    {
        this.mapY = y;
    }

    public void setMallPos(int x, int y)
    {
        this.mallPos = "Location: X = " + x + " Y = " + y;
    }
}