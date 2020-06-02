package leetcode;

/**
 * num:50
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author: TuGai
 * @createTime: 2020-06-02 22:59
 **/
public class Pow {

    /**
     * 递归分治算法。
     * 超时了。。。。。。。
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPowV1(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / myPowV1(x, -n);
        if ((n & 1) == 0) {
            return myPowV1(x, n / 2) * myPowV1(x, n / 2);
        } else {
            return myPowV1(x, n / 2) * myPowV1(x, n / 2) * x;
        }
    }

    /**
     * 使用 快速幂 的方法
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double result = 1.0d;
        for (int i = n; i != 0; i /= 2) {
            if ((i & 1) != 0) {
                result *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        double v = myPow(2, -10);
        double pow = Math.pow(2, -10);
        System.out.println(v == pow);
        System.out.println(v + "  " + pow);
    }

}
