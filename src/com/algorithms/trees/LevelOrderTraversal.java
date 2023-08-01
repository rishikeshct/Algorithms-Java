package trees;

import java.util.*;

public class LevelOrderTraversal {
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

        List<List<Integer>> result = new ArrayList<>();

        LevelOrderTraversalFunc(result, root, 0);
        result.forEach(res -> System.out.println(Arrays.toString(res.toArray())));
        LevelOrderTraversalQueueFunc(root);

    }

    private static void LevelOrderTraversalFunc(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (result.size() <= height) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(root.val);

        LevelOrderTraversalFunc(result, root.left, height+1);
        LevelOrderTraversalFunc(result, root.right, height+1);

    }

    private static void LevelOrderTraversalQueueFunc(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                r.add(queue.peek().val);

                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }

                queue.poll();
            }
            res.add(r);
        }

        res.forEach(r -> System.out.println(Arrays.toString(r.toArray())));


    }
}
