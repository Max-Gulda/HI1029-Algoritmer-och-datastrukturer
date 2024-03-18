package F14.NB49;

import java.util.*;

public class Capsack {

    private static class Item implements Comparable<Item>{
        public int price, weight;
        public Item(int price, int weight){
            this.price = price;
            this.weight = weight;
        }
        @Override
        public int compareTo(Item o) {
            return Double.compare(((double)o.price / o.weight ), ((double)this.price / this.weight));
        }

        @Override
        public String toString() {

            return price + "kr & " + weight + "kg";
        }
    }

    public static int capsack(int weight, List<Item> list){
        int[] dp = new int[weight+1];
        Arrays.fill(dp, 0);
        for(int i = 0; i < weight+1; i++){
            for(Item item: list){
                if(i - item.weight >= 0){
                    dp[i] = Math.max(dp[i], dp[i-item.weight] + item.price);
                }
            }
        }
        return dp[weight];
    }

    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(3,5));
        list.add(new Item(2, 2));
        list.add(new Item(5,4));
        System.out.println(capsack(1,list));

    }
}
