package LABA.uppgift2;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("First");
        list.add("Second");
        list.add("Third");
        System.out.println("List after adding elements: " + list);
        
        list.add(1, "Inserted");
        System.out.println("List after inserting an element: " + list);

        System.out.println("Removed element: " + list.remove(2));
        System.out.println("List after removing an element: " + list);

        System.out.println("Removed element: " + list.remove(0));
        System.out.println("List after removing the first element: " + list);

        System.out.println("Element at index 1: " + list.get(1));

        System.out.println("\nIterating through the list:");
        for (String s : list) {
            System.out.println(s);
        }

        list.remove(0);
        list.remove(0);
        System.out.println("List after removing all elements: " + list);

        list.add("New first");
        list.add("New second");;
        list.add("New third");
        try{
            list.add(null);
            System.out.println("Adding null");
        }catch (Exception e){
            System.out.println("Couldn't add null to list." + e.getMessage());
        }
        System.out.println("List after adding back items: " + list);
    }
}
