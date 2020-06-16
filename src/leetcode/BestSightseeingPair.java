package leetcode;

/**
 * 1014. 最佳观光组合
 * <p>
 * num:1014
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * @author: TuGai
 * @createTime: 2020-06-17 00:49
 **/
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) return 0;

        int[] dp = new int[A.length];

        int max = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            dp[i] = max + A[i] - i;
            max = Math.max(max, A[i] + i);
        }

        max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        BestSightseeingPair pair = new BestSightseeingPair();
        int[] ints = {8, 1, 5, 2, 6};
        System.out.println(pair.maxScoreSightseeingPair(ints));
    }
}
