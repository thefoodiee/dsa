package StackAndQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    static void main() {
        ngeOptimal(
                new int[]{2,4},
                new int[]{1,2,3,4}
        );
    }
    static void nge(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();
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
        System.out.println(Arrays.toString(res));
    }

    static void ngeOptimal(int[] arr1, int[] arr2){
        // store arr1[i] -> i
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr1.length; i++){
            map.put(arr1[i], i);
        }

        //initialize ans arr
        int[] res = new int[arr1.length];
        Arrays.fill(res, -1);

        //monotonic stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<arr2.length; i++){
            while(!stack.isEmpty() && arr2[i] > stack.peek()){
                int top = stack.pop();
                res[map.get(top)] = arr2[i];
            }

            //only add elements of array 1 in stack
            if(map.containsKey(arr2[i])){
                stack.push(arr2[i]);
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
