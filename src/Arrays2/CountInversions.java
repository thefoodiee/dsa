package Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {
    static void main() {
        mergeSort(new int[]{2,4,1,3,5}, 0, 4);
        System.out.println(mergeSort(new int[]{2,4,1,3,5}, 0, 4));
    }
    static int mergeSort(int[] arr, int start, int end){
        if(start<end){
           int mid = start + ((end-start) / 2);
           int leftCount = mergeSort(arr, start, mid);
           int rightCount = mergeSort(arr, mid+1, end);
           int count = merge(arr, start, mid, end);
           return leftCount + rightCount + count;
        }
        return 0;
    }

    static int merge(int[] arr, int start, int mid, int end){
        List<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid+1;
        int invCount = 0;

        while(i <= mid && j <= end){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
                invCount += mid-i+1;
            }
        }

        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=end){
            temp.add(arr[j]);
            j++;
        }

        for(int k = 0; k<temp.size(); k++){
            arr[start+k] = temp.get(k);
        }
        return invCount;
    }
}
