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
    public ListNode reverseList(ListNode head) {
        // Approach 1

        ListNode temp = head;
        Stack<Integer> stk = new Stack<>();
        if(head == null) return null;
        while(temp!=null) {
            stk.push(temp.val);
            temp = temp.next;
        }
        ListNode newhead = new ListNode(stk.pop());
        temp = newhead;
        while(!stk.empty()){
            ListNode newNode = new ListNode(stk.pop());
            temp.next = newNode;
            temp = temp.next;
        }
        return newhead;

        // Approach 2

        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        // // ListNode temp = dummy;
        // // ListNode prev = null;
        // prev.next = dummy;
        // while(prev!=null){
        //     prev = head.next;
        //     head = prev;
        // } 
        // return prev;
    }
}