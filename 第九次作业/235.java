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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null||q==null||root==null)
        return null;
        //如果左右子树全部大于根节点，则ＬＣＡ必定在右子树中，应用递归算法进入右子树中
        else if(p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
            //如果左右子树全部小于根节点，则ＬＣＡ必定左子树中，应用递归算法进入左子树中
            else if(p.val<root.val&&q.val<root.val)
           return lowestCommonAncestor(root.left,p,q);
           //如果子树小根节点，右子树大根节点，则root就为LCA
           else return root;
    }
}