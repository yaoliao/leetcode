package leetcode;

/**
 * 125. 验证回文串
 * <p>
 * num:125
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author: TuGai
 * @createTime: 2020-06-19 00:20
 **/
public class ValidPalindrome {

    // ===================== 自己写的虽然思路是对的，但是代码太丑了 。。。。=============

    public boolean isPalindromeV1(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;

        int len = s.length();
        int l = 0, r = len - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            while (!Character.isLetterOrDigit(lc)) {
                l++;
                if (l >= r) return true;
                lc = s.charAt(l);
            }

            char rc = s.charAt(r);
            while (!Character.isLetterOrDigit(rc)) {
                r--;
                if (l >= r) return true;
                rc = s.charAt(r);
            }
            if (Character.isUpperCase(lc))
                lc = Character.toLowerCase(lc);
            if (Character.isUpperCase(rc))
                rc = Character.toLowerCase(rc);

            if (lc != rc) return false;
            l++;
            r--;
        }
        return true;
    }

    // ===================== 同样的思路代码写的好看多了 =============

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome("race a car"));
        System.out.println(palindrome.isPalindrome(" "));
    }

}
