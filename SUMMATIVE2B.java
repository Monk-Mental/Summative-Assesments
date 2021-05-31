
package summative2b;
import java.util.Scanner;
/**
 *[Summative2B.java]
 * A Program that finds the hypotenuse off a right triangle
 * @author Arya Peer
 */

public class SUMMATIVE2B {
    
    public static void main(String[] args) {
        //declare and initialize input
        Scanner input = new Scanner(System.in);
        
        //Declare variables
        double a, b, c, a2, b2;
        String name, last;
        int pos = 0;
        
        //ask for and get full name
        System.out.println("Enter your full name: ");
        name=input.nextLine();
        
        //ask for and get side a leangth
        System.out.println("Enter the length of Side A");
        //set a to inputted value
        a=input.nextDouble();
        
        //ask for and get length of side b
        System.out.println("Enter the length of Side B");
        //set b to inputted value
        b=input.nextDouble();
        
        //setting a2 and b2 to a to the power of 2 and b to the power of 2
        a2=Math.pow(a,2);
        b2=Math.pow(b,2);
        
        //setting c to the square root of a^2+b^2 and rounding it off
        c=Math.sqrt(a2+b2);
        c= Math.round(c* 100.0) / 100.0;
        
        //find the position of the space
        pos = name.indexOf(" ");
        //get the last name
        last = name.substring(pos + 1, name.length());
        //set first letter of last name to capital
        last =(last.substring(0, 1).toUpperCase())+ last.substring(1);
        
        //output last name
        System.out.println("Mr. " +last+", the hypotenuse of your triangle is: "+c);
        
        //close input
        input.close();

    }
    
}
