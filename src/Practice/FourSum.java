package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    static void main() {
        System.out.println(
                sum(
                        new int[]{1,0,-1,0,-2,2},
                        0
                )
        );
    }
    static List<List<Integer>> sum(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<arr.length; i++){
            if(i>0 && arr[i-1] == arr[i]) continue;
            for(int j = i+1; j<arr.length; j++){
                if(j>i+1 && arr[j-1] == arr[j]) continue;
                int l = j+1;
                int r = arr.length-1;

                while(l<r){
                    long sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if(sum<target){
                        l++;
                    }
                    else if(sum > target){
                        r--;
                    }
                    else{
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
                        ans.add(temp);
                        l++;
                        r--;
                        while(l<r && arr[l-1] == arr[l]) l++;
                        while(l<r && arr[r+1] == arr[r]) r--;
                    }
                }
            }
        }
        return ans;
    }
}
