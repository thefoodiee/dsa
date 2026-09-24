package Arrays4;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    static void main() {
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

    static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            else{
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }
}
