# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        tail = None
        if head is None:
            return None
        while head:
            head, tail = self.invert(head, tail)
        head, tail = tail, head
        for _ in range(n-1):
            head, tail = self.invert(head, tail)
        head = head.next
        while head:
            head, tail = self.invert(head, tail)
        return tail

    def invert(self, head, tail):
        next = head.next
        head.next = tail
        return next, head