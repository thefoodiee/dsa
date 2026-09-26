package Recursion;

public class Init {
    static void main() {
//        printNums(5);
//        System.out.println(factorial(5));
//        System.out.println(sumN(10));
//        System.out.println(fibonacci(6));
        System.out.println(isSorted(new int[]{1,2,3,4,5}, 4));
    }
    static void printNums(int n){
        if(n == -1) return;
        System.out.println(n);
        printNums(n-1);
    }
    static int factorial(int n){
        if(n == 0){
            return 1;
        }

        return n * factorial(n-1);
    }
    static int sumN(int n){
        if(n == 1) return 1;
        return n + sumN(n-1);
    }
    static int fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    static boolean isSorted(int[] arr, int n){
        if(n == 0 || n == 1) return true;
        return arr[n-1] >= arr[n-2] && isSorted(arr, n-1);
    }
}
