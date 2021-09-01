import java.util.*;

public class CharConverter
{
    public static void main(String[] args)
    {
        // Initialize relevant variables.
        Scanner input = new Scanner(System.in);
        char uppercasechar, lowercasechar;
        int ascii;        
        
        // Get uppercase char from user and find corresponding ASCII value and lowercase value.
        System.out.print("Please enter an uppercase character: ");
        uppercasechar = input.next().charAt(0);
        ascii = (int)uppercasechar;
        lowercasechar = (char)((int)uppercasechar + 32);        

        // Print out corresponding ASCII value and lowercase char to user.
        System.out.println("The ASCII value of '" + uppercasechar + "' is: " + ascii);
        System.out.println("The corresponding lowercase character of '" + uppercasechar + "' is: '" + lowercasechar + "'");
        
        // Close scanner.
        input.close();
    }
}
