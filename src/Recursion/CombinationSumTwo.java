package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    static void main() {
        int[] arr = {2,5,2,1,2};
        Arrays.sort(arr);
        System.out.println(comb(
                arr,
                new ArrayList<>(),
                new ArrayList<>(),
                0,
                5,
                0
        ));
    }
    static List<List<Integer>> comb(
            int[] arr,
            ArrayList<Integer> curr,
            List<List<Integer>> ans,
            int sum,
            int target,
            int i
    ){
        if(sum == target){
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        if(i>=arr.length || sum > target){
            return ans;
        }

        curr.add(arr[i]);
        comb(arr, curr, ans, sum+arr[i], target, i+1);
        while(i+1<arr.length && arr[i] == arr[i+1]) i++;

        curr.removeLast();
        comb(arr, curr, ans, sum, target, i+1);
        return ans;
    }
}
