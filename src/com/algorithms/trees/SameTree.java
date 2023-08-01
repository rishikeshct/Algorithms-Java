package trees;

public class SameTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        /**
         *        4
         *      2    7
         *    1   3 6  9
         *         10
         */

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        node3.right = node10;

        TreeNode root21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(2);
        TreeNode node27 = new TreeNode(7);
        TreeNode node21 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node26 = new TreeNode(6);
        TreeNode node29 = new TreeNode(9);
        TreeNode node210 = new TreeNode(10);

        /**
         *        4
         *      2    7
         *    1   3 6  9
         *         10
         */

        root21.left = node22;
        root21.right = node27;
        node22.left = node21;
        node22.right = node23;
        node27.left = node26;
        node27.right = node29;
        node23.right = node210;

        new InvertBinaryTree().printTreeLines(root);
        System.out.println(SameTreeFunc(root, root21));
    }

    public static boolean SameTreeFunc(TreeNode root, TreeNode root1) {

        if (root == null && root1 == null) {
            return true;
        }

        if (root == null || root1 == null) {
            return false;
        }

       boolean left = SameTreeFunc(root.left, root1.left);
       boolean right = SameTreeFunc(root.right, root1.right);

       return root.val == root1.val && left && right;
    }
}
