package F5.NB13;

public class Sqrt {
    private Sqrt() {}

    public static double sqrt(double number){
        return ROT(number, 1.0, 0.001);
    }

    private static double ROT(double n, double a, double e){
        if(Math.abs((a*a) - n) < e) return a;
        return ROT(n,((a*a) + n)/(2*a),e);
    }

}
