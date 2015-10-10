/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node==null)//链表为空的时候，当前方法终止
        return;
        node.val=node.next.val;//将下一个节点的值覆盖当前节点
        node.next=node.next.next;//删除下一个节点
    }
}