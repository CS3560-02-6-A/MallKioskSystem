package src.model;

public class Store 
{
    //INSTANCE VARIABLES
    private int storeID;
    private String name;
    private String telephone;
    private OperationHour hours;

    //CONSTRUCTOR 
    public Store(int id, String name, String telephone, OperationHour hours) 
    {
        this.storeID = id;
        this.name = name;
        this.telephone = telephone;
        this.hours = hours;
    }

    //GETTER
    public int getStoreID() 
    { 
        return this.storeID; 
    }
    public String getStoreName() 
    { 
        return this.name; 
    }
    public String getStoreTelephone() 
    { 
        return this.telephone;
    }
    public OperationHour getHours()
    {
        return this.hours;

    }


    //SETTER
    public void setID(int id) 
    {
        this.storeID = id;
    }
    public void setStoreName(String name)
    { 
        this.name = name; 
    }
    public void setStoreTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
