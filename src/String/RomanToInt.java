package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    static void main() {
        System.out.println(convert("LVIII"));
    }
    static int convert(String roman){
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V',5,
                'X',10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000
        );

        int sum = 0;
        sum += map.get(roman.charAt(roman.length()-1));
        for(int i = roman.length()-2; i>=0; i--){
            char prev = roman.charAt(i+1);
            int currNum = map.get(roman.charAt(i));
            int prevNum = map.get(prev);
            if(currNum<prevNum){
                sum -= currNum;
            }
            else{
                sum += currNum;
            }
        }
        return sum;
    }
}
