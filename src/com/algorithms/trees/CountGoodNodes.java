package trees;

public class CountGoodNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        int nodeMax = Integer.MIN_VALUE;

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
        System.out.println(CountGoodNodesFunc(root, nodeMax));
    }

    private static int CountGoodNodesFunc(TreeNode root, int nodeMax) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val > nodeMax)
            res = 1;

        res += CountGoodNodesFunc(root.left, Math.max(nodeMax, root.val));
        res += CountGoodNodesFunc(root.right, Math.max(nodeMax, root.val));
        return res;

    }
}
