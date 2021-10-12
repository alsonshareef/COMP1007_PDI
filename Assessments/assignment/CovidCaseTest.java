import java.util.*;

public class CovidCaseTest
{
    public static void main(String[] args)
    {
/*
        // Default Covid Case
        CovidCase defaultCovidCase = new CovidCase();
        System.out.println(defaultCovidCase.toString());
        System.out.println();

        // Second Default
        CovidCase secondDefaultCovidCase = new CovidCase();
        System.out.println(secondDefaultCovidCase.toString());
        System.out.println();

        defaultCovidCase.setDate(43,3,2019);
        secondDefaultCovidCase.setDate(13,3,2019);

        System.out.println();

        System.out.println(defaultCovidCase.toString());

        System.out.println();

        System.out.println(secondDefaultCovidCase.toString());

        System.out.println();

        // Equals
        if (defaultCovidCase.equals(secondDefaultCovidCase))
        {
            System.out.println("Both covid cases ARE equal");
        }
        else
        {
            System.out.println("Both covid cases ARE NOT equal");
        }
*/

        // CovidCase created with param constructor
        System.out.println("*** CREATE COVID CASES ***");
        String [] ageGroupArray = {"0-9", "10-19", "20-29", "20-29", "30-39", "40-49", "60-69", "60-69", "90+"};
        String [] sexArray = {"M", "F", null, "F", null, "M", "F", "M", null};
        int [] casesArray = {1, 2, 3, 4, -3, 5, 6, 7, 8};
        CovidCase [] covidCases;
        covidCases = new CovidCase[9];        
        
        try
        {
            CovidCase testCC = new CovidCase(null, null, null, "90+", "M", 5, 3, 9, 1995);
            System.out.println();
            System.out.println(testCC.toString());
        }
        catch (Exception error)
        {
            System.out.println("NOT ABLE TO CREATE COVID CASE OBJECT BECAUSE: " + error.getMessage());
        }

        for (int i = 0; i < 9; i++)
        {
            try
            {
                covidCases[i] = new CovidCase("pCountry", "pProvince", "pRegion", ageGroupArray[i], sexArray[i], casesArray[i], 29, 2, 2000);
            }
            catch (Exception e)
            {
                System.out.println("COULD NOT CREATE OBJECT BECAUSE: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("*** FINISHED CREATING COVID CASES ***");
        System.out.println();

        System.out.println("*** DISPLAY COVID CASE STATES ***");
        for (int i = 0; i < 9; i++)
        {
            try
            {
                System.out.println(covidCases[i].toString());
                System.out.println();
            }
            catch (Exception e)
            {
                System.out.println("FAILED TO GET STATE DETAILS OF NULL OBJECT");
                System.out.println(e);
                System.out.println();
            }
        }

        System.out.println("*** FINISH DISPLAYING COVID CASE STATES ***");
        // Length of array
        System.out.println("*************************************");
        System.out.println("Total length of covid cases array is: " + covidCases.length);
        System.out.println();

        try
        {
            covidCases[1].setDate(10,12,2012);
            System.out.println(covidCases[1].getDate());
        }
        catch(Exception e)
        {
            System.out.println("Cannot get date for Covid Case 1");
        }
        System.out.println();
        System.out.println(covidCases[3].toString());
    }
}
