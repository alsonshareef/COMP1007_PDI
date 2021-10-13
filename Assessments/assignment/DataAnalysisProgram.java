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
        /* - [1] - On file open, read CSV file and parse data into array of arrays of
         useable data, and convert that data into an array of Covid Case
         objects representing the data in each row of CSV file for menu system
         to use to generate statistics based on user input */
        String testCsvFileName = "COVID19BE_CASES_TESTDATA.csv";
        String csvFileName = "COVID19BE_CASES.csv";
        String [] csvRowStrings;
        CovidCase [] covidCases;

        //csvRowStrings = getCsvRowStrings("COVID19BE_CASES.csv");
        csvRowStrings = getCsvRowStrings("COVID19BE_CASES_TESTDATA.csv");

        processRowsToObjects(csvRowStrings);

        /* - [2] - Now that array of Covid Case objects has been created, the following menu system will start for user to select options to display different sets of statistics based on the covid cases */
        
        /* - [3] - Safely close program */
        System.exit(0);
    }

/*****************************************************************************
* METHOD: readFile
* IMPORTS: pFileName (String)
* EXPORTS: None
* ASSERTION: Reads provided file line by line
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

        try 
        {
            /* FIRST READ: Dynamically determine amount of rows to set csvRowArray length to */
            fs = new FileInputStream(pFileName);
            reader = new InputStreamReader(fs);
            br = new BufferedReader(reader);
            line = br.readLine();
            
            while (line != null)
            {
                rowNum++;
                //System.out.println(line);
                line = br.readLine();
            }
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
                { }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
        
        csvRowArray = new String[rowNum];

        try
        {
            fs = new FileInputStream(pFileName);
            reader = new InputStreamReader(fs);
            br = new BufferedReader(reader);
            rowNum = 0;
            line = br.readLine();

            while (line != null)
            {
                csvRowArray[rowNum] = line;
                rowNum++;
                line = br.readLine();
            }
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
                { }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
        }
        
        //System.out.println(rowNum);
        return csvRowArray;
    }

/*****************************************************************************
* METHOD: processCSVLine
* IMPORTS: csvRow (String)
* EXPORTS: None
* ASSERTION: Parses string version of CSV line into useable data
******************************************************************************/
    private static void processRowsToObjects(String [] csvRows)
    {
        String[] csvRowSplit;
        CovidCase [] covidCases;
        String day;
        String month;
        String year;
        String country;
        String province;
        String region;
        String ageGroup;
        String sex;
        String cases;

        int dayInt = 0;
        int monthInt = 0;
        int yearInt = 0;
        int casesInt = 0;

        covidCases = new CovidCase[csvRows.length];
        System.out.println("CC length: " + covidCases.length);
            
        for(int i = 1; i < csvRows.length; i++)
        {
            csvRowSplit = csvRows[i].split(",");
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
               
                System.out.println(ageGroup); 
                System.out.println(ageGroup.equals("40-49"));

                // Day string to int
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

                // Day string to int
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

                // Day string to int
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

                // Day string to int
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
//-----------------------------------
                try
                {   
                    covidCases[i-1] = new CovidCase(country, province, region, "40-49", "M", casesInt, dayInt, monthInt, yearInt);              
                    System.out.println(covidCases[0].toString());
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println();
                }

            }
        }
    }

}
