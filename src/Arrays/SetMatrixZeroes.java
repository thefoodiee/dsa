package Arrays;

import java.util.Arrays;

public class SetMatrixZeroes {
    static void main() {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
//        setZeroBrute(matrix);
//        setZeroBetter(matrix);
        setZeroOptimal(matrix);
    }

    //naive approach
    static void setZeroBrute(int[][] matrix){
        int x = matrix[0].length;
        int y = matrix.length;

        for(int i = 0; i<y; i++){
            for(int j = 0; j<y; j++){
                if(matrix[i][j] == 0){
                    setRow(i, matrix,-1);
                    setCol(i, matrix, -1);
                }
            }
        }

        for(int i = 0; i<y; i++){
            for(int j = 0; j<x; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    static void setRow(int row, int[][] matrix, int num){
        for(int i = 0; i<matrix[0].length; i++){
            matrix[row][i] = num;
        }
    }
    static void setCol(int col, int[][] matrix, int num){
        for(int i = 0; i<matrix.length; i++){
            matrix[i][col] = num;
        }
    }

    //better
    static void setZeroBetter(int[][] matrix){
        int x = matrix[0].length;
        int y = matrix.length;

        int[] hashRow = new int[x];
        int[] hashCol = new int[y];
        for(int i = 0; i<y; i++){
            for(int j = 0; j<x; j++){
                if(matrix[i][j] == 0){
                    hashCol[i] = 1;
                    hashRow[j] = 1;
                }
            }
        }

        for(int e:hashRow){
            if(e == 1){
                setRow(e,matrix,0);
            }
        }

        for(int e:hashCol){
            if(e==1){
                setCol(e, matrix, 0);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    static void setZeroOptimal(int[][] matrix){
        int x = matrix[0].length;
        int y = matrix.length;

        int hashCol = 1;

        for(int i = 0; i<y; i++){
            if (matrix[i][0] == 0) {
                hashCol = 0;
                break;
            }
        }
        for(int i = 0; i<y; i++){
            for(int j = 1; j<x; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // inner matrix
        for(int i = 1; i<y; i++){
            if(matrix[i][0] == 0){
                setRow(i, matrix, 0);
            }
        }
        for(int i = 1; i<x; i++){
            if(matrix[0][i] == 0){
                setCol(i, matrix, 0);
            }
        }

        // 0 row
        if(matrix[0][0] == 0){
            setRow(0,matrix,0);
        }

        // 0 col
        if(hashCol == 0){
            setCol(0,matrix,0);
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
