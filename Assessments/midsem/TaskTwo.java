/**
 * FILE: TaskTwo.java 
 * AUTHOR: Alson Shareef
 * UNIT: COMP1007
 * PURPOSE: Track the goals scored by 3 players for 5 of their matches
 * REFERENCES: None
 * DATE CREATED: 01/09/2021
 * DATE MODIFIED: 02/09/2021, 03/09/2021
*/

import java.util.*;

public class TaskTwo
{
    public static void main(String[] args)
    {
        // Initialise Scanner for user input
        Scanner input = new Scanner(System.in);

        /* 1. Take user input for goals scored for the week for each player, 
            and if input is negative, record 0 goals for the week for the player.
            If input is positive then record user input as goals scored for the week
            for the player. */

        // 1.a) Weekly goals recording for Mohamed Salah
        int [] moSalahGoals;
        moSalahGoals = new int[5];

        for (int i = 0; i < 5; i++)
        {
            // Integer for tracking the current week to record for.
            int currentWeekNum = i + 1;
            
            // Get goals scored for the current week by user.
            int moSalahGoalsForWeek;
            System.out.println("Please enter the goals scored by Mohamed Salah"
                                                + " in Week " + currentWeekNum + ": ");
            moSalahGoalsForWeek = input.nextInt();

            /* If user inputted negative integer, record 0 goals for the week
                 and if user input is 0 or higher, record the user input as the
                 goals for the week. */
            if (moSalahGoalsForWeek < 0)
            {
                moSalahGoals[i] = 0;
            }
            else
            {
                moSalahGoals[i] = moSalahGoalsForWeek;
            }
        }
        System.out.println();

        // 1.b) Weekly goals recording for Harry Kane
        int [] harryKaneGoals;
        harryKaneGoals = new int[5];

        for (int i = 0; i < 5; i++)
        {
            // Integer for tracking the current week to record for.
            int currentWeekNum = i + 1;

            // Get goals scored for the current week by user.
            int harryKaneGoalsForWeek;
            System.out.println("Please enter the goals scored by Harry Kane"
                                                + " in Week " + currentWeekNum + ": ");
            harryKaneGoalsForWeek = input.nextInt();

            /* If user inputted negative integer, record 0 goals for the week
                 and if user input is 0 or higher, record the user input as the
                 goals for the week. */
            if (harryKaneGoalsForWeek < 0)
            {
                harryKaneGoals[i] = 0;
            }
            else
            {
                harryKaneGoals[i] = harryKaneGoalsForWeek;
            }
        }
        System.out.println();

        // 1.c) Weekly goals recording for Lionel Messi.
        int [] lionelMessiGoals;
        lionelMessiGoals = new int[5];

        for (int i = 0; i < 5; i++)
        {
            // Integer for tracking the current week to record for.
            int currentWeekNum = i + 1;

            // Get goals scored for the current week by user.
            int lionelMessiGoalsForWeek;
            System.out.println("Please enter the goals scored by Lionel Messi"
                                                + " in Week " + currentWeekNum + ": ");
            lionelMessiGoalsForWeek = input.nextInt();

            /* If user inputted negative integer, record 0 goals for the week
                 and if user input is 0 or higher, record the user input as the
                 goals for the week. */
            if (lionelMessiGoalsForWeek < 0)
            {
                lionelMessiGoals[i] = 0;
            }
            else
            {
                lionelMessiGoals[i] = lionelMessiGoalsForWeek;
            }
        }
        System.out.println();

        // 2. Prompt the user that data entry phase is complete.
        System.out.println("=====================");
        System.out.println("DATA ENTRY COMPLETED");
        System.out.println("=====================");        
        System.out.println();

        /*  Now that data entry is completed, display a menu of 4 options 
            which allows user to see either total goals scored by each player,
            average goals scored by each player for the 5 weeks, the highest 
            goal scorer or to exit the program. */

        int menuOption;
        do
        {
            // 3. Display menu options and prompt user to select an option.
            System.out.println("*** MENU ***");
            System.out.println("> 1. Display total number of goals scored by"
                                                             + " each player"); 
            System.out.println("> 2. Display the average number of goals scored "
                                                            + "by each player");
            System.out.println("> 3. Display the highest goal scorer's name "
                                                         + "number of goals.");
            System.out.println("> 0. Exit Golden Boot Tracker Program.");
            menuOption = input.nextInt();
            System.out.println();

            switch(menuOption)
            {
                // 3.a) If user selects 0, close program.
                case 0:
                    System.out.println("Okay, goodbye!");
                break;

                /* 3.b) If user selects 1, display the total goals scored by 
                        each player over the 5 games. */
                case 1:
                    int moSalahTotalGoals;
                    int harryKaneTotalGoals;
                    int lionelMessiTotalGoals;
                    
                    /* Call for sumOfArrayElements method to calculate the 
                        sum of the total goals scored by passing the respective
                        players array of goals as an argument to the method. */
                    moSalahTotalGoals = sumOfArrayElements(moSalahGoals);
                    System.out.println("Mohamed Salah scored a total of: "
                                              + moSalahTotalGoals + " goals.");                    

                    harryKaneTotalGoals = sumOfArrayElements(harryKaneGoals);
                    System.out.println("Harry Kane scored a total of: "
                                            + harryKaneTotalGoals + " goals."); 

                    lionelMessiTotalGoals = sumOfArrayElements(lionelMessiGoals);
                    System.out.println("Lionel Messi scored a total of: "
                                          + lionelMessiTotalGoals + " goals."); 
                    
                    System.out.println();
                break;

                /* 3.c) If user selects 2, display the average amount of goals
                        that the players scored across the 5 games. */
                case 2:
                    double moSalahAvgGoals;
                    double harryKaneAvgGoals;
                    double lionelMessiAvgGoals;

                    /* Get total goals scored by each player, typecast integer 
                        of total goals to a double and divide by 5.0 to get an 
                        accurate value of average goals scored for each player. */
                    moSalahAvgGoals = (double)(sumOfArrayElements(moSalahGoals)) / 5.0;
                    System.out.println("Mohamed Salah scored an average of: " 
                                                + moSalahAvgGoals + " goals.");

                    harryKaneAvgGoals = (double)(sumOfArrayElements(harryKaneGoals)) / 5.0;
                    System.out.println("Harry Kane scored an average of: " 
                                              + harryKaneAvgGoals + " goals.");

                    lionelMessiAvgGoals = (double)(sumOfArrayElements(lionelMessiGoals)) / 5.0;
                    System.out.println("Lionel Messi scored an average of: " 
                                            + lionelMessiAvgGoals + " goals.");
                    System.out.println();
                break;

                /* 3.d) If user selects 3, display who the highest scorer was 
                        over the 5 games */
                case 3:
                    int moSalahGoalSum = sumOfArrayElements(moSalahGoals);
                    int harryKaneGoalSum = sumOfArrayElements(harryKaneGoals);
                    int lionelMessiGoalSum = sumOfArrayElements(lionelMessiGoals);

                    /* If Mohamed Salah scored more total goals than Harry Kane
                                 and Lionel Messi, he is the highest scorer. */
                    if (moSalahGoalSum > harryKaneGoalSum &&
                                         moSalahGoalSum > lionelMessiGoalSum)
                    {
                        System.out.println("Mohamed Salah was the highest"
                                                 + " scorer over the 5 games.");
                    }
                    
                    /* If Harry Kane scored more total goals than Mohamed Salah
                                 and Lionel Messi, he is the highest scorer. */
                    else if (harryKaneGoalSum > moSalahGoalSum &&
                                         harryKaneGoalSum > lionelMessiGoalSum)
                    {
                        System.out.println("Harry Kane was the highest scorer"
                                                        + " over the 5 games.");
                    }

                    /* If Lionel Messi scored more total goals than Mohamed Salah
                                   and Harry Kane, he is the highest scorer. */
                    else if (lionelMessiGoalSum > moSalahGoalSum &&
                                         lionelMessiGoalSum > harryKaneGoalSum)
                    {
                        System.out.println("Lionel Messi was the highest scorer"
                                                         + " over the 5 games.");
                    }

                    // All players scored the same amount of goals.
                    else
                    {
                        System.out.println("All players scored the same amount"
                                             + " of goals over the 5 games.");
                    }

                    System.out.println();
                break;

                default:
                    System.out.println("Invalid option. Please select one of "
                                             + "the valid options provided.");
                    System.out.println();
            }
        }
        while (menuOption != 0);
        
        // Close Scanner
        input.close();
    }

   /*************************************************************************** 
    * METHOD: sumOfArrayElements
    * IMPORTS: array (Array of Integers)
    * EXPORTS: sumOfArray (Integer)
    * ASSERTION: sumOfArray will be equal to sum of all elements of array
    **************************************************************************/

    public static int sumOfArrayElements (int [] array)
    {
        int sumOfArray = 0;
        int arrayLength = array.length;

        for(int i = 0; i < arrayLength; i++)
        {
            sumOfArray += array[i];
        }
        return sumOfArray;        
    }

}
