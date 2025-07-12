package binary_tree.traversals;

import java.util.ArrayList;
import java.util.Stack;




public class IterativePostOrder2Stacks {
    class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    ArrayList<Integer> postOrder(TreeNode node) {
        // code here
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.add(node);

        while(true) {
            if(stack1.isEmpty()) break;

            TreeNode currentNode = stack1.pop();
            stack2.add(currentNode.val);
            if(currentNode.left != null) {
                stack1.add(currentNode.left);
            }
            if(currentNode.right != null) {
                stack1.add(currentNode.right);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack2.isEmpty()) {
            result.add(stack2.pop());
        }

        return result;
    }

}

