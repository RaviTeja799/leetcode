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
    ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next; // store
        curr.next = prev;          // revers
        return reverse(next, curr);
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
}