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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode prev = dummy;
        dummy.next = head;
        while(temp!=null){
            if(temp.val == val){
                prev.next = prev.next.next;
                temp = prev.next;
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}