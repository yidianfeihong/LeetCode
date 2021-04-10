package solutions;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Solution59 {

    public static void main(String[] args) {
        int[][] res = new Solution59().generateMatrix(3);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int index = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = index++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = index++;
            }
            if (top != bottom) {
                for (int j = right - 1; j >= left; j--) {
                    matrix[bottom][j] = index++;
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    matrix[i][left] = index++;
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return matrix;
    }

}
