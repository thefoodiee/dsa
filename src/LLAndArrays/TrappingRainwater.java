package LLAndArrays;

import java.util.Arrays;

public class TrappingRainwater {
    static void main() {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trapBetter(arr));
        System.out.println(trapOptimal(arr));
    }
    static int trapBetter(int[] height){
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;

        for(int i = 1; i<height.length; i++){
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[rightMax.length-1] = 0;
        for(int i = height.length-2; i>=0; i--){
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }

        int trapped = 0;
        for(int i = 0; i<height.length; i++){
            trapped += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return trapped;
    }

    static int trapOptimal(int[] arr){
        int left = 0;
        int right = arr.length-1;

        int leftMax = arr[left];
        int rightMax = arr[right];
        int total = 0;

        while(left < right){
            if(leftMax<rightMax){
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                total += leftMax - arr[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                total += rightMax - arr[right];
            }
        }
        return total;

    }
}
