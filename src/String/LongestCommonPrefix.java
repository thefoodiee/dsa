package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    static void main() {
        System.out.println(
                prefix(new String[]{"dog"})
        );
    }
    static String prefix(String[] arr){
        StringBuilder s = new StringBuilder();
        Arrays.sort(arr);

        String first = arr[0];
        String last = arr[arr.length-1];

        int iter = Math.min(first.length(), last.length());

        for(int i = 0; i<iter; i++){
            if(first.charAt(i) == last.charAt(i)){
                s.append(first.charAt(i));
            }
            else{
                break;
            }
        }
        return s.toString();
    }
}
