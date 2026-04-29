package src.model;

public class Item {

    //INSTANCE VARIABLES
    private int id;
    private String name;
    private String type;
    private String color;
    private String gender;
    private String occasion;

    //CONSTRUCTOR
    public Item(int id, String name, String type, String color, String gender, String occasion) 
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.gender = gender;
        this.occasion = occasion;
    }

    //GETTER METHODS
    public int getItemID() { return id; }
    public String getItemName() { return name; }
    public String getItemType() { return type; }
    public String getItemColor() { return color; }
    public String getGender() { return gender; }
    public String getOccasion() { return occasion; }

    //SETTER METHODS
    public void setItemID(int given_id)
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

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setOccasion(String occasion)
    {
        this.occasion = occasion;
    }
}