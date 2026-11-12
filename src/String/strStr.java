package String;

public class strStr {
    static void main() {
        System.out.println(find("leetcode", "leeto"));
    }

    static int find(String haystack, String needle){
        int r = needle.length();
        for(int i = 0; i<haystack.length(); i++){
            if(r<=haystack.length()){
                String sub = haystack.substring(i, r);
                if(sub.equals(needle)) return i;
            }
            r++;
        }
        return -1;
    }
}
