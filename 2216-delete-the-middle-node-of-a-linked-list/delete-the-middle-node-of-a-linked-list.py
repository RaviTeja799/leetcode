# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteMiddle(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if head.next == None:
            return None
        slow = fast = head
        temp = head
        while fast!=None and fast.next!=None:
            temp = slow
            fast = fast.next.next
            slow = slow.next
        temp.next = temp.next.next
        slow.next = None
        return head
        