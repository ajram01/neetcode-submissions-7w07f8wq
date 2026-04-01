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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;
        

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null){
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        ListNode second = prev;
        ListNode first = head;

        while(second != null){

            ListNode l1 = first.next;
            ListNode l2 = second.next;

            first.next = second;
            second.next = l1;

            first = l1;
            second = l2;
        }

    }
}
