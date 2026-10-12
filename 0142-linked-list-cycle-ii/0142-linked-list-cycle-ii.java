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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Phase 1: Determine if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If no cycle was found, return null
        if (!hasCycle) {
            return null;
        }

        // Phase 2: Find the exact node where the cycle begins
        slow = head; // Reset slow pointer back to the head
        while (slow != fast) {
            slow = slow.next;          // Both move 1 step at a time now
            fast = fast.next;
        }

        // They meet at the start of the cycle
        return slow;
    }
}