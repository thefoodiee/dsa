package Arrays;

public class MaxSubarray {
    static void main() {
        System.out.println(subarr(new int[]{-1,2,1}));
    }

    static int subarr(int[] arr){
        int sum = 0, max = 0;
        for(int i : arr){
            if(sum<0) sum = 0;
            sum += i;
            max = Math.max(sum, max);
        }
        return max;
    }
}
