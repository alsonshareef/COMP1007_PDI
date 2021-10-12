/**
* FILE: Date.java
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: A class designed to build Date objects which store the day, month and 
           year of a particular date
* REFERENCES: None
* DATE CREATED: 09/10/2021
*/

import java.util.*;

public class Date
{
    // *******************************************************************
    // CLASS FIELDS
    // *******************************************************************

    private int dayOfMonth;
    private int monthOfYear;
    private int year;

    // *******************************************************************
    // CONSTRUCTOR WITH PARAMETERS
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: With Parameters
    * IMPORTS: pDay (Integer), pMonth (Integer), pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Create Date object with values received from user
    **********************************************************************/
    public Date (int pDay, int pMonth, int pYear) throws Exception
    {
        /* Invoke setter methods to validate and assign class fields with
                         user inputs retrieved from constructor parameters */
        setYear(pYear);
        setMonthOfYear(pMonth);
        if(checkMonth(pMonth))
        {
            if(checkDay(pDay, pMonth))
            {
                dayOfMonth = pDay;
            }
            else
            {
                throw new Exception("Day value passed to constructor is not " +
                             "valid given the month and/or year provided.");
            }
        }
    }

    // *******************************************************************
    // COPY CONSTRUCTOR
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: Copy
    * IMPORTS: pDate (Date)
    * EXPORTS: None
    * ASSERTION: Create copy of imported Date object
    **********************************************************************/
    public Date (Date pDate)
    {
        dayOfMonth = pDate.getDayOfMonth();
        monthOfYear = pDate.getMonthOfYear();
        year = pDate.getYear();
    }    

    // *******************************************************************
    // DEFAULT CONSTRUCTOR
    // *******************************************************************

    /*********************************************************************
    * CONSTRUCTOR: Default
    * IMPORTS: None
    * EXPORTS: None
    * ASSERTION: Creates Date object with default values
    **********************************************************************/
    public Date ()
    {
        dayOfMonth = 1;
        monthOfYear = 1;
        year = 1111;
    }

    // *******************************************************************
    // ACCESSOR METHODS (GETTERS)
    // *******************************************************************

    /*********************************************************************
    * ACCESSOR: getDayOfMonth
    * IMPORTS: None
    * EXPORTS: day (Integer)
    * ASSERTION: Returns integer representing the day within a month
    **********************************************************************/
    public int getDayOfMonth()
    {
        return dayOfMonth;
    }
    
    /*********************************************************************
    * ACCESSOR: getMonthOfYear
    * IMPORTS: None
    * EXPORTS: month (Integer)
    * ASSERTION: Returns integer representing the month
    **********************************************************************/
    public int getMonthOfYear()
    {
        return monthOfYear;
    }
    
    /*********************************************************************
    * ACCESSOR: getYear
    * IMPORTS: None
    * EXPORTS: year (Integer)
    * ASSERTION: Returns integer representing the year
    **********************************************************************/
    public int getYear()
    {
        return year;
    }

    /*********************************************************************
    * ACCESSOR: toString
    * IMPORTS: None
    * EXPORTS: dateString (String)
    * ASSERTION: Returns string representation of the state of date object
    **********************************************************************/
    public String toString()
    {
        String dateString = "Full date: " + dayOfMonth + "/" + monthOfYear + 
                                                                "/" + year;
        return dateString;
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
        Date inDate = null;
        if(inObject instanceof Date)
        {
            inDate = (Date)inObject;
            if (dayOfMonth == inDate.getDayOfMonth())
                if(monthOfYear == inDate.getMonthOfYear())
                    if(year == inDate.getYear())
                        isEqual = true;
        }
        return isEqual;
    }

    // *******************************************************************
    // MUTATOR METHODS (SETTERS)
    // *******************************************************************

