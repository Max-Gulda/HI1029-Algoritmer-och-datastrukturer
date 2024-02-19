package F12.NB37;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class EgyptianFraction {

    public static void fraction(int num, int den) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).append("/").append(den).append(" = ");

        while (num > 0) {
            int ceiling = (den + num - 1) / num;
            sb.append("1/").append(ceiling);

            num = num * ceiling - den;
            den = den * ceiling;

            if (num > 0) {
                sb.append(" + ");
            }
        }

        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        fraction( 5 ,121);
    }
}
