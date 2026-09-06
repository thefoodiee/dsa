package Arrays2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static void main() {
        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
    static int[][] merge(int[][] arr){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int LEP = arr[0][1], LSP = arr[0][0];
        for(int i = 0; i<arr.length; i++){
            int CSP = arr[i][0];
            int CEP = arr[i][1];
            if(CSP <= LEP){
                LEP = Math.max(CEP, LEP);
            }
            else{
                ans.add(new int[]{LSP, LEP});
                LSP = CSP;
                LEP = CEP;
            }
        }
        //add ending elements
        ans.add(new int[]{LSP, LEP});
        return ans.toArray(new int[ans.size()][]);
    }
}
