package leetcode;

/**
 * 63. 不同路径 II
 * <p>
 * num:63
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-02 22:14
 **/
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len1 = obstacleGrid.length;
        int len2 = obstacleGrid[0].length;
        int[][] dp = new int[len1][len2];
        if (obstacleGrid[0][0] == 1) return 0;
        int k = 0;
        while (k < len1 && obstacleGrid[k][0] != 1) {
            dp[k][0] = 1;
            k++;
        }
        k = 0;
        while (k < len2 && obstacleGrid[0][k] != 1) {
            dp[0][k] = 1;
            k++;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {0, 0, 0}}
        ));

        /*System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{
                {1}}
        ));*/

        /*System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}}
        ));*/
    }

}
