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

        defaultDate.setDayOfMonth(33);
        defaultDate.setMonthOfYear(3);
        defaultDate.setYear(4321);
        System.out.println("UPDATED Default day of month: " + defaultDate.getDayOfMonth());
        System.out.println("UPDATED Default month of year: " + defaultDate.getMonthOfYear());
        System.out.println("UPDATED Default year: " + defaultDate.getYear());

        System.out.println();

        // Param Constructor Date
        Date paramDate = new Date(69,420,3005);
        System.out.println("Param day of month: " + paramDate.getDayOfMonth());
        System.out.println("Param month of year: " + paramDate.getMonthOfYear());
        System.out.println("Param year: " + paramDate.getYear());

        paramDate.setDayOfMonth(3);
        paramDate.setMonthOfYear(9);
        paramDate.setYear(2020);
        System.out.println("UPDATED Param day of month: " + paramDate.getDayOfMonth());
        System.out.println("UPDATED Param month of year: " + paramDate.getMonthOfYear());
        System.out.println("UPDATED Param year: " + paramDate.getYear());
        System.out.println("Param date state in string form: " + paramDate.toString());
        System.out.println("Is param date a leap year? " + paramDate.isLeapYear());

    }
}
