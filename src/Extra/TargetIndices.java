package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndices {
    static void main() {
        System.out.println(target(
                new int[]{1,2,5,2,3},
                2
        ));
    }
    static List<Integer> target(int[] arr, int target){
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == target){
                ans.add(i);
            }
        }
        return ans;
    }
}
