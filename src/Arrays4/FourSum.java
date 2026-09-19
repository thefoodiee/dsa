package Arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    static void main() {

        sum(new int[]{2,2,2,2,2},8);
    }
    static void sum(int[] arr, int target){
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(i>0 && arr[i-1] == arr[i]) continue;
            for(int j = i+1; j<arr.length; j++){
                if(j>i+1 && arr[j-1] == arr[j]) continue;
                int k = j+1;
                int l = arr.length-1;

                while(k<l){
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum<target) k++;
                    else if(sum>target)l--;
                    else{
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        ans.add(temp);

                        k++;
                        l--;
                        while(k<arr.length && arr[k] == arr[k-1])k++;
                        while(l<arr.length && arr[l] == arr[l-1])l--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
