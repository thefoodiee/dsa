package Arrays2;

import java.util.Arrays;

public class MergeSortedArray {
    static void main() {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
    static void merge(int[] arr1, int m, int[] arr2, int n){
        if(m == 0){
            for(int i = 0; i<arr2.length; i++){
                arr1[i] = arr2[i];
            }
            return;
        }

        else if(n == 0) return;

        int idx1 = m-1;
        int idx2 = n-1;
        int numIdx = arr1.length-1;
        while(idx1 >= 0 && idx2 >= 0){
            if(arr1[idx1] > arr2[idx2]){
                arr1[numIdx] = arr1[idx1];
                idx1--;
            }
            else{
                arr1[numIdx] = arr2[idx2];
                idx2--;
            }
            numIdx--;
        }
        //copy remaining from arr2
        while(idx2>=0){
            arr1[numIdx] = arr2[idx2];
            idx2--;
            numIdx--;
        }
        System.out.println(Arrays.toString(arr1));
    }
}
