package Practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    static void main() {
        System.out.println(perm(
                new int[]{1,2,3},
                new boolean[]{false, false, false},
                new ArrayList<>(),
                new ArrayList<>(),
                0
        ));
    }

    static List<List<Integer>> perm(
            int[] arr,
            boolean[] used,
            List<List<Integer>> ans,
            ArrayList<Integer> curr,
            int i
    ){
        if(i == arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int j = 0; j<arr.length; j++){
            if(used[j]) continue;
            curr.add(arr[j]);
            used[j] = true;

            perm(arr, used, ans, curr, i+1);

            curr.removeLast();
            used[j] = false;
        }
        return ans;
    }
}
