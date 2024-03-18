package F13.NB43;

import java.util.Scanner;

public class Change {

    public static int växel(int belopp, int[] valutor){
        for(int valuta: valutor){
            if(valuta == belopp) return 1;
        }
        if(belopp <= 0) return Integer.MAX_VALUE;
        int sum = belopp;
        for(int i = 1; i < belopp/2; i++){
            sum = Math.min(växel(i, valutor) + växel(belopp - i, valutor), sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Hur många olika valutor finns det?");
            int length = scan.nextInt();
            if(length == 0) break;
            int[] a = new int[length];
            for(int i = 0; i < length; i++){
                System.out.print("Valuta " + (i + 1) + " : ");
                a[i] = scan.nextInt();
            }
            System.out.println("Hur mycket vill du växla? ");
            int money = scan.nextInt();
            System.out.println("Det kan växlas med : " + växel(money, a) + " st");

        }
        System.out.println("Ending simulation...");
    }
}
