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
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers at different speeds
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Tortoise moves 1 step
            fast = fast.next.next;     // Hare moves 2 steps

            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, it means there is an end to the list (no cycle)
        return false;
    }
}