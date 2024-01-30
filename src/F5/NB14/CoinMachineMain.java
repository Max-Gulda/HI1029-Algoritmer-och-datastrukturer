package F5.NB14;

import java.util.Scanner;

public class CoinMachineMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int points = 1;
        while(points >= 0){
            System.out.print("Vilken poäng ska uppnås: ");
            points = scan.nextInt();
            int result = CoinMachine.machine(points);
            int result2 = CoinMachine.theMachine2(1,points);
            if(result >= 0) System.out.println("Poängen kan uppnås med: " + result + " eller med räknesätt 2: " + result2);
            else System.out.println("Poängen går ej att uppnå!");

        }
    }
}
