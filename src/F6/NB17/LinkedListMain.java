package F6.NB17;

import java.util.NoSuchElementException;

public class LinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        // Adding elements
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        // Testing size method
        System.out.println("Size of the list: " + list.size());

        // Testing getNode method
        try {
            System.out.println("Element at index 0: " + list.getNode(0));
            System.out.println("Element at index 1: " + list.getNode(1));
            System.out.println("Element at index 2: " + list.getNode(2));
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // Testing for an invalid index
        try {
            System.out.println("Element at an invalid index: " + list.getNode(3));
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}

