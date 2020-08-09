package leetcode;

/**
 * 5461. 仅含 1 的子串数
 * <p>
 * num:5461
 * https://leetcode-cn.com/problems/number-of-substrings-with-only-1s/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 22:18
 **/
public class NumberOfSubstringsWithOnly1s {

    public int numSub(String s) {
        final int mod = (int) 1e9 + 7;
        long count = 0;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                res = (res + (count * (count + 1) / 2)) % mod;
                count = 0;
            }
        }
        if (count != 0) {
            res = (res + (count * (count + 1) / 2)) % mod;
        }
        return (int) res;
    }

}
