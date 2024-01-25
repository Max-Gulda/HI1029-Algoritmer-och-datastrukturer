package F4.pp7;

import java.util.Scanner;

import static F4.pp7.pp7.infixCalc;

public class pp7Main {
    public static void main(String[] args){
        String exp = " ";
        Scanner scan = new Scanner(System.in);
        while(exp != ""){
            System.out.print("Enter expression or press enter to exit: ");
            exp = scan.nextLine();
            if("".equals(exp)){
                System.out.println("Thanks for trying out the calculator!");
            }else {
                try{
                    System.out.println(infixCalc(exp));
                }catch (Exception e) {
                    System.out.println("Expression couldn't be calculated : " + e.getMessage());
                }
            }

        }
    }
}
