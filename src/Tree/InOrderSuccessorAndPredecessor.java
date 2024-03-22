package Tree;

public class InOrderSuccessorAndPredecessor {
    TreeNode res;
    static TreeNode newNode(int data)
    {
        TreeNode temp = new TreeNode();
        temp.val = data;
        temp.left = temp.right = null;
        return temp;
    }

    TreeNode findInorderSuccessorUtil(TreeNode root, TreeNode node) {
        if(node == null || root == null) return null;

        if(root == node) {
            return root;
        }

        TreeNode left = findInorderSuccessorUtil(root.left, node);
        TreeNode right = findInorderSuccessorUtil(root.right, node);

        if (left != null || right != null) {
            if(left != null && left == root.left) {
                res = root;
                return null;
            }
            return root;
        }

        return null;
    }
    TreeNode findInorderSuccessor(TreeNode node, TreeNode root) {
        if(node == null || root == null) return null;

        if(node.right != null) {
            TreeNode res = node.right;
            while(res.left != null) {
                res = res.left;
            }
            return res;
        } else {
            findInorderSuccessorUtil(root, node);
            return res;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = newNode(1);
//        root.left = newNode(2);
//        root.right = newNode(3);
//        root.left.left = newNode(4);
//        root.left.right = newNode(5);
//        root.right.right = newNode(6);
        TreeNode root = newNode(2);
        root.left = newNode(1);
        root.right = newNode(3);
        TreeNode inorderSuccessor = new InOrderSuccessorAndPredecessor().findInorderSuccessor(root.left, root);
        System.out.println(inorderSuccessor.val);
    }
}
