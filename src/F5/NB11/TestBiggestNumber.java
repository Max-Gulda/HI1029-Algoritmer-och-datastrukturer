package F5.NB11;

public class TestBiggestNumber {
    public static void main(String[] args){
        int [] arr = new int[10];

        StringBuilder b = new StringBuilder("Array is : [");
        for(int i = 0; i < arr.length; i++){
            b.append(arr[i]);
            if(i < arr.length -1) b.append(", ");
            else b.append("]");
        }
        System.out.println(b.toString());


        for(int i = 0; i < arr.length - 2 ; i++){
            arr[i] = 13 % (4 + i);
        }

        b = new StringBuilder("Array is : [");
        for(int i = 0; i < arr.length; i++){
            b.append(arr[i]);
            if(i < arr.length -1) b.append(", ");
            else b.append("]");
        }
        System.out.println(b.toString());

        System.out.println("Biggest number is: " + BiggestNumber.biggestNumber(arr));
    }
}
