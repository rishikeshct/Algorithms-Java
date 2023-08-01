package HeapPriorityQueue;

import java.util.PriorityQueue;

public class KThLargest {
    public static void main(String[] args) {
        int[] array = {7,2,3,4,5,6};
        int k = 3;

        System.out.println(KThLargestFunc(array, k));
    }

    private static int KThLargestFunc(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < array.length;i++ ) {
            if (queue.size() == k) {
                if (queue.peek() < array[i]) {
                    queue.poll();
                    queue.add(array[i]);
                } else {
                    queue.add(array[i]);
                }
            } else {
                queue.add(array[i]);
            }
        }

        return queue.peek();
    }

}
