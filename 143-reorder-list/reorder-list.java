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
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head, next = prev;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);

        ListNode curr = head;
        while (curr != slow) {
            curr = curr.next;
        }
        ListNode head2 = curr.next;
        curr.next = null;
        head2 = reverse(head2);

        ListNode l1 = head, l2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        boolean flag = true;
        while (l1 != null && l2 != null) {
            if (flag) {
                temp.next = l1;
                flag = false;
                l1 = l1.next;
            } else {
                temp.next = l2;
                flag = true;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }
        head = dummy.next;
    }
}