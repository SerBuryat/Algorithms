package ru.serburyat.leetcode.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervalsArrays {

    public static void main(String[] args) {
        var intervals = new int[][]{{1,4}, {4,5}};
        System.out.println(Arrays.deepToString(new MergeIntervalsArrays().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            var start = intervals[k];
            var next = intervals[i];
            if (start[1] < next[0]) {
                k++;
                intervals[k] = next;
            } else {
                start[1] = Math.max(start[1], next[1]);
            }
        }

        return Arrays.copyOfRange(intervals, 0, k + 1);
    }

}
