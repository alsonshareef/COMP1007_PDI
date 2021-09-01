/**
 * AUTHOR: Alson Shareef
 * PURPOSE: Runs 1 out of a selection of integer operations based on user input
 * DATE: 30/08/2021
 */

import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int option; 

        do
        {
            // 1. Ask user which option they would like to select
            System.out.println("What would you like to do?");
            System.out.println("> 1. Sum of 2 Integers");
            System.out.println("> 2. Product of 2 Integers");
            System.out.println("> 3. Determine if 2 Integers are Divisible");
            System.out.println("> 0. Exit"); 
            option = input.nextInt();

            // 2. Run corresponding code if user selected a valid option.
            switch(option)
            {
                // 2.a) Exit program
                case 0:
                    System.out.println("Goodbye!");
                break;

                // 2.b) Take 2 integers from user and output the sum
                case 1:
                    int sumIntOne, sumIntTwo, sum;
                    System.out.println("Enter first integer");
                    sumIntOne = input.nextInt();
                    System.out.println("Enter second integer");
                    sumIntTwo = input.nextInt();

                    sum = sumIntOne + sumIntTwo;

                    System.out.println("The sum of " + sumIntOne + " and " + 
                                        sumIntTwo + " is equal to: " + sum);
                    
                break;

                // 2.c) Take 2 integers from user and output the product
                case 2:
                    int prodIntOne, prodIntTwo, product;
                    System.out.println("Enter first integer");
                    prodIntOne = input.nextInt();
                    System.out.println("Enter second integer");
                    prodIntTwo = input.nextInt();

                    product = prodIntOne * prodIntTwo;
                    System.out.println("The product of " + prodIntOne + " and " +
                                        prodIntTwo + " is equal to: " + product);
                break;

                // 2.d) Take two integers and output whether they are divisible
                case 3:
                    System.out.print("Determine if 2 Integers are Divisible \n");
                break;

                // 2.e) If input was invalid, request user to input valid
                //      option
                default:
                    System.out.println("Option does not exist. Please select a "
                                                        + "valid option.");
            }        
        } while ((option < 0) || (option > 3));
        input.close(); // Close Scanner Object.
    }
}
