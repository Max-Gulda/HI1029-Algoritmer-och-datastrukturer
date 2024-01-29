package F6.NB16;

import java.util.Scanner;

public class CoinMachineMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int points = 1;
        while(points >= 0){
            System.out.print("Vilken poäng ska uppnås: ");
            points = scan.nextInt();
            int result = CoinMachine.theMachineImproved(points);
            if(result >= 0) System.out.println("Poängen kan uppnås med: " + result + " kr");
            else System.out.println("Poängen går ej att uppnå!");

        }
    }
}
