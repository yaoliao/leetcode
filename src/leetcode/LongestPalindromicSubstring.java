package leetcode;

/**
 * 5. 最长回文子串
 * <p>
 * num:5
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author: TuGai
 * @createTime: 2020-06-12 22:52
 **/
public class LongestPalindromicSubstring {

    // ========================= 写了一大坨 ===========================

    public String longestPalindromeV1(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        char[] chars = new char[2 * len + 1];
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) chars[i] = '*';
            else chars[i] = s.charAt(i / 2);
        }

        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < chars.length; i++) {
            int l = i, r = i;
            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            l++;
            r--;
            if ((maxRight - maxLeft) < (r - l)) {
                maxLeft = l;
                maxRight = r;
            }
        }
        char[] res = new char[(maxRight - maxLeft) / 2];
        for (int i = maxLeft; i <= maxRight; i++) {
            if ((i - maxLeft) % 2 == 0) continue;
            res[(i - maxLeft) / 2] = chars[i];
        }
        return new String(res);
    }

    // ========================= 还是一大坨 ===========================

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring string = new LongestPalindromicSubstring();
        System.out.println(string.longestPalindrome("babad"));
        System.out.println(string.longestPalindrome("cbbd"));
    }

}
