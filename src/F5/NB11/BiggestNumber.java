package F5.NB11;

public class BiggestNumber {

    private BiggestNumber(){}

    public static int biggestNumber(int[] arr){
        return bN(arr,Integer.MIN_VALUE, 0);
    }

    private static int bN(int[] arr, int biggest, int index){
        if(index >= arr.length) return biggest;
        if(arr[index] > biggest) return bN(arr, arr[index], index + 1);
        return bN(arr, biggest, index + 1);
    }
}
