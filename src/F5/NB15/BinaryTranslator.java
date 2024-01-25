package F5.NB15;

import java.util.Scanner;

public class BinaryTranslator {
    private BinaryTranslator(){}

    public static String decToBin(int decimalNumber){
        StringBuilder sb = new StringBuilder();
        return dec2Bin(decimalNumber, sb);
    }

    public static int binToDec(String s){
        return bin2Dec(s,0,0);
    }

    private static int bin2Dec(String s, int index, int dec){
        if(index == s.length()) return dec;
        if (s.charAt(index) == '1') {
            return bin2Dec(s,index + 1, (dec * 2)+1);
        }
        return bin2Dec(s, index + 1, dec*2);
    }

    private static String dec2Bin(int number, StringBuilder b){
        if (number == 0) return b.reverse().toString();
        b.append(number % 2);
        return dec2Bin(number / 2, b);
    }
}
