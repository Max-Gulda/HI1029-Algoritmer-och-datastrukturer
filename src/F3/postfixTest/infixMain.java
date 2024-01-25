package F3.postfixTest;

import java.util.Scanner;

public class infixMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = " ";
        while (s != "") {
            System.out.println("Enter expression: ");
            s = scan.nextLine();
            if(s == "") break;
            try{
                System.out.println(s + " = " + postfixEval.calcInfix(s));
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
