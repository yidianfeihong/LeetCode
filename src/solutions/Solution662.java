package solutions;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution662 {

    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.left = new TreeNode();
        node.right = new TreeNode();
        System.out.println(new Solution662().widthOfBinaryTree(node));
        HashMap<String, Object> map = new HashMap<>();
        map.computeIfAbsent("", x -> 1);
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0, 0);
        return res;
    }

    public void dfs(TreeNode node, int depth, int position) {
        if (node == null) return;
        if (!map.containsKey(depth)) {
            map.put(depth, position);
        }
        res = Math.max(res, position - map.get(depth) + 1);
        dfs(node.left, depth + 1, position * 2);
        dfs(node.right, depth + 1, position * 2 + 1);
    }

}
