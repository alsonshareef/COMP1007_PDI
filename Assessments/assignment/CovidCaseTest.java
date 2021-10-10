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

        System.out.println();

        // Mutate Default Covid Case
        defaultCovidCase.setCountry("Australia");
        defaultCovidCase.setProvince("Perth");
        defaultCovidCase.setRegion("WA");
        defaultCovidCase.setAgeGroup("89-99");
        defaultCovidCase.setSex("F");
        defaultCovidCase.setCases(69);
        defaultCovidCase.setDate(4,10,3000);

        System.out.println("Default Covid Case COUNTRY: " + defaultCovidCase.getCountry());
        System.out.println("Default Covid Case PROVINCE: " + defaultCovidCase.getProvince());
        System.out.println("Default Covid Case REGION: " + defaultCovidCase.getRegion());
        System.out.println("Default Covid Case AGE GROUP: " + defaultCovidCase.getAgeGroup());
        System.out.println("Default Covid Case SEX: " + defaultCovidCase.getSex());
        System.out.println("Default Covid Case CASES: " + defaultCovidCase.getCases());
        System.out.println("Default Covid Case DATE: " + defaultCovidCase.getDate().toString());

        System.out.println();

        // Covid Case Param Consuctor
        CovidCase paramCovidCase = new CovidCase("United States", "New York", "East", "0-9", "F", 420, 5, 7, 1996);
        System.out.println("Default Covid Case COUNTRY: " + paramCovidCase.getCountry());
        System.out.println("Default Covid Case PROVINCE: " + paramCovidCase.getProvince());
        System.out.println("Default Covid Case REGION: " + paramCovidCase.getRegion());
        System.out.println("Default Covid Case AGE GROUP: " + paramCovidCase.getAgeGroup());
        System.out.println("Default Covid Case SEX: " + paramCovidCase.getSex());
        System.out.println("Default Covid Case CASES: " + paramCovidCase.getCases());
        System.out.println("Default Covid Case DATE: " + paramCovidCase.getDate().toString());

    }

}
