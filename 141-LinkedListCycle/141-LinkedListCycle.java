// Last updated: 11/08/2026, 20:58:35
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(fast==slow){
            return true;
           }
        }
        return false;
    }
}