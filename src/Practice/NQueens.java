package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NQueens {
    static void main() {
        int n = 4;
        char[][] board = new char[n][n];
        for(char[] c: board){
            Arrays.fill(c, '.');
        }
        System.out.println(
                nQueens(
                        n,
                        0,
                        new ArrayList<>(),
                        board,
                        new HashSet<>(),
                        new HashSet<>(),
                        new HashSet<>()
                )
        );
    }

    static List<List<String>> nQueens(
            int n,
            int row,
            List<List<String>> ans,
            char[][] board,
            HashSet<Integer> cols,
            HashSet<Integer> posDiag,
            HashSet<Integer> negDiag
    ){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] c : board){
                temp.add(new String(c));
            }
            ans.add(temp);
            return ans;
        }

        for(int col = 0; col<n; col++){
            if(cols.contains(col) || posDiag.contains(row+col) || negDiag.contains(row-col)) continue;

            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row+col);
            negDiag.add(row-col);

            nQueens(n, row+1, ans, board, cols, posDiag, negDiag);

            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(row-col);
        }

        return ans;
    }
}
