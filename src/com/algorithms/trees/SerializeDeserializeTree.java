package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {
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
       String str = SerializeTree(root);
        System.out.println(str);

        new InvertBinaryTree().printTreeLines(Deserialize(str));
    }

    private static TreeNode Deserialize(String str) {
       String[] strings = str.split(" ");
       Queue<TreeNode> queue = new LinkedList<>();

       TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
       queue.add(root);

      for (int i = 1; i < strings.length; i++) {
          TreeNode parent = queue.poll();
          if (!strings[i].equals("n")) {
              TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
              parent.left = left;
              queue.add(left);
          }
          if (!strings[++i].equals("n")) {
              TreeNode right = new TreeNode(Integer.parseInt(strings[i]));
              parent.right = right;
              queue.add(right);
          }
      }
      return root;
    }

    private static String SerializeTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            if (parent == null) {
                stringBuilder.append("n ");
                continue;
            }

            stringBuilder.append(parent.val + " ");

            queue.add(parent.left);
            queue.add(parent.right);
        }

        return stringBuilder.toString();
    }
}
