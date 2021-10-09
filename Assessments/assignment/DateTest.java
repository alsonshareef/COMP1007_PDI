import java.util.*;

public class DateTest
{
    public static void main(String[] args)
    {
        // Default Date
        Date defaultDate = new Date();
        System.out.println("Default day of month: " + defaultDate.getDayOfMonth());
        System.out.println("Default month of year: " + defaultDate.getMonthOfYear());
        System.out.println("Default year: " + defaultDate.getYear());
        System.out.println("Default Date String: " + defaultDate.toString());

        System.out.println();

        // Mutate Default Date
        defaultDate.setDayOfMonth(2);
        defaultDate.setMonthOfYear(12);
        defaultDate.setYear(2021);
        System.out.println("MUTATED Default Date String: " + defaultDate.toString());

        System.out.println();

        // Date constructed with params
        Date paramDate = new Date(29,2,2004);
        System.out.println("PARAM CONSTRUCTED Date String: " + paramDate.toString());
    }
}
