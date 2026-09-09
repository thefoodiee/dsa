package Arrays3;

public class Pow {
    static void main() {
        System.out.println(pow(3, 9));
    }

    static double pow(double x, int n){
        double ans = helper(x, Math.abs(n));
        if(n>=0) return ans;
        else return 1/ans;
    }

    static double helper(double x, int n){
        if (n==0) return 1;
        if(x == 0) return 0;

        double ans = helper(x, n/2);
        ans = ans * ans;

        if(n%2 != 0) return (double) x*ans;
        else return ans;
    }
}
