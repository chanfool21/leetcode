package binary_tree.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderInOrderPostOrderIn1Flow {
    class Result {
        List<Integer> preOrder;
        List<Integer> inOrder;
        List<Integer> postOrder;

        Result() {
            this.preOrder = new ArrayList<>();
            this.inOrder = new ArrayList<>();
            this.postOrder = new ArrayList<>();
        }
    }

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

    class TreeNodePair {
        TreeNode node;
        int flow;

        TreeNodePair(TreeNode node, int flow) {
            this.node = node;
            this.flow = flow;
        }
    }
    Result getAll3Traversals(TreeNode root) {
        Result result = new Result();

        if(root == null) return result;
        Stack<TreeNodePair> stack = new Stack<>();
        stack.add(new TreeNodePair(root, 1));

        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        while(!stack.isEmpty()) {
            TreeNodePair currentNodePair = stack.pop();
            int flow = currentNodePair.flow;

            if(flow == 1) {
                preOrderList.add(currentNodePair.node.val);
                stack.add(new TreeNodePair(currentNodePair.node, flow+1));
                if(currentNodePair.node.left != null) {
                    stack.add(new TreeNodePair(currentNodePair.node.left, 1));
                }
            } else if(flow == 2) {
                inOrderList.add(currentNodePair.node.val);
                stack.add(new TreeNodePair(currentNodePair.node, flow+1));
                if(currentNodePair.node.right != null) {
                    stack.add(new TreeNodePair(currentNodePair.node.right, 1));
                }
            } else {
                postOrderList.add(currentNodePair.node.val);
            }
        }

        result.postOrder = postOrderList;
        result.preOrder = preOrderList;
        result.inOrder = inOrderList;

        return result;

    }
}
