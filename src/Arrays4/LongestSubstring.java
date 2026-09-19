package Arrays4;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    static void main() {
        longest("pwwkew");
    }
    static void longest(String s){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;

        for(int right = 0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            int len = right-left+1;
            max = Math.max(len, max);
        }
        System.out.println(max);
    }
}
