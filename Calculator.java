/*
  Here the main logic is that We take two numbers as a input and then
 using switch case we perform basic arithmatic operations 
 */
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {  //move on this line is just part of template😛
        //declaring variables
        double n1;
        double n2;
        double ans;
        char op;

        Scanner sc = new Scanner(System.in);  // creating an object (name sc) (of Scanner class) to take input into system from user
        
        System.out.println("Enter two numbers:");

        n1 = sc.nextDouble();  // now take one decimal number as a input and store it in n1 variable
        n2 = sc.nextDouble();  // now take one decimal number as a input and store it in n2 variable

        System.out.println("Enter the operator (+,-,*,/):");

        op = sc.next().charAt(0);
        switch (op) {
            case '+': ans = n1 + n2; break;
            case '-': ans = n1 - n2; break;
            case '*': ans = n1 * n2; break;
            case '/': ans = n1 / n2; break;
            default:
                System.out.println("Error! Enter correct operator");
                sc.close();
                return;
        }
        System.out.println("The result is:");
        System.out.println(n1 + " " + op + " " + n2 + " = " + ans);
        sc.close();  
    }
}