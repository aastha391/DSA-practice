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
    public ListNode sortList(ListNode head) {
    //     if(head==null || head.next==null)
    //     {
    //         return head;
    //     }
    //     ListNode mid=getmid(head);
    //     ListNode left=sortList(head);
    //     ListNode right=sortList(mid);
    //     return mergeTwoLists(left,right);
       
    // }
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //    ListNode head=new ListNode();
    //    ListNode tail=head;
    //    while(list1!=null && list2!=null)
    //    {
    //     if(list1.val<list2.val)
    //     {
    //         tail.next=list1;
    //         list1=list1.next;
    //     }
    //     else
    //     {
    //         tail.next=list2;
    //         list2=list2.next;
    //     }
    //     tail=tail.next;
    //    }
    //    if(list1!=null)
    //    {
    //     tail.next=list1;
    //    }
    //    if(list2!=null)
    //    {
    //     tail.next=list2;
    //    }
    //    return head.next;
    // }
    // public static ListNode getmid(ListNode head)
    // {
    //     ListNode midprev=null;
    //     ListNode fast=head;
    //     ListNode slow=head;
    //     while(fast!=null && fast.next!=null)
    //     {
    //         midprev=slow;
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     midprev.next=null;
    //     return slow;
    // }

    if(head==null || head.next==null) return head;
    ListNode midNode=middle(head);
    ListNode lefthead=head;
    ListNode righthead=midNode.next;
    midNode.next=null;
    lefthead=sortList(lefthead);
    righthead=sortList(righthead);

    return merge(lefthead,righthead);
}

static ListNode middle(ListNode head){
    ListNode slow=head;
    ListNode fast=head.next;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
}

static ListNode merge(ListNode head1,ListNode head2){
    ListNode temp1=head1;
    ListNode temp2=head2;
    ListNode dummy=new ListNode(-1);
    ListNode temp=dummy;
    while(temp1!=null && temp2!=null){
        if(temp1.val<temp2.val){
            temp.next=temp1;
            temp=temp1;
            temp1=temp1.next;
        }
        else{
           temp.next=temp2;
           temp=temp2;
           temp2=temp2.next; 
        }
    }

    if(temp1!=null){
        temp.next=temp1;
    }
    else{
        temp.next=temp2;
    }
    return dummy.next;
}

}