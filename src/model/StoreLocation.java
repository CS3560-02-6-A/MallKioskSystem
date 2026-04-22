package src.model;

public class StoreLocation {
    private int storeID;
    private int mapX;
    private int mapY;
    private String mallPos;

    public StoreLocation(int storeID, int mapX, int mapY, String mallPos) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.mallPos = mallPos;
    }

    public int getStoreID() { return storeID; }
    public int getMapX() { return mapX; }
    public int getMapY() { return mapY; }
    public String getMallPos() { return mallPos; }
}