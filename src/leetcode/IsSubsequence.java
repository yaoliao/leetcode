package leetcode;

/**
 * 392. 判断子序列
 * <p>
 * num:392
 * https://leetcode-cn.com/problems/is-subsequence/
 *
 * @author: TuGai
 * @createTime: 2020-07-27 22:03
 **/
public class IsSubsequence {

    public boolean isSubsequenceV(String s, String t) {
        int m = s.length();
        int point = 0;
        int point_t = 0;
        while (point < m) {
            char c = s.charAt(point);
            while (point_t < t.length() && t.charAt(point_t) != c) point_t++;
            if (point_t == t.length()) return false;
            point++;
            point_t++;
        }
        return point == m;
    }

    // 抄的双百写法。。。。。
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }


}
