package Greedy;

import java.util.Arrays;

public class AssignCookies {
    static void main() {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(cookies(g, s));
    }
    static int cookies(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        if(s.length == 0) return 0;
        int count = 0;
        int j = 0, i = 0;
        while(i<g.length && j<s.length){
            if(s[j] == g[i]) {
                count++;
                j++;
                i++;
            }
            else j++;
        }
        return count;
    }
}
