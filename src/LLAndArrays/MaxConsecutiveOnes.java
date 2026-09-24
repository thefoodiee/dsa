package LLAndArrays;

public class MaxConsecutiveOnes {
    static void main() {
        int[] arr = {1,1,1,0,1,1,0,1};
        System.out.println(maxOnes(arr));
    }
    static int maxOnes(int[] arr){
        int max = 0;
        int count = 0;
        for(int i : arr){
            if(i == 0) count = 0;
            else count++;
            max = Math.max(count, max);
        }
        return max;
    }
}
