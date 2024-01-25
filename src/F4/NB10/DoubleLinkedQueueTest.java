package F4.NB10;

import java.util.NoSuchElementException;

public class DoubleLinkedQueueTest {
    public static void main(String[] args) {
        DoubleLinkedQueue<String> queue = new DoubleLinkedQueue<>();

        queue.offerFirst("first");
        queue.offerLast("last");
        queue.offerFirst("before first");
        queue.offerLast("after last");

        System.out.println("Queue after offers: " + queue);

        System.out.println("Polled from first: " + queue.pollFirst());
        System.out.println("Queue after polling first: " + queue);

        System.out.println("Polled from last: " + queue.pollLast());
        System.out.println("Queue after polling last: " + queue);

        System.out.println("Polled from first: " + queue.pollFirst());
        System.out.println("Queue after removing all but one element: " + queue);

        System.out.println("Polled from last: " + queue.pollLast());
        System.out.println("Queue after removing all elements: " + queue);

        try {
            queue.pollFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught as expected: " + e.getMessage());
        }
    }
}
