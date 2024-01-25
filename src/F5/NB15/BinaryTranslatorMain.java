package F5.NB15;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BinaryTranslatorMain {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String scanned = "";
            while (true) {
                System.out.print("Enter 'bin' to translate binary to decimal, 'dec' to translate decimal to binary, or 'exit' to quit: ");
                scanned = scan.nextLine().trim();

                if ("bin".equals(scanned)) {
                    System.out.print("Enter binary number: ");
                    String binaryInput = scan.nextLine().trim();
                    System.out.println(binaryInput + " in decimal = " + BinaryTranslator.binToDec(binaryInput));
                } else if ("dec".equals(scanned)) {
                    System.out.print("Enter decimal number: ");
                    try {
                        int decimalInput = scan.nextInt();
                        scan.nextLine(); // Clear buffer
                        System.out.println(decimalInput + " in binary = " + BinaryTranslator.decToBin(decimalInput));
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid decimal number. Please enter a valid integer.");
                        scan.nextLine(); // Clear buffer
                    }
                } else if ("exit".equals(scanned)) {
                    break;
                } else {
                    System.out.println("Unknown command, please try again.");
                }
            }
        }
    }
}

