package F3.arrayliststack;

import java.util.EmptyStackException;

public class ArrayListStackMain {
    public static void main(String[] args) {
        ArrayListStack<Integer> arrayListStack = new ArrayListStack<>();

        System.out.println("Initial ArrayList Stack: " + arrayListStack);

        // Pushing elements onto the stack
        for (int i = 1; i <= 5; i++) {
            arrayListStack.push(i);
            System.out.println("Pushed " + i + ": " + arrayListStack);
        }

        // Peeking at the top element
        try {
            System.out.println("Peek at top element: " + arrayListStack.peek());
        } catch (EmptyStackException e) {
            System.out.println("Cannot peek, stack is empty.");
        }

        // Popping elements from the stack
        while (!arrayListStack.isEmpty()) {
            try {
                System.out.println("Popped: " + arrayListStack.pop() + ", Stack after pop: " + arrayListStack);
            } catch (EmptyStackException e) {
                System.out.println("Cannot pop, stack is empty.");
            }
        }

        // Checking if the stack is empty
        System.out.println("Is stack empty? " + arrayListStack.isEmpty());

        // Attempting to pop from an empty stack
        try {
            arrayListStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught exception while popping from an empty stack: " + e.getMessage());
        }

        // Attempting to push null to the stack
        try {
            arrayListStack.push(null);
        } catch (NullPointerException e) {
            System.out.println("Caught exception while pushing null: " + e.getMessage());
        }
    }
}
