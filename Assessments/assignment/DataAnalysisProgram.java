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
        // [1] Declarations for main program variables
        String testCsvFileName = "COVID19BE_CASES_TESTDATA.csv";
        String csvFileName = "COVID19BE_CASES.csv";

        String [] csvRowStrings = {};
        CovidCase [] covidCases = {};

        /* [2] On file open, read CSV file and parse data into array of strings of
               useable data. Can comment and un comment either lines below to
               use test csv of main csv file */
        try
        {
            csvRowStrings = getCsvRowStrings(csvFileName);
        }
        catch (Exception e)
        {
            System.out.println("I/O Error reading file in main: " + e.getMessage());
        }

        /* [3] - Create array of Covid Cases with row strings*/
        if (csvRowStrings.length > 0)
        {
            try
            {
                covidCases = processRowsToObjects(csvRowStrings);
            }
            catch(Exception e)
            {
                System.out.println("Error creating array of Covid Cases in main: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Error creating array of Covid Cases in main: No row of CSV strings array");
        }
        
        /* [4] - Feed Covid Cases array to menus for user to generate statistics */
        if (covidCases.length > 0)
        {
            greeting(); 
            mainMenu(covidCases);
        }
        else
        {
            System.out.println("Error in main: Could not begin program since valid data is not provided.");
        }
               
        /* [5] - When done generating stats, safely close program */
        System.exit(0);
    }

/*****************************************************************************
* METHOD: getCsvRowStrings
* IMPORTS: pFileName (String)
* EXPORTS: csvRowArray (Array)
* ASSERTION: Reads CSV file and returns array of each CSV row as a string
******************************************************************************/
    public static String [] getCsvRowStrings(String pFileName) throws IOException 
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
                    throw new IOException("Error with closing input stream for" + 
                                    " first file read: " + "\n" + ex2);
                }
            }
            throw new IOException("Error in fileProcessing for first read: " + "\n" + errorDetails);
        }

        // Assign csvRowArray length to number of rows in CSV File
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
                    throw new IOException("Error with closing input stream for" + 
                                    " second file read: " + "\n" + ex2);
                }
            }
            throw new IOException("Error in fileProcessing for second read: " + "\n" + errorDetails);
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
    private static CovidCase [] processRowsToObjects(String [] csvRows) throws Exception
    {
        // [1] Initialize variables
        String[] csvRowSplit;
        CovidCase [] covidCases = {};

        String day, month, year, country, province, region, ageGroup, sex, cases, errorMessage;
        day = month = year = country = province = region = ageGroup = sex = cases = errorMessage = "";

        int dayInt, monthInt, yearInt, casesInt, csvRowNum;
        dayInt = monthInt = yearInt = casesInt = csvRowNum = -1;

        /* [2] Assign length of the array that will store Covid Cases to 
               length of csvRows - 1, because we will not be using data in 
               the first row which stores column headers */
        covidCases = new CovidCase[csvRows.length - 1];
        
        // [3] Turn day, month, year and case values into integers
        for(int rowNum = 0; rowNum < csvRows.length; rowNum++)
        {
            // 3.1 Ignore first row of CSV file
            if (rowNum == 0)
            {
                continue;
            }

            // 3.2 Split the string into columns
            csvRowSplit = csvRows[rowNum].split(",");

            // 3.3 Extract data and assign to variables to pass to Covid Case constructor
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

                try
                {
                    dayInt = Integer.parseInt(day);
                    monthInt = Integer.parseInt(month);
                    yearInt = Integer.parseInt(year);
                    casesInt = Integer.parseInt(cases);
                }
                catch(NumberFormatException numError)
                {
                    errorMessage = "Issue with converting data from CSV row number " +
                                                 rowNum + " to integers" + "\n";
                    if (dayInt == -1)
                    {
                        errorMessage += "Day string could not be converted to dayInt" + "\n" + numError;
                    }
                    else if (monthInt == -1)
                    {
                        errorMessage += "Month string could not be converted to monthInt" + "\n" + numError;
                    }
                    else if (yearInt == -1)
                    {
                        errorMessage += "Year string could not be converted to yearInt" + "\n" + numError;
                    }
                    else
                    {
                        errorMessage += "Cases string could not be converted to casesInt" + "\n" + numError;
                    }

                    throw new NumberFormatException(errorMessage);
                }
                catch(Exception error)
                {
                    throw new Exception("General error with converting strings to ints: " + error);
                }
            }

            // 3.4 Pass extracted data into Covid Case class constructor and store in array
            try
            {
                covidCases[rowNum-1] = new CovidCase(country, province, region, ageGroup, sex, casesInt, dayInt, monthInt, yearInt);
            }
            catch(Exception e)
            {
                csvRowNum = rowNum + 1;
                throw new Exception("processStringToObjects Method: Unable to" + 
        " turn data from CSV file row " + csvRowNum + " to Covid Case object" + "\n" + e);
            }
        }
        return covidCases;
    }

