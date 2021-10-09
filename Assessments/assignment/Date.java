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
        /* Invoke setter methods to validate and assign class fields with
                         user inputs retrieved from constructor parameters */
        setYear(pYear);
        setMonthOfYear(pMonth);
        setDayOfMonth(pDay);
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
        int minDays = 1;
        int maxDays = 0;
        int m = monthOfYear;
        boolean leapYear = isLeapYear();
        
        /* Determine maximum days within the current month to know amount of valid days */
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            // Max possible days is 31 for any of these selected months.
            maxDays = 31;
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            // Max possible days is 30 for any of these selected months.
            maxDays = 30;
        }
        else if (m == 2)
        {
            if (leapYear)
            {
            // If month is February and it is a leap year, max days is 29.
                maxDays = 29;
            }
            else
            {
            // If month is February and it is NOT a leap year, max days is 28.
                maxDays = 28;
            }
        }
        
        /* Ensure user inputs a number between min and max days within current month*/
        if (pDay >= minDays && pDay <= maxDays)
        {
            dayOfMonth = pDay;
            System.out.println("Day of month has been successfully updated.");
        }
        else
        {
            System.out.println("You did not input a day that exists within this" 
                + " month. Please enter a day that exists within this month.");
        }
    }

    /*********************************************************************
    * MUTATOR: setMonthOfYear
    * IMPORTS: pMonth (Integer)
    * EXPORTS: None
    * ASSERTION: Value of monthOfYear attribute will be updated to pMonth
    **********************************************************************/
    public void setMonthOfYear (int pMonth)
    {
        /* Ensures that user inputs a number representing one of the 12 months */
        if (pMonth >= 1 && pMonth <= 12)
        {
            monthOfYear = pMonth;
            System.out.println("Month of year has been successfully updated.");
        }
        else
        {
            System.out.println("You did not input a valid month. Please enter a valid month.");
        }
    }    

    /*********************************************************************
    * MUTATOR: setYear
    * IMPORTS: pYear (Integer)
    * EXPORTS: None
    * ASSERTION: Value of year attribute will be updated to pYear
    **********************************************************************/
    public void setYear (int pYear)
    {
        /* Ensures that the user inputs a positive value to set as year */
        if (pYear > 0)
        {
            year = pYear;
            System.out.println("Year has been successfully updated.");
        }
        else
        {
            System.out.println("You did not input a valid year number." + 
                                                "Please enter a valid year.");
        }
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
