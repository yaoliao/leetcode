package leetcode;

/**
 * 44. 通配符匹配
 * <p>
 * num:44
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * @author: TuGai
 * @createTime: 2020-07-05 16:36
 **/
public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;

        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                if (sChar == pChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (pChar == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (pChar == '?') {
                        if (dp[i - 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }

    public static void main(String[] args) {
        WildcardMatching matching = new WildcardMatching();
//        System.out.println(matching.isMatch("aa", "*"));
//        System.out.println(matching.isMatch("cb", "?b"));
//        System.out.println(matching.isMatch("adceb", "*a*b"));
        System.out.println(matching.isMatch("ho", "**ho"));
    }

}
