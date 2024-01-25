package F5.NB12;

import java.util.Scanner;

public class PowMain {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int n = 1;
        while(x != 0 || n != 0){
            System.out.print("Enter x: ");
            x = scan.nextInt();
            System.out.print("Enter n: ");
            n = scan.nextInt();
            if(x != 0 || n != 0){
                System.out.println("Pow Rec : " + Pow.powRec(x,n));
                System.out.println("Pow Itr : " + Pow.powIter(x,n));
            }
        }
    }
}
