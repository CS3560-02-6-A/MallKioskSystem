package src.model;

public class Store 
{
    //INSTANCE VARIABLES
    private int id;
    private String name;
    private String telephone;
    private OperationHour hours;

    //CONSTRUCTOR 
    public Store(int id, String name, String telephone, OperationHour hours) 
    {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.hours = hours;

    }

    //GETTER
    public int getStoreID() { return this.id; }
    public String getStoreName() { return this.name; }
    public String getStoreTelephone() { return this.telephone; }


    //SETTER
    public void setID(int id) 
    {
        this.id = id;
    }
    public void setStoreName(String name)
    { 
        this.name = name; 
    }
    public void getStoreTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
