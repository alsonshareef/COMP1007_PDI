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
                      int pDay, int pMonth, int pYear) throws Exception
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
        province = "Antwerpen";
        region = "Flanders";
        ageGroup = "40-49";
        sex = "M";
        cases = 5;
        date = new Date();
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
        if (isNull(pCountry))
        {            
            country = "NA";
        }
        else
        {
            country = pCountry;
        }
    }

    /*********************************************************************
    * MUTATOR: setProvince
    * IMPORTS: pProvince (String)
    * EXPORTS: None
    * ASSERTION: Value of province attribute will be updated to pProvince
    **********************************************************************/
    public void setProvince (String pProvince)
    {
        if (isNull(pProvince))
        {            
            province = "NA";
        }
        else
        {
            province = pProvince;
        }
    }    

    /*********************************************************************
    * MUTATOR: setRegion
    * IMPORTS: pRegion (String)
    * EXPORTS: None
    * ASSERTION: Value of region attribute will be updated to pRegion
    **********************************************************************/
    public void setRegion (String pRegion)
    {
        if (isNull(pRegion))
        {            
            region = "NA";
        }
        else
        {
            region = pRegion;
        }
    }

    /*********************************************************************
    * MUTATOR: setAgeGroup
    * IMPORTS: pAgeGroup (String)
    * EXPORTS: None
    * ASSERTION: Value of ageGroup attribute will be updated to pAgeGroup
    **********************************************************************/
    public void setAgeGroup (String pAgeGroup) throws Exception
    {
        if (isNull(pAgeGroup))
        {            
            ageGroup = "NA";
        }
        else
        {
            if (checkAgeGroup(pAgeGroup))
            { 
                ageGroup = pAgeGroup;
            } 
            else
            {
                throw new Exception("Data in Age Group category was invalid.");
            }
        }
    }

    /*********************************************************************
    * MUTATOR: setSex
    * IMPORTS: pSex (String)
    * EXPORTS: None
    * ASSERTION: Value of sex attribute will be updated to pMonth
    **********************************************************************/
    public void setSex (String pSex) throws Exception
    {
        if (isNull(pSex))
        {            
            sex = "NA";
        }
        else
        {
            if (checkSex(pSex))
            { 
                if (pSex.equals("M") || pSex.equals("m"))
                { 
                    sex = "M";
                }
                else if (pSex.equals("F") || pSex.equals("f"))
                {
                    sex = "F";
                }
                else
                {
                    sex = "NA";
                }
            } 
            else
            {
                throw new Exception("Data in Sex category was invalid.");
            }
        }
    }    

    /*********************************************************************
    * MUTATOR: setCases
    * IMPORTS: pCases (Integer)
    * EXPORTS: None
    * ASSERTION: Value of cases attribute will be updated to pCases
    **********************************************************************/
    public void setCases (int pCases) throws Exception
    {
            if (pCases > -1)
            { 
                cases = pCases;
            } 
            else
            {
                throw new Exception("Data in cases category was invalid.");
            }
    }

    /*********************************************************************
    * MUTATOR: setDate
    * IMPORTS: pDay (Integer), pMonth (Integer), pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of date attribute will be updated to Date object with 
                 attribute values being equal to pDay, pMonth and pYear
    **********************************************************************/
    public void setDate (int pDay, int pMonth, int pYear) throws Exception
    {
        try
        {
            date = new Date(pDay, pMonth, pYear);
        }
        catch(Exception e)
        {
            throw new Exception("Not able to create new Date object and" + 
                            " set to date class field in Covid Case object.");
        }
    }
    
    // *******************************************************************
    // INTERNAL METHODS (PRIVATE)
    // *******************************************************************

    /*********************************************************************
    * METHOD: isNull
    * IMPORTS: pString (String)
    * EXPORTS: notNull (Boolean)
    * ASSERTION: Returns boolean representing if pString is null
    **********************************************************************/
    private boolean isNull (String pString)
    {
        boolean nullCheck = false;
        if (pString == null)
        {
            nullCheck = true;
        }
        return nullCheck;
    }

    /*********************************************************************
    * METHOD: checkAgeGroup
    * IMPORTS: pAgeGroup (String)
    * EXPORTS: validAgeGroup (Boolean)
    * ASSERTION: Returns boolean representing if pAgeGroup is valid
    **********************************************************************/
    private boolean checkAgeGroup (String pAgeGroup)
    {
        boolean validAgeGroup = false;
        String ag = pAgeGroup;
        if (ag.equals("NA") || ag.equals("0-9") || ag.equals("10-19") || ag.equals("20-29") || ag.equals("30-39") 
            || ag.equals("40-49") || ag.equals("50-59") || ag.equals("60-69") || ag.equals("70-79")
                                             || ag.equals("80-89") || ag.equals("90+"))
        {
            validAgeGroup = true;
        }
        return validAgeGroup;
    }

    /*********************************************************************
    * METHOD: checkSex
    * IMPORTS: pSex (String)
    * EXPORTS: validSex (Boolean)
    * ASSERTION: Returns boolean representing if pSex is valid
    **********************************************************************/
    private boolean checkSex (String pSex)
    {
        boolean validSex = false;
        if (pSex.equals("NA") || pSex.equals("M") || pSex.equals("m") || pSex.equals("F") || pSex.equals("f"))
        {
            validSex = true;
        }
        return validSex;
    }
}
