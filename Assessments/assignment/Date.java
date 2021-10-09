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
    public Date (int pDay, int pMonth, int pYear)
    {
        /* Invoke setter methods to validate and assigned class fields with
                         user inputs retrieved from constructor parameters */
        setDayOfMonth(pDay);
        setMonthOfYear(pMonth);
        setYear(pYear);
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

    // *******************************************************************
    // MUTATOR METHODS (SETTERS)
    // *******************************************************************

    /*********************************************************************
    * MUTATOR: setDayOfMonth
    * IMPORTS: pDay (Integer)
    * EXPORTS: None
    * ASSERTION: Value of dayOfMonth attribute will be updated to pDay
    **********************************************************************/
    public void setDayOfMonth (int pDay)
    {
            dayOfMonth = pDay;
            System.out.println("Day of month has been successfully updated.");
    }

    /*********************************************************************
    * MUTATOR: setMonthOfYear
    * IMPORTS: pMonth (Integer)
    * EXPORTS: None
    * ASSERTION: Value of monthOfYear attribute will be updated to pMonth
    **********************************************************************/
    public void setMonthOfYear (int pMonth)
    {
            monthOfYear = pMonth;
            System.out.println("Month of year has been successfully updated.");
    }    

    /*********************************************************************
    * MUTATOR: setYear
    * IMPORTS: pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of year attribute will be updated to pYear
    **********************************************************************/
    public void setYear (int pYear)
    {
            year = pYear;
            System.out.println("Year has been successfully updated.");
    }

    // *******************************************************************
    // DOING METHODS (PUBLIC)
    // *******************************************************************
    
    /*********************************************************************
    * METHOD: toString
    * IMPORTS: None
    * EXPORTS: dateString (String)
    * ASSERTION: Returns string representation of the state of date object
    **********************************************************************/
    public String toString()
    {
        String dateString = "The date is " + dayOfMonth + "/" + monthOfYear + 
                                                                "/" + year;
        return dateString;
    }

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

}
