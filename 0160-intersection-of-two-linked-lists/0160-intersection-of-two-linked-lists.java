/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int n1 = 0;
        ListNode temp2 = headB;
        int n2 = 0;
        while (temp1 != null) {
            temp1 = temp1.next;
            n1++;
        }

        while (temp2 != null) {
            temp2 = temp2.next;
            n2++;
        }

        if (n1 < n2) {
            return collitionPoint(headB, headA, n2 - n1);
        } else {
            return collitionPoint(headA, headB, n1 - n2);
        }
    }

    private ListNode collitionPoint(ListNode large, ListNode small, int diff) {
        ListNode temp = large;
        while (diff > 0) {
            temp = temp.next;
            diff--;
        }
        while (temp != null) {
            if (temp == small) {
                return temp;
            }
            temp = temp.next;
            small = small.next;
        }
        return null;
    }
}