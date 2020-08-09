package leetcode;

import java.util.Arrays;

/**
 * 5446. 三次操作后最大值与最小值的最小差
 * <p>
 * num:5446
 * https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 17:18
 **/
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int m = nums[nums.length - 1 - 3 + i] - nums[i];
            min = Math.min(min, m);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves moves = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
//        System.out.println(moves.minDifference(new int[]{1, 5, 0, 10, 14}));
//        System.out.println(moves.minDifference(new int[]{6,6,0,1,1,4,6}));
        System.out.println(moves.minDifference(new int[]{1, 5, 6, 14, 15}));
    }

}
