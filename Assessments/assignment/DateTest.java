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
        System.out.println("Default " + defaultDate.toString());

        System.out.println();

        defaultDate.setDayOfMonth(433);
        defaultDate.setMonthOfYear(422);
        defaultDate.setYear(44443);

        System.out.println("Mutated default: " + defaultDate.toString());
/*
        // Copy of Default
        Date copyDefaultDate = new Date(defaultDate);
        System.out.println("Copy Default day of month: " + copyDefaultDate.getDayOfMonth());
        System.out.println("Copy Default month of year: " + copyDefaultDate.getMonthOfYear());
        System.out.println("Copy Default year: " + copyDefaultDate.getYear());
        System.out.println("Copy Default " + copyDefaultDate.toString());      

        System.out.println();

        // Check if default and copy default are equal
        if(defaultDate.equals(copyDefaultDate))
        {
            System.out.println("defaultDate IS equal to copyDefaultDate");
        }
        else
        {
            System.out.println("defaultDate IS NOT equal to copyDefaultDate");
        } 
        
        System.out.println();

        // Date created with Param Constructor
        Date paramDate = new Date(3,9,1995);
        System.out.println();
        System.out.println("Param day of month: " + paramDate.getDayOfMonth());
        System.out.println("Param month of year: " + paramDate.getMonthOfYear());
        System.out.println("Param year: " + paramDate.getYear());
        System.out.println("Param " + paramDate.toString());

        System.out.println();

        // Check if paramDate and copyDefault are equal
        if(paramDate.equals(copyDefaultDate))
        {
            System.out.println("paramDate IS equal to copyDefaultDate");
        }
        else
        {
            System.out.println("paramDate IS NOT equal to copyDefaultDate");
        } 
        
        System.out.println();

        // Mutate paramDate to defaultDate
        paramDate.setDayOfMonth(1);        
        paramDate.setMonthOfYear(1);        
        paramDate.setYear(1111);        
        System.out.println();
        System.out.println("Mutated Param " + paramDate.toString());

        System.out.println();

        // Check if mutated paramDate and defaultDate are equal
        if(paramDate.equals(defaultDate))
        {
            System.out.println("MUTATED paramDate IS equal to copyDefaultDate");
        }
        else
        {
            System.out.println("MUTATED paramDate IS NOT equal to copyDefaultDate");
        }
*/
    }
}
