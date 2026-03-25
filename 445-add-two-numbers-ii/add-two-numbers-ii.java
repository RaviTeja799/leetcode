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
    public ListNode reverse(ListNode head){
        ListNode curr = head,prev = null;
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l3 = null;int cnt = 0;
        while(l1!=null || l2 !=null || cnt!=0){
            int s = cnt;
            if(l1!=null) {
                s+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                s+=l2.val;
                l2=l2.next;
            }
            cnt = s/10;
            ListNode nn = new ListNode(s%10);
            nn.next = l3;
            l3 = nn;
        }
        return l3;
    }
}