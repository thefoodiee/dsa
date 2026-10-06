package Extra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
        // check row
        for(int i = 0; i<9; i++){
            Set<Character> rows = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(rows.contains(board[i][j])) return false;
                rows.add(board[i][j]);
            }
        }

        //check cols
        for(int i = 0; i<9; i++){
            Set<Character> cols = new HashSet<>();
            for(int j = 0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(cols.contains(board[j][i])) return false;
                cols.add(board[j][i]);
            }
        }

        //check boxes
        for(int row = 0; row<9; row+=3){
            for(int col = 0; col<9; col+=3){
                Set<Character> box = new HashSet<>();
                for(int i = row; i<row+3; i++){
                    for(int j = col; j<col+3; j++){
                        if(board[i][j] == '.') continue;
                        if(box.contains(board[i][j])) return false;
                        box.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
