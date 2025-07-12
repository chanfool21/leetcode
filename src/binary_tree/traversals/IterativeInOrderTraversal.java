package binary_tree.traversals;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;

        while(true) {
            if(currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                if(stack.isEmpty()) break;
                currentNode = stack.pop();
                result.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }

        return result;
    }
}
