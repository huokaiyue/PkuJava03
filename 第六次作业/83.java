/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
           return head;
        ListNode p=head;
        while(p!=null&&p.next!=null){//指针P指向不相同元素
            if(p.val==p.next.val)
               p.next=p.next.next;
            else
              p=p.next;
        }
     return head;
    }
}