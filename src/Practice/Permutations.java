package Practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static void main() {
        boolean[] used = new boolean[3];
        System.out.println(
                perm(
                        new int[]{1,2,3},
                        new boolean[3],
                        0,
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
    }

    static List<List<Integer>> perm(
            int[] arr,
            boolean[] used,
            int ptr,
            List<List<Integer>> ans,
            ArrayList<Integer> curr
    ){
        if(ptr >= arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int i = 0; i<arr.length; i++){
            if(used[i]) continue;
            curr.add(arr[i]);
            used[i] = true;

            perm(arr, used, ptr+1, ans, curr);

            curr.removeLast();
            used[i] = false;
        }
        return ans;
    }
}
