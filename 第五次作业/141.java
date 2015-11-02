/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //使快指针每次走两步，慢指针每次一步，相同时间内，快指针走的距离是慢指针的两倍。
        //如果快指针的所知结点的下个结点为空，则没有环，如果快指针与慢指针所知结点相同，则有环
        if(head==null)
           return false;
        ListNode fast=head,slow=head;
        while(true){
          //  if(fast.next==null)
          if(fast.next==null||fast.next.next==null)
               return false;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
             return true;
        }
    }
}