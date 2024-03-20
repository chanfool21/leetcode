package binary_tree.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public  TreeNode createTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode current = queue.poll();
            if (current == null)
                continue;

            Integer leftVal = arr[i];
            if (leftVal != null) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }

            if (i + 1 < arr.length) {
                Integer rightVal = arr[i + 1];
                if (rightVal != null) {
                    current.right = new TreeNode(rightVal);
                    queue.add(current.right);
                }
            }
        }

        return root;
    }

    static boolean isBalanceBT = true;

    int fnc(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = fnc(root.left);
        int r = fnc(root.right);

        if(Math.abs(l-r) > 1) {
            isBalanceBT = false;
        }

        return 1 + Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        fnc(root);
        return isBalanceBT;
    }

    public static void main(String[] args) {
        TreeNode root = new CheckIfBalancedBinaryTree().createTreeFromArray(new Integer[] {1});
        System.out.println(new CheckIfBalancedBinaryTree().isBalanced(root));
    }

}
