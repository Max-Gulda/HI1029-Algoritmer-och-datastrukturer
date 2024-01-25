package F1;

import java.util.ArrayList;

import static F1.DeleteClass.delete;

public class P2Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("äpple");
        list.add("äpple");
        list.add("päron");
        list.add("banan");
        list.add("melon");
        System.out.println(list);
        delete(list,"äpple");
        System.out.println(list);
    }
}

