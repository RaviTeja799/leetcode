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
    public ListNode middleNode(ListNode head) {
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast!=null && fast.next!=null){
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // return slow;
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0 ; i < (cnt/2); i++){
            temp = temp.next;
        }
        return temp;
   }
}