import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double n1;
        double n2;
        double ans;
        char op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
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