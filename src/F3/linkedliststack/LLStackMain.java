package F3.linkedliststack;

public class LLStackMain {
    public static void main(String[] Args) {
        LinkedListStack<Integer> LLStack = new LinkedListStack<>();

        System.out.println("Linked List stack : " + LLStack);
        LLStack.push(3);
        for (int i = 0; i < 10; i++) {
            LLStack.push(i);
        }
        System.out.println("Linked List stack : " + LLStack);

        // Testing peek() and size() methods
        System.out.println("Top element is: " + LLStack.peek());
        System.out.println("Size of Linked List Stack: " + LLStack.size());

        // Testing peek(int n) method
        try {
            System.out.println("Element at position 3: " + LLStack.peek(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
        }

        // Testing flush() method
        System.out.println("Flushed data: " + LLStack.flush());
        System.out.println("Linked List stack after flush: " + LLStack);

        while (!LLStack.isEmpty()) {
            int result = LLStack.pop();
            System.out.println("Popped " + result + " from linked list stack");
        }

        if (LLStack.isEmpty()) {
            System.out.println("Linked list stack is empty");
        } else {
            System.out.println("This should not happen!");
        }

        // Testing exception handling for null inputs
        try {
            LLStack.push(null);
        } catch (NullPointerException ne) {
            System.out.println("\nLinked list " + ne.getMessage());
        }
    }
}
