package ru.serburyat.leetcode.mergeintervals;

import java.util.ArrayList;
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

        var indexes = new ArrayList<Integer>();
        for (int i = 0; i < intervals.length - 1; i++) {
            var start = intervals[i];
            var next = intervals[i + 1];

            if (start[1] < next[0]) {
                indexes.add(i);
            } else {
                next[0] = start[0];
                next[1] = Math.max(start[1], next[1]);
            }
        }

        indexes.add(intervals.length - 1);

        return indexes.stream()
                .map(index -> intervals[index])
                .toArray(int[][]::new);
    }

}
