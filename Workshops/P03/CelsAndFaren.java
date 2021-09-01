import java.util.*;

public class CelsAndFaren
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);    
        
        // 1. Get initial temp scale from user to know which scale to convert to. 
        char initialtempscale;
        System.out.println("Which temperate scale are you converting from?");
        System.out.println("> Type 'C' or 'c' to convert from Celsius");
        System.out.println("> Type 'F' or 'f' to convert from Fahrenheit");
        initialtempscale = input.next().charAt(0);
        
        // 2. If initial temp scale is fahreheit, convert to celsius.
        if (initialtempscale == 'F' || initialtempscale == 'f')
        {
            // 2.a) Get initial temp value from user to then convert.
            double initialtemp;
            System.out.print("Enter the temperature in Fahrenheit you would" + 
                                                "like to convert to Celsius: ");
            initialtemp = input.nextDouble();
            
            // 2.b) Calculate conversion to Celsius and output to user.
            double c;
            c = (initialtemp - 32) * (5.0/9.0);
            System.out.println(initialtemp + " degrees Fahrenheit is " + c
                                                         + " degress Celsius.");
        }    
    
        // 3. If initial temp scale is celsius, conver to fahrenheit.       
        if (initialtempscale == 'C' || initialtempscale == 'c')
        {
            // 3.a) Get initial temp value from user to then convert.
            double initialtemp;
            System.out.print("Enter the temperature in Celsius you would"
                                           + " like to convert to Fahrenheit: ");
            initialtemp = input.nextDouble();

            // 3.b) Calculate conversion to Fahrenheit and output to user.
            double f;
            f = ((9.0/5.0) * initialtemp) + 32;
            System.out.println(initialtemp + " degrees Celsius is " + f +
                                                         " degress Fahrenheit.");
        }
        
        // 4. Close scanner.
        input.close();
    }
}
