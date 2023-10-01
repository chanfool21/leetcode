package LinkedList;
class Node {
    String url;
    Node next;
    Node prev;

    Node(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}
public class BrowserHistory {
    Node head = null;
    Node currentNode = null;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        currentNode = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        if(currentNode != null) {
            currentNode.next = newNode;
            Node prev = currentNode;
            currentNode = currentNode.next;
            currentNode.prev = prev;
        } else {
            currentNode = newNode;
        }
    }

    public String back(int steps) {
        while(currentNode.prev != null && steps > 0) {
            steps--;
            currentNode = currentNode.prev;
        }

        return currentNode.url;
    }

    public String forward(int steps) {
        while(currentNode.next != null && steps > 0) {
            steps--;
            currentNode = currentNode.next;
        }

        return currentNode.url;
    }
}
