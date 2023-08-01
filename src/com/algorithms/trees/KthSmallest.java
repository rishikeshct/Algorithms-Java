package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);



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


        new InvertBinaryTree().printTreeLines(root);
        System.out.println(KthSmallestFunc(root, 3));
        List<TreeNode> list = new ArrayList<>();
        KthSmallestFuncInOrder(root, 3, list);

        System.out.println(list.get(3-1).val);
    }

    private static void KthSmallestFuncInOrder(TreeNode root, int k, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        KthSmallestFuncInOrder(root.left, k, list);

        list.add(root);
        KthSmallestFuncInOrder(root.right, k, list);

    }

    private static int KthSmallestFunc(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int n = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            n++;
            if (n == k) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }
}
