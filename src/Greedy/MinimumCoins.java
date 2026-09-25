package Greedy;

public class MinimumCoins {
    static void main() {
        coins(39);
    }
    static void coins(int n){
        int[] coins = {1,2,5,10};

        int count = 0;
        int sum = 0;
        int idx = coins.length-1;

        while(idx >= 0){
            if(sum == n) break;
            int coin = coins[idx];
            if(sum + coin > n){
                idx--;
                continue;
            }
            sum += coin;
            count++;

        }
        System.out.println(count);
    }
}
