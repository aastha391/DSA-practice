/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            return;
        }
        ListNode mid=middlenode(head);
        ListNode hs=reverselist(mid);
        ListNode hf=head;
        while(hf!=null && hs!=null)
        {
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;

            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }

        if(hf!=null)
        {
            hf.next=null;
        }
    }
     public ListNode middlenode(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverselist(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        ListNode present=head;
        ListNode prev=null;
        ListNode next=present.next;
        while(present!=null)
        {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        return prev;
    }
}