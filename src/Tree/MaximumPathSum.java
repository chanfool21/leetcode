package Tree;
import java.util.*;


public class MaximumPathSum {
    static int maxPath = 0;
    /*
    Kadane with inorder traversal wont work because inorder traversal wont promise a path in case of iorder successor and root, since both will come close in inorder traversal but when we form a path, they are far
     */
    List<Integer> result = new ArrayList<Integer>();
    List<Integer> getPathByInorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }

        getPathByInorderTraversal(root.left);
        result.add(root.val);
        getPathByInorderTraversal(root.right);
        return result;

    }
    public int maxPathSum1(TreeNode root) {
        List<Integer> ele = new ArrayList<Integer>();
        getPathByInorderTraversal(root);
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < result.size(); i++) {
            curSum += result.get(i);
            if(curSum < 0) {
                curSum = 0;
            }

            maxSum = Math.max(curSum, maxSum);

        }

        return maxSum;

    }
    int fnc(TreeNode root) {
        if(root == null) return 0;


        int left = fnc(root.left);
        int right = fnc(root.right);

        if(left < 0) left = 0;
        if(right < 0) right = 0;
        maxPath = Math.max(maxPath, root.val + left + right);
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPath = 0;
        fnc(root);
        return maxPath;

    }

    public TreeNode createBinaryTree(String[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();

            // Create the left child if the value is not "null"
            if (!levelOrder[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(levelOrder[i]));
                queue.offer(current.left);
            }
            i++;

            // Create the right child if the value is not "null"
            if (i < levelOrder.length && !levelOrder[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(levelOrder[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        //String[] levelOrder = {"1", "-2", "-3", "1", "3", "-2", "null", "-1"};
        //String[] levelOrder = {"-10","9","20","null","null","15","7"};
        String[] levelOrder = {"9", "6", "-3", "null", "null", "-6", "2", "null", "null", "2", "null", "-6", "-6", "-6"};
        TreeNode root = new MaximumPathSum().createBinaryTree(levelOrder);
        System.out.println(new MaximumPathSum().maxPathSum(root));
        // Now you have the binary tree constructed from the level order traversal.
    }
}
