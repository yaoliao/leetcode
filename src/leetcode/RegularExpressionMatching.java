package leetcode;

/**
 * 10. 正则表达式匹配
 * <p>
 * num:10
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author: TuGai
 * @createTime: 2020-06-20 00:14
 **/
public class RegularExpressionMatching {

    //================ 动态规划 太难了 ====================

    public boolean isMatchV1(String s, String p) {
        if (s == null || p == null) return false;

        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];

        //初始化
        dp[0][0] = true;
        for (int j = 2; j <= plen; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        if (j < 2) continue;
                        char c = p.charAt(j - 2);
                        if (c == '.' || c == sc) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                        }
                        dp[i][j] = dp[i][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = false;
                    }

                }
            }
        }
        return dp[slen][plen];
    }

    //================ 递归 也太难了 ====================

    public boolean isMatch(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty()) return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {//如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            return isMatch(s, p.substring(2)) ||
                    (headMatched && isMatch(s.substring(1), p));
        } else if (headMatched) {//否则，如果s和p的首字符相等
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatch("aa", "a"));
        System.out.println(matching.isMatch("aa", "a*"));
        System.out.println(matching.isMatch("aab", "c*a*b"));
        System.out.println(matching.isMatch("mississippi", "mis*is*p*."));
    }
}
