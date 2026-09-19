package Extra;

import java.util.Arrays;

public class CyclicShift {
    static void main() {
        cyclicShift(new int[][]{{1,2,3},{4,5,6}, {7,8,9}}, 3, new int[]{1,2,0}, new int[]{2,2,1});
    }
    static int[][] cyclicShift(int[][] matrix, int n, int[] rowShift, int[] colShift){
        for(int i = 0; i<n; i++){
            rotateRowLeft(matrix, i, rowShift[i]);
        }
        for(int i = 0; i<n; i++){
            rotateColUp(matrix, i, colShift[i]);
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    static void rotateRowLeft(int[][] matrix, int row, int k){
        //rotate from 0 to k-1
        int l = 0;
        int r = k-1;
        while(l<r){
            int temp = matrix[row][l];
            matrix[row][l] = matrix[row][r];
            matrix[row][r] = temp;
            l++;
            r--;
        }

        //reverse from k to end
        l = k;
        r = matrix[row].length-1;
        while(l<r){
            int temp = matrix[row][l];
            matrix[row][l] = matrix[row][r];
            matrix[row][r] = temp;
            l++;
            r--;
        }

        //revrese whole arr
        l = 0;
        r = matrix[row].length-1;
        while(l<r) {
            int temp = matrix[row][l];
            matrix[row][l] = matrix[row][r];
            matrix[row][r] = temp;
            l++;
            r--;
        }
    }

    static void rotateColUp(int[][] matrix, int col, int k){
        //rotate from 0 to k-1
        int l = 0;
        int r = k-1;
        while(l<r){
            int temp = matrix[l][col];
            matrix[l][col] = matrix[r][col];
            matrix[r][col] = temp;
            l++;
            r--;
        }

        //reverse from k to end
        l = k;
        r = matrix[0].length-1;
        while(l<r){
            int temp = matrix[l][col];
            matrix[l][col] = matrix[r][col];
            matrix[r][col] = temp;
            l++;
            r--;
        }

        //revrese whole arr
        l = 0;
        r = matrix[col].length-1;
        while(l<r) {
            int temp = matrix[l][col];
            matrix[l][col] = matrix[r][col];
            matrix[r][col] = temp;
            l++;
            r--;
        }
    }

}
