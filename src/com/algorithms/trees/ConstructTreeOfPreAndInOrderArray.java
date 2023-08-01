package trees;

import com.sun.source.tree.Tree;

public class ConstructTreeOfPreAndInOrderArray {
    static int idx = 0;
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        TreeNode root = ConstructTreeOfPreAndInOrderArrayFunc(preOrder, inOrder, 0, preOrder.length - 1);

        new InvertBinaryTree().printTreeLines(root  );
    }

    private static TreeNode ConstructTreeOfPreAndInOrderArrayFunc(int[] preOrder, int[] inOrder, int left, int right) {
        if (idx == preOrder.length || left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[idx]);

        for (int i = left; i <= right; i++) {
            if (preOrder[idx] == inOrder[i]) {
                idx++;

                root.left = ConstructTreeOfPreAndInOrderArrayFunc(preOrder, inOrder, left, i-1);
                root.right = ConstructTreeOfPreAndInOrderArrayFunc(preOrder, inOrder, i + 1, right);

                break;
            }
        }
        return root;
    }

}
