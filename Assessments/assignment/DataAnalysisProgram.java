/**
* FILE: DataAnalysisProgram
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: Track the goals scored by 3 players for 5 of their matches
* REFERENCES: None
* DATE CREATED: 11/09/2021
*/

import java.util.*;
import java.io.*;

public class DataAnalysisProgram
{
    public static void main(String [] args)
    {
        // Declarations for main program variables
        String testCsvFileName = "COVID19BE_CASES_TESTDATA.csv";
        String csvFileName = "COVID19BE_CASES.csv";

        Scanner input = new Scanner(System.in);

        String [] csvRowStrings;
        CovidCase [] covidCases;

        int menuOption1;
        int menuOption2;
        int menuOption3;

        boolean validInput1;
        boolean validInput2;
        boolean validInput3;

        /* [1] - On file open, read CSV file and parse data into array of arrays of
                 useable data */
        csvRowStrings = getCsvRowStrings("COVID19BE_CASES.csv");
        //csvRowStrings = getCsvRowStrings("COVID19BE_CASES_TESTDATA.csv");

        /* [2] - After creating string representations of each csv row and
                 storing them in an array, parse each string for useable data,
                 and use that data to generate a new array of Covid Case 
                 objects representing the data of each CSV row */
        covidCases = processRowsToObjects(csvRowStrings);
        //System.out.println("Covid Case array length: " + covidCases.length);

        int arrRow = 101112;
        int csvRow = arrRow + 2;

        //System.out.println("---------------- DATA FOR CSV ROW: " + csvRow + " ----------------");
        //System.out.println(covidCases[arrRow].toString());

        /* [3] - Now that array of Covid Case objects has been created, 
                 the following menu system will start for user to select 
                 options to display different sets of statistics based on the 
                 covid cases */
        do
        {
            // Greeting
            System.out.println("Welcome to the COVID-19 Data Analysis Program." + 
            " Make a selection from the menu below regarding the information" + 
                                                    " you would like to see.");
            System.out.println();
        
            // Display Menu 1
            System.out.println(" - SELECT FROM THE FOLLOWING - ");            
            System.out.println("> [1] Statistics of entire nation.");            
            System.out.println("> [2] Statistics of entire nation.");            
            System.out.println("> [3] Statistics of entire nation.");
            System.out.print("Your choice: ");
           
            menuOption1 = 0; 
            do
            {
                validInput1 = false;
                try
                {
                    menuOption1 = input.nextInt();            
                }
                catch(Exception e)
                {
                    System.out.println("Did not enter an number. Please try again.");
                }
            }
            while(validInput1 != true);
            
            System.out.println();
        }
        while (menuOption1 != 3);
        
        /* [4] - Safely close program */
        input.close();
        System.exit(0);
    }

/*****************************************************************************
* METHOD: getCsvRowStrings
* IMPORTS: pFileName (String)
* EXPORTS: csvRowArray (Array)
* ASSERTION: Reads CSV file and returns array of each row as a string
******************************************************************************/
    public static String [] getCsvRowStrings(String pFileName) 
    {
        FileInputStream fs = null;
        InputStreamReader reader;
        BufferedReader br;
        int rowNum;
        rowNum = 0;
        String line;
        String [] csvRowArray;

        /* FIRST READ: Dynamically determine amount of rows to set to the 
                       length of csvRowArray */
        try 
        {
            fs = new FileInputStream(pFileName);
            reader = new InputStreamReader(fs);
            br = new BufferedReader(reader);
            line = br.readLine();
           
            // Calculate number of rows in CSV file 
            while (line != null)
            {
                rowNum++;
                line = br.readLine();
            }
            
            // Close stream after first read
            fs.close();
        }
        catch(IOException errorDetails) 
        {
            if(fs != null) 
            {
                try 
                {
                    fs.close();
                }
                catch(IOException ex2) 
                { 
                    System.out.println("Error with closing input stream for" + 
                                    " first file read: " + ex2.getMessage());
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
        
        csvRowArray = new String[rowNum];

        /* SECOND READ: After dynamically setting the array length, 
                        reset the filestream, stream reader and buffered reader
                        to read the same file again for assigning the string 
                        representation of each line to the arraw*/
        try
        {
            fs = new FileInputStream(pFileName);
            reader = new InputStreamReader(fs);
            br = new BufferedReader(reader);
            rowNum = 0;
            line = br.readLine();

            // Assign string version of each csv row to array
            while (line != null)
            {
                csvRowArray[rowNum] = line;
                rowNum++;
                line = br.readLine();
            }
            
            // Close stream after second read
            fs.close();
        }
        catch(IOException errorDetails) 
        {
            if(fs != null) 
            {
                try 
                {
                    fs.close();
                }
                catch(IOException ex2) 
                { 
                    System.out.println("Error with closing input stream for" + 
                                    " second file read: " + ex2.getMessage());
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }

        /* After creating array of csv row strings, return array to be used 
                                                to create Covid Case objects */
        return csvRowArray;
    }

/*****************************************************************************
* METHOD: processRowsToObjects
* IMPORTS: csvRow (String)
* EXPORTS: covidCases (Array)
* ASSERTION: Returns array of Covid Case objects based on data from CSV rows strings
******************************************************************************/
    private static CovidCase [] processRowsToObjects(String [] csvRows)
    {
        String[] csvRowSplit;
        CovidCase [] covidCases;

        String day = "";
        String month = "";
        String year = "";
        String country = "";
        String province = "";
        String region = "";
        String ageGroup = "";
        String sex = "";
        String cases = "";

        int dayInt = 0;
        int monthInt = 0;
        int yearInt = 0;
        int casesInt = 0;
        int csvRowNum = 0;

        covidCases = new CovidCase[csvRows.length - 1];
            
        for(int rowNum = 0; rowNum < csvRows.length; rowNum++)
        {
            if (rowNum == 0)
            {
                continue;
            }

            csvRowSplit = csvRows[rowNum].split(",");

            for(int j = 0; j < csvRowSplit.length; j++)
            {
                day = csvRowSplit[0];
                month = csvRowSplit[1];
                year = csvRowSplit[2];
                country = csvRowSplit[3];
                province = csvRowSplit[4];
                region = csvRowSplit[5];
                ageGroup = csvRowSplit[6];
                sex = csvRowSplit[7];
                cases = csvRowSplit[8];

                                
                // TURN DAY STRING INTO INT
                try
                {
                    dayInt = Integer.parseInt(day);
                    
                }
                catch(NumberFormatException numEx)
                {
                    System.out.println(numEx);
                    System.out.println("Could not turn day string '" + day + "' to integer.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception: " + e);
                }

                // TURN MONTH STRING INTO INT
                try
                {
                    monthInt = Integer.parseInt(month);
                    
                }
                catch(NumberFormatException numEx)
                {
                    System.out.println(numEx);
                    System.out.println("Could not turn month string '" + month + "' to integer.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception: " + e);
                }

                // TURN YEAR STRING INTO INT
                try
                {
                    yearInt = Integer.parseInt(year);
                    
                }
                catch(NumberFormatException numEx)
                {
                    System.out.println(numEx);
                    System.out.println("Could not turn year string '" + year + "' to integer.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception: " + e);
                }

                // TURN CASES STRING INTO INT
                try
                {
                    casesInt = Integer.parseInt(cases);
                    
                }
                catch(NumberFormatException numEx)
                {
                    System.out.println(numEx);
                    System.out.println("Could not turn cases string '" + cases + "' to integer.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception: " + e);
                }
                
            }
            // NOW CREATE OBJECTS
            try
            {
                covidCases[rowNum-1] = new CovidCase(country, province, region, ageGroup, sex, casesInt, dayInt, monthInt, yearInt);
            }
            catch(Exception e)
            {
                csvRowNum = rowNum + 1;
                System.out.println("processStringToObjects Method: Unable to" + 
        " turn data from CSV file row " + csvRowNum + " to Covid Case object");
                System.out.println(e);
                System.out.println();
            }
        }
        return covidCases;
    }
}
