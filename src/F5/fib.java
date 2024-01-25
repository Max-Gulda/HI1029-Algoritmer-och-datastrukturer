package F5;

public class fib {

    static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    static int fak(int n){
        if(n==1) return 1;
        return fak(n-1) * n;
    }

    static int binarySearch(int[] arr, int obj){
        System.out.println(arr.length-1);
        return bser(arr, obj, 0, arr.length-1);
    }

    private static int bser(int[] arr, int obj, int low, int high){
        if(low > high) return -1;

        int middle = low + (high-low) / 2;

        if (arr[middle] == obj) {
            return middle;
        }else if (arr[middle] > obj) {
            return bser(arr,obj,low,middle - 1);
        } else {
            return bser(arr,obj,middle + 1, high);
        }
    }

    static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y,x % y);
    }

    static int antalVägar(int m, int n){
        return av(m,n);
    }

    private static int av(int m, int n){
        if(m == 0 && n == 0) return 1;
        else{
            int result = 0;
            if(m>0) result = av(m-1,n);
            if(n>0) result += av(m,n-1);
            return result;
        }
    }

    public static void main(String[] args){
        //System.out.println(fib(7));
        //System.out.println(fak(5));
        //int[] list = new int[10];
        //list[0] = 1;
        //list[1] = 2;
        //list[2] = 3;
        //list[3] = 4;
        //list[4] = 5;
        //list[5] = 6;
        //list[6] = 7;
        //list[7] = 8;
        //list[8] = 9;
        //list[9] = 10;
//
        //System.out.println(binarySearch(list,10));
//
        //System.out.println(gcd(21,78));

        System.out.println(antalVägar(2,2));
    }
}
