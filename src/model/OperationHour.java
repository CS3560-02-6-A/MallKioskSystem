package src.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class OperationHour
{
    //INSTANCE VARIBLES
    private Map<String, String> storeHoursList;

    //CONSTRUCTOR
    public OperationHour()
    {
        this.storeHoursList = new HashMap<>();
    }

    //INSTANCE METHODS
    public void addDateHour(DateHour givenDateHour)
    {
        storeHoursList.put(givenDateHour.getDayOfWeek(), givenDateHour.getTime());
    }

    public void addAListOfDataHour(List<DateHour> listDateHour)
    {
        for(DateHour e: listDateHour)
        {
            storeHoursList.put(e.getDayOfWeek(), e.getTime());
        }
    }

    public String printOperationHour()
    {
        return storeHoursList.toString();
    }

};
    