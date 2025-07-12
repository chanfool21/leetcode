package Tree.dfs;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CountPathsForSum {
    public int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        return fnc(root, 0, S, mp);
    }

    int fnc(TreeNode root, int currentSum, int S, Map<Integer, Integer> sumMap) {
//        if(root == null) {
//            if(currentSum >= S) {
//                if(sumMap.containsKey(S-currentSum)) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//            else return 0;
//        }
//        if(currentSum >= S) {
//            if(sumMap.containsKey(S-currentSum)) {
//                return 1;
//            }
//        }
//        sumMap.put(currentSum, 1);
//        int val =  fnc(root.left, currentSum + root.val, S, sumMap);
//
//        val+= fnc(root.right, currentSum + root.val, S, sumMap);
//        sumMap.remove(currentSum);
//        return val;
        if(root == null) {
            return 0;
        }

        currentSum += root.val;
        sumMap.put(currentSum, 1);
        if(currentSum == S) {
            return 1;
        } else if(sumMap.containsKey(S-currentSum)) {
            return 1;
        }

        int val =  fnc(root.left, currentSum + root.val, S, sumMap);

        val+= fnc(root.right, currentSum + root.val, S, sumMap);
        sumMap.remove(currentSum);
        return val;
    }

    public static void main(String[] args) {
        CountPathsForSum solution = new CountPathsForSum();
        
        // Test Case 1: Simple tree with sum = 12
        // Tree structure:
        //       1
        //      / \
        //     7   9
        //    / \  / \
        //   6  5 2  3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        System.out.println("Test Case 1 - Number of paths with sum 12: " + solution.countPaths(root1, 12));
        // Expected output: 3 (paths: 1->9->2, 7->5, 9->3)
//
//        // Test Case 2: Tree with negative numbers
//        // Tree structure:
//        //       10
//        //      /  \
//        //     5   -3
//        //    / \    \
//        //   3   2    11
//        //  / \   \
//        // 3  -2   1
//        TreeNode root2 = new TreeNode(10);
//        root2.left = new TreeNode(5);
//        root2.right = new TreeNode(-3);
//        root2.left.left = new TreeNode(3);
//        root2.left.right = new TreeNode(2);
//        root2.right.right = new TreeNode(11);
//        root2.left.left.left = new TreeNode(3);
//        root2.left.left.right = new TreeNode(-2);
//        root2.left.right.right = new TreeNode(1);
//        System.out.println("Test Case 2 - Number of paths with sum 8: " + solution.countPaths(root2, 8));
//        // Expected output: 3 (paths: 5->3, 5->2->1, -3->11)
//
//        // Test Case 3: Empty tree
//        System.out.println("Test Case 3 - Empty tree with sum 0: " + solution.countPaths(null, 0));
//        // Expected output: 0
//
//        // Test Case 4: Single node tree
//        TreeNode root4 = new TreeNode(5);
//        System.out.println("Test Case 4 - Single node with sum 5: " + solution.countPaths(root4, 5));
//        // Expected output: 1
    }
}
