package binary_tree.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderUsing1Stack {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if(node == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;
        TreeNode temp = null;
        while(currentNode != null || !stack.isEmpty()) {
            if(currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                if(stack.isEmpty()) break;
                temp = stack.peek().right;

                if(temp == null) {
                    temp = stack.pop();
                    result.add(temp.val);

                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                } else {
                    currentNode = temp;
                }
            }
        }

        return result;
    }
}
