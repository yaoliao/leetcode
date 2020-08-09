package leetcode;

import java.util.*;

/**
 * 632. 最小区间
 * num:632
 * <p>
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * @author: TuGai
 * @createTime: 2020-08-01 00:31
 **/
public class SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();
        int[] point = new int[size];

        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, nums.get(i).get(0));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(m -> nums.get(m).get(point[m])));

        for (int i = 0; i < size; i++) {
            queue.add(i);
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        int minRange = Integer.MAX_VALUE;
        while (true) {
            Integer p = queue.poll();
            Integer n = nums.get(p).get(point[p]);
            if (max - n < minRange) {
                minRange = max - n;
                l = n;
                r = max;
            }

            point[p]++;
            if (point[p] == nums.get(p).size()) {
                break;
            }

            queue.add(p);
            max = Math.max(max, nums.get(p).get(point[p]));
        }
        return new int[]{l, r};
    }


    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists lists = new SmallestRangeCoveringElementsFromKLists();
        // [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        System.out.println(Arrays.toString(lists.smallestRange(nums)));
    }

}
