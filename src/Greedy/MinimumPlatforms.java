package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPlatforms {
    static void main() {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
//        System.out.println(minPlatformsBrute(arr, dep));
//        System.out.println(minPlatformsBetter(arr, dep));
        System.out.println(minPlatformsOptimal(arr, dep));
    }
    static int minPlatformsBrute(int[] arr, int[] dep){
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            int count = 1;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] <= dep[i] && dep[j] >= arr[i]){
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    static int minPlatformsBetter(int[] arr, int[] dep){
        int max = 0;
        List<List<Integer>> time = new ArrayList<>();
        int idx = 0;
        for(int i : arr){
            time.add(Arrays.asList(i, 0));
            idx++;
        }
        for(int i : dep){
            time.add(Arrays.asList(i, 1));
            idx++;
        }
        time.sort((a,b) -> Integer.compare(a.get(0),b.get(0)));

        int count = 0;
        for(int i = 0; i<time.size(); i++){
            if(time.get(i).get(1) == 0){
                count++;
            }
            else if(time.get(i).get(1) == 1){
                count--;
            }
            max = Math.max(count, max);
        }

        return max;

    }

    static int minPlatformsOptimal(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0;
        int j = 0;
        int max = 0;
        int count = 0;
        while(i<n){
            if(arr[i] <= dep[j]){
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}