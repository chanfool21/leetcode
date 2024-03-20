package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class FindLevelOfANodeInTree {

    static Node buildTree(String str) {
        if(str.length() == 0 || str.equals("N")) {
            return null;
        }

        String s[] = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < s.length) {
            Node currentNode = q.poll();
            String currVal = s[i];

            if(!currVal.equals("N")) {
                currentNode.left = new Node(Integer.parseInt(currVal));
                q.add(currentNode.left);
            }
            i++;
            if(i >= s.length) {
                break;
            }
            currVal = s[i];
            if(!currVal.equals("N")) {
                currentNode.right = new Node(Integer.parseInt(currVal));
                q.add(currentNode.right);
            }
            i++;
        }

        return root;
    }

    int fnc(Node node, int data) {
        if(node == null) return Integer.MAX_VALUE;

        if(node.data == data) {
            return 1;
        }

        int l = fnc(node.left,data);
        int r = fnc(node.right, data);

        if(l == Integer.MAX_VALUE && r == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(l != Integer.MAX_VALUE) {
            return 1 + l;
        } else {
            return 1 + r;
        }
    }
    int getLevel(Node node, int data)
    {
        // Write your code here
        int res = fnc(node, data);

        if(res == Integer.MAX_VALUE) {
            return 0;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Node root = buildTree("4 3 38 2 N 34 42 1 N 5 36 40 50 N N N 16 35 37 39 41 45 N 6 31 N N N N N N N N 44");

        System.out.println(new FindLevelOfANodeInTree().getLevel(root, 34));
    }
}

