package trees;

public class MaxPathSum {
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



        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        node3.right = node10;
        node10.right = node11;

        TreeNode max = new TreeNode(Integer.MIN_VALUE);
        new InvertBinaryTree().printTreeLines(root);

        MaxPathSumFunc(root, max);

        System.out.println(max.val);
    }

    private static int MaxPathSumFunc(TreeNode root, TreeNode max) {
        if (root == null) {
            return 0;
        }


        /**
         *        4
         *      2    7
         *    1   3 6  9
         *         10
         *            11
         */

        int left =  MaxPathSumFunc(root.left, max);
        int right =  MaxPathSumFunc(root.right, max);

        int currMax = Math.max(Math.max(left,right)+root.val, root.val);
        int currMax1 = Math.max((left+right+root.val), currMax);
        max.val = Math.max(currMax1, max.val);

        return currMax;
    }
}
