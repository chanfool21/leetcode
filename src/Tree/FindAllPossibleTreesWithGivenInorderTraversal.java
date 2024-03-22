package Tree;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossibleTreesWithGivenInorderTraversal {

    static void displayPreorder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        displayPreorder(root.left);
        displayPreorder(root.right);
    }
    List<TreeNode> generateAllTreesWithGivenInorderTraversal(int a[], int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();

        if(start > end) {
            result.add(null);
            return result;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateAllTreesWithGivenInorderTraversal(a, start, i-1);
            List<TreeNode> rightTrees = generateAllTreesWithGivenInorderTraversal(a, i+1, end);

            for(int j = 0; j < leftTrees.size(); j++) {
                for(int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(a[i]);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    result.add(root);
                }
            }
        }


        return result;
    }
    public static void main(String[] args) {
        int inorder[] = new int[] {4,5,7};
        List<TreeNode> roots = new FindAllPossibleTreesWithGivenInorderTraversal().generateAllTreesWithGivenInorderTraversal(inorder, 0, inorder.length-1);
        for(int i = 0; i < roots.size(); i++) {
            displayPreorder(roots.get(i));
            System.out.println();
        }
    }
}
