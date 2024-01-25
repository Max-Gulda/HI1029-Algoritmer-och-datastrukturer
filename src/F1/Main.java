package F1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> mylist = new ArrayList<>();
        mylist.add("hej");
        mylist.add("hopp");
        mylist.add("gummi");
        mylist.add("s*!#p");
        mylist.add("hej");
        mylist.add("då");

        System.out.println(count(mylist,"hej"));
        replace(mylist, "hej", "haha");
        System.out.println(mylist);


    }
    public static int count(List<String> list, String s){
        int number = 0;
        for (String obj: list){
            if(s.equals(obj)) number++;
        }
        return number;
    }
    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for(int i = 0; i < aList.size(); i++){
            if(aList.get(i).equals(oldItem)){
                aList.set(i, newItem);
            }
        }
    }
    public static void delete(ArrayList<String> aList, String target){
        for(int i = 0; i < aList.size(); i++){
            if(aList.get(i).equals(target)){
                aList.remove(i);
                return;
            }
        }
    }
}