package solutions;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int count = list.size();
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
