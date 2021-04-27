package solutions;

public class Solution50 {

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2.1, 3));
    }

    public double myPow(double x, int n) {
        return n > 0 ? myPow1(x, n) : 1 / myPow1(x, -n);
    }


    public double dps(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = dps(x, n / 2);
        return (n & 1) == 1 ? y * y * x : y * y;
    }

    public double myPow1(double x, int n) {
        double res = 1;
        double contribute = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= contribute;
            }
            contribute *= contribute;
            n /= 2;
        }
        return res;
    }

}
