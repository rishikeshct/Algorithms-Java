package stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        /**
         * position = {0, 3, 5, 8, 10}
         * speed =    {1, 3, 1, 4, 2}
         * time =    {12, 3, 7, 1, 1}
         */
        int[] speed = {2,4,1,1,3};

        System.out.println(new CarFleet().CarFleetFunc(position, speed, target));
    }

    private int CarFleetFunc(int[] position, int[] speed, int target) {

        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < position.length; i++) {
            queue.add(new Node(position[i], (target-position[i])/speed[i]));
        }

        Node node = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            if (queue.peek().time > node.time) {
                count++;
                node = queue.poll();
            } else {
                queue.poll();
            }
        }
        return count;
    }

    class Node implements Comparable<Node> {

        int pos;
        float time;

        public Node(int pos, float time) {
            this.pos = pos;
            this.time = time;
        }


        @Override
        public int compareTo(Node o) {
            return o.pos - this.pos;
        }
    }
}
