package F5.NB12;

import java.util.Scanner;

public class Pow {
    private Pow(){}

    public static int powRec(int x, int n){
        if(n==0) return 1;
        return powRec(x,n-1)*x;
    }

    public static int powIter(int x, int n){
        int result = 1;
        for(int i = 0; i < n; i++){
            result *= x;
        }
        return result;
    }
}
