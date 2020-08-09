package leetcode;

/**
 * 343. 整数拆分
 * <p>
 * num:343
 * https://leetcode-cn.com/problems/integer-break/
 *
 * @author: TuGai
 * @createTime: 2020-07-30 00:16
 **/
public class IntegerBreak {

    public int integerBreakV(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
                dp[i] = Math.max(dp[i], (i - j) * j);
            }
        }
        return dp[n];
    }

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }


    public static void main(String[] args) {
        IntegerBreak aBreak = new IntegerBreak();
        System.out.println(aBreak.integerBreak(4));
    }
}
