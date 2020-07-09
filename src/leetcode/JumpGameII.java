package leetcode;

/**
 * 45. 跳跃游戏 II
 * <p>
 * num:45
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-08 22:37
 **/
public class JumpGameII {

    /**
     * ===============  TODO  TODO  TODO  TODO  TODO  TODO  TODO  TODO   ================
     *                                  多做几遍
     * =================================================================================
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = nums[0];
        int count = 0;
        int maxI = 0;
        for (int i = 0; true; i = maxI) {
            if (i + step >= nums.length - 1) return count + 1;
            int tmpMax = 0;
            for (int j = 1; j <= step; j++) {
                if (i + j >= nums.length) return count + 1;
                if (tmpMax < (i + j + nums[i + j])) {
                    tmpMax = i + j + nums[i + j];
                    maxI = i + j;
                }
            }
            count++;
            if (maxI >= nums.length - 1) return count;
            step = nums[maxI];
        }
    }

    /*public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1) return (step + 1);
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    public int jump1(int[] nums) {
        if (nums.length < 2) return 0;

        int n = 0;
        int max = nums[0];
        int i = 0;
        while (max < nums.length - 1) {
            int maxi = i;
            int x = max;
            for (int j = i + 1; j <= max; j++) {
                if (nums[j] + j > x) {
                    x = nums[j] + j;
                    maxi = j;
                }
            }
            n++;
            i = maxi;
            max = x;
        }
        return n + 1;
    }*/

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
//        System.out.println(jumpGameII.jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(jumpGameII.jump(new int[]{2, 1, 1, 1, 1}));
//        System.out.println(jumpGameII.jump(new int[]{1, 1, 1, 1, 1}));
//        System.out.println(jumpGameII.jump(new int[]{1, 1, 1, 2, 1}));
        System.out.println(jumpGameII.jump(new int[]{1, 2, 3, 1}));
    }
}
