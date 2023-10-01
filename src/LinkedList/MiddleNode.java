package LinkedList;

import java.util.List;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next!= null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return slow;
            }
        }

        return slow;
    }

    public static ListNode createLinkedListFromArray(int[] values) {
        ListNode head = null; // Initialize the head of the linked list
        boolean isFlagSet = false;
        // Loop through the array in forward order
        ListNode prev = null;
        for (int i = 0; i < values.length; i++) {
            // Create a new ListNode with the current element's value
            ListNode newNode = new ListNode(values[i]);
            if(isFlagSet == false) {
                head = newNode;
                isFlagSet = true;
                prev = newNode;
            }
            // Make the new ListNode point to the current head of the linked list
            prev.next = newNode;

            // Update the head of the linked list to the newly created ListNode
            prev = prev.next;
        }

        return head; // Return the head of the linked list
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode linkedList = createLinkedListFromArray(arr);
        ListNode middle = new MiddleNode().middleNode(linkedList);

        for(ListNode cur = middle; cur != null; cur = cur.next) {
            System.out.println(cur.val + " ");
        }

        // You can now use the 'linkedList' variable to work with your linked list.
    }
}
