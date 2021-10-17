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
            log("I/O Error reading file in main: " + e.getMessage(), 0, "both");
            log("-------------------------", 0, "both");
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
                log("Error creating array of Covid Cases in main: " + 
                                                    e.getMessage(), 0, "both");
                log("-------------------------", 0, "both");
            }
        }
        else
        {
            log("Error creating array of Covid Cases in main: No row of " + 
                                                "CSV strings array", 0, "both");
            log("-------------------------", 0, "both");
        }
        
        /* [4] - Feed Covid Cases array to menus for user to generate statistics */
        if (covidCases.length > 0)
        {
            try
            {
                greeting(); 
                mainMenu(covidCases);
            }
            catch(Exception e)
            {
                if(e.getMessage() == null)
                {
                    log("Menus error: Invalid user input in Main Menu" + "\n" +
                                                                 e, 1, "both");
                }
                else 
                {
                    log("Menus error: " + e.getMessage(), 1, "both");
                }
            }
        }
        else
        {
            log("Error in main: Could not begin program since valid data" + 
                                               " is not provided.", 0, "both");
            log("-------------------------", 0, "both");
        }
               
        /* [5] - When done generating stats, safely close program */
        System.exit(0);
    }

/*****************************************************************************
* METHOD: log
* IMPORTS: pString (String)
* EXPORTS: None
* ASSERTION: Takes a string and both outputs it to console, and writes to log file
******************************************************************************/
    public static void log (String pString, int pNewLine, String pType)
    {
        FileOutputStream fs = null;
        PrintWriter pw;
        try
        {
            fs = new FileOutputStream("logFile.txt", true);
            pw = new PrintWriter(fs);

            if (pType == "both")
            {
                System.out.println(pString);
                pw.append(pString + "\n");
            }
            else if (pType == "file")
            {
                pw.append(pString + "\n");
            }
            else
            {
                System.out.println(pString);
            }
            
            for (int i = 0; i < pNewLine; i++ )
            {
                System.out.println();
                pw.append("\n");
            }

            pw.close();
        }
        catch (IOException e)
        {
            if (fs != null)
            {
                try
                {
                    fs.close();
                }
                catch (IOException e2)
                {
                    System.out.println("Error closing file stream for print writer.");
                }
            }
            System.out.println("Error writing to log file: " + e.getMessage());
        }
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
                        errorMessage += "Day string could not be converted to dayInt" +
                                                               "\n" + numError;
                    }
                    else if (monthInt == -1)
                    {
                        errorMessage += "Month string could not be converted to monthInt" +
                                                               "\n" + numError;
                    }
                    else if (yearInt == -1)
                    {
                        errorMessage += "Year string could not be converted to yearInt" +
                                                               "\n" + numError;
                    }
                    else
                    {
                        errorMessage += "Cases string could not be converted to casesInt" +
                                                               "\n" + numError;
                    }

                    throw new NumberFormatException(errorMessage);
                }
                catch(Exception error)
                {
                    throw new Exception("General error with converting strings to ints: " +
                                                                         error);
                }
            }

            // 3.4 Pass extracted data into Covid Case class constructor and store in array
            try
            {
                covidCases[rowNum-1] = new CovidCase(country, province, region,
                           ageGroup, sex, casesInt, dayInt, monthInt, yearInt);
            }
            catch(Exception e)
            {
                csvRowNum = rowNum + 1;
                throw new Exception("processStringToObjects Method: Unable to" + 
                " turn data from CSV file row " + csvRowNum + 
                " to Covid Case object" + "\n" + e);
            }
        }
        return covidCases;
    }

/*****************************************************************************
* METHOD: totalCases
* IMPORTS: covidCases (CovidCase [])
* EXPORTS: total (Integer)
* ASSERTION: Generates total number of Covid Cases
******************************************************************************/
    public static int totalCases (CovidCase [] covidCases)
    {
        int total = 0;
        for (int i = 0; i < covidCases.length; i++)
        {
            total += covidCases[i].getCases();
        }
        return total;            
    }

/*****************************************************************************
* METHOD: totalGender
* IMPORTS: gender (String), covidCases (CovidCase [])
* EXPORTS: total (Integer)
* ASSERTION: Generates total number of Covid Cases for a specific gender
******************************************************************************/
    public static int totalGender (String gender, CovidCase [] covidCases)
    {
        int total = 0;
        for (int i = 0; i < covidCases.length; i++)
        {
            if(covidCases[i].getSex().equals(gender))
            {
                total += covidCases[i].getCases();
            }
        }
        return total;            
    }

