package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public static HashMap<Integer, Node> map = new HashMap<>();
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.neighbors = new ArrayList<>(List.of(node1));
        Node node2 = new Node(3);
        node1.neighbors = new ArrayList<>(List.of(node2));
        Node node3 = new Node(4);
        node2.neighbors = new ArrayList<>(List.of(node3));
        node3.neighbors = new ArrayList<>(List.of(node));


        System.out.println(CloneGraphFunc(node));
    }

    private static Node CloneGraphFunc(Node node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node copyNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, copyNode);

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(CloneGraphFunc(neighbor));
        }

        return copyNode;
    }
}
