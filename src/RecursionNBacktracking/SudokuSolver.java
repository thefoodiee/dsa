package RecursionNBacktracking;

public class SudokuSolver {
    static void main() {
    }

    static boolean solve(char[][] board, int row, int col){
        if(row == 9) return true;
        int nextRow = row;
        int nextCol = col+1;

        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(board[row][col] != '.'){
            return solve(board, nextRow, nextCol);
        }

        for(char i = '1'; i<='9'; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solve(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, char digit){
        for(int i = 0; i<9; i++){
            if(board[row][i] == digit){
                return false;
            }
        }

        for(int i = 0; i<9; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        int sRow = (row/3) * 3;
        int sCol = (col/3) * 3;

        for(int i = sRow; i<= sRow+2; i++){
            for(int j = sCol; j<=sCol+2; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
}
