import java.util.*;

public class IntegerOutput
{
    public static void main(String[] args)
    {
        int userInteger;
        Scanner input = new Scanner(System.in);
        
        // Ask user for an integer
        System.out.print("Enter an integer number: ");
        userInteger = input.nextInt();

        // Loop from 1 upto and including userInteger, outputing the current
        // integer for every iteration.
        for(int count = 1; count <= userInteger; count++) 
        {
            System.out.print(count + " ");
        }       
    }
}
