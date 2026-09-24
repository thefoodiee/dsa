package LLAndArrays;

import java.util.*;

public class ThreeSum {
    static void main() {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
    static List<List<Integer>> threeSum(int[] arr){
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++){
            int l = i+1;
            int r = arr.length-1;
            while(l<r){
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == 0){
                    ans.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    l++;
                    r--;
                }
                else if(sum<0){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