    /*********************************************************************
    * MUTATOR: setDayOfMonth
    * IMPORTS: pDay (Integer)
    * EXPORTS: None
    * ASSERTION: Value of dayOfMonth attribute will be updated to pDay
    **********************************************************************/
    public void setDayOfMonth (int pDay) throws Exception
    {
        if(checkDay(pDay, monthOfYear))
        {
            dayOfMonth = pDay;
        }
        else
        {
            throw new Exception("Data in Day category was not valid.");
        }
    }

    /*********************************************************************
    * MUTATOR: setMonthOfYear
    * IMPORTS: pMonth (Integer)
    * EXPORTS: None
    * ASSERTION: Value of monthOfYear attribute will be updated to pMonth
    **********************************************************************/
    public void setMonthOfYear (int pMonth) throws Exception
    {
        if (checkMonth(pMonth))
        {
            monthOfYear = pMonth;
        }
        else
        {
            throw new Exception("Data in month category was not valid.");
        }
    }    

    /*********************************************************************
    * MUTATOR: setYear
    * IMPORTS: pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of year attribute will be updated to pYear
    **********************************************************************/
    public void setYear (int pYear) throws Exception
    {
        if (checkYear(pYear))
        {
            year = pYear;
        }
        else
        {
            throw new Exception("Data in year category was not valid.");
        }
    }

    // *******************************************************************
    // DOING METHODS (PUBLIC)
    // *******************************************************************

    /*********************************************************************
    * METHOD: isLeapYear
    * IMPORTS: None
    * EXPORTS: leapYearVal (Boolean)
    * ASSERTION: Returns a boolean value representating whether year is a leap year
    **********************************************************************/
    public boolean isLeapYear()
    {
        /* Can check if a year was a leap year if the year can be cleanly 
                                            divided by 4 with no remainder. */
        boolean leapYear = false;
        if (year % 4 == 0)
        {
            leapYear = true;
        }
        return leapYear;
    }

    // *******************************************************************
    // INTERNAL METHODS (PRIVATE)
    // *******************************************************************

    /*********************************************************************
    * METHOD: checkDay
    * IMPORTS: pDay (Integer), pMonth (Integer)
    * EXPORTS: validDay
    * ASSERTION: Returns boolean representing if day exists within given month
    **********************************************************************/
    private boolean checkDay (int pDay, int pMonth)
    {
        int minDays = 1;
        int maxDays = 0;
        int m = pMonth;
        boolean leapYear = isLeapYear();
        boolean validDay = false;
       
        /* 1. Determine maximum days within the current month to know amount of valid days */
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            // 1.a) Max possible days is 31 for any of these selected months.
            maxDays = 31;
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            // 1.b) Max possible days is 30 for any of these selected months.
            maxDays = 30;
        }
        else if (m == 2)
        {
            if (leapYear)
            {
                // 1.c) If month is February and it is a leap year, max days is 29.
                maxDays = 29;
            }
            else
            {
                // 1.d) If month is February and it is NOT a leap year, max days is 28.
                maxDays = 28;
            }
        } 
        

        /* 2. Ensure user inputs a number between min and max days within current month*/
        if (pDay >= minDays && pDay <= maxDays)
        {
            validDay = true;
        }
        return validDay;
    }

    /*********************************************************************
    * METHOD: checkMonth
    * IMPORTS: pMonth (Integer)
    * EXPORTS: validMonth
    * ASSERTION: Returns boolean representing whether month is valid
    **********************************************************************/
    private boolean checkMonth (int pMonth)
    {
        /* Ensures that user inputs a number representing one of the 12 months */
        boolean validMonth = false;
        if (pMonth >= 1 && pMonth <= 12)
        {
            validMonth = true;
        }
        return validMonth;
    }
    
    /*********************************************************************
    * METHOD: checkYear
    * IMPORTS: pYear (Integer)
    * EXPORTS: validYear
    * ASSERTION: Value of year attribute will be updated to pYear
    **********************************************************************/
    private boolean checkYear (int pYear)
    {
        /* Ensures that the user inputs a positive value to set as year */
        boolean validYear = false; 
        if (pYear > 0)
        {
            validYear = true;
        }
        return validYear; 
    }
}
