package Practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    static void main() {
        System.out.println(
                partition(
                        "aab",
                        0,
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
    }
    static List<List<String>> partition(
            String s,
            int ptr,
            List<List<String>> ans,
            ArrayList<String> curr
    ){
        if(ptr >= s.length()){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int i = ptr; i<s.length(); i++){
            if(isPalinrome(s, ptr, i)){
                curr.add(s.substring(ptr, i+1));

                partition(s, i+1, ans, curr);

                curr.removeLast();
            }
        }
        return ans;
    }

    static boolean isPalinrome(String s, int l, int r){
//        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}
