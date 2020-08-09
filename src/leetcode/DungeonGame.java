package leetcode;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * <p>
 * num:174
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 00:41
 **/
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] : 从当前点到中点所需的最小值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        DungeonGame game = new DungeonGame();
        int[][] ints = {{0, -3}};
        System.out.println(game.calculateMinimumHP(ints));
    }


}
