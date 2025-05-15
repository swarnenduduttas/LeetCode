/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         Map<ListNode, Integer> map = new HashMap<>();
        int counter=1;
        ListNode temp = head;

        while(temp != null){
            counter++;
            if(map.containsKey(temp)){
                return temp;
            } else {
                map.put(temp, counter);
            }
            temp = temp.next;
        }
        return null;
    }
}