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
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();

            curr.next = temp;
            curr = curr.next;

            if (temp.next != null)
                minHeap.offer(temp.next);
        }

        return head.next;
    }
}