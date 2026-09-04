package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    static void main() {
//        System.out.println(nCr(5,3));
//        printRow(5);
        printTree(5);
    }
    static long nCr(int row, int col){
        long res = 1;
        for(int i = 0; i<col; i++){
            res = res * (row-i);
            res = res / (i+1);
        }
        return res;
    }

    static List<Integer> printRow(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i = 1; i<row; i++) {
            int prev = ans.get(i-1);
            prev = prev * (row - i);
            prev = prev / i;
            ans.add(prev);
        }
        return ans;
    }

    static void printTree(int len){
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= len; i++) {
            ans.add(printRow(i));
        }
        System.out.println(ans);
    }
}
