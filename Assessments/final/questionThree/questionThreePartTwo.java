/**
* FILE: questionThreePartTwo
* AUTHOR: Alson Shareef
* UNIT: COMP1007
* PURPOSE: 
* REFERENCES: None
* DATE CREATED: 5/11/2021
*/

import java.util.*;

public class questionThreePartTwo
{
    public static void main(String [] args)
    {
        // Variable declarations
        Scanner sc = new Scanner(System.in);
        char c;
        int letterAmount;
        int count = 0;
        int asciiVal = 0;
        char [] capitalLetterArray;
        
        // [1] - Determine amount of capital letters user will like to store.
        System.out.println("Welcome to the Capital Letter Storage Program. " + 
                            "How many capital letters would you like to store?");
        System.out.print("> ");
        letterAmount = sc.nextInt();

        // [2] - Set array length to amount of capital letters user wants to store.
        capitalLetterArray = new char [letterAmount];

        // [3] - Start retrieving capital letters from user to store in array.
        System.out.println("Great! Please start entering your capital letters");
        while(count < letterAmount)
        {
            // Get character and it's ascii value.
            System.out.print("> ");
            c = sc.next().charAt(0);
            asciiVal = c;

            // Check if character is a capital using it's ascii value.
            if (asciiVal > 64 && asciiVal < 91)
            {
                // If character is a capital letter, store in array.
                capitalLetterArray[count] = c;
                count++;
            }
            else if (asciiVal == 63)
            {
                // If character is '?', exit program
                System.out.println("Bye!");
                break;
            }
            else
            {
                // If not capital, ask user to re-enter a capital
                System.out.println("You did not enter a capital letter," + 
                                                            " please try again.");
            }
        }

        System.out.println();

        // [4] - Display all stored capital letters
        if (asciiVal != 63)
        {
            System.out.println("These were the capital letters you stored.");
            for(int i = 0; i < capitalLetterArray.length; i++)
            {
                System.out.println(capitalLetterArray[i]);
            }
        }

        // Close Scanner
        sc.close();
    }
}
