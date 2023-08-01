package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightView {
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

        new InvertBinaryTree().printTreeLines(root);
        List<Integer> result = new ArrayList<>();
        RightViewFunc(root, result, 0);

        result.forEach(res -> System.out.println(res));
    }

    private static void RightViewFunc(TreeNode root, List<Integer> result, int height) {

        if (root == null) {
            return;
        }

        if (height == result.size()) {
            result.add(root.val);
        }

        RightViewFunc(root.right, result, height+1);

        RightViewFunc(root.left, result, height+1);

    }
}
