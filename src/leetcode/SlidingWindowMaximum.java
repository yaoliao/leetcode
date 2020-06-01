package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * num:239
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author: TuGai
 * @createTime: 2020-06-01 10:15
 **/
public class SlidingWindowMaximum {


    public static void main(String[] args) {

        /*int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;*/
        int[] ints = {1, 3, 1, 2, 0, 5};
        int k = 3;
        /*int[] ints = {1, -1};
        int k = 1;*/
        int[] ints1 = maxSlidingWindow(ints, k);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    /**
     * 使用 双端队列的写法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] ints = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            if (i >= k && i - k >= deque.peek()) {
                deque.poll();
            }

            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < num)
                deque.removeLast();

            deque.add(i);

            if (i >= k - 1) {
                ints[i - k + 1] = nums[deque.peek()];
            }
        }
        return ints;
    }

    // 使用 java 优先队列，结果超时了。。。。我吐了。。。
    public static int[] maxSlidingWindowWithPriority(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        int[] ints = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k - 1) {
                ints[i - k + 1] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }
        return ints;
    }
}
