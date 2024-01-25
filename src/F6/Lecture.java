package F6;

import java.util.LinkedList;
import java.util.Queue;

public class Lecture {

    //Kan du ge exempel på rekursiva funktioner som är effektivare med djupet först?

    private static class Tillstand{
        public int position, antalResor;
        public Tillstand(int p, int a) {
            position = p;
            antalResor = a;
        }
    }

    static void hanoi(int n, int f, int t, int x){
        if(n>0){
            hanoi(n-1,f,x,t);
            System.out.println(f+"=>" + t);
            hanoi(n-1,x,t,f);
        }
    }

    static int antalResorHiss(int n, int upp, int ned, int destination){
        return antalResorHiss(n,upp,ned,1,destination,0);
    }

    static int antalResorHiss(int n, int upp, int ned, int position, int destination, int antalResor){
        if(position == destination) return antalResor;
        if(antalResor>30) return Integer.MAX_VALUE;
        int up = position + upp <= n ? antalResorHiss(n,upp,ned,position+upp,destination,antalResor+1): Integer.MAX_VALUE;
        int down = position - ned >= 1 ? antalResorHiss(n,upp,ned,position-ned,destination,antalResor+1) : Integer.MAX_VALUE;
        return Math.min(up,down);
    }

    static int antalResorHissBredd(int n, int upp, int ned, int destination) {
        Queue<Tillstand> q = new LinkedList<>();
        Tillstand t = new Tillstand(1,0);

        while(t.position != destination){
            if(t.position + upp <= n){
                q.offer(new Tillstand(t.position+upp,t.antalResor+1));
            }
            if(t.position - ned > 0){
                q.offer(new Tillstand(t.position-ned, t.antalResor+1));
            }
            t=q.poll();
        }
        return t.antalResor;
    }



    public static void main(String[] args) {
        //System.out.println(antalResorHiss(78, 15 , 8, 35));
        System.out.println(antalResorHiss(7,3,1,2));
        System.out.println(antalResorHissBredd(7,3,1,2));
        hanoi(3,1,2,3);
    }
}
