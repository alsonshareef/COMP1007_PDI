import java.util.*;

public class DateTest
{
    public static void main(String[] args)
    {
        // [TEST 1]: CREATE NEW DATE USING DEFAULT CONSTRUCTOR
        Date defaultDate = new Date();
        System.out.println("Default day of month: " + defaultDate.getDayOfMonth());
        System.out.println("Default month of year: " + defaultDate.getMonthOfYear());
        System.out.println("Default year: " + defaultDate.getYear());
        System.out.println("Default " + defaultDate.toString());
        System.out.println();


        // [TEST 2]: CREATE SECOND DEFAULT USING COPY CONSTRUCTOR
        Date copyDefaultDate = new Date(defaultDate);
        System.out.println("Copy Default day of month: " + copyDefaultDate.getDayOfMonth());
        System.out.println("Copy Default month of year: " + copyDefaultDate.getMonthOfYear());
        System.out.println("Copy Default year: " + copyDefaultDate.getYear());
        System.out.println("Copy Default " + copyDefaultDate.toString());      
        System.out.println();

        // [TEST 3]: CHECK IF DEFAULT AND COPY DEFAULT ARE EQUAL
        System.out.println("********* CHECK IF DEFAULT AND COPY ARE EQUAL *********");
        if(defaultDate.equals(copyDefaultDate))
        {
            System.out.println("defaultDate IS equal to copyDefaultDate");
        }
        else
        {
            System.out.println("defaultDate IS NOT equal to copyDefaultDate");
        } 
        System.out.println();


        // [TEST 4]: TRY CREATE DATE WITH PARAM CONSTRUCTOR
        System.out.println("********* TRY CREATE DATE WITH PARAM CONSTRUCTOR *********");
        try
        {
            Date paramDate = new Date(28,2, 2001);
            System.out.println("Param day of month: " + paramDate.getDayOfMonth());
            System.out.println("Param month of year: " + paramDate.getMonthOfYear());
            System.out.println("Param year: " + paramDate.getYear());
            System.out.println("Param " + paramDate.toString());
            System.out.println("Successfully create Date with param constructor");
        }
        catch (Exception error)
        {
            System.out.println("NOT ABLE TO CREATE DATE OBJECT BECAUSE: " + error);
        }
        System.out.println();

        // [TEST 5.1]: ENSURE A DATE CREATED WITH PARAM CONSTRUCTOR DOES NOT EQUAL DEFAULT
        System.out.println("********* CHECK IF PARAM DATE AND DEFAULT ARE EQUAL *********");
        System.out.println("The following check should return NOT EQUAL:");
        try
        {
            Date paramDate = new Date(29,2,2000);
            if(paramDate.equals(copyDefaultDate))
            {
                System.out.println("paramDate IS equal to copyDefaultDate");
            }
            else
            {
                System.out.println("paramDate IS NOT equal to copyDefaultDate");
            } 
        }
        catch(Exception error)
        {
            System.out.println("paramDate equals method did not work");
            System.out.println("EXCEPTION TYPE: " + error);
        }
        System.out.println();

        // [TEST 6]: MUTATE A DATE CONSTRUCTED WITH PARAM TO DEFAULT, AND CHECK IF EQUAL TO DEFAULT
        System.out.println("********* CHECK IF MUTATED PARAM CAN EQUAL DEFAULT *********");
        try
        {
            Date paramDate = new Date(3,9,2000);
            System.out.println("Original Param " + paramDate.toString());
            paramDate.setDayOfMonth(1);        
            paramDate.setMonthOfYear(1);        
            paramDate.setYear(1111);        
            System.out.println();
            System.out.println("Mutated Param " + paramDate.toString());

            System.out.println();

            if(paramDate.equals(defaultDate))
            {
                System.out.println("MUTATED paramDate IS equal to defaultDate");
            }
            else
            {
                System.out.println("MUTATED paramDate IS NOT equal to defaultDate");
            }
        }
        catch (Exception error)
        {
            System.out.println("paramDate equals method did not work");
            System.out.println("EXCEPTION TYPE: " + error);
        }
        System.out.println();

        // [EXTRA TEST]: CREATE ARRAY OF DATE OBJECTS AND CHECK IF INVALID CLASS FIELDS CREATE NULL OBJECTS
        System.out.println("********* CHECK IF ARRAY HAS NULL DATE OBJECTS IF INPUT TO CONSTRUCTORS ARE INVALID *********");
        // Create date objects array with different class fields.
        Date [] dateArray;
        int [] dayArray = {29, 29, 3, -6, 7, 17, 23, 4, 30, 4};
        int [] monthArray = {2, 2, 3, 6, 7, 17, 23, 4, 30, 12};
        int [] yearArray = {2000, 1995, 2001, 2021, 2013, 1990, 2005, 1967, 2000, 0};
        dateArray = new Date[10];
        
        for (int i = 0; i < 10; i++)
        {
            try
            {
                dateArray[i] = new Date(dayArray[i], monthArray[i], yearArray[i]);
            }
            catch (Exception error)
            {
                int objectNum = i + 1;
                System.out.println("EXCEPTION FOR DATE OBJECT " + objectNum + ": " + error.getMessage());
                System.out.println("Could not create date object due to invalid input data");
                System.out.println();
            }
        }

        System.out.println();

        // Try check state of every object
        for (int i = 0; i < 10; i++)
        {
            int objectNum = i + 1;
            try
            {
                System.out.println("State for Date object " + objectNum + ": " + dateArray[i].toString());
            }
            catch (Exception error)
            {
                System.out.println("Could not read state for object " + objectNum + " as object is null");
            }
            System.out.println();
        }
    }
}
