package Tree;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeByPreorderAndInorder {
    //static int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int findInorderIndex(int inorder[], int l, int r, int val) {
        for(int i = l; i <= r; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    TreeNode fnc(int [] preorder, int [] inorder, int preIndex, int leftInorder, int rightInorder, int n) {
        if(leftInorder > rightInorder || preIndex >= n) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);

        if(leftInorder == rightInorder) return root;

        int inorderM = inorderMap.get(root.val);
        preIndex++;
        root.left = fnc(preorder, inorder, preIndex, leftInorder, inorderM-1, n);
        if(root.left == null) preIndex--;
        preIndex++;
        root.right = fnc(preorder, inorder, preIndex, inorderM + 1, rightInorder, n);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return fnc(preorder, inorder, 0, 0, inorder.length-1, inorder.length);
    }

    public static void main(String[] args) {

        TreeNode root = new CreateBinaryTreeByPreorderAndInorder().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println(root);
    }
}
