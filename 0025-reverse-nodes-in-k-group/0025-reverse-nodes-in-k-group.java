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
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;

    }

    private ListNode reverseLL(ListNode temp) {
        if(temp == null || temp.next == null)
            return temp;
        ListNode newHead = reverseLL(temp.next);
        ListNode front = temp.next;
        front.next = temp;
        temp.next = null;
        return newHead;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        ListNode kthNode = temp;
        int count = 1;
        while(kthNode != null){
            if(count == k){
                break;
            }
            kthNode = kthNode.next;
            count++;
        }
        return kthNode;
    }


}