package trees;

public class SubTreeOfAnotherTree {
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
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        node3.right = node10;

        TreeNode root21 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node210 = new TreeNode(10);

        /**
         *        4
         *      2    7
         *    1   3 6  9
         *         10
         */

        root21.right = node23;
        root21.left = node21;
        node23.right = node210;

        new InvertBinaryTree().printTreeLines(root);
        System.out.println(SubTreeOfAnotherTreeFunc(root, root21));
    }

    private static boolean SubTreeOfAnotherTreeFunc(TreeNode root, TreeNode root1) {
        if (root == null) {
            return false;
        }

        return SameTree.SameTreeFunc(root, root1) || SubTreeOfAnotherTreeFunc(root.left, root1) || SubTreeOfAnotherTreeFunc(root.right, root1);
    }
}
