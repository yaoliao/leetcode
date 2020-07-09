package leetcode;

/**
 * 198. 打家劫舍
 * <p>
 * num:198
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author: TuGai
 * @createTime: 2020-06-30 23:03
 **/
public class HouseRobber {

    public int robV1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = nums[0];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }


    /**
     * https://leetcode-cn.com/problems/house-robber/solution/liang-ge-yue-0ji-chu-cong-an-mo-shi-zhuan-xing-zi-/
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }


    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1, 2, 3, 1}));
        System.out.println(robber.rob(new int[]{2, 7, 9, 3, 1}));
    }

}
