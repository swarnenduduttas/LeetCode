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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode before = null;
        ListNode t = head;
        int pos = 1;
        
        while(pos < left) {
            before = t;
            t = t.next;
            pos++;
        }

        int count = 0;
        ListNode curr = t;
        ListNode prev = null;
        ListNode temp = null;
        while(count < right-left+1){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }

        t.next = curr;
        if(before != null){
        before.next = prev;
        return head;
        }
        return prev;
    }
}