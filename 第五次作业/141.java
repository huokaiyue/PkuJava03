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
        //ʹ��ָ��ÿ������������ָ��ÿ��һ������ͬʱ���ڣ���ָ���ߵľ�������ָ���������
        //�����ָ�����֪�����¸����Ϊ�գ���û�л��������ָ������ָ����֪�����ͬ�����л�
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