package Practice;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    static void main() {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValid(board));
    }
    static boolean isValid(char[][] board){
        //check rows
        for(int i = 0; i<9; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j<board.length; j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }

        //check cols
        for(int i = 0; i<9; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j<board.length; j++){
                if(board[j][i] != '.'){
                    if(set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }

        //check 3x3 boxes
        for(int row = 0; row<9; row+=3){
            for(int col = 0; col<9; col+=3){
                Set<Character> set = new HashSet<>();
                for(int i = row; i<row+3; i++){
                    for(int j = col; j<col+3; j++){
                        if(board[i][j] != '.'){
                            if(set.contains(board[i][j])) return false;
                            set.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
