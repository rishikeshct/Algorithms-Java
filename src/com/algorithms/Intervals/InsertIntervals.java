package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{3,3}, {4,6}, {5,7}};

        int[] newInterval = {3, 3};

        int[][] res = InsertIntervalsFunc(intervals, newInterval);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println("-------------");

        res = InsertIntervalsFunc2(intervals, newInterval);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }    }

    static int[][] InsertIntervalsFunc2(int[][] intervals, int[] newInterval) {
        int newS=newInterval[0];
        int newE=newInterval[1];
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        int i=0;
        for(i=0;i<intervals.length;i++){
            if(newE<intervals[i][0]){
                break;
            }else if(newS>intervals[i][1]){
                //add the given interval.
                ArrayList<Integer> currA=new ArrayList<Integer>();
                currA.add(intervals[i][0]);
                currA.add(intervals[i][1]);
                arr.add(currA);
            }else{
                //overlapping
                newS=Math.min(newS,intervals[i][0]);
                newE=Math.max(newE,intervals[i][1]);
            }
        }
        //Inserted the required new intervals.
        ArrayList<Integer> currA=new ArrayList<Integer>();
        currA.add(newS);
        currA.add(newE);
        arr.add(currA);
        //add all remaning interavls if exiits;
        for(int j=i;j<intervals.length;j++){
            ArrayList<Integer> currB=new ArrayList<Integer>();
            currB.add(intervals[j][0]);
            currB.add(intervals[j][1]);
            arr.add(currB);
        }
        //conv to int[][].
        int[][] ans=new int[arr.size()][2];
        for(int m=0;m<arr.size();m++){
            ans[m][0]=arr.get(m).get(0);
            ans[m][1]=arr.get(m).get(1);
        }
        return ans;
    }

    private static int[][] InsertIntervalsFunc(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];

        int mergeStartIndex = -1;
        int mergeEndIndex = intervals.length;

        for (int i = 0; i < intervals.length; i++) {
            if (start >= intervals[i][0] && start <= intervals[i][1]) {
                mergeStartIndex = i;
                start = intervals[i][0];
                break;

            } else if (start > intervals[i][1]) {
                mergeStartIndex = i + 1;
            }

        }

        for (int i = intervals.length - 1; i>=0 ; i--) {
            if (end >= intervals[i][0] && end <= intervals[i][1]) {
                mergeEndIndex = i;
                if (end < intervals[i][1]) {
                    end = intervals[i][1];
                }
                break;
            } if (end  < intervals[i][0]) {
                mergeEndIndex = i -1;
            }
        }


       LinkedList<int[]> list =  new LinkedList<>(Arrays.asList(intervals));
        if (mergeEndIndex == intervals.length && mergeStartIndex ==intervals.length) {
            list.addLast(new int[]{start, end});
        } else if (mergeEndIndex == -1 && mergeStartIndex == -1) {
            list.addFirst(new int[]{start, end});
        } else {
            if (mergeStartIndex == -1) {
                mergeStartIndex = 0;
            }
            if (mergeEndIndex == intervals.length) {
                mergeEndIndex = intervals.length-1;
            }
            for (int i = mergeStartIndex; i <= mergeEndIndex; i++) {
                list.remove(intervals[i]);
            }
            list.add(mergeStartIndex, new int[]{start, end});
        }

        return list.toArray(new int[list.size()][2]);
    }
}
