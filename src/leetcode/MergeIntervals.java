package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * <p>
 * num:56
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author: TuGai
 * @createTime: 2020-07-06 21:40
 **/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] ints = new int[intervals.length][2];
        ints[0][0] = intervals[0][0];
        ints[0][1] = intervals[0][1];
        int num = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (ints[num][1] >= intervals[i][0]) {
                ints[num][1] = Math.max(intervals[i][1], ints[num][1]);
            } else {
                num++;
                ints[num][0] = intervals[i][0];
                ints[num][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(ints, num + 1);
    }

}
