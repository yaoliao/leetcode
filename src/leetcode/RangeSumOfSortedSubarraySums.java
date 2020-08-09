package leetcode;

import java.util.PriorityQueue;

/**
 * 5445. 子数组和排序后的区间和
 * <p>
 * num:5445
 * https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 16:56
 **/
public class RangeSumOfSortedSubarraySums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int pre = nums[i];
            add(queue, pre, right);
            for (int j = i + 1; j < len; j++) {
                pre += nums[j];
                add(queue, pre, right);
            }
        }
        int sum = 0;
        while (queue.size() >= left) {
            sum += queue.poll();
        }
        return sum;
    }

    private void add(PriorityQueue<Integer> queue, int i, int size) {
        if (queue.size() < size) {
            queue.add(i);
        } else {
            if (queue.peek() > i) {
                queue.poll();
                queue.add(i);
            }
        }
    }


    public static void main(String[] args) {
        RangeSumOfSortedSubarraySums sum = new RangeSumOfSortedSubarraySums();
        System.out.println(sum.rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4));
    }
}
