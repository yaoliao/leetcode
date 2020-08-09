package leetcode;

/**
 * 55. 跳跃游戏
 * <p>
 * num:55
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 23:30
 **/
public class JumpGame {

    public boolean canJumpV1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        int step = 0;
        int maxI = nums[0];
        int maxDistance = 0;
        for (int i = 1; i < nums.length; i++) {
            if (maxI >= nums.length) return true;
            if (i + nums[i] > maxDistance) {
                maxDistance = i + nums[i];
            }
            if (maxI == i) {
                maxI = maxDistance;
                step++;
            }
        }
        return maxI > nums.length;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


}
