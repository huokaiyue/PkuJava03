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
    public int maxDepth(TreeNode root) {
        //DFS思想，图的深度优先遍历
        if(root==null)
        return 0;
        int l,r,depth;
         depth=1;
        l=maxDepth(root.left);//递归函数的调用，返回左子树的深度
        r=maxDepth(root.right);//递归函数的调用，返回右子树的深度
        if(l>r)
        {
           depth+=l;
          
        }
        else depth+=r;
        return depth;
        
    }
}