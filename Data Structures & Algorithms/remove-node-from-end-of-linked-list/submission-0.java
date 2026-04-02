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
        // Step 0: Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Step 2: Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Step 3: Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Step 4: Remove the n-th node from end
        second.next = second.next.next;
        
        // Step 5: Return the updated list
        return dummy.next;
    }
}