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
    //定义快慢指针寻找链表中间点位置           
     ListNode f=head;//定义快指针
     ListNode s=head;//定义慢指针
     while(f.next!=null&&f.next.next!=null){   //快指针每次前移动两个位置，慢指针每次移动一个位置
         f=f.next.next;
         s=s.next;
     }
     ListNode secondH=s.next;  //将链表分成左右两部分，secondH指向右半部分链表头结点
     s.next=null;
     ListNode p1=secondH;
     ListNode p2=p1.next;
     while(p1!=null&&p2!=null){     //转换右半部分链表使尾部节点变为头结点
         ListNode m=p2.next;
         p2.next=p1;
         p1=p2;
         p2=m;
     }
     secondH.next=null;  //把转换后的右半部分链表尾节点置空
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