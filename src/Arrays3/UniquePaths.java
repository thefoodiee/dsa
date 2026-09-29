package Arrays3;

import java.util.Arrays;

public class UniquePaths {
    static void main() {
        System.out.println(paths(3,1));
    }
    static int paths(int m, int n){
        if(m==1 || n==1) return 1;
        int[][] matrix = new int[m][n];

        //fill top row with 1
        Arrays.fill(matrix[0], 1);

        //fill 1st col with 1
        for(int i = 0; i<matrix.length; i++){
            matrix[i][0] = 1;
        }

        //compute all paths
        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[1].length; j++){
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }
        return matrix[m-1][n-1];
    }
}
