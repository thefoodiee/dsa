package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CombinationSumTwo {
    static void main() {
        int[] arr = {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        System.out.println(
                combination(
                        arr,
                        8,
                        0,
                        0,
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
    }
    static List<List<Integer>> combination(
            int[] arr,
            int target,
            int sum,
            int ptr,
            List<List<Integer>> ans,
            ArrayList<Integer> curr

    ){
        if(sum == target){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        if(ptr >= arr.length || sum>target){
            return ans;
        }

        curr.add(arr[ptr]);
        sum += arr[ptr];
        combination(arr, target, sum, ptr+1, ans, curr);

        //skip dupes
        while(ptr+1<arr.length && arr[ptr] == arr[ptr+1]) ptr++;

        curr.removeLast();
        sum -= arr[ptr];
        combination(arr, target, sum, ptr+1, ans, curr);

        return ans;
    }

    static List<List<Integer>> comb(
            int[] arr,
            int target,
            int sum,
            int ptr,
            Set<List<Integer>> ans,
            ArrayList<Integer> curr

    ){
        if(sum == target){
            ans.add(new ArrayList<>(curr));
            return new ArrayList<>(ans);
        }

        if(ptr >= arr.length || sum>target){
            return new ArrayList<>(ans);
        }

        curr.add(arr[ptr]);
        sum += arr[ptr];
        comb(arr, target, sum, ptr+1, ans, curr);

        curr.removeLast();
        sum -= arr[ptr];
        comb(arr, target, sum, ptr+1, ans, curr);

        return new ArrayList<>(ans);
    }
}
