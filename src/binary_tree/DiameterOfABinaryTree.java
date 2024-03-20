package binary_tree;

public class DiameterOfABinaryTree {

    static class Diameter {
        int diameter;
    }
    public int diameterOfBinaryTree(Node root) {
        Diameter dia = new Diameter();
        dia.diameter = 0;
        int res = fnc1(dia, root);
        return dia.diameter;
    }

    int getHeight(Node root) {
        if(root == null) return 0;

        int l =  getHeight(root.left);
        int r = getHeight(root.right);

        return 1 + Math.max(l, r);
    }
    int fnc(Diameter dia, Node root) {
        if(root == null) return 0;

        int l = getHeight(root.left);
        int r = getHeight(root.right);

        dia.diameter = Math.max(dia.diameter, 1 + l + r);
        fnc(dia, root.left);
        fnc(dia, root.right);
        return 0;
    }

    int fnc1(Diameter dia, Node root) {
        if(root == null) return 0;

        int l = fnc1(dia, root.left);
        int r = fnc1(dia, root.right);

        dia.diameter = Math.max(dia.diameter, l + r);
        return 1 + Math.max(l, r);
    }
}
