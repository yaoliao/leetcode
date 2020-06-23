package leetcode;

/**
 * 13. 罗马数字转整数
 * <p>
 * num:13
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 21:05
 **/
public class RomanToInteger {

    /*字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000*/

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException("s is illegal argument");
        int res = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = change(c);
            res = val < pre ? res - val : res + val;
            pre = val;
        }
        return res;
    }

    private int change(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }

    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.romanToInt("MCMXCIV"));
    }
}
