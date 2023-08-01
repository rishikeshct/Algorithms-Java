package trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;

        new InvertBinaryTree().printTreeLines(root);
        revertBinaryTree(root);
        new InvertBinaryTree().printTreeLines(root);
    }

    private static TreeNode revertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        revertBinaryTree(root.left);
        revertBinaryTree(root.right);

        TreeNode temp = root.left;
        root.left= root.right;
        root.right = temp;

        return root;
    }

    public void printTreeLines(TreeNode root) {
            printTreeHelper(root, "", false);
    }


    private void printTreeHelper(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);

        printTreeHelper(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTreeHelper(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
