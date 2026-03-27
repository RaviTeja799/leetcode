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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode slow = head,fast = head,prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = slow;
        prev.next = null;
        ListNode node = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = node;
            node = curr;
            curr = next;
        }
        curr = head;
        while(node != null &&curr!=null){
            if(node.val!=curr.val) return false;
            node = node.next;
            curr = curr.next;
        }
        return true;
    }
}