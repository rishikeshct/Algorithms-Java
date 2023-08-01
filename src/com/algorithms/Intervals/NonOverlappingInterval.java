package Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NonOverlappingInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(NonOverlappingIntervalFunc(intervals));
    }

    private static int NonOverlappingIntervalFunc(int[][] intervals) {

        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;


    }
}
