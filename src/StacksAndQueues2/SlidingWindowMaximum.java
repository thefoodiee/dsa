package StacksAndQueues2;

import java.util.*;

public class SlidingWindowMaximum {
    static void main() {
        System.out.println(
                Arrays.toString(slide(new int[]{1,3,-1,-3,5,3,6,7}, 3))
        );
    }

    static int[] slide(int[] arr, int k){
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n-k+1];

        //setup deque for first k ele
        for(int i = 0; i<k; i++){
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        ans[0] = arr[deque.peekFirst()];

        //remaining ele
        for(int i = k; i<n; i++){
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            ans[i-k+1] = arr[deque.peekFirst()];
        }
        return ans;
    }
}
