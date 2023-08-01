package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{29,40},{41,50}};

        System.out.println(MeetingRoomFunc(intervals));
    }

    private static boolean MeetingRoomFunc(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] > intervals[i][0]) {
                return false;
            }else {
                currentInterval = intervals[i];
            }
        }

        return true;
    }
}
