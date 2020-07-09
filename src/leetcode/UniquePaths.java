package leetcode;

/**
 * 62. 不同路径
 * <p>
 * num:62
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author: TuGai
 * @createTime: 2020-06-26 22:08
 **/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[0][0] = 1;
                else dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        System.out.println(paths.uniquePaths(2, 2));
    }


}
