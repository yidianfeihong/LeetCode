package solutions;

import model.TreeNode;

public class Solution236 {

    public static void main(String[] args) {


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return root;
        }
        if(root!=null){
            TreeNode left = lowestCommonAncestor(root.left, p, q) ;
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left!=null&&right!=null){
                return root;
            }else if(left==null){
                return right;
            }else{
                return left;
            }
        }
        return null;
    }

}
