package ru.serburyat.leetcode.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MergeIntervalsSimple {

    public static void main(String[] args) {
        var intervals = new int[][]{{1,4}, {0,0}};
        System.out.println(Arrays.deepToString(new MergeIntervalsSimple().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) {
            return intervals;
        }

        var intervalsMap = Arrays.stream(intervals)
                .collect(
                        Collectors.toMap(
                                interval -> interval[0],
                                interval -> interval[1],
                                Math::max,
                                TreeMap::new
                        )
                );

        var mergedIntervals = new LinkedList<Entry<Integer, Integer>>();
        mergedIntervals.addLast(intervalsMap.pollFirstEntry());

        while(!intervalsMap.isEmpty()) {
            var last = mergedIntervals.removeLast();
            var next = intervalsMap.pollFirstEntry();

            if(last.getValue() < next.getKey()) {
                mergedIntervals.addLast(last);
                mergedIntervals.addLast(next);
            } else {
                mergedIntervals.addLast(
                        last.getValue() < next.getValue()
                                ? Map.entry(last.getKey(), next.getValue())
                                : last
                );
            }
        }

        return mergedIntervals.stream()
                .map(entry -> new int[]{entry.getKey(), entry.getValue()})
                .toArray(int[][]::new);
    }

}
