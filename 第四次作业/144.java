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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result =new ArrayList<>();
   
        Stack<TreeNode> s=new Stack<TreeNode>();
      /*  while(root!=null) {
            if(root.left==null) {
                //in-order here!!!
                //pre-order here!!!
                result.add(root.val);
                root=root.right;
            }
            else {
                root=root.left;
                while(root.right!=null &&root.right!=root) {
                    root=root.right;
                }
                if(root.right==null) {
                    root.right=root;
                    //pre-order here!!!
                    result.add(root.val);
                    root=root.left;
                }
                else {
                   root.right=null;
                    //in-order here!!!
                    root=root.right;
                }
            }
        }*/
        if(root==null)
        return result;
        s.push(root);
       // while(root!=null||!s.empty()){
        // if(root!=null)
       // {   s.push(root);
        while(!s.empty()){
        root=s.pop();
        
       // s.pop();
        result.add(root.val);
        if(root.right!=null) 
       { s.push(root.right);}
        if(root.left!=null)
       { s.push(root.left);}}
           // while(root!=null){//先将二叉树的根节点放栈中，然后一次将左子树放入栈中
            
           // result.add(root.val);
            //s.push(root);
           //result.add(root.val);
            
            //root=root.left;}
        //}}
       // else
       // {   //将左子树依次弹出，然后遍历其右子树
      // root=s.top;
        //    s.pop();
        //    root=root.right;
      //  }
        
           return result;
    }
   
}
