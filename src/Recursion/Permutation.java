package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static void main() {
        System.out.println(perm(
                new int[]{1,2,3},
                new ArrayList<>(),
                new ArrayList<>()
        ));
    }

    static List<List<Integer>> perm(int[] arr, ArrayList<Integer> subset, List<List<Integer>> ans){
        if(subset.size() == arr.length){
            ans.add(new ArrayList<>(subset));
            return ans;
        }

        // try EVERY unused element instead of using global i in function param
        for(int i = 0; i<arr.length; i++){
            if(subset.contains(arr[i])) continue;

            subset.add(arr[i]);
            perm(arr, subset, ans);
            subset.removeLast();
        }
        return ans;
    }
}
