package binary_tree.dfs;

public class FlattenBinaryTreeToLinkedList {
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
    public void flatten(TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null) return;

        if(root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode currentNode = root.right;
            while(currentNode.right != null) {
                currentNode = currentNode.right;
            }

            currentNode.right = temp;

        }
        flatten(root.right);

    }


}
