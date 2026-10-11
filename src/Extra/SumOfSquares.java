package Extra;

public class SumOfSquares {
    static void main() {
        System.out.println(sum(
                new int[]{1,2,3,4}
        ));
    }
    static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr.length % (i+1) == 0){
                sum += (arr[i] * arr[i]);
            }
        }
        return sum;
    }
}
