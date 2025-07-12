package Tree.dfs;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsForASum {
    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        fnc(root, targetSum, new ArrayList<>(), results);
        return results;
    }

    void fnc(TreeNode root, int remainingSum, List<Integer> currentPath, List<List<Integer>> results) {

        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(remainingSum == root.val) {
                currentPath.add(root.val);
                List<Integer> temp = new ArrayList<>(currentPath);
                results.add(temp);
                currentPath.remove(currentPath.size()-1);
                return;
            } else {
                return;
            }
        }
        if(remainingSum < 0) {
            return;
        }

        currentPath.add(root.val);
        fnc(root.left, remainingSum - root.val, currentPath, results);
        fnc(root.right, remainingSum - root.val, currentPath, results);
        currentPath.remove(currentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);

        // Level 2 nodes
        TreeNode node7 = new TreeNode(7, node4, null);
        TreeNode node1 = new TreeNode(1, node10, node5);

        // Root node
        TreeNode root = new TreeNode(12, node7, node1);
        List<List<Integer>> result = new FindAllPathsForASum().findPaths(root, 23);
        for(List<Integer> list: result) {
            for(Integer ele: list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
