package LinkedList;

import java.util.LinkedList;
import java.util.Stack;

public class PalindromeList {
    static ListNode head = null;
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode current = head;
        while(current != null) {
            st.push(current.val);
            current = current.next;
        }
        current = head;
        while(current!= null) {
            if(st.isEmpty() || st.peek() != current.val) {
                return false;
            }
            st.pop();
            current = current.next;
        }
        return true;
    }

    boolean isPalindromeByRecursion(ListNode cur) {
        if(cur == null) return true;

        boolean res = isPalindromeByRecursion(cur.next);
        if(head.val != cur.val) {
            res = false;
        }

        head = head.next;
        return res;
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
        int[] arr = {1, 2, 3};
        ListNode linkedList = createLinkedListFromArray(arr);
        head = linkedList;
        System.out.println(new PalindromeList().isPalindromeByRecursion(linkedList));
        // You can now use the 'linkedList' variable to work with your linked list.
    }
}
