package Practice;

import java.util.Arrays;

public class TrappingRainwater {
    static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapOptimal(arr));
    }

    static int trapBrute(int[] arr){
        int n = arr.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int[] min = new int[n];

        //construct leftmax and rightmax arr
        maxLeft[0] = 0;
        for(int i = 1; i<n; i++){
            maxLeft[i] = Math.max(arr[i-1], maxLeft[i-1]);
        }

        maxRight[0] = 0;
        for(int i = n-2; i>=0; i--){
            maxRight[i] = Math.max(arr[i+1], maxRight[i+1]);
        }

        //min l and r
        for(int i = 0; i<n; i++){
            min[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int water = 0;
        for(int i = 0; i<n; i++){
            int curr = min[i] - arr[i];
            if(curr>0){
                water += curr;
            }
        }

        return water;
    }

    static int trapOptimal(int[] arr){
        int water = 0;
        int l = 0, r = arr.length-1;
        int leftMax = arr[l];
        int rightMax = arr[r];

        while(l<r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(arr[l], leftMax);
                water += leftMax - arr[l];
            }
            else{
                r--;
                rightMax = Math.max(arr[r], rightMax);
                water += rightMax - arr[r];
            }
        }
        return water;
    }
}
