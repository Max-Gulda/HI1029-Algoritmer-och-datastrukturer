package F6.NB16;

import java.util.Scanner;

public class CoinMachineMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int points = 1;
        while(points >= 0){
            System.out.print("Vilken poäng ska uppnås: ");
            points = scan.nextInt();
            if(points >= 1){
                int result = CoinMachine.machineImproved(points);
                if(result >= 0) System.out.println("Poängen kan uppnås med: " + result + "kr");
                else System.out.println("Poängen går ej att uppnå!");
            }else{
                System.out.println("Tack för att du testade CoinMachine 2.0");
                break;
            }


        }
    }
}
