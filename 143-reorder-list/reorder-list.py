# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: None Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while(fast!=None and fast.next!=None):
            slow = slow.next
            fast = fast.next.next
        curr = slow.next
        slow.next = None
        prev = None
        while curr!=None:
            later = curr.next
            curr.next = prev
            prev = curr
            curr = later
        t1 = head
        t2 = prev
        while t2!=None:
            a = t1.next
            b = t2.next
            t1.next = t2
            t2.next = a
            t1 = a
            t2 = b
        