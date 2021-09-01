import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        int option; 
        int close;
        Scanner input = new Scanner(System.in);

        while (close != 0)
        {
            // 1. Ask user which option they would like to select
            System.out.print("What would you like to do? \n");
            System.out.print("> 1. Sum of 2 Integers \n");
            System.out.print("> 2. Product of 2 Integers \n");
            System.out.print("> 3. Determine if 2 Integers are Divisible \n");
            System.out.print("> 0. Exit \n"); 
            System.out.print(":"); 
            option = input.nextInt();

            // 2. Write switch case statement to handle what will happen for each selection.
            switch(option)
            {
                case 1:
                    System.out.print("Sum of 2 Integers");
                break;
                case 2:
                    System.out.print("Product of 2 Integers");
                break;
                case 3:
                    System.out.print("Determine if 2 Integers are Divisible");
                break;
                case 0:
                    close = 0;
                    System.out.print("Goodbye!");
                break;
                default:
                    System.out.print("Option does not exist. Please select a valid option.");
            }        
        }
    }
}