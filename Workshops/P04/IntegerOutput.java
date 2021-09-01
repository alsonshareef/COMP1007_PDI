import java.util.*;

public class IntegerOutput
{
    public static void main(String[] args)
    {
        int integer;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        integer = input.nextInt();

        for(int count = 1; count <= integer; count++) 
        {
            System.out.print(count + " ");
        }       
    }
}
