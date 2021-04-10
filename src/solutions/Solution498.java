package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution498 {

    public static void main(String[] args) {
        int[] diagonalOrder = new Solution498().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int i : diagonalOrder) {
            System.out.print(i + "\t");
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int row = mat.length;
        int column = mat[0].length;
        int[] res = new int[row * column];
        boolean towardTop = false;
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0, j = 0; j < column; j++) {
            towardTop = !towardTop;
            resList.add(findDiagonalOrder(mat, towardTop, i, j));
        }
        for (int j = column - 1, i = 1; i < row; i++) {
            towardTop = !towardTop;
            resList.add(findDiagonalOrder(mat, towardTop, i, j));
        }
        int index = 0;
        for (List<Integer> list : resList) {
            for (Integer integer : list) {
                res[index++] = integer;
            }
        }
        return res;
    }

    public List<Integer> findDiagonalOrder(int[][] mat, boolean towardTop, int left, int right) {
        int row = mat.length;
        ArrayList<Integer> data = new ArrayList<>();
        while (left < row && right >= 0) {
            data.add(mat[left++][right--]);
        }
        if (towardTop) {
            Collections.reverse(data);
        }
        return data;
    }

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int N = matrix.length;
        int M = matrix[0].length;
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();
        for (int d = 0; d < N + M - 1; d++) {
            intermediate.clear();
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;
            while (r < N && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
