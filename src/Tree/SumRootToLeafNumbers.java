package Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumRootToLeafNumbers {
    void fnc(TreeNode root, List<Integer> currentPath, List<List<Integer>> paths) {

        if(root.left == null && root.right == null) {
            currentPath.add(root.val);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(currentPath);
            paths.add(temp);
            currentPath.remove(currentPath.size()-1);
            return;
        }

        currentPath.add(root.val);
        if(root.left != null)
        fnc(root.left, currentPath, paths);
        if(root.right != null)
        fnc(root.right, currentPath, paths);
        currentPath.remove(currentPath.size()-1);
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();

        fnc(root, currentPath, paths);
        int sum = 0;
        for(List<Integer> path: paths) {
            int n = path.size();
            int cnt = 0;

            int num = 0;
            for(int i = n-1; i >= 0; i--) {
               num+= path.get(i) * Math.pow(10, cnt);
               cnt++;
            }
            sum = sum + num;
        }

        return sum;
    }


    public static void main(String[] args) {
        String[] levelOrder = {"1", "2", "3"};
        TreeNode root = new MaximumPathSum().createBinaryTree(levelOrder);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

}
