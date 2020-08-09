package leetcode;

/**
 * 29. 两数相除
 * <p>
 * num:29
 * https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @author: TuGai
 * @createTime: 2020-06-27 23:59
 **/
public class DivideTwoIntegers {


    /**
     * =============  强强强  =============
     * <p>
     * https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) { // 被除数 除数
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^32, 2^32-1]，如果a是-2^32，转为正数时将会溢出
        if (a > b) return 0;
        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    int div(int a, int b) {
        if (a > b) return 0;
        int count = 1;
        int tb = b;
        while (tb + tb >= a && tb + tb < 0) { // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count + div(a - tb, b);
    }

    //============================================================

    public int divideTry(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int mark = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            mark = -1;
        }
        int a = dividend, b = divisor;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = helper(a, b);
        return mark == 1 ? res : -res;
    }

    private int helper(int a, int b) {
        if (a > b) return 0;
        int tmpB = b;
        int count = 1;
        while (tmpB + tmpB >= a && tmpB + tmpB < 0) {
            tmpB += tmpB;
            count += count;
        }
        return count + helper(a - tmpB, b);
    }

    public static void main(String[] args) {
        DivideTwoIntegers integers = new DivideTwoIntegers();
        System.out.println(integers.divideTry(2147483647, 3));
    }


}