/*****************************************************************************
* METHOD: generateSpecificStats
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: None
* ASSERTION: Generates statistics on Covid-19 cases based on user input
******************************************************************************/
    public static void generateSpecificStats(CovidCase [] covidCases, String statFilter)
    {
        int stats = 0;
        switch(statFilter)
        {
            // Total Number of Covid-19 Cases
            case "Total":
                int countryTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    countryTotal += covidCases[i].getCases();
                }
                stats = countryTotal;            
            break;

            // Total Number of Male Covid-19 Cases
            case "Male":
                int maleTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getSex().equals("M"))
                    {
                        maleTotal += covidCases[i].getCases();
                    }
                }
                stats = maleTotal;            
            break;

            // Total Number of Female Covid-19 Cases
            case "Female":
                int femaleTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getSex().equals("F"))
                    {
                        femaleTotal += covidCases[i].getCases();
                    }
                }
                stats = femaleTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 0 and 9
            case "0-9":
                int zeroToNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("0-9"))
                    {
                        zeroToNineTotal += covidCases[i].getCases();
                    }
                }
                stats = zeroToNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 10 and 19
            case "10-19":
                int tenToNineteenTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("10-19"))
                    {
                        tenToNineteenTotal += covidCases[i].getCases();
                    }
                }
                stats = tenToNineteenTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 20 and 29
            case "20-29":
                int twentyToTwentyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("20-29"))
                    {
                        twentyToTwentyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = twentyToTwentyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 30 and 39
            case "30-39":
                int thirtyToThirtyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("30-39"))
                    {
                        thirtyToThirtyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = thirtyToThirtyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 40 and 49
            case "40-49":
                int fortyToFortyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("40-49"))
                    {
                        fortyToFortyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = fortyToFortyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 50 and 59
            case "50-59":
                int fiftyToFiftyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("50-59"))
                    {
                        fiftyToFiftyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = fiftyToFiftyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 60 and 69
            case "60-69":
                int sixtyToSixtyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("60-69"))
                    {
                        sixtyToSixtyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = sixtyToSixtyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 70 and 79
            case "70-79":
                int seventyToSeventyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("70-79"))
                    {
                        seventyToSeventyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = seventyToSeventyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 80 and 89
            case "80-89":
                int eightyToEightyNineTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("80-89"))
                    {
                        eightyToEightyNineTotal += covidCases[i].getCases();
                    }
                }
                stats = eightyToEightyNineTotal;            
            break;

            // Total Number of Covid-19 Cases between ages 90+
            case "90+":
                int nintyPlusTotal = 0;
                for (int i = 0; i < covidCases.length; i++)
                {
                    if(covidCases[i].getAgeGroup().equals("90+"))
                    {
                        nintyPlusTotal += covidCases[i].getCases();
                    }
                }
                stats = nintyPlusTotal;            
            break;

        }
        System.out.println(stats);
    }

