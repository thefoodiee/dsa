package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsTwo {
    static void main() {
        System.out.println(subsets(
                new int[]{1,2,2},
                new ArrayList<>(),
                new ArrayList<>(),
                0
        ));
    }
    static List<List<Integer>> subsets(int[] arr, ArrayList<Integer> subset, List<List<Integer>> ans, int i){
        if(i  == arr.length){
            ans.add(new ArrayList<>(subset));
            return ans;
        }

        subset.add(arr[i]);
        subsets(arr, subset, ans, i+1);

        while(i+1 < arr.length && arr[i] == arr[i+1]) i++;
        subset.removeLast();
        subsets(arr,subset,ans,i+1);
        return ans;
    }
}
