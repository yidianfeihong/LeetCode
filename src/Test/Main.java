package Test;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5},
                     {3, 1, 4, 7, 6},
                     {5, 7, 9, 11, 13},
                    {-3, -5, 13, 14, 22}};
        for (int j = 0; j < 5; j++) {
            int i = 0;
            System.out.print(a[i][j] + "->");
            while (j != 0 && i != 3) {
                i++;
                j--;
                System.out.print(a[i][j] + "->");
            }
            j = j + i;
        }
        for (int i = 1, j = 4; i != 4; ) {
            j = 4;
            System.out.print(a[i][j] + "->");
            while (i != 3) {
                i++;
                j--;
                System.out.print(a[i][j] + "->");
            }
            i = j;
        }
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}
