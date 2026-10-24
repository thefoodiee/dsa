package Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    static void main() {
        System.out.println(Arrays.toString(nge(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }

    static int[] nge(int[] arr1, int[] arr2){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr1.length; i++){
            map.put(arr1[i], i);
        }

        int[] res = new int[arr1.length];
        Arrays.fill(res, -1);

        for(int i = 0; i<arr2.length; i++){
            if(map.containsKey(arr2[i])){
                for(int j = i+1; j<arr2.length; j++){
                    if(arr2[j] > arr2[i]){
                        res[map.get(arr2[i])] = arr2[j];
                        break;
                    }
                }
            }
        }
        return res;
    }
}
