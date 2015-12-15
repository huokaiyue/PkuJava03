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
        //������ڵ�Ϊ�գ������Ҫ���ǶԳƶ�����
    if(root==null)
    return true;
    //�����Ϊ�գ���Ҫ�ֱ�ȸ��ڵ����������������ֵ��Ȼ������Ƚ���������������������������������
    return comp(root.left,root.right);
    }
    public boolean comp(TreeNode lroot,TreeNode rroot){
        //�������������Ϊ�գ���Ϊ�Գƶ�����
        if(lroot==null&&rroot==null)
         return true;
        // �����������������һ��Ϊ�գ��ⲻ�ǶԳƶ�����
         if(lroot==null||rroot==null)
         return false;
        // �ݹ��㷨�������ж���������������ֵ��Ȼ������Ƚ���������������������������������
         if(lroot.val==rroot.val&&comp(lroot.left,rroot.right)&&comp(lroot.right,rroot.left))
         return true;
         return false;
    }
}