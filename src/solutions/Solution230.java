package solutions;

import model.TreeNode;

import java.util.*;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class Solution230 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        System.out.println(new Solution230().kthSmallest(treeNode, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        midInOrder(list, root);
        return list.get(k - 1);
    }

    public void midInOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        midInOrder(list, root.left);
        list.add(root.val);
        midInOrder(list, root.right);
    }
}
