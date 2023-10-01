package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class CycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        if(fast.next != null) {
            fast = fast.next.next;
        } else {
            return false;
        }

        while(slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;

            if(fast != null) {
                fast = fast.next;
            } else {
                return false;
            }
        }

        if(slow == null || fast == null) return false;
        else return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
    }
}