/*****************************************************************************
* METHOD: generateRegionStats
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: None
* ASSERTION: Generates statistics on Covid-19 cases based on specific filters
******************************************************************************/
    public static void generateRegionStats(CovidCase [] covidCases, String pRegion)
    {
        CovidCase [] regionBasedCovidCases;
        int regionArrLength = 0;
        int regionArrIndex = 0;
        int total = 0;
        int maleTotal = 0;
        int femaleTotal = 0;
        int zeroToNine = 0;
        int tenToNineteen = 0;
        int twentyToTwentyNine = 0;
        int thirtyToThirtyNine = 0;
        int fortyToFortyNine = 0;
        int fiftyToFiftyNine = 0;
        int sixtyToSixtyNine = 0;
        int seventyToSeventyNine = 0;
        int eightyToEightyNine = 0;
        int nintyPlus = 0;

        // 1. Dynamically determine length of regionBasedCovidCases array
        for(int i = 0; i < covidCases.length; i++)
        {
            if(covidCases[i].getRegion().equals(pRegion))
            {
                regionArrLength += 1;
            }
        }
        regionBasedCovidCases = new CovidCase[regionArrLength];

        /* 2. Go through all covid cases and assign the cases that match 
                                pRegion to new regionBasedCovidCases array */
        for(int i = 0; i < covidCases.length; i++)
        {
            if(covidCases[i].getRegion().equals(pRegion))
            {
                regionBasedCovidCases[regionArrIndex] = covidCases[i];
                regionArrIndex++;
            }
        }

        // 3. Generate regional stats using regionBasedCovidCases array
            for (int i = 0; i < regionBasedCovidCases.length; i++)
            {
                // Region Total Cases
                total += regionBasedCovidCases[i].getCases();
                
                // Region Total Male Cases
                if(regionBasedCovidCases[i].getSex().equals("M"))
                {
                    maleTotal += regionBasedCovidCases[i].getCases();
                }                

                // Region Total Female Cases
                if(regionBasedCovidCases[i].getSex().equals("F"))
                {
                    femaleTotal += regionBasedCovidCases[i].getCases();
                }               
 
                // Region Total from ages 0 to 9
                if(regionBasedCovidCases[i].getAgeGroup().equals("0-9"))
                {
                    zeroToNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 10 to 19
                if(regionBasedCovidCases[i].getAgeGroup().equals("10-19"))
                {
                    tenToNineteen += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 20 to 29
                if(regionBasedCovidCases[i].getAgeGroup().equals("20-29"))
                {
                    twentyToTwentyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 30 to 39
                if(regionBasedCovidCases[i].getAgeGroup().equals("30-39"))
                {
                    thirtyToThirtyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 40 to 49
                if(regionBasedCovidCases[i].getAgeGroup().equals("40-49"))
                {
                    fortyToFortyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 50 to 59
                if(regionBasedCovidCases[i].getAgeGroup().equals("50-59"))
                {
                    fiftyToFiftyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 60 to 69
                if(regionBasedCovidCases[i].getAgeGroup().equals("60-69"))
                {
                    sixtyToSixtyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 70 to 79
                if(regionBasedCovidCases[i].getAgeGroup().equals("70-79"))
                {
                    seventyToSeventyNine += regionBasedCovidCases[i].getCases();
                }
                
                // Region Total from ages 80 to 89
                if(regionBasedCovidCases[i].getAgeGroup().equals("80-89"))
                {
                    eightyToEightyNine += regionBasedCovidCases[i].getCases();
                }

                // Region Total from ages 90+
                if(regionBasedCovidCases[i].getAgeGroup().equals("90+"))
                {
                    nintyPlus += regionBasedCovidCases[i].getCases();
                }
            }

        // 4. Display stats to user
        System.out.println();
        System.out.println("------ REGIONAL COVID STATS FOR " + pRegion + " ------");
        System.out.println("Total number of COVID-19 cases for " + pRegion + ": " + total);            
        System.out.println("Total number of COVID-19 male cases for " + pRegion +
                                                             ": " + maleTotal);            
        System.out.println("Total number of COVID-19 female cases for " + pRegion +
                                                             ": " + femaleTotal);            
        System.out.println("Total number of COVID-19 cases in 0-9 age group for " +
                                                 pRegion + ": " + zeroToNine);            
        System.out.println("Total number of COVID-19 cases in 10-19 age group for " +
                                                 pRegion + ": " + tenToNineteen);            
        System.out.println("Total number of COVID-19 cases in 20-29 age group for " +
                                             pRegion + ": " + twentyToTwentyNine);            
        System.out.println("Total number of COVID-19 cases in 30-39 age group for " +
                                             pRegion + ": " + thirtyToThirtyNine);            
        System.out.println("Total number of COVID-19 cases in 40-49 age group for " + 
                                            pRegion + ": " + fortyToFortyNine);            
        System.out.println("Total number of COVID-19 cases in 50-59 age group for " + 
                                            pRegion + ": " + fiftyToFiftyNine);            
        System.out.println("Total number of COVID-19 cases in 60-69 age group for " +
                                             pRegion + ": " + sixtyToSixtyNine);            
        System.out.println("Total number of COVID-19 cases in 70-79 age group for " + 
                                        pRegion + ": " + seventyToSeventyNine);            
        System.out.println("Total number of COVID-19 cases in 80-89 age group for " + 
                                            pRegion + ": " + eightyToEightyNine);            
        System.out.println("Total number of COVID-19 cases in 90+ age group for " + 
                                                    pRegion + ": " + nintyPlus);            
    }

/*****************************************************************************
* METHOD: greeting
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Great the user with purpose of program
******************************************************************************/
    public static void greeting()
    {
        System.out.println();
        System.out.println("Welcome to the COVID-19 Data Analysis Program." + 
            " Make a selection from the menu below regarding the information" + 
                                                    " you would like to see.");
    }


/*****************************************************************************
* METHOD: mainMenuScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with main menu options
******************************************************************************/
    public static void mainMenuScreen ()
    {
        System.out.println();
        System.out.println(" - MAIN MENU: SELECT FROM THE FOLLOWING - ");            
        System.out.println("> [1] Statistics of entire nation.");            
        System.out.println("> [2] Statistics of regions.");            
        System.out.println("> [3] Exit the program.");
        System.out.print("Your choice: ");
    }

/*****************************************************************************
* METHOD: menuOneScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with Menu 1 options
******************************************************************************/
    public static void menuOneScreen ()
    {
        System.out.println();
        System.out.println(" - STATISTICS FOR ENTIRE NATION: SELECT FROM THE FOLLOWING - ");            
        System.out.println("> [1] Display total number of COVID-19 cases");            
        System.out.println("> [2] Display total number of COVID-19 cases: Males");            
        System.out.println("> [3] Display total number of COVID-19 cases: Females.");            
        System.out.println("> [4] Display total number of COVID-19 cases: 0-9 group.");            
        System.out.println("> [5] Display total number of COVID-19 cases: 10-19 group.");            
        System.out.println("> [6] Display total number of COVID-19 cases: 20-29 group.");            
        System.out.println("> [7] Display total number of COVID-19 cases: 30-39 group.");            
        System.out.println("> [8] Display total number of COVID-19 cases: 40-49 group.");            
        System.out.println("> [9] Display total number of COVID-19 cases: 50-59 group.");            
        System.out.println("> [10] Display total number of COVID-19 cases: 60-69 group.");            
        System.out.println("> [11] Display total number of COVID-19 cases: 70-79 group.");            
        System.out.println("> [12] Display total number of COVID-19 cases: 80-89 group.");            
        System.out.println("> [13] Display total number of COVID-19 cases: 90+ group.");            
        System.out.print("Your choice: ");
    }

/*****************************************************************************
* METHOD: menuTwoScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with Menu 2 options
******************************************************************************/
    public static void menuTwoScreen ()
    {
        System.out.println();
        System.out.println(" - STATISTICS BY REGION: SELECT FROM THE FOLLOWING - ");            
        System.out.println("> [1] Flanders");            
        System.out.println("> [2] Brussels");            
        System.out.println("> [3] Wallonia");
        System.out.println("> [4] Unknown");
        System.out.print("Your choice: ");
    }

/*****************************************************************************
* METHOD: newSelection
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Returns boolean representing if user would like to make 
             another selection from the menu they are currently using
******************************************************************************/
    public static boolean newSelection ()
    {
        boolean selection = false;
        boolean validInput = false;
        do 
        {
            try
            {
                System.out.println("Would you like to make another selection (Y OR N) ?");
                Scanner input = new Scanner(System.in);
                char userInput = input.next().charAt(0);

                if(userInput == 'Y' || userInput == 'y')
                {
                    selection = true;
                    validInput = true;
                }
                else if (userInput == 'N' || userInput == 'n')
                {
                    selection = false;
                    validInput = true;
                }
                else
                {
                    System.out.println("Did not give a Yes or No. Please try again.");
                    System.out.println();
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid input for deciding new selection");
                System.out.println();
            }
        }
        while (validInput != true);
        return selection;
    }

/*****************************************************************************
* METHOD: mainMenu
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: None
* ASSERTION: Main menu method which directs user to Menu 1 and Menu 2 or exits program
******************************************************************************/
    public static void mainMenu (CovidCase [] covidCases)
    {
        boolean exit = false;
        do
        {
            mainMenuScreen(); 
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();

                switch(menuOption)
                {
                    case 1:
                        menuOne(covidCases);
                    break;

                    case 2:
                        menuTwo(covidCases);
                    break;

                    case 3:
                        System.out.println("Bye!");
                        exit = true;
                    break;
                    
                    default:
                        System.out.println();
                        System.out.println("Did not select a correct option in main menu. Please try again");
                    break;
                }
            }
            catch(Exception e)
            {
                System.out.println();
                System.out.println("Invalid user input in main menu.");
            }
        }
        while (exit != true);
    }

/*****************************************************************************
* METHOD: menuOne
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: None
* ASSERTION: Generates Menu 1 for user to generate statistics on entire nation
******************************************************************************/
    public static void menuOne (CovidCase [] covidCases)
    {
        boolean menuOneExit = false;
        do
        {
            menuOneScreen();
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();
                boolean validInput = false;

                switch(menuOption)
                {
                    case 1:
                        System.out.println("Total number of COVID-19 Cases: ");
                        generateSpecificStats(covidCases, "Total");
                        validInput = true;
                    break;

                    case 2:
                        System.out.println("Total number of COVID-19 Male Cases: ");
                        generateSpecificStats(covidCases, "Male");
                        validInput = true;
                    break;

                    case 3:
                        System.out.println("Total number of COVID-19 Female Cases: ");
                        generateSpecificStats(covidCases, "Female");
                        validInput = true;
                    break;

                    case 4:
                        System.out.println("Total COVID-19 Cases in '0-9' Age Group: ");
                        generateSpecificStats(covidCases, "0-9");
                        validInput = true;
                    break;
   
                    case 5:
                        System.out.println("Total COVID-19 Cases in '10-19' Age Group: ");
                        generateSpecificStats(covidCases, "10-19");
                        validInput = true;
                    break;

                    case 6:
                        System.out.println("Total COVID-19 Cases in '20-29' Age Group: ");
                        generateSpecificStats(covidCases, "20-29");
                        validInput = true;
                    break;

                    case 7:
                        System.out.println("Total COVID-19 Cases in '30-39' Age Group: ");
                        generateSpecificStats(covidCases, "30-39");
                        validInput = true;
                    break;

                    case 8:
                        System.out.println("Total COVID-19 Cases in '40-49' Age Group: ");
                        generateSpecificStats(covidCases, "40-49");
                        validInput = true;
                    break;

                    case 9:
                        System.out.println("Total COVID-19 Cases in '50-59' Age Group: ");
                        generateSpecificStats(covidCases, "50-59");
                        validInput = true;
                    break;

                    case 10:
                        System.out.println("Total COVID-19 Cases in '60-69' Age Group: ");
                        generateSpecificStats(covidCases, "60-69");
                        validInput = true;
                    break;

                    case 11:
                        System.out.println("Total COVID-19 Cases in '70-79' Age Group: ");
                        generateSpecificStats(covidCases, "70-79");
                        validInput = true;
                    break;

                    case 12:
                        System.out.println("Total COVID-19 Cases in '80-89' Age Group: ");
                        generateSpecificStats(covidCases, "80-89");
                        validInput = true;
                    break;

                    case 13:
                        System.out.println("Total COVID-19 Cases in '90+' Age Group: ");
                        generateSpecificStats(covidCases, "90+");
                        validInput = true;
                    break;

                    default:
                        System.out.println("Did not select a correct menu" + 
                                        " option in MENU 1. Please try again");
                        System.out.println();
                    break;
                }

                if(validInput)
                {
                    if(newSelection() != true)
                    {
                        menuOneExit = true;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid user input in MENU 1");
                System.out.println();
            }
        }
        while (menuOneExit != true);
    }

/*****************************************************************************
* METHOD: menuTwo
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: None
* ASSERTION: Generates Menu 2 for user to generate statistics on different regions
******************************************************************************/
    public static void menuTwo (CovidCase [] covidCases)
    {
        boolean menuTwoExit = false;
        do
        {
            menuTwoScreen();
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();
                boolean validInput = false;

                switch(menuOption)
                {
                    case 1:
                        System.out.println("Show all stats for region: Flanders");
                        generateRegionStats(covidCases, "Flanders");
                        validInput = true;
                    break;

                    case 2:
                        System.out.println("Show all stats for region: Brussels");
                        generateRegionStats(covidCases, "Brussels");
                        validInput = true;
                    break;

                    case 3:
                        System.out.println("Show all stats for region: Wallonia");
                        generateRegionStats(covidCases, "Wallonia");
                        validInput = true;
                    break;

                    case 4:
                        System.out.println("Show all stats for region: Unknown");
                        generateRegionStats(covidCases, "NA");
                        validInput = true;
                    break;
   
                    default:
                        System.out.println("Did not select a correct menu option in MENU 2. Please try again");
                        System.out.println();
                    break;
                }

                if(validInput)
                {
                    if(newSelection() != true)
                    {
                        menuTwoExit = true;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid user input in MENU 2");
                System.out.println();
            }
        }
        while (menuTwoExit != true);
    }
}
