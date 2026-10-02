package RecursionNBacktracking;

import java.util.*;

public class NQueens {
    static void main() {
        int n = 4;
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        System.out.println(nQueens(
                n,
                0,
                board,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new ArrayList<>()
        ));
    }

    static List<List<String>> nQueens(int n, int row, char[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> ans){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            ans.add(temp);
            return ans;
        }

        for(int i = 0; i<n; i++){
            if(cols.contains(i) || posDiag.contains(row+i) || negDiag.contains(row-i)){
                continue;
            }

            cols.add(i);
            posDiag.add(row+i);
            negDiag.add(row-i);
            board[row][i] = 'Q';

            nQueens(n, row+1, board, cols, posDiag, negDiag, ans);

            cols.remove(i);
            posDiag.remove(row+i);
            negDiag.remove(row-i);
            board[row][i] = '.';
        }
        return ans;
    }

}
