package F5.NB141;

import java.util.Scanner;
public class MarblesMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int blue;
        int red;
        int white;
        do {
            System.out.print("Enter number of blue marbles: ");
            blue = scan.nextInt();
            System.out.print("Enter number of white marbles: ");
            white = scan.nextInt();
            System.out.print("Enter number of red marbles: ");
            red = scan.nextInt();
            System.out.println(Marbles.marbles(red,blue,white) + " swaps is needed!");
        } while(blue != 0 || red != 0 || white != 0);
    }
}
