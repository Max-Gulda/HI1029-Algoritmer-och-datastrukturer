package F1;

import java.util.ArrayList;

import static F1.ReplaceClass.replace;

public class P1Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hej");
        list.add("hopp");
        list.add("hej");
        list.add("då");
        System.out.println(list);
        replace(list,"hej", "okej");
        System.out.println(list);
    }
}

