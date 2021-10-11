/**
* FILE: CovidCase.java
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: A class designed to build CovidCase objects which store data 
           relating to covid cases
* REFERENCES: None
* DATE CREATED: 10/10/2021
*/

import java.util.*;

public class CovidCase
{
    // *******************************************************************
    // CLASS FIELDS
    // *******************************************************************

    private String country;
    private String province;
    private String region;
    private String ageGroup;
    private String sex;
    private int cases;
    private Date date;

    // *******************************************************************
    // CONSTRUCTOR WITH PARAMETERS
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: With Parameters
    * IMPORTS: pCountry (String), pProvince (String), pRegion (String),
               pAgeGroup (String), pSex (String), pCases (Integer),
               pDay (Integer), pMonth (Integer), pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Create CovidCase object with values received from user
    **********************************************************************/
    public CovidCase (String pCountry, String pProvince, String pRegion,
                      String pAgeGroup, String pSex, int pCases,
                      int pDay, int pMonth, int pYear)
    {
        /* Invoke setter methods and Date constructor method to validate 
           and assign class fields with user inputs retrieved from 
           constructor parameters */
        setCountry(pCountry);
        setProvince(pProvince);
        setRegion(pRegion);
        setAgeGroup(pAgeGroup);
        setSex(pSex);
        setCases(pCases);
        date = new Date (pDay, pMonth, pYear);
    }

    // *******************************************************************
    // COPY CONSTRUCTOR
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: Copy
    * IMPORTS: pCovidCase (CovidCase)
    * EXPORTS: None
    * ASSERTION: Create copy of imported CovidCase object
    **********************************************************************/
    public CovidCase (CovidCase pCovidCase)
    {
        country = pCovidCase.getCountry();
        province = pCovidCase.getProvince();
        region = pCovidCase.getRegion();
        ageGroup = pCovidCase.getAgeGroup();
        sex = pCovidCase.getSex();
        cases = pCovidCase.getCases();
        date = pCovidCase.getDate();
    }    

    // *******************************************************************
    // DEFAULT CONSTRUCTOR
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: Default
    * IMPORTS: None
    * EXPORTS: None
    * ASSERTION: Creates CovidCase object with default values
    **********************************************************************/
    public CovidCase ()
    {
        country = "Belgium";
        province = "Brussels";
        region = "Flanders";
        ageGroup = "20-29";
        sex = "M";
        cases = 10;
        date = new Date(29,2,2020);
    }

    // *******************************************************************
    // ACCESSOR METHODS (GETTERS)
    // *******************************************************************

    /*********************************************************************
    * ACCESSOR: getCountry
    * IMPORTS: None
    * EXPORTS: country (String)
    * ASSERTION: Returns string representing the country of covid case
    **********************************************************************/
    public String getCountry()
    {
        return country;
    }
    
    /*********************************************************************
    * ACCESSOR: getProvince
    * IMPORTS: None
    * EXPORTS: province (String)
    * ASSERTION: Returns string representing the province of covid case
    **********************************************************************/
    public String getProvince()
    {
        return province;
    }
    
    /*********************************************************************
    * ACCESSOR: getRegion
    * IMPORTS: None
    * EXPORTS: region (String)
    * ASSERTION: Returns string representing the region of covid case
    **********************************************************************/
    public String getRegion()
    {
        return region;
    }

    /*********************************************************************
    * ACCESSOR: getAgeGroup
    * IMPORTS: None
    * EXPORTS: ageGroup (String)
    * ASSERTION: Returns string representing the age group of covid case
    **********************************************************************/
    public String getAgeGroup()
    {
        return ageGroup;
    }
    
    /*********************************************************************
    * ACCESSOR: getSex
    * IMPORTS: None
    * EXPORTS: sex (String)
    * ASSERTION: Returns string representing the sex of covid case
    **********************************************************************/
    public String getSex()
    {
        return sex;
    }
    
    /*********************************************************************
    * ACCESSOR: getCases
    * IMPORTS: None
    * EXPORTS: cases (Integer)
    * ASSERTION: Returns integer representing the amount of covid cases
    **********************************************************************/
    public int getCases()
    {
        return cases;
    }

