/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    // if(head==null)
      //         return true;
     if(head==null||head.next==null)
           return true;
    //�������ָ��Ѱ�������м��λ��           
     ListNode f=head;//�����ָ��
     ListNode s=head;//������ָ��
     while(f.next!=null&&f.next.next!=null){   //��ָ��ÿ��ǰ�ƶ�����λ�ã���ָ��ÿ���ƶ�һ��λ��
         f=f.next.next;
         s=s.next;
     }
     ListNode secondH=s.next;  //������ֳ����������֣�secondHָ���Ұ벿������ͷ���
     s.next=null;
     ListNode p1=secondH;
     ListNode p2=p1.next;
     while(p1!=null&&p2!=null){     //ת���Ұ벿������ʹβ���ڵ��Ϊͷ���
         ListNode m=p2.next;
         p2.next=p1;
         p1=p2;
         p2=m;
     }
     secondH.next=null;  //��ת������Ұ벿������β�ڵ��ÿ�
     while(p1!=null&&head!=null){
         if(head.val==p1.val){
             head=head.next;
             p1=p1.next;
         }
         else return false;
     }
     return true;
     
    }
}