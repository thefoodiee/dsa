package Arrays;

import java.util.Arrays;

public class SortColors {
    static void main() {
        sort(new int[]{0,0,1,0,2,1,2});
    }
    static void sort(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid<=high){
            if(arr[mid] == 0){
                swap(mid, low, arr);
                mid++; low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(mid, high, arr);
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
