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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        int n = 0,flag =0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        ListNode t1,t2 = head,t3,t4=null,nll;
        while(n>=k){
            t1 = head;
            nll = null;
            for(int i = 0; i< k; i++){
                t3 = head;  
                head = head.next;
                t3.next = nll;
                nll= t3;
            }
            if(flag == 0){
                t4 = nll;
                flag = 1;
            }
            else{
                t2.next = nll;
            }
            t2 = t1;
            n-=k;
        }
        if(head!=null) t2.next = head;
        return t4;
    }
}