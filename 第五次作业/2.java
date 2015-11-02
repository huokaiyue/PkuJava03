/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       // int sum=0;
        int carry=0;
        ListNode head=null;
        ListNode result=null;
        while(l1!=null||l2!=null){
          // int sum=0;
           int sum=carry;
           if(l1!=null){
               sum+=l1.val;
               l1=l1.next;
           } 
           if(l2!=null){
               sum+=l2.val;
               l2=l2.next;
           }
           if(sum>=10){
              carry=1;
              sum=sum%10;
              }
           else
              carry=0;
          ListNode item=new ListNode(sum);
          //if(result==null){
             //head=item;
            //result=head;
         //}
         // result.next=item;
          if(result==null){
             head=item;
           //  result=head;
           }else
            result.next=item;
           result=item;
         }
        if(carry==1)
          result.next=new ListNode(1);
        return head;
    }
}