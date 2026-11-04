package String;

import java.util.Arrays;

public class ReverseWords {
    static void main() {
        System.out.println(reverse("the sky is blue"));
    }

    static String reverse(String s){
        String[] str = s.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();
        for(int i = str.length-1; i>=0; i--){
            ans.append(str[i]);
            if(i!=0) ans.append(" ");
        }

        return ans.toString();
    }
}
