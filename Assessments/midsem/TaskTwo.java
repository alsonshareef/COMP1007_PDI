/**
 * FILE: TaskTwo.java 
 * AUTHOR: Alson Shareef
 * UNIT: COMP1007
 * PURPOSE: Track the goals scored by 3 players for 5 of their matches
 * DATE: 01/09/2021
*/

import java.util.*;

public class TaskTwo
{
    public static void main(String[] args)
    {
        /* 1. Initialise Scanner for user input and three arrays of length 5 
            to store three players goals scored over 5 weeks. */
        Scanner input = new Scanner(System.in);
        int [] moSalahGoals;
        int [] harryKaneGoals;
        int [] lionelMessiGoals;
        moSalahGoals = new int[5];
        harryKaneGoals = new int[5];
        lionelMessiGoals = new int[5];

        /* 2. Take user input for goals scored for the week for each player, 
            and if input is negative, record 0 goals for the week for the player.
            If input is positive then record user input as goals scored for the week
            for the player. */
        for (int i = 0; i < 5; i++)
        {
            // Integer for tracking the current week to record for.
            int weekNum = i + 1;
            // 2.a) Weekly goals recording for Mohamed Salah
            int moSalahGoalsForWeek;
            System.out.println("Please enter the goals scored by Mohamed Salah"
                                                + " in Week " + weekNum + ": ");
            moSalahGoalsForWeek = input.nextInt();
            if (moSalahGoalsForWeek < 0)
            {
                moSalahGoals[i] = 0;
            }
            else
            {
                moSalahGoals[i] = moSalahGoalsForWeek;
            }
            // 2.b) Weekly goals recording for Harry Kane
            int harryKaneGoalsForWeek;
            System.out.println("Please enter the goals scored by Harry Kane"
                                                + " in Week " + weekNum + ": ");
            harryKaneGoalsForWeek = input.nextInt();
            if (harryKaneGoalsForWeek < 0)
            {
                harryKaneGoals[i] = 0;
            }
            else
            {
                harryKaneGoals[i] = harryKaneGoalsForWeek;
            }
            // 2.c) Weekly goals recording for Lionel Messi.
            int lionelMessiGoalsForWeek;
            System.out.println("Please enter the goals scored by Lionel Messi"
                                                + " in Week " + weekNum + ": ");
            lionelMessiGoalsForWeek = input.nextInt();
            if (lionelMessiGoalsForWeek < 0)
            {
                lionelMessiGoals[i] = 0;
            }
            else
            {
                lionelMessiGoals[i] = lionelMessiGoalsForWeek;
            }
            System.out.println();
        }

        // 3. Display summary of user's completed data entry.
        System.out.println("-_-_-_-_-_-_-_-_-_-");
        for (int i = 0; i < 5; i++)
        {
            int weekNum = i + 1;
            System.out.println("In week " + weekNum + ", Mohamed Salah scored "
             + moSalahGoals[i] + " goals.");
            System.out.println("In week " + weekNum + ", Harry Kane scored "
             + harryKaneGoals[i] + " goals.");
            System.out.println("In week " + weekNum + ", Lionel Messi scored "
             + lionelMessiGoals[i] + " goals.");

            System.out.println("-_-_-_-_-_-_-_-_-_-");
        }        
        System.out.println();
        System.out.println("=====================");
        System.out.println("DATA ENTRY COMPLETED");
        System.out.println("=====================");        
        System.out.println();

        /* 4. Now that data entry is completed, display a menu of 4 options 
            which allows user to see either total goals scored by each player,
            average goals scored by each player for the 5 weeks, the highest 
            goal scorer or to exit the program. */
        int menuOption;
        do
        {
        
        }
        while ((menuOption < 0) || (menuOption > 3));
        
        // Close Scanner
        input.close();
    }
}
