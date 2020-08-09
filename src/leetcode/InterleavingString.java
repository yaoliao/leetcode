package leetcode;

/**
 * 97. 交错字符串
 * <p>
 * num:97
 * https://leetcode-cn.com/problems/interleaving-string/
 *
 * @author: TuGai
 * @createTime: 2020-07-18 00:53
 **/
public class InterleavingString {

    public boolean isInterleaveDp(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c = s3.charAt(i + j - 1);
                if (s1.charAt(i - 1) == c && dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (s2.charAt(j - 1) == c && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[len1][len2];
    }

    //========================

    private boolean[][] dp;
    private char[] s1, s2, s3;

    private boolean helper(int i, int j, int k) {
        if (i == s1.length && j == s2.length) return true;
        if (i > s1.length || j > s2.length || dp[i][j]) return false;
        if (i < s1.length && s1[i] == s3[k] && helper(i + 1, j, k + 1)) {
            return true;
        }
        if (j < s2.length && s2[j] == s3[k] && helper(i, j + 1, k + 1)) {
            return true;
        }
        dp[i][j] = true;
        return false; // s1[i] != s3[k] && s2[j] != s3[k]
    }

    // 1ms 100%(中文) 0ms 100%(英文)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        dp = new boolean[s1.length() + 1][s2.length() + 1];
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();
        return helper(0, 0, 0);
    }

    public static void main(String[] args) {
        InterleavingString string = new InterleavingString();
        System.out.println(string.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}
