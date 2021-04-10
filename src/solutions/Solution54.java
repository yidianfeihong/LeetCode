package solutions;

import java.util.ArrayList;
import java.util.List;

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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution54 {

    public static void main(String[] args) {
        System.out.println(new Solution54().spiralOrder(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
//        System.out.println(new Solution54().spiralOrder(new int[][]{{7}, {9}, {6}, {9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top != bottom) {
                for (int j = right - 1; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return res;
    }

}
