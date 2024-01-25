package F2.NB2;

public class IntListMain {
    public static void main(String[] args){
        IntList myList = new IntList(2);
        myList.add(3);
        myList.add(0, 2);
        System.out.println(myList);
        System.out.println("Size of the list is: " + myList.size());
        System.out.println("Index of 3 is: " + myList.indexOf(3));
        try{
            System.out.println("At index 3 is: " + myList.get(3));
        }catch (Exception e) {
            System.out.println("There is no number at index 3");
        }
        myList.add(13);
        myList.add(37);
        System.out.println("My list is : " + myList);
        try{
            System.out.println("At index 3 is: " + myList.get(3));
        }catch (Exception e) {
            System.out.println("There is no number at index 3");
        }
        myList.remove(3);
        System.out.println("My list is : " + myList);

        myList.set(2, 31415);
        System.out.println(myList);

    }
}
