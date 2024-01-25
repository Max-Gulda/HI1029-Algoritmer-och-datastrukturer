package F2;

public class F2Main {
    public static void main(String[] args){
        SingleLinkedList<String> myList = new SingleLinkedList<>();
        myList.add("Banan");
        myList.add("Melon");
        myList.add("Kiwi");
        myList.add("och");
        myList.add("Citron");
        System.out.println(myList);
        for(String obj: myList){
            System.out.println(obj);
        }
    }
}
