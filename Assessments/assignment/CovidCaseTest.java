import java.util.*;

public class CovidCaseTest
{
    public static void main(String[] args)
    {
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
    }

}
