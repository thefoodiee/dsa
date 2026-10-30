package StacksAndQueues2;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {
    static void main() {
//        System.out.println(Arrays.toString(nse(new int[]{4,8,5,2,25})));
//        System.out.println(Arrays.toString(pse(new int[]{1, 6, 2})));
        System.out.println(largestBrute(new int[]{2,4}));
    }

    static int largestBrute(int[] arr){
        int ans = 0;
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        for(int i = 0; i<arr.length; i++){
            ans = Math.max(ans, arr[i]*(nse[i] - pse[i] - 1));
        }
        return ans;
    }

    static int[] nse(int[] arr){
        int[] ans = new int[arr.length];
        Arrays.fill(ans, arr.length);

        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    static int[] pse(int[] arr){
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        Stack<Integer> stack =  new Stack<>();

        for(int i = 0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}
