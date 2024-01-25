package F4.NB8;

public class TestArrayQueue {
    public static void main(String[] args){
        ArrayQueue<String> queue = new ArrayQueue<>(10);
        for(int i = 1; i < 9; i++){
            queue.offer("e" + i);
        }
        System.out.println(queue + ", Size : " + queue.size());
        StringBuilder b = new StringBuilder("Polling the following elements: ");
        for(int i = 0 ; i < 5; i++){
            b.append(queue.poll()).append(", ");
        }
        b.append(queue.poll());
        System.out.println(b.toString());
        System.out.println(queue);

        b = new StringBuilder("\nPolling the following elements: ");
        b.append(queue.poll()).append(", ");
        b.append(queue.poll());
        System.out.println(b.toString());
        System.out.println(queue);
        for (int i = 9; i < 15; i++){
            queue.offer("e"+i);
        }
        System.out.println(queue);

        while(queue.peek() != null){
            System.out.println(queue.poll());
        }
        System.out.println(queue);
    }
}
