package Arrays;

import java.util.Arrays;

public class NextPermutation {
    static void main() {
        int[] arr = {2,3,1};
        next(arr);
    }

    static void next(int[] arr){
        //find breaking point
        int pivotPos = -1;
        int n = arr.length;
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                pivotPos = i;
                break;
            }
        }

        //no pivot
        if(pivotPos == -1){
            reverse(arr, 0, n-1);
            System.out.println(Arrays.toString(arr));
            return;
        }

        //find first greater element
        for(int i = n-1; i>=pivotPos; i--){
            if(arr[i] > arr[pivotPos]){
                //swap
                int temp = arr[i];
                arr[i] = arr[pivotPos];
                arr[pivotPos] = temp;
                break;
            }
        }

        int[] ans = reverse(arr, pivotPos+1, n-1);
        System.out.println(Arrays.toString(ans));
    }

    static int[] reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
