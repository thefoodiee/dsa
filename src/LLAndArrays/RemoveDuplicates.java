package LLAndArrays;

import java.util.Arrays;

public class RemoveDuplicates {
    static void main() {
        int[] arr = {1,2};
        System.out.println(remove(arr));
    }
    static int remove(int[] arr){
        if(arr.length < 2) return 1;
        int l = 1;
        int r = 1;
        while(r<arr.length){
            if(arr[r] > arr[l-1]){
                arr[l] = arr[r];
                l++;
            }
            r++;
            System.out.println(Arrays.toString(arr));
        }
        return l;
    }
}
