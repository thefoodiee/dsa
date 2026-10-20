package Practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    static void main() {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solve(board, 0);
        System.out.println(Arrays.deepToString(board));
    }

    // the function is responsible for value at each cell
    static boolean solve(
            char[][] board,
            int idx
    ){
        if(idx == 81){
            return true;
        }

        int row = idx/9;
        int col = idx%9;

        if(board[row][col] != '.'){
            return solve(board, idx+1);
        }

        for(char i = '1'; i<='9'; i++){
            if(isValid(board, row, col, i)){
                board[row][col] = i;
                if(solve(board, idx+1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    static boolean isValid(char[][] board, int row, int col, char num){
        //check row
        for(int i = 0; i<9; i++){
            if(board[row][i] == num) return false;
        }

        //check cols
        for(int i = 0; i<9; i++){
            if(board[i][col] == num) return false;
        }

        //check 3x3 box
        int searchRow = (row/3) * 3;
        int searchCol = (col/3) * 3;

        for(int i = searchRow; i<=searchRow+2; i++){
            for(int j = searchCol; j<= searchCol+2; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
}
