package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    static void main() {
//        System.out.println(perm(
//                "abc",
//                new StringBuilder(),
//                new ArrayList<>()
//        ));
//        List<String> ans = perm(
//                "123",
//                new StringBuilder(),
//                new ArrayList<>()
//        );
//        System.out.println(getK(ans, 3));
//        System.out.println(getK(39705,8));
        System.out.println(optimal(3,3));
    }

    static String getK(int k, int n){
        String s = "";
        for(int i = 0; i<n; i++){
            s += (char) i+1;
        }

        List<String> ans = perm(s, k, new StringBuilder(), new ArrayList<>());
        return ans.get(k-1);
    }

    static List<String> perm(String s, int k, StringBuilder subset, List<String> ans){
        if(ans.size() == k){
            return ans;
        }
        if(subset.length() == s.length()){
            ans.add(subset.toString());
            return ans;
        }

        for(int i = 0; i<s.length(); i++){
            if(subset.indexOf(String.valueOf(s.charAt(i))) != -1) continue;
            subset.append(s.charAt(i));

            perm(s, k, subset, ans);
            subset.deleteCharAt(subset.length()-1);
        }
        return ans;
    }

    static String optimal(int n, int k){
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i<n; i++){
            fact = fact * i;
            nums.add(i);
        }

        nums.add(n);
        String ans = "";
        k = k-1;

        while(true){
            ans += nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size() == 0){
                break;
            }
            k = k%fact;
            fact = fact/nums.size();
        }
        return ans;
    }
}
