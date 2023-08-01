package Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        /**
         * Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.
         * Example 1:
         * Input:
         * [[0, 30],[5, 10],[15, 20]]
         * Output:
         *  2
         */

        int[][] intervals = {{100,700}, {200, 300}, {299,500}};
        System.out.println(MeetingRoom2Func(intervals));
    }

        private static int MeetingRoom2Func(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        queue.add(intervals[0]);
        int count =1;
        for (int i = 1; i < intervals.length; i++) {
                int[]  current= queue.peek();
                if (current[1] > intervals[i][0] && count <= queue.size()) {
                    count++;
                    queue.add(intervals[i]);
                } else {
                    queue.poll();
                    queue.add(intervals[i]);
                }
            }

        return count;
        }
}
