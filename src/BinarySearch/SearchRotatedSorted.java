package BinarySearch;

public class SearchRotatedSorted {
    static void main() {
        System.out.println(search(
                new int[]{4,5,6,7,0,1,2},
                7
        ));
    }
    static int search(int[] arr, int target){
        //find pivot first
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]>arr[r]){
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        int pivot = l;
        l = 0;
        r = arr.length-1;
        if(target >= arr[pivot] && target <= arr[r]){
            l = pivot;
        }
        else{
            r = pivot-1;
        }

        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
}
