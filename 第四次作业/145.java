/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//����˼��Ϊ�������ڵ㡢�ҽ�㡢���㣬�������η����ջ�У���Ҫ���ö�ջ�ĺ���ȳ����ʽ��б������������������еĽ��ֵ���������У���ջΪ��ʱ�����������򣬼�Ϊ������ 
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r=new ArrayList<Integer>();//�½�����
        if(root==null)  //������ڵ�Ϊ�գ�ֱ�ӷ���
          return r;
        Stack<TreeNode> s=new Stack<TreeNode>();//������ջ������װ��������TreeNode�����
        TreeNode N=root.right;
        r.add(root.val);//�����ڵ��ֵ����������
        s.add(root);//�Ѹ��ڵ���뵽��ջ��
        while(!s.isEmpty()){
           // if(N!=null){
             while(N!=null){  //�����ҽ�㣬���ҽ���ֵ���뵽�����У������ý������ջ��
                r.add(N.val);
                s.add(N);
                N=N.right;
            }
            TreeNode node=s.pop();//�Ƴ�ջ��Ԫ��node
            N=node.left;//ѡȡ������
            if(N!=null){//���ջ��Ԫ�ؽ������ڵ㣬���ٴα�������ڵ�
               r.add(N.val); 
               s.add(N);
              // N=N.left;
              N=N.right;
            }
        }
        int i=0;
        int j=r.size()-1;
        while(i<j){
            int m=r.get(i);
            r.set(i,r.get(j));
            r.set(j,m);
            i++;
            j--;
        }
        return r;
    }
}