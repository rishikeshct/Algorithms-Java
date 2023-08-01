package HeapPriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (var n : nums) add(n);
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {

        KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream(3, new int[]{3, 4, 6, 5, 8});
        System.out.println(kthLargestElementInStream.add(7));

    }
}
