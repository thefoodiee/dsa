package Practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static void main() {
        System.out.println(perm(
                new int[]{1,2,3},
                new ArrayList<>(),
                new ArrayList<>()
        ));
    }
    static List<List<Integer>> perm(int[] arr, ArrayList<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int j = 0; j<arr.length; j++){
            if(curr.contains(arr[j])) continue;

            curr.add(arr[j]);

            perm(arr, curr, ans);

            curr.removeLast();
        }

        return ans;
    }
}
