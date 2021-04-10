package main;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if ((long) mid * mid < x) {
                l = mid + 1;
            } else if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return r;
    }


    public int permutation(int n, int m) {
        return factorial(n) / factorial(n - m);
    }

    public int permutation2(int n, int m) {
        int res = 1;
        for (int i = m; i > 0; i--) {
            res *= n--;
        }
        return res;
    }

    public int combination(int n, int m) {
        return factorial(n) / factorial(n - m) / factorial(m);
    }

    public int combination2(int n, int m) {
        int top = 1;
        for (int i = m; i > 0; i--) {
            top *= n--;
        }
        int bottom = 1;
        for (int i = 1; i <= m; i++) {
            bottom *= m;
        }
        return top / bottom;
    }


    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
