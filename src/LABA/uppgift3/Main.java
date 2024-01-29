package LABA.uppgift3;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> l = new SingleLinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        Iterator<String> iter = l.iterator();
        //iter.next();
        //iter.next();
        //iter.remove();
        //iter.next();
        iter.remove();
        System.out.println(l);
        //SingleLinkedList<String> list = new SingleLinkedList<>();
//
        //list.add("First");
        //list.add("Second");
        //list.add("Third");
        //System.out.println("List after initial additions: " + list);
//
        //// Using iterator to remove the second element
        //Iterator<String> iterator = list.iterator();
        //while (iterator.hasNext()) {
        //    String element = iterator.next();
        //    if ("Second".equals(element)) {
        //        iterator.remove();
        //    }
        //}
//
        //System.out.println("List after removing 'Second': " + list);
//
        //list.add("Fourth");
        //list.add("Fifth");
        //System.out.println("List after adding more elements: " + list);
//
        //iterator = list.iterator();
        //if (iterator.hasNext()) {
        //    iterator.next();
        //    iterator.remove();
        //}
        //System.out.println("List after removing the first element: " + list);
//
        //System.out.println("Remaining elements in the list:");
        //iterator = list.iterator();
        //while (iterator.hasNext()) {
        //    System.out.println(iterator.next());
        //}
    }
}
