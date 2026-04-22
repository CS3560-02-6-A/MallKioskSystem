package src.model;

public class Item {

    //INSTANCE VARIABLES
    private int id;
    private String name;
    private String type;
    private String color;

    //CONSTRUCTOR
    public Item(int id, String name, String type, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
    }

    //GETTER METHODS
    public int getItemID() { return id; }
    public String getItemName() { return name; }
    public String getItemType() { return type; }
    public String getItemColor() { return color; }

    //SETTER METHODS
    public  void setItemID(int given_id)
    {
        this.id = given_id;
    }
    public void setItemName(String given_name)
    {
        this.name = given_name;
    }

    public void setItemType(String given_type)
    {
        this.type = given_type;
    }

    public void setItemColor(String given_color)
    {
        this.color = given_color;
    }
}