package leetcode;

/**
 * 72. 编辑距离
 * <p>
 * num:72
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @author: TuGai
 * @createTime: 2020-06-17 21:03
 **/
public class EditDistance {

    /**
     * ===================================================================================================
     * <p>
     * ============################  这个状态的定义太巧妙了，完全想不到啊 #################====================
     * <p>
     * ===================================================================================================
     *
     * <p>
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
     * <p>
     * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
     * <p>
     * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
     * <p>
     * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
     * <p>
     * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;

        int len1 = word1.length();
        int len2 = word2.length();

        // int[i][j] : 表示要将前 i 位的 word1 转换成 前 j 位的 word2 需要的最小步数
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化 要将前 i 位的 word1 转化位 0 位的 word2，就需要删除 i 步
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // 同上
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { //表示当前字母相同所以操作数和上步一样
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance("horse", "ros"));
    }

}
