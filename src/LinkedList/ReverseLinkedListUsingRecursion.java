package LinkedList;

public class ReverseLinkedListUsingRecursion {

//    void fnc(ListNode current, ListNode head) {
//        if(current == null) {
//            return;
//        }
//
//        fnc(current.next, head);
//        ListNode prev = current.next;
//
//        if(prev == null) {
//            head = current;
//        } else {
//            prev.next =
//        }
//    }
//    ListNode fnc(ListNode root) {
//        ListNode head = null;
//        fnc(root, head);
//    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode leftPrev = null;
        ListNode prev = null;
        ListNode cur = head;
        int cnt = 1;

        while(cnt < l && cur != null) {
            cnt++;
            prev = cur;
            cur = cur.next;
        }

        leftPrev = prev;
        ListNode rightNext = cur;
        ListNode next = cur;
        //1 2 3 4 5
        while(cnt <= r && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }

        if(leftPrev == null) {
            head = prev;
        } else {
            leftPrev.next = prev;
        }

        rightNext.next = cur;
        return head;
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
        int[] arr = {1};
        ListNode linkedList = new ReverseLinkedListUsingRecursion().createLinkedListFromArray(arr);
        ListNode rev = new ReverseLinkedListUsingRecursion().reverseBetween(linkedList, 1, 5);

        for(ListNode cur = rev; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

}
