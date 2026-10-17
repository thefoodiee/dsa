package Practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void main() {
        System.out.println(
                combination(
                        new int[]{2,3,5},
                        8,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        0,
                        0
                )
        );
    }

    static List<List<Integer>> combination(
            int[] arr,
            int target,
            List<List<Integer>> ans,
            ArrayList<Integer> curr,
            int sum,
            int ptr
    ){
        if(sum == target){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        if(ptr >= arr.length || sum > target){
            return ans;
        }

        curr.add(arr[ptr]);
        sum += arr[ptr];
        combination(arr, target, ans, curr, sum, ptr);

        curr.removeLast();
        sum -= arr[ptr];
        combination(arr, target, ans, curr, sum, ptr+1);

        return ans;
    }
}
