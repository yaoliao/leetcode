package leetcode;

/**
 * 1025. 除数博弈
 * <p>
 * num:1025
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author: TuGai
 * @createTime: 2020-07-24 00:20
 **/
public class DivisorGame {

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j != 0) continue;
                if (!dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        System.out.println(game.divisorGame(3));
    }

}
