package solutions;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Solution29 {


    public static void main(String[] args) {
        int[] res = new Solution29().spiralOrder1(new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        });
//        int[] res = new Solution29().spiralOrder1(new int[][]{{7}, {9}, {6}});
        for (int re : res) {
            System.out.print(re + "\t");
        }
    }

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, index = 0;
        int size = (right + 1) * (bottom + 1);
        int[] res = new int[size];
        while (index != size) {
            //从左到右
            for (int i = top, j = left; j <= right; j++) {
                res[index++] = matrix[i][j];
            }
            top++;
            if (index == size) {
                return res;
            }
            //从上到下
            for (int i = top, j = right; i <= bottom; i++) {
                res[index++] = matrix[i][j];
            }
            right--;
            if (index == size) {
                return res;
            }
            //从右到左
            for (int i = bottom, j = right; j >= left; j--) {
                res[index++] = matrix[i][j];
            }
            bottom--;
            if (index == size) {
                return res;
            }
            //从下到上
            for (int i = bottom, j = left; i >= top; i--) {
                res[index++] = matrix[i][j];
            }
            left++;
        }
        return res;
    }


    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }

}
