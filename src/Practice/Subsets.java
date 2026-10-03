package Practice;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    static void main() {
        System.out.println(subsets(
                new int[]{1,2,3},
                new ArrayList<>(),
                new ArrayList<>(),
                0
        ));
    }
    static List<List<Integer>> subsets(int[] arr, ArrayList<Integer> curr, List<List<Integer>> ans, int i){
        if(i == arr.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        curr.add(arr[i]);

        subsets(arr, curr, ans, i+1);

        curr.removeLast();

        subsets(arr, curr, ans, i+1);

        return ans;
    }
}
