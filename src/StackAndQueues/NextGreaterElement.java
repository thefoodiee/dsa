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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr1.length; i++){
            map.put(arr1[i], i);
        }

        int[] ans = new int[arr1.length];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = arr2.length - 1; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(arr2[i]);
                ans[i] = -1;
                continue;
            }

            if(stack.peek() > arr2[i]){
                ans[i] = stack.peek();
                stack.push(arr2[i]);
                continue;
            }

            while(stack.peek() <= arr2[i] && !stack.isEmpty()){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(arr2[i]);
        }
        System.out.println(Arrays.toString(ans));
    }
}
