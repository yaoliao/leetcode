package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * num:96
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author: TuGai
 * @createTime: 2020-07-03 22:44
 **/
public class UniqueBinarySearchTrees {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) return 0;
        int helper = helper(1, n);
        return helper;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int helper(int start, int end) {
        if (start > end) return 1;
        if (map.containsKey((end - start))) return map.get((end - start));
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            int right = helper(i + 1, end);
            sum += (left * right);
        }
        map.put((end - start), sum);
        return sum;
    }

    /**
     * dp
     *
     * @param n
     * @return
     */
    public int numTreesDp(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j <= i) {
                if (j == 1 || j == n) dp[i] += dp[i - 1];
                else dp[i] += dp[j - 1] * dp[i - j];
                j++;
            }
        }
        return dp[n];
    }


    // ================================   try again  ========================

    public int numTreesDpV2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                num += (j - 1 == 0 ? 1 : dp[j - 1]) * (i - j == 0 ? 1 : dp[i - j]);
            }
            dp[i] = num;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        UniqueBinarySearchTrees trees = new UniqueBinarySearchTrees();
        System.out.println(trees.numTrees(1));
        System.out.println(trees.numTreesDp(1));
    }

}
