package src.model;

public class Store 
{
    //INSTANCE VARIABLES
    private int id;
    private String name;
    private String telephone;
    private Map operationHour;

    //CONSTRUCTOR 
    public Store(int id, String name, String telephone, Map operationHour) 
    {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.operationHour = openingHour;

    }

    //GETTER
    public int getStoreID() { return this.id; }
    public String getStoreName() { return this.name; }
    public String getStoreTelephone() { return this.telephone; }
    public 


    //SETTER
    public void setID(int id) 
    {
        this.id = id;
    }
    public void getStoreName(String name)
    { 
        this.name = name; 
    }
    public void getStoreTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
