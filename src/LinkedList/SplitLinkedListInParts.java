package LinkedList;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;

        while(cur != null) {
            cur = cur.next;
            n++;
        }

        cur = head;

        int part = (n / k);
        int extra = n % k;

        ListNode [] result = new ListNode[k];
        for(int i = 0; i < k; i++) {
            ListNode partHead = cur;
            for(int j = 0; cur != null && j < part - 1; j++) {
                cur = cur.next;
            }

            if(cur != null && extra > 0) {
                if(part > 0)
                    cur = cur.next;
                extra--;
            }
            ListNode dummy = cur;
            if(cur  != null) {
                cur = cur.next;
                dummy.next = null;
            }
            result[i] = partHead;
        }

        return result;
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
        int[] arr = {1, 2, 3};
        ListNode linkedList = new SplitLinkedListInParts().createLinkedListFromArray(arr);
        ListNode [] result = new SplitLinkedListInParts().splitListToParts(linkedList, 5);

        for(ListNode head: result) {
            while(head != null) {
                System.out.print(head.val + "");
                head = head.next;
            }
            System.out.println("<================>");
        }
        // You now have a linked list with values [1, 2, 3], where the head has a value of 1.
    }
}
