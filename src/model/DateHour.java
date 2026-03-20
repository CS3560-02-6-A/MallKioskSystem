public class DateHour
{
    //INSTANCE VARIABLES
    private String dayOfWeek;
    private String time;

    //CONSTRCUTOR
    public DateHour(String givenDayOfWeek, String givenTime)
    {
        this.dayOfWeek = givenDayOfWeek;
        this.time = givenTime;
    }

    //INSTANCE METHODS
    //GETTER
    public String getDayOfWeek()
    {
        return this.dayOfWeek;
    }
    public String getTime()
    {
        return this.time;
    }
    //SETTER
    public void setDayOfWeek(String day) // ex: Wed
    {
        this.dayOfWeek = day;
    }
    pubic void setTime(String time) //ex: 10am-12pm
    {
        this.time = time;
    }

}