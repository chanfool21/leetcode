package DailyChallenges;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithArbitraryPointer {

    public Node copyRandomList(Node head) {
        Node current = head;

        while(current != null) {
            Node newNode = new Node(current.val);
            newNode.next=current.next;
            current.next = newNode;
            current = current.next.next;
        }

        // [] -> new -> [] -> new -> [] -> new -> null
        // 7 13 11 10 1
        current = head;
        while(current!= null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }
        current = head;
        Node currentHead = head.next;
        Node currentNew = current.next;

        while(current != null) {
            current.next = currentNew.next;
            if(currentNew.next != null) {
                currentNew.next = currentNew.next.next;
            }
            current = current.next;
            currentNew = currentNew.next;
        }

        return currentHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = head;

        Node result = new CopyListWithArbitraryPointer().copyRandomList(head);

        Node current = result;
        while(current != null) {
            System.out.println("current node_value: " + current.val);
            if(current.random != null)
                System.out.println("random node_value: " + current.random.val);
            else
                System.out.println("random node_value: NULL");
            current = current.next;
        }
    }
}
