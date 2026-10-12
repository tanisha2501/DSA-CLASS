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
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a min-heap to store the heads of the k lists, ordered by node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Initialize the heap with the head node of each non-null list
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        // Process the heap until it is empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            ListNode smallest = minHeap.poll();
            
            // Append it to our merged list
            tail.next = smallest;
            tail = tail.next;

            // If there is a next node in the same list, add it to the min-heap
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummyHead.next;
    }
}