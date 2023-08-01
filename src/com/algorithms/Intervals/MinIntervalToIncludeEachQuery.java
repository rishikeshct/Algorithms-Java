package Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinIntervalToIncludeEachQuery {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] queries = {5,2,3,4};

        System.out.println(Arrays.toString(MinIntervalToIncludeEachQueryFunc(intervals, queries)));

        System.out.println(Arrays.toString(MinIntervalToIncludeEachQueryFunc2(intervals, queries)));

    }

    private static int[] MinIntervalToIncludeEachQueryFunc(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        Integer[] indices = new Integer[queries.length];

        for (int i = 0; i < queries.length; ++i)
            indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(a -> queries[a]));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {

                    if (intervals[j][0] > queries[indices[i]]) {
                        break;
                    }
                if (intervals[j][0] <=  queries[indices[i]] &&  queries[indices[i]] <= intervals[j][1]) {
                    min = Math.min(min, intervals[j][1] - intervals[j][0] + 1);
                }
            }
            if (min == Integer.MAX_VALUE) {
                ans[indices[i]] = -1;
            } else {
                ans[indices[i]] = min;
            }
        }

        return ans;
    }

    private static int[] MinIntervalToIncludeEachQueryFunc2(int[][] intervals, int[] queries) {

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        Queue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.size - b.size);
        Integer[] indices = new Integer[queries.length];

        for (int i = 0; i < queries.length; ++i)
            indices[i] = i;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(indices, (a, b) -> queries[a] - queries[b]);

        int i = 0; // intervals' pointer
        for (final int index : indices) {
            while (i < intervals.length && intervals[i][0] <= queries[index]) {
                minHeap.offer(new Interval(intervals[i][1] - intervals[i][0] + 1, intervals[i][1]));
                ++i;
            } 
            while (!minHeap.isEmpty() && minHeap.peek().right < queries[index])
                minHeap.poll();
            if (!minHeap.isEmpty())
                ans[index] = minHeap.peek().size;
        }

        return ans;
    }

}

class Interval {
    public int size;
    public int right;
    public Interval(int size, int right) {
        this.size = size;
        this.right = right;
    }
}