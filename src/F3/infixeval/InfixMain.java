package F3.infixeval;

import java.util.Scanner;

public class InfixMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = " ";
        while(str != ""){
            System.out.println("Enter an infix expression: ");
            str = scan.nextLine();
            if(str == "") break;
            int result = InfixToPostfix.infixCalculator(str);

            System.out.println("Result: " + result);
        }
        scan.close();
    }
}

