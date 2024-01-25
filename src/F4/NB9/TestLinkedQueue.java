package F4.NB9;

public class TestLinkedQueue {
    public static void main(String[] args){
        LinkedQueue<String> queue = new LinkedQueue<>();
        for(int i = 0; i < 8; i++){
            queue.enqueue("e"+i);
        }
        System.out.println(queue);
        StringBuilder b = new StringBuilder("Dequeing the following elements: ");
        for(int i = 0; i < 4; i++){
            b.append(queue.dequeue()).append(" ");
        }
        System.out.println(b.toString());
        System.out.println(queue);
        System.out.println("Dequeuing the rest of the elements, size of queue = " + queue.size());
        int size = queue.size();
        for(int i = 0; i < size; i++){
            System.out.println("Dequeing : " + queue.dequeue());
        }
        System.out.println(queue);


    }
}
