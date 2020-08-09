package leetcode;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * num:698
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 * @author: TuGai
 * @createTime: 2020-07-13 14:08
 **/
public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsetsV1(int[] nums, int k) {
        int len = nums.length;
        if (nums.length < k) return false;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        sum = sum / k;
        int[] target = new int[k];
        Arrays.fill(target, sum);
        return helper(target, nums, k, len - 1);
    }


    private boolean helper(int[] target, int[] nums, int k, int cur) {
        if (cur < 0) return true;
        for (int i = 0; i < k; i++) {
            if (target[i] == nums[cur] || target[i] - nums[cur] >= nums[0]) {
                target[i] -= nums[cur];
                boolean res = helper(target, nums, k, cur - 1);
                if (res) return true;
                target[i] += nums[cur];
            }
        }
        return false;
    }

    // ==============

    /**
     * other ===============
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum / k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum / k, 0, 0, used);
    }

    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 构建下一个集合
            return backtracking(nums, k - 1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur + nums[i], i + 1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }


    /**
     * [10,10,10,7,7,7,7,7,7,6,6,6]
     * 3
     *
     * @param args
     */
    public static void main(String[] args) {
        PartitionToKEqualSumSubsets partition = new PartitionToKEqualSumSubsets();
        System.out.println(partition.canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3));
    }

}
