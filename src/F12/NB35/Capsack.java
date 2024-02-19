package F12.NB35;

import java.util.*;

public class Capsack {

    private static class item implements Comparable<item>{
        public int cost;
        public int weight;

        public item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
        @Override
        public int compareTo(item o) {
            return -Double.compare((double)cost/weight, (double) o.cost/o.weight);
        }

        @Override
        public String toString(){
            return "cost : " + cost + " weight : " + weight;
        }
    }

    public static void capsac(int sizeOfCapsack, List<item> items){
        Collections.sort(items);
        int index = 0;
        int weight = 0;
        int amountOfMoney = 0;
        while (index < items.size()){
            while(weight + items.get(index).weight <= sizeOfCapsack){
                weight += items.get(index).weight;
                System.out.println("Adding: " + items.get(index).cost);
                amountOfMoney += items.get(index).cost;
            }
            index++;
        }
        System.out.println("Total weight brought = " + weight + " kg");
        System.out.println("Total cost brought = " + amountOfMoney + " kr");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<item> items = new ArrayList<>();

        System.out.println("Enter the capacity of the capsack: ");
        int sizeOfCapsack = scanner.nextInt();

        System.out.println("Enter the number of items: ");
        int numberOfItems = scanner.nextInt();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter cost and weight for item " + (i + 1) + " (separated by space): ");
            int cost = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new item(cost, weight));
        }

        capsac(sizeOfCapsack, items);

        scanner.close();
    }
}
