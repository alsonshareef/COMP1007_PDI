import java.util.*;

public class CovidCaseTest
{
    public static void main(String[] args)
    {
        // Default Covid Case
        CovidCase defaultCovidCase = new CovidCase();
        System.out.println("Default Covid Case COUNTRY: " + defaultCovidCase.getCountry());
        System.out.println("Default Covid Case PROVINCE: " + defaultCovidCase.getProvince());
        System.out.println("Default Covid Case REGION: " + defaultCovidCase.getRegion());
        System.out.println("Default Covid Case AGE GROUP: " + defaultCovidCase.getAgeGroup());
        System.out.println("Default Covid Case SEX: " + defaultCovidCase.getSex());
        System.out.println("Default Covid Case CASES: " + defaultCovidCase.getCases());
        System.out.println("Default Covid Case DATE: " + defaultCovidCase.getDate().toString());

    }

}
