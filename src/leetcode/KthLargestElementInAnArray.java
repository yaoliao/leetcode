package leetcode;

import java.util.PriorityQueue;

/**
 * num:215
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author: TuGai
 * @createTime: 2020-06-04 23:01
 **/
public class KthLargestElementInAnArray {

    /**
     * 利用小顶堆
     * 只超过 59% 。。。。。。。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k)
                queue.add(nums[i]);
            else if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
//        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] ints = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(ints, 2);
        System.out.println(kthLargest);
    }

}
