package BinarySearch;

public class SingleNonDuplicate {
    static void main() {
        System.out.println(find(new int[]{1,1,2,2,4,4,8}));
    }
    static int find(int[] arr){
        int n = arr.length;

        if(arr.length == 1) return arr[0];

        if(arr[0] != arr[1]) return arr[0];

        if(arr[n-2] != arr[n-1]) return arr[n-1];

        int l = 0;
        int r = arr.length-2;
        while(l<=r){
            int mid = (l+r)/2;
            boolean isMidEven = mid%2 == 0;

            if((!isMidEven && arr[mid-1] == arr[mid]) || (isMidEven && arr[mid+1] == arr[mid])){
                l = mid+1;
            }
            else if((!isMidEven && arr[mid+1] == arr[mid]) || (isMidEven && arr[mid-1] == arr[mid])){
                r = mid-1;
            }
            else if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
        }
        return -1;
    }
}
