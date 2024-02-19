package TentaPlugg;

public class klocka {
    public static int klocka(int end, int start){
        end %= 12;
        start %= 12;
        return klocka(end,start,0);
    }

    public static int klocka(int end, int start, int points){
        if(end == start) return points;
        //System.out.println("current : " + start + ", end : " + end + " button presses : " + points);
        if(points == 15) return Integer.MAX_VALUE;
        int ten = klocka(end, (start + 10)%12, points + 1);
        int seven = klocka(end, (start + 7)%12, points + 1);
        return Math.min(ten, seven);
    }


    public static void main(String[] args) {
        System.out.println(klocka(11,12));
    }
}
