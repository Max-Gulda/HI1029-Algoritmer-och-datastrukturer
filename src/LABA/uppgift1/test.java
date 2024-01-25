package LABA.uppgift1;

import java.util.ArrayList;

public class test {
    public static int test(int n){
        int r = 0;
        for ( int i = 1; i <=n; i++){
            for (int j = 1; j<=i;j++){
                for (int k = j; k <= i+j;k++){
                    for(int m=1; m <=i+j-k;m++){
                        r++;
                    }
                }
            }
        }
        return r;
    }
    public static void main(String[] args) {
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= 40; i++){
            t.add(i);
        }
        for (int i : t){
            result.add(test(i));
            System.out.println("n = " + i + " : " + test(i));
        }

        StringBuilder b = new StringBuilder("[");
        for(int i : result) {
            b.append(i).append(" ");
        }
        b.append("]");
        System.out.println(b.toString());

        System.out.println(test(100));
    }
}
