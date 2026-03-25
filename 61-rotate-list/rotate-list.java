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
    // public ListNode reverse(ListNode head){
    //     ListNode curr = head, prev = null, next = null;
    //     while(curr!=null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        if(head==null) return null;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        k=k%(n+1);
        if(k == 0) return head;
        ListNode x = head;
        int y = n-k;
        while(y-- > 0){
            x = x.next;
        }
        ListNode p = x.next;
        x.next = null;
        temp.next = head;
        return p;

    }
}