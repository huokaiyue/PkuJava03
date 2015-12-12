/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //平衡二叉树：一棵空树、或左右两棵子树的高度差绝对值不超过1，并且左右两棵树子树都是平衡二叉树
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
           return true;
        //return now(root)&&isBalanced(root.left)&&isBalanced(root.right);
        int mid=depth(root.left)-depth(root.right);
        if(mid>1||mid<-1)
          return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    /*public boolean now(TreeNode root) //判断以当前结点为根的树是否是一棵平衡二叉树
    { if(root==null)
         return true;
       int left=0;
       int right=0;
       if(root.left!=null)
          left=depth(root.left);
       if(root.right!=null)
          right=depth(root.right);
       if(Math.abs(left-right)<=1)
         return true;
       else
         return false;
    }*/
     public int depth(TreeNode root){
        if(root==null)
          return 0;
         /* else
           if(root.left==null&&root.right!=null)
               return depth(root.right)+1;
               else
                  if(root.left!=null&&root.right==null)
                  return depth(root.left)+1;
                  else
                     {
                         int num1=depth(root.right)+1;
                         int num2=depth(root.right)+1;
                         return num1>num2?num1:num2; 
                     }*/
        int left=depth(root.left);
        int right=depth(root.right);
        return left>right?left+1:right+1;
    }
}