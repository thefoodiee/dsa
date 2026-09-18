package Arrays4;

import java.util.HashMap;

public class SubarraySumEqualsK {
    static void main() {
        System.out.println(subarr(new int[]{1,1,1}, 2));
    }
    static int subarr(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
