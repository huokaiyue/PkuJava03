/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//整体思想为遍历根节点、右结点、左结点，将其依次放入堆栈中，主要利用堆栈的后进先出性质进行遍历。并将遍历过程中的结点值放入链表中，堆栈为空时，将链表逆序，即为所求结果 
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r=new ArrayList<Integer>();//新建链表
        if(root==null)  //如果根节点为空，直接返回
          return r;
        Stack<TreeNode> s=new Stack<TreeNode>();//建立堆栈，里面装的类型是TreeNode结点类
        TreeNode N=root.right;
        r.add(root.val);//将根节点的值放入链表中
        s.add(root);//把根节点加入到堆栈中
        while(!s.isEmpty()){
           // if(N!=null){
             while(N!=null){  //遍历右结点，把右结点的值放入到链表中，并将该结点放入堆栈中
                r.add(N.val);
                s.add(N);
                N=N.right;
            }
            TreeNode node=s.pop();//移除栈顶元素node
            N=node.left;//选取其左结点
            if(N!=null){//如果栈顶元素结点有左节点，则再次遍历其左节点
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