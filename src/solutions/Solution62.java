package solutions;

public class Solution62 {

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(19, 13));
    }


    public int uniquePaths(int m, int n) {
        int[][] dps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dps[i][j] = 1;
                } else {
                    dps[i][j] = dps[i][j - 1] + dps[i - 1][j];
                }
            }
        }
        return dps[m - 1][n - 1];
    }


    public int getPathNum(int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) {
            return 1;
        }
        return getPathNum(m - 1, n) + getPathNum(m, n - 1);
    }

}
