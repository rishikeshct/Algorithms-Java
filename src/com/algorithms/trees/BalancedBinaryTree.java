package trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);


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
        node10.right = node11;

        boolean[] flag = new boolean[1];
        new InvertBinaryTree().printTreeLines(root);
        System.out.println( BalancedBinaryTreeFunc(root, flag));
        System.out.println(flag[0]);
    }

    private static int BalancedBinaryTreeFunc(TreeNode root, boolean[] flag) {
        if (root == null) {
            return 0;
        }

        int left = BalancedBinaryTreeFunc(root.left, flag);
        int right = BalancedBinaryTreeFunc(root.right, flag);

        if (Math.abs(left - right) > 1) {
            flag[0] = false;
        }

        return Math.max(left, right) + 1;

    }

}
