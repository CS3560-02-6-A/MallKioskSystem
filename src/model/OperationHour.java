import java.util.HashMap;
import java.util.Map;

public class OperationHour
{
    //INSTANCE VARIBLES
    private Map storeHoursList;

    //CONSTRUCTOR
    public OpeningHour
    {
        Map<String, String> storeHoursList = new HashMap<>();
    }

    //INSTANCE METHODS
    public addDateHour(DateHour givenDateHour)
    {
        storeHoursList.put(givenDateHour.getDayOfWeek(), givenDateHour.getTime());
    }

    public addAListOfDataHour(List listDateHour)
    {
        for(DateHour e: listDateHour)
        {
            storeHourList.put(e.getDayOfWeek(), givenDateHour.getTime());
        }
    }

    public String printOperationHour()
    {
        return 
    }


}