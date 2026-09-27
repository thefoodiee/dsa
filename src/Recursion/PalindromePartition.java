package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition {
    static void main() {
        String s = "aab";
        System.out.println(partition(
                s,
                new ArrayList<>(),
                new ArrayList<>(),
                0
        ));
    }

    static List<List<String>> partition(
            String s,
            ArrayList<String> curr,
            List<List<String>> ans,
            int i
    ){
        if(i>= s.length()){
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int j = i; j<s.length(); j++){
            if(isPalindrome(s, i, j)){
                curr.add(s.substring(i,j+1));
                partition(s, curr, ans, j+1);

                curr.removeLast();
            }
        }
        return ans;
    }
    static boolean isPalindrome(String s, int l, int r){
//        int l = 0;
//        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
