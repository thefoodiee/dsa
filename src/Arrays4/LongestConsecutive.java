package Arrays4;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutive {
    static void main() {
        System.out.println(longestOptimal(new int[]{100,4,200,1,3,2}));
//        longestOptimal(new int[]{100,4,200,1,3,2});
    }

    static int longestBetter(int[] arr){
        Arrays.sort(arr);
        int count = 0;
        int lastSmallest = Integer.MIN_VALUE;
        int max = 0;

        for(int i = 0; i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;

            if(arr[i] != lastSmallest+1){
                count = 1;
            }
            else{
                count++;
            }
            lastSmallest = arr[i];
            max = Math.max(count, max);
        }
        return max;
    }

    static int longestOptimal(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int count = 0;
        int max = 0;
        for(Integer key : map.keySet()){
            int curr = key-1;
            if(map.containsKey(curr)) {
                count = 1;
                continue;
            }
            else{
                int next = key+1;
                count = 1;
                while(map.containsKey(next)){
                    count++;
                    next += 1;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
