package F4.NB81;

import F4.NB81.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String [] args){
        ArrayQueue<String> queue = new ArrayQueue<>(4);
        queue.offer("first");
        queue.offer("second");
        queue.poll();
        queue.poll();
        System.out.println(queue);
        queue.offer("third");
        queue.offer("forth");
        queue.offer("fifth");
        queue.offer("sixth");
        queue.offer("seventh");
        queue.offer("eigth");
        //System.out.println(queue);
        queue.offer("ninth");
        queue.offer("tenth");
        queue.offer("eleventh");
        System.out.println(queue);

        StringBuilder b = new StringBuilder("Polling :");
        for(int i = 0; i < 8; i++){
            b.append(queue.poll()).append(" ");
        }
        b.append("off the list.");
        System.out.println(b.toString());
        System.out.println(queue);
    }
}
