package leetcode;

/**
 * num:69
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author: TuGai
 * @createTime: 2020-06-08 00:13
 **/
public class SqrtX {

    /**
     * 二分查找法
     *
     * @param x
     * @return
     */
    public static int mySqrtV1(int x) {
        if (x == 0) return 0;
        int l = 0, r = x, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        int i = mySqrt(2147395599);
        System.out.println(i);
    }
}
