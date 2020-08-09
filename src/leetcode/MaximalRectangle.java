package leetcode;

/**
 * 85. 最大矩形
 * <p>
 * num:85
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @author: TuGai
 * @createTime: 2020-07-31 10:16
 **/
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '1') continue;
                dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                int high = Integer.MAX_VALUE;
                for (int k = 0; k <= i; k++) {
                    high = Math.min(high, dp[i - k][j]);
                    if (high == 0) break;
                    max = Math.max(max, (k + 1) * high);
                }

            }
        }
        return max;
    }

}
