import java.util.*;

public class CovidCaseTest
{
    public static void main(String[] args)
    {
        // [TEST 1]: CREATE COVID CASE USING DEFAULT CONSTRUCTOR
        CovidCase defaultCovidCase = new CovidCase();
        System.out.println("Default Covid Case: " + defaultCovidCase.toString());
        System.out.println();

        // [TEST 2]: CREATE SECOND DEFAULT COVID CASE WITH COPY CONSTRUCTOR
        CovidCase copyDefaultCovidCase = new CovidCase();
        System.out.println("Copy of Default Covid Case: " + copyDefaultCovidCase.toString());
        System.out.println();

        // [TEST 3]: CHECK IF DEFAULT AND COPY DEFAULT ARE EQUAL
        if (defaultCovidCase.equals(copyDefaultCovidCase))
        {
            System.out.println("defaultCovidCase IS equal to copyDefaultCovidCase");
        }
        else
        {
            System.out.println("defaultCovidCase IS NOT equal to copyDefaultCovidCase");
        }
        System.out.println();

        // [TEST 4]: TRY CREATE COVID CASE WITH PARAM CONSTRUCTOR
        System.out.println("********* TRY CREATE COVID CASE WITH PARAM CONSTRUCTOR *********");
        System.out.println();
        try
        {
            CovidCase paramCC = new CovidCase(null, null, null, "30-39", "F", 6, 29, 2, 2000);
            System.out.println();
            System.out.println("Successfully created CovidCase object with param constructor");
            System.out.println();
            System.out.println(paramCC.toString());
        }
        catch (Exception error)
        {
            System.out.println("NOT ABLE TO CREATE COVID CASE OBJECT BECAUSE: " + error);
        }    
        System.out.println();

        // [TEST 5]: CREATE COVID CASE WITH PARAMS, MUTATE CLASS FIELDS TO DEFAULT AND CHECK IF EQUAL TO DEFAULT OBJECT
        try
        {
            System.out.println("********* MUTATING PARAMCC TO DEFAULT STATE *********");
            CovidCase paramCC = new CovidCase(null, null, null, "30-39", "F", 16, 29, 2, 2000);
            System.out.println();
            System.out.println("Original param Covid Case state: " + paramCC.toString());
            System.out.println();
            paramCC.setCountry("Belgium");
            paramCC.setProvince("Antwerpen");
            paramCC.setRegion("Flanders");
            paramCC.setAgeGroup("40-49");
            paramCC.setSex("M");
            paramCC.setCases(5);
            paramCC.setDate(1,1,2011);
            System.out.println();
            System.out.println("Mutated param Covid Case state: " + paramCC.toString());
            
            System.out.println();

            if(copyDefaultCovidCase.equals(paramCC))
            {
                System.out.println("paramCC WAS SUCCESSFULLY mutated to default state");
            }
            else
            {
                System.out.println("paramCC WAS NOT mutated to default state");
            }
        }
        catch (Exception error)
        {
            System.out.println("NOT ABLE TO CREATE COVID CASE OBJECT BECAUSE: " + error);
        }    
        System.out.println();       
    }
}
