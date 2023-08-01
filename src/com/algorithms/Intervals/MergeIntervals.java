package Intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = MergeIntervalsFunc(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

        System.out.println("-----------------");
        res = MergeIntervalsFunc2(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }

    private static int[][] MergeIntervalsFunc2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval = intervals[0];
        List<int[]> mergedInterval = new LinkedList<>();

        mergedInterval.add(currentInterval);
        for (int[] interval : intervals) {
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                currentInterval = interval;
                mergedInterval.add(currentInterval);
            }
        }

        return mergedInterval.toArray(new int[mergedInterval.size()][2]);

    }

    private static int[][] MergeIntervalsFunc(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new LinkedList<>();
       for (int i = 0; i < intervals.length; i++) {
           boolean flag = false;

           if (i == intervals.length - 1) {
               list.add(new int[]{intervals[i][0], intervals[i][1]});
           } else {
               while (!flag) {
                   if ( i < intervals.length - 1 && ((start >= intervals[i+1][0] && start <= intervals[i+1][1]) ||
                           end >= intervals[i+1][1] || (end >= intervals[i+1][0] && end <= intervals[i+1][1]))) {
                       start = Math.min(start, intervals[i+1][0]);
                       end = Math.max(end, intervals[i+1][1]);
                       i++;
                   } else {
                       flag = true;
                       list.add(new int[]{start, end});
                       if (i + 1 < intervals.length - 1) {
                           start = intervals[i+1][0];
                           end = intervals[i+1][1];
                       }
                   }
               }
           }


       }
     return  list.toArray(new int[list.size()][2]);

    }
}
