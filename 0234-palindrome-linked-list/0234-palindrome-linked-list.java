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
    public boolean isPalindrome(ListNode head) {
         if(head == null || head.next == null)
            return true;

        //Find the middle
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the 2nd half;
        ListNode newHead = reverseList_RECURSIVE(slow.next);

        //Compare the values
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverseList_RECURSIVE(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        //restore the order before returning
        reverseList_RECURSIVE(newHead);
        return true;
    }

    public ListNode reverseList_RECURSIVE(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList_RECURSIVE(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }
}