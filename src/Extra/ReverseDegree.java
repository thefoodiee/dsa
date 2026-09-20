package Extra;

import java.util.HashMap;

public class ReverseDegree {
    static void main() {
//        System.out.println((char) 97);
//        revreseDegree("abc");
        System.out.println(revreseDegree("zaza"));
    }

    static int revreseDegree(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<26; i++){
            map.put((char) (97+i), 26-i);
        }

        int ans = 0;

        for(int i = 0; i<s.length(); i++){
            int reversePos = map.get(s.charAt(i));
            ans += (reversePos * (i+1));
        }
        return ans;
    }
}
