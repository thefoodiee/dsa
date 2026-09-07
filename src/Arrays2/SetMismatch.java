package Arrays2;

public class SetMismatch {
    static void main() {
        mismatch(new int[]{1,2,2,3,5});
    }

    static void mismatch(int[] arr){
        int n = arr.length;
        // sum of n numbers and their squares
        int Sn = (n*(n+1))/2;
        int S2n = (n*(n+1)*(2*n+1))/6;

        //incorrect sums
        int In = 0;
        int I2n = 0;
        for(int i = 0; i<n; i++){
            In += arr[i];
            I2n += arr[i] * arr[i];
        }

        int y = (((S2n-I2n)/(Sn-In)) - Sn + In)/2;
        int x = Sn -In + y;
        System.out.println(x);
        System.out.println(y);
    }
}
