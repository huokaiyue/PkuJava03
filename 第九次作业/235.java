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
        //�����������ȫ�����ڸ��ڵ㣬��̣ã��ض����������У�Ӧ�õݹ��㷨������������
        else if(p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
            //�����������ȫ��С�ڸ��ڵ㣬��̣ã��ض��������У�Ӧ�õݹ��㷨������������
            else if(p.val<root.val&&q.val<root.val)
           return lowestCommonAncestor(root.left,p,q);
           //�������С���ڵ㣬����������ڵ㣬��root��ΪLCA
           else return root;
    }
}