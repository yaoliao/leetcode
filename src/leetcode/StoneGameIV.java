package leetcode;

/**
 * 5447. 石子游戏 IV
 * <p>
 * num:5447
 * https://leetcode-cn.com/problems/stone-game-iv/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 17:26
 **/
public class StoneGameIV {

    public boolean winnerSquareGame(int n) {
        // i 个石子的情况下，Alice 先手是否能取胜
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 当 Alice 拿走 j*j 个石子后，
                // 剩下的石子就相当于由 Bob 先手去拿。如果为 dp[i - j*j] == false,就相当于 Bob 无法获胜，那么 Alice胜
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StoneGameIV gameIV = new StoneGameIV();
        System.out.println(gameIV.winnerSquareGame(1));
        System.out.println(gameIV.winnerSquareGame(2));
        System.out.println(gameIV.winnerSquareGame(4));
        System.out.println(gameIV.winnerSquareGame(7));
        System.out.println(gameIV.winnerSquareGame(17));
    }

}
