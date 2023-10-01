package LinkedList;

public class ReorderList {
    ListNode getMiddleNode(ListNode current) {
        if(current == null) {
            return current;
        }

        ListNode slowPtr = current;
        ListNode fastPtr = current;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if(fastPtr == null) {
                return slowPtr;
            } else {
                fastPtr = fastPtr.next;
            }
        }

        return slowPtr;
    }

    ListNode reverseListFromMiddle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = current;

        while(current!= null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    ListNode mergeForwardAndReverseLists(ListNode forwardHead, ListNode reverseHead) {
        ListNode current = forwardHead;
        ListNode result = current;
        forwardHead = forwardHead.next;
        boolean first = false;

        while(forwardHead != null && reverseHead != null) {
            if(!first) {
                current.next = reverseHead;
                current = current.next;
                reverseHead = reverseHead.next;
                first = true;
            } else {
                first = false;
                current.next = forwardHead;
                current = current.next;
                forwardHead = forwardHead.next;
            }
        }

        while(forwardHead != null) {
            current.next = forwardHead;
            forwardHead = forwardHead.next;
            current = current.next;
        }

        while(reverseHead != null) {
            current.next = reverseHead;
            reverseHead = reverseHead.next;
            current = current.next;
        }

        return result;
    }
    public void reorderList(ListNode head) {
        ListNode current = head;
        ListNode middleNode = getMiddleNode(current);
        ListNode reverseHead = reverseListFromMiddle(middleNode.next);
        middleNode.next = null;
        current = head;
        head = mergeForwardAndReverseLists(current, reverseHead);
    }

    public ListNode createLinkedListFromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null; // Return null for an empty array
        }

        ListNode head = new ListNode(values[0]); // Create the head node
        ListNode current = head; // Initialize the current node

        // Iterate through the array starting from index 1
        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]); // Create a new node
            current.next = newNode; // Link the current node to the new node
            current = newNode; // Update the current node to the new node
        }

        return head; // Return the head of the linked list
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ReorderList().createLinkedListFromArray(arr);
        new ReorderList().reorderList(head);
        for(ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
