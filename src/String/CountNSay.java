package String;

public class CountNSay {
    static void main() {
        System.out.println(count(5, new StringBuilder()));
    }
    static String count(int n, StringBuilder curr){
        if(n == 1) {
            curr.append("1");
            return curr.toString();
        }

        count(n-1, curr);
        curr.replace(0, curr.length(), getRLE(curr.toString()));
        return curr.toString();
    }

    static String getRLE(String s){
        char[] c = s.toCharArray();
        int count = 1;
        int l = 0, r = 1;
        StringBuilder sb = new StringBuilder();

        while(l<s.length() && r<s.length()){
            if(c[l] == c[r]){
                count++;
                r++;
            }
            else{
                sb.append(count);
                sb.append(c[l]);
                l = r;
                r++;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c[l]);
        return sb.toString();
    }
}
