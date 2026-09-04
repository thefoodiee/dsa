package Arrays;

public class SellStock {
    static void main() {
        stock(new int[]{7,1,5,3,6,4});
    }
    static void stock(int[] arr){
        int mini = arr[0];
        int profit = 0;
        for(int i = 1; i<arr.length; i++){
            int cost = arr[i] - mini;
            profit = Math.max(cost, profit);
            mini = Math.min(mini, arr[i]);
        }
        System.out.println(profit);
    }
}
