package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void main() {
        System.out.println(combination(
                new int[]{2,3,6,7},
                new ArrayList<>(),
                new ArrayList<>(),
                0,
                7,
                0
        ));
    }
    static List<List<Integer>> combination(
            int[] arr,
            ArrayList<Integer> curr,
            List<List<Integer>> ans,
            int total,
            int target,
            int i
            ){
        if(total == target){
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        if(i >= arr.length || total > target){
            return ans;
        }

        curr.add(arr[i]);
        combination(arr, curr, ans, total+arr[i], target, i);

        curr.removeLast();
        combination(arr, curr, ans, total, target, i+1);
        return ans;
    }
}
