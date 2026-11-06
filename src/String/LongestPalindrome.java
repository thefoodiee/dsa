package String;

public class LongestPalindrome {
    static void main() {
        System.out.println(longest("babad"));
    }

    static String longest(String s){
        String ans = "";
        int max = 0;

        for(int i = 0; i<s.length(); i++){
            int l = i, r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    ans = s.substring(l, r+1);
                    max = r-l+1;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    ans = s.substring(l, r+1);
                    max = r-l+1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
