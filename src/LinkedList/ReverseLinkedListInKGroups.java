package LinkedList;

public class ReverseLinkedListInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode modHead = null;
        ListNode prev = null;
        ListNode cur = head;

        int n = 0;
        while(cur != null) {
            cur = cur.next;
            n++;
        }

        int parts = n/k;
        int i = 0;
        cur = head;
        ListNode curLast = null;
        while(i < parts) {
            i++;
            int j = 1;
            ListNode next = cur;
            ListNode curHead = null;
            while(j <= k && cur != null) {
                if(j == 1) curHead = cur;
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                j++;
            }

            if(modHead == null) {
                modHead = prev;
            }

            if(curLast != null) {
                curLast.next = prev;
                curLast = curHead;
            } else {
                curLast = curHead;
            }
        }

        curLast.next = cur;
        return modHead;
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
        ListNode head = new ReverseLinkedListInKGroups().createLinkedListFromArray(new int[]{1,2,3,4,5,6});
        ListNode res = new ReverseLinkedListInKGroups().reverseKGroup(head, 3);
        for(ListNode cur = res; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
