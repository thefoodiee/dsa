package Arrays2;

public class SearchMatrix {
    static void main() {
//        System.out.println(binarySearch(new int[]{1,2,3,4,5}, 6));
        int[][] mat = {{1,2,3}, {4,6,7}, {8,9,10}};
//        System.out.println(search(mat, 5));
        System.out.println(optimal(mat, 4));
    }
    static boolean search(int[][] matrix, int target){
        int x = matrix[0].length;
        int y = matrix.length;

        for(int i = 0; i<y; i++){
            if(target >= matrix[i][0] && target <= matrix[i][x-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    static boolean binarySearch(int[] arr, int target){
        int l = 0;
        int  r = arr.length-1;
        while(l<=r){
             int mid = l + ((r-l)/2);
             if(arr[mid] == target){
                 return true;
             }
             else if(arr[mid] < target){
                 l = mid+1;
             }
             else{
                 r = mid-1;
             }
        }
        return false;
    }

    static boolean optimal(int[][] matrix, int target){
        // hypothetically flatten the array and then perform binary search
        int x = matrix[0].length;
        int y = matrix.length;

        int l = 0;
        int r = x*y-1;

        while(l<=r){
            int mid = l + ((r-l)/2);
            int rowIdx = mid/x;
            int colIdx = mid%x;

            if(matrix[rowIdx][colIdx] > target){
                r = mid-1;
            }
            else if(matrix[rowIdx][colIdx] < target){
                l = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
