/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //如果根节点为空，这符合要求，是对称二叉树
    if(root==null)
    return true;
    //如果不为空，这要分别比根节点的左子树右子树的值，然后继续比较左子树的右子树还有右子树的左子树
    return comp(root.left,root.right);
    }
    public boolean comp(TreeNode lroot,TreeNode rroot){
        //如果左右子树都为空，则为对称二叉树
        if(lroot==null&&rroot==null)
         return true;
        // 如果左右子树红其中一个为空，这不是对称二叉树
         if(lroot==null||rroot==null)
         return false;
        // 递归算法，依次判断左子树右子树的值，然后继续比较左子树的右子树还有右子树的左子树
         if(lroot.val==rroot.val&&comp(lroot.left,rroot.right)&&comp(lroot.right,rroot.left))
         return true;
         return false;
    }
}