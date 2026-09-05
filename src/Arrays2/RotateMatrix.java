package Arrays2;

import java.util.Arrays;

class RotateMatrix {
    static void main() {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    static void rotate(int[][] matrix){
        int x = matrix[0].length;
        int y = matrix.length;
        //transpose
        for(int i = 0; i<y-1; i++){
            for(int j = i+1; j<x; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse every row
        for(int i = 0; i<y; i++){
            int l = 0, r = x-1;
            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