    /*********************************************************************
    * ACCESSOR: getDate
    * IMPORTS: None
    * EXPORTS: date (Date)
    * ASSERTION: Returns object representing the date the covid cases were found
    **********************************************************************/
    public Date getDate()
    {
        /* Return copy of 'date' object to avoid unwanted mutation of 
                                                    original 'date' object */
        return new Date(date);
    }

    /*********************************************************************
    * ACCESSOR: toString
    * IMPORTS: None
    * EXPORTS: covidCaseString (String)
    * ASSERTION: Returns string representation of the state of covid case object
    **********************************************************************/
    public String toString()
    {
        String covidCaseString = "COVID CASE DETAILS" + "\n"
                                + "Country: " + country + "\n"
                                + "Province: " + province + "\n" 
                                + "Region: " + region + "\n"
                                + "Age Group: " + ageGroup + "\n"
                                + "Sex: " + sex + "\n"
                                + "Cases: " + cases + "\n"
                                + "Covid Case " + date.toString();
        return covidCaseString;
    }

    /*********************************************************************
    * ACCESSOR: equals
    * IMPORTS: inObject (Object)
    * EXPORTS: isEqual (Boolean)
    * ASSERTION: Returns boolean representing if the two object are equal
    **********************************************************************/
    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        CovidCase inCovidCase = null;
        if(inObject instanceof CovidCase)
        {
            inCovidCase = (CovidCase)inObject;
                if(country == inCovidCase.getCountry())
                    if(province == inCovidCase.getProvince())
                        if(region == inCovidCase.getRegion())
                            if(ageGroup == inCovidCase.getAgeGroup())
                                if(sex == inCovidCase.getSex())
                                    if(cases == inCovidCase.getCases())
                                        if(date.equals(inCovidCase.getDate()))
                                            isEqual = true;
        }
        return isEqual;
    }

    // *******************************************************************
    // MUTATOR METHODS (SETTERS)
    // *******************************************************************

    /*********************************************************************
    * MUTATOR: setCountry
    * IMPORTS: pCountry (String)
    * EXPORTS: None
    * ASSERTION: Value of country attribute will be updated to pCountry
    **********************************************************************/
    public void setCountry (String pCountry)
    {
        country = pCountry;
    }

    /*********************************************************************
    * MUTATOR: setProvince
    * IMPORTS: pProvince (String)
    * EXPORTS: None
    * ASSERTION: Value of province attribute will be updated to pProvince
    **********************************************************************/
    public void setProvince (String pProvince)
    {
        province = pProvince;
    }    

    /*********************************************************************
    * MUTATOR: setRegion
    * IMPORTS: pRegion (String)
    * EXPORTS: None
    * ASSERTION: Value of region attribute will be updated to pRegion
    **********************************************************************/
    public void setRegion (String pRegion)
    {
        region = pRegion;
    }

    /*********************************************************************
    * MUTATOR: setAgeGroup
    * IMPORTS: pAgeGroup (String)
    * EXPORTS: None
    * ASSERTION: Value of ageGroup attribute will be updated to pAgeGroup
    **********************************************************************/
    public void setAgeGroup (String pAgeGroup)
    {
        ageGroup = pAgeGroup;
    }

    /*********************************************************************
    * MUTATOR: setSex
    * IMPORTS: pSex (String)
    * EXPORTS: None
    * ASSERTION: Value of sex attribute will be updated to pMonth
    **********************************************************************/
    public void setSex (String pSex)
    {
        sex = pSex;
    }    

    /*********************************************************************
    * MUTATOR: setCases
    * IMPORTS: pCases (Integer)
    * EXPORTS: None
    * ASSERTION: Value of cases attribute will be updated to pCases
    **********************************************************************/
    public void setCases (int pCases)
    {
        cases = pCases;
    }

    /*********************************************************************
    * MUTATOR: setDate
    * IMPORTS: pDay (Integer), pMonth (Integer), pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of date attribute will be updated to Date object with 
                 attribute values being equal to pDay, pMonth and pYear
    **********************************************************************/
    public void setDate (int pDay, int pMonth, int pYear)
    {
        date = new Date(pDay, pMonth, pYear);
    }

    // *******************************************************************
    // DOING METHODS (PUBLIC)
    // *******************************************************************
    

    
    // *******************************************************************
    // INTERNAL METHODS (PRIVATE)
    // *******************************************************************

}
