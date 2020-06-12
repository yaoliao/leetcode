package leetcode;

/**
 * 9. 回文数
 * <p>
 * num:9
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author: TuGai
 * @createTime: 2020-06-10 00:47
 **/
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String num = String.valueOf(x);
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (num.charAt(l) != num.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(2332));
    }

}
