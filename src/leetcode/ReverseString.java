package leetcode;

/**
 * 344. 反转字符串
 * <p>
 * num:344
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author: TuGai
 * @createTime: 2020-07-05 22:04
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) return;
        int l = 0, r = len - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

}
