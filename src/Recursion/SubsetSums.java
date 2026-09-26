package Recursion;

import java.util.ArrayList;

public class SubsetSums {
    static void main() {
        System.out.println(sums(new int[]{1,2,1}, new ArrayList<>(), 0, 0));
    }
    static ArrayList<Integer> sums(int[] arr, ArrayList<Integer> ans, int sum, int i){
        if(i == arr.length){
            ans.add(sum);
            return ans;
        }

        sum += arr[i];
        sums(arr, ans, sum, i+1);

        sum -= arr[i];
        sums(arr, ans, sum, i+1);
        return ans;
    }
}
