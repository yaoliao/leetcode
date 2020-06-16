package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 322. 零钱兑换
 * <p>
 * num:322
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author: TuGai
 * @createTime: 2020-06-16 23:03
 **/
public class CoinChange {


    // ==================== 暴力求解。。。。 无记忆化的 dfs 超出时间限制 自己写的垃圾代码 ======================
    public int coinChangeV1(int[] coins, int amount) {
        if (amount == 0) return 0;

        long[] res = {Long.MAX_VALUE};
        Arrays.sort(coins);
        recursive(coins, amount, 0, 0, res);
        return res[0] == Long.MAX_VALUE ? -1 : (int) res[0];
    }

    private void recursive(int[] coins, int amount, long sum, int count, long[] res) {
        if (count >= res[0]) return;

        if (res[0] != Long.MAX_VALUE) return;

        if (sum == amount) {
            res[0] = count;
            return;
        }
        if (sum > amount) return;
        for (int i = coins.length - 1; i >= 0; i--) {
            recursive(coins, amount, sum + coins[i], count + 1, res);
        }
    }

    // ==================== bfs 牛皮啊 ====================

    public int coinChangeV2(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins); // 递增
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);

        boolean[] exit = new boolean[amount + 1]; // 剪枝 :用于判断这个数字是否计算过

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer all = queue.poll();
                for (int i = 0; i < coins.length; i++) {
                    int num = all - coins[i];
                    if (num == 0) return count;
                    if (num < 0) break; //  剪枝 : 后面的 coin 都比这个大直接跳过
                    if (exit[num]) continue;
                    queue.add(num);
                    exit[num] = true;
                }
            }
            count++;
        }
        return -1;
    }

    // ==================== 动态规划 相当于楼梯问题 (我怎么没想到那哎。。。还是要多做啊 ！！！！！！！)====================

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        int[] ints = {1, 2, 5};
        System.out.println(change.coinChange(ints, 11));

        int[] ints1 = {2};
        System.out.println(change.coinChange(ints1, 3));

        int[] ints2 = {1, 2147483647};
        System.out.println(change.coinChange(ints2, 2));

        int[] ints3 = {1, 2, 5};
        System.out.println(change.coinChange(ints3, 100));
    }

}
