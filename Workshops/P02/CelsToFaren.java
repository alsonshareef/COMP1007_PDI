import java.util.*;

public class CelsToFaren 
{
    public static void main(String[] args)
    {
        Scanner SC = new Scanner(System.in);
        double celsius, farenheit;

        System.out.print("Please enter degrees in Celsius: ");
        celsius = SC.nextInt();

        farenheit = ((9.0/5.0) * celsius) + 32;
        
        System.out.println(celsius + " degrees Celsius is " + farenheit + " degrees in Fahrenheit");
        SC.close();
    }
}
