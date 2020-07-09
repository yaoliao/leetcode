package leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * num:215
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author: TuGai
 * @createTime: 2020-06-04 23:01
 **/
public class KthLargestElementInAnArray {

    /**
     * 利用小顶堆 O(nlgk)
     * 只超过 59% 。。。。。。。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestByQueue(int[] nums, int k) {
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

    /**
     * 基于快排 O(NlogN)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestQSort(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int l = leftIndex, r = rightIndex;

        // 枢纽元的选择的优化
        int mid = (leftIndex + rightIndex) >> 1;
        int tmp = nums[mid];
        nums[mid] = nums[leftIndex];
        nums[leftIndex] = tmp;

        tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) r--;
            nums[l] = nums[r];

            while (l < r && nums[l] <= tmp) l++;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        quickSort(nums, leftIndex, l - 1);
        quickSort(nums, r + 1, rightIndex);
    }

    /**
     * 减治算法
     * <p>
     * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
     */

    private static final Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (true) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        swap(nums, left, rt);
        return rt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
//        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] ints = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargestByQueue(ints, 2));
        System.out.println(findKthLargestQSort(ints, 2));
    }

}
