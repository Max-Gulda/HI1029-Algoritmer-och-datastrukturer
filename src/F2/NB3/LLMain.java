package F2.NB3;

public class LLMain {
    public static void main(String[] args){
        Node head = new Node();
        head.data = "Gilgamesh";

        Node node1 = new Node();
        node1.data = "löper";

        Node node2 = new Node();
        node2.data = "på";

        Node node3 = new Node();
        node3.data = "stäppen";

        //Linking the list to eachother
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        //Printing the list
        Node current = head;
        System.out.println("The linked list:");
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

        //Removing "på" from the list
        current = head.next;
        Node previous = head;
        while (current != null){
            if(current.data.equals("på")) {
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("\nPrinting after removing \"på\"");
        current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

        //Adding back på
        System.out.println("\nAdding back \"på\"");
        current = head.next;
        while(current != null){
            if(current.data.equals("löper")) current.next = node2;
            current = current.next;
        }

        current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

        Node head2 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();

        head2.data = "när";
        node5.data = "den";
        node6.data = "brinner";

        head2.next = node5;
        node5.next = node6;
        node6.next = null;

        current = head2;
        System.out.println("\nSecond linked list:");
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("\nLinking the list togheter");
        current = head;
        while(current != null){

            current = current.next;
            if (current.next == null){
                current.next = head2;
                break;
            }
        }

        System.out.println("\nPrinting the merged list");
        current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

        //Splitting the list
        current = head;
        while (current != null){
            if(current.data.equals("stäppen")){
                current.next = null;
            }
            current = current.next;
        }

        System.out.println("\nCutting the list");
        System.out.println("\nList 1:");
        current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("\nList 2:");
        current = head2;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
