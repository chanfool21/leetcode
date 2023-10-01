package microsoft_leetcode_assesments;

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

public class LeafSimilarTrees {

    void populateLeafByInorderTraversal(TreeNode root, List<Integer> leafSequence) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            leafSequence.add(root.val);
            return;
        }

        populateLeafByInorderTraversal(root.left, leafSequence);
        populateLeafByInorderTraversal(root.right, leafSequence);
    }
    List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> leafSequence = new ArrayList<>();
        populateLeafByInorderTraversal(root, leafSequence);
        return leafSequence;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = getLeafSequence(root1);
        List<Integer> leafSeq2 = getLeafSequence(root2);

        if(leafSeq1.size() != leafSeq2.size()) {
            return false;
        }

        for(int i = 0; i < leafSeq1.size(); i++) {
            if(leafSeq1.get(i) != leafSeq2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
