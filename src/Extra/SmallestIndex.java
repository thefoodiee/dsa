package Extra;

public class SmallestIndex {
    static void main() {
        int[] arr = {1,10,11};
        System.out.println(smallest(arr));
    }
    static int smallest(int[] arr){
        int idx = -1;
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            int num = arr[i];
            while(num != 0){
                sum += num%10;
                num /= 10;
            }
            if(sum == i) return i;
        }
        return -1;
    }
}
