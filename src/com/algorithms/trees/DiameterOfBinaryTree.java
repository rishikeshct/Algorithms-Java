package trees;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        TreeNode nodeMax = new TreeNode(Integer.MIN_VALUE);

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

        new InvertBinaryTree().printTreeLines(root);
       DiameterOfBinaryTreeFunc(root, nodeMax);
        System.out.println(nodeMax.val);
    }

    private static int DiameterOfBinaryTreeFunc(TreeNode root, TreeNode max) {
        if (root == null) {
            return 0;
        }

        int left = DiameterOfBinaryTreeFunc(root.left, max);
        int right = DiameterOfBinaryTreeFunc(root.right, max);

        max.val = Math.max(left+right+1, max.val);

       return Math.max(left, right) + 1;
    }
}
