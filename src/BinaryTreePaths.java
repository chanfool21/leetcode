import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePaths {

    private void utilityFnc(TreeNode root, List<List<Integer>> response, List<Integer> currentPath) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            currentPath.add(root.val);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(currentPath);
            response.add(temp);
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        currentPath.add(root.val);
        utilityFnc(root.left, response, currentPath);
        utilityFnc(root.right, response, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        utilityFnc(root, response, currentPath);

        List<String> finalResponse = new ArrayList<>();

        for (List<Integer> resultPath : response) {
            String responseString = "";
            for (int i = 0; i < resultPath.size(); i++) {
                if (i != resultPath.size() - 1)
                    responseString += resultPath.get(i) + "->";
                else
                    responseString += resultPath.get(i);
            }
            finalResponse.add(responseString);
        }
        return finalResponse;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = null;
        node1.right = node3;

        List<String> result = new BinaryTreePaths().binaryTreePaths(root);
        result.forEach(eachValue -> {
            System.out.println(eachValue);
        });
    }
}
