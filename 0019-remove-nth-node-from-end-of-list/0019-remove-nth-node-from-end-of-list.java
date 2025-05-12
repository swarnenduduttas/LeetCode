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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;
        return head;
    }
}