/*****************************************************************************
* METHOD: totalAgeGroup
* IMPORTS: ageGroup (String), covidCases (CovidCase [])
* EXPORTS: total (Integer)
* ASSERTION: Generates total number of Covid Cases for a specific age group
******************************************************************************/
    public static int totalAgeGroup (String ageGroup, CovidCase [] covidCases)
    {
        int total = 0;
        for (int i = 0; i < covidCases.length; i++)
        {
            if(covidCases[i].getAgeGroup().equals(ageGroup))
            {
                total += covidCases[i].getCases();
            }
        }
        return total;            
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

        /* Check to change pRegion to more meaningful name if displaying Unknown 
           Region stats */
        if(pRegion.equals("NA"))
        {
            pRegion = "Unknown Regions";
        }

        // 3. Display stats to user
        log("------ REGIONAL COVID STATS FOR " + pRegion + " ------", 0, "both");
        log("Total number of COVID-19 cases for " + pRegion + ": " + 
                                totalCases(regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 male cases for " + pRegion + ": " +
                          totalGender("M", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 female cases for " + pRegion + ": " + 
                          totalGender("F", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 0-9 age group for " + pRegion +
                 ": " + totalAgeGroup("0-9", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 10-19 age group for " + pRegion +
               ": " + totalAgeGroup("10-19", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 20-29 age group for " + pRegion +
               ": " + totalAgeGroup("20-29", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 30-39 age group for " + pRegion +
               ": " + totalAgeGroup("30-39", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 40-49 age group for " + pRegion +
               ": " + totalAgeGroup("40-49", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 50-59 age group for " + pRegion +
               ": " + totalAgeGroup("50-59", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 60-69 age group for " + pRegion +
               ": " + totalAgeGroup("60-69", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 70-79 age group for " + pRegion +
               ": " + totalAgeGroup("70-79", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 80-89 age group for " + pRegion +
               ": " + totalAgeGroup("80-89", regionBasedCovidCases), 0, "both");            

        log("Total number of COVID-19 cases in 90+ age group for " + pRegion + 
                ": " + totalAgeGroup("90+", regionBasedCovidCases), 0, "both");            
        log("", 0, "both");
    }

/*****************************************************************************
* METHOD: greeting
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Great the user with purpose of program
******************************************************************************/
    public static void greeting()
    {
        log("", 0, "both");
        log("Welcome to the COVID-19 Data Analysis Program. Make a selection" + 
        " from the menu below regarding the information you would like to see.", 1, "both");
    }


/*****************************************************************************
* METHOD: mainMenuScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with main menu options
******************************************************************************/
    public static void mainMenuScreen ()
    {
        log(" - MAIN MENU: SELECT FROM THE FOLLOWING - ", 0, "both");            
        log("> [1] Statistics of entire nation.", 0, "both");            
        log("> [2] Statistics of regions.", 0, "both");            
        log("> [3] Exit the program.", 0, "both");
        log("Your choice: ", 0, "both");
    }

/*****************************************************************************
* METHOD: menuOneScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with Menu 1 options
******************************************************************************/
    public static void menuOneScreen ()
    {
        log(" - STATISTICS FOR ENTIRE NATION: SELECT FROM THE FOLLOWING - ", 0, "both");            
        log("> [1] Display total number of COVID-19 cases", 0, "both");            
        log("> [2] Display total number of COVID-19 cases for Males.", 0, "both");            
        log("> [3] Display total number of COVID-19 cases for Females.", 0, "both");            
        log("> [4] Display total number of COVID-19 cases for age group 0-9.", 0, "both");            
        log("> [5] Display total number of COVID-19 cases for age group 10-19. ", 0, "both");
        log("> [6] Display total number of COVID-19 cases for age group 20-29. ", 0, "both");
        log("> [7] Display total number of COVID-19 cases for age group 30-39. ", 0, "both");
        log("> [8] Display total number of COVID-19 cases for age group 40-49. ", 0, "both");
        log("> [9] Display total number of COVID-19 cases for age group 50-59. ", 0, "both");
        log("> [10] Display total number of COVID-19 cases for age group 60-69. ", 0, "both");
        log("> [11] Display total number of COVID-19 cases for age group 70-79. ", 0, "both");
        log("> [12] Display total number of COVID-19 cases for age group 80-89. ", 0, "both");
        log("> [13] Display total number of COVID-19 cases for age group 90+ ", 0, "both");
        log("Your choice: ", 0, "both");
    }

/*****************************************************************************
* METHOD: menuTwoScreen
* IMPORTS: None
* EXPORTS: None
* ASSERTION: Prompt user with Menu 2 options
******************************************************************************/
    public static void menuTwoScreen ()
    {
        log(" - STATISTICS BY REGION: SELECT FROM THE FOLLOWING - ", 0, "both");            
        log("> [1] Flanders", 0, "both");            
        log("> [2] Brussels", 0, "both");            
        log("> [3] Wallonia", 0, "both");
        log("> [4] Unknown Regions", 0, "both");
        log("Your choice: ", 0, "both");
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
                log("Would you like to make another selection (Y OR N) ?", 0, "both");
                Scanner input = new Scanner(System.in);
                char userInput = input.next().charAt(0);

                log(String.valueOf(userInput), 1, "file");

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
                    log("Did not give a Yes or No. Please try again.", 1, "both");
                }
            }
            catch(Exception e)
            {
                log("Invalid input for deciding new selection", 1, "both");
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
    public static void mainMenu (CovidCase [] covidCases) throws Exception
    {
        boolean exit = false;
        do
        {
            mainMenuScreen(); 
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();
                log(String.valueOf(menuOption), 1, "file");

                switch(menuOption)
                {
                    case 1:
                        menuOne(covidCases);
                    break;

                    case 2:
                        menuTwo(covidCases);
                    break;

                    case 3:
                        log("Bye!", 1, "both");
                        log("-------------------------", 0, "both");
                        exit = true;
                    break;
                    
                    default:
                        log("Did not select a correct option in main menu. Please try again", 1, "both");
                    break;
                }
            }
            catch(InputMismatchException e)
            {
                throw new InputMismatchException(e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println();
                throw new Exception("Invalid user input in main menu.");
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
    public static void menuOne (CovidCase [] covidCases) throws Exception
    {
        boolean menuOneExit = false;
        do
        {
            menuOneScreen();
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();
                boolean validInput = true;
                
                log(String.valueOf(menuOption), 1, "file");

                switch(menuOption)
                {
                    case 1:
                        log("Total number of COVID-19 Cases: " + 
                                            totalCases(covidCases), 0, "both");
                    break;

                    case 2:
                        log("Total number of COVID-19 Male Cases: " + 
                                        totalGender("M", covidCases), 0, "both");
                    break;

                    case 3:
                        log("Total number of COVID-19 Female Cases: " + 
                                        totalGender("F", covidCases), 0, "both");
                    break;

                    case 4:
                        log("Total COVID-19 Cases in '0-9' Age Group: " + 
                                    totalAgeGroup("0-9", covidCases), 0, "both");
                    break;
   
                    case 5:
                        log("Total COVID-19 Cases in '10-19' Age Group: " +
                                  totalAgeGroup("10-19", covidCases), 0, "both");
                    break;

                    case 6:
                        log("Total COVID-19 Cases in '20-29' Age Group: " +
                                  totalAgeGroup("20-29", covidCases), 0, "both");
                    break;

                    case 7:
                        log("Total COVID-19 Cases in '30-39' Age Group: " +
                                  totalAgeGroup("30-39", covidCases), 0, "both");
                    break;

                    case 8:
                        log("Total COVID-19 Cases in '40-49' Age Group: " + 
                                  totalAgeGroup("40-49", covidCases), 0, "both");
                    break;

                    case 9:
                        log("Total COVID-19 Cases in '50-59' Age Group: " +
                                  totalAgeGroup("50-59", covidCases), 0, "both");
                    break;

                    case 10:
                        log("Total COVID-19 Cases in '60-69' Age Group: " +
                                  totalAgeGroup("60-69", covidCases), 0, "both");
                    break;

                    case 11:
                        log("Total COVID-19 Cases in '70-79' Age Group: " +
                                  totalAgeGroup("70-79", covidCases), 0, "both");
                    break;

                    case 12:
                        log("Total COVID-19 Cases in '80-89' Age Group: " + 
                                 totalAgeGroup("80-89", covidCases), 0 , "both");
                    break;

                    case 13:
                        log("Total COVID-19 Cases in '90+' Age Group: " +
                                    totalAgeGroup("90+", covidCases), 0, "both");
                    break;

                    default:
                        validInput = false;
                        log("Did not select an existing menu" + 
                              " option in Menu 1. Please try again", 1, "both");
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
            catch(InputMismatchException e)
            {
                throw new InputMismatchException("Invalid user input in Menu 1" + "\n" + e);
            }
            catch(Exception e)
            {
                throw new Exception("General error in Menu 1" + "\n" + e);
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
    public static void menuTwo (CovidCase [] covidCases) throws Exception
    {
        boolean menuTwoExit = false;
        do
        {
            menuTwoScreen();
            try
            {
                Scanner input = new Scanner(System.in);
                int menuOption = input.nextInt();
                boolean validInput = true;

                log(String.valueOf(menuOption), 1, "file");

                switch(menuOption)
                {
                    case 1:
                        generateRegionStats(covidCases, "Flanders");
                    break;

                    case 2:
                        generateRegionStats(covidCases, "Brussels");
                    break;

                    case 3:
                        generateRegionStats(covidCases, "Wallonia");
                    break;

                    case 4:
                        generateRegionStats(covidCases, "NA");
                    break;
   
                    default:
                        log("Did not select an existing menu option in Menu 2." + 
                                                " Please try again", 1, "both");
                        validInput = false;
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
            catch(InputMismatchException e)
            {
                throw new InputMismatchException("Invalid user input in Menu 2" + "\n" + e);
            }
            catch(Exception e)
            {
                throw new Exception("General error in Menu 2" + "\n" + e);
            }
        }
        while (menuTwoExit != true);
    }
}
