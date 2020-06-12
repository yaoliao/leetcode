package leetcode.interview;

/**
 * interview:46
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author: TuGai
 * @createTime: 2020-06-09 00:49
 **/
public class ChangeNumberToChar {

    /**
     * 动态规划
     * 最重要的方法：f(n) = f(n+1) + g(n,n+1)*f(n+2)
     * n : 表示 num 的长度, f(n) : 表示可以翻译的数量
     * base: f(n) = 0, f(n-1) = 1
     * 如果 第 n 和 n+1 组成的值 10 <= X <= 25，则 g(n,n+1) = 1，否则为 0
     * 例如: num : 12258 则
     * f(5) --> 1
     * f(4) --> 1
     * f(3) --> f(4) + g(n,n+1)*f(5) --> 因为 (n,n+1) = 58 > 25 ,所以 g(n,n-1) = 0 --> 1
     * f(2) --> f(3) + g(n,n+1)*f(4) --> f(3) + 1*f(4) --> 2
     * f(1) --> f(2) + g(n,n+1)*f(3) --> f(2) + 1*f(3) --> 3
     * f(0) --> f(1) + g(n,n+1)*f(2) --> f(2) + 1*f(2) --> 5
     *
     * @param num
     * @return
     */
    public static int translateNumV1(int num) {
        if (num == 0) return 1;
        String numStr = String.valueOf(num);
        int f1 = 1, f2 = 1, g = 0, count = f2;
        for (int i = numStr.length() - 2; i >= 0; i--) {
            Integer integer = Integer.valueOf(numStr.charAt(i) + "" + numStr.charAt(i + 1));
            if (integer > 25 || integer < 10) {
                g = 0;
            } else {
                g = 1;
            }
            count = f2 + g * f1;
            f1 = f2;
            f2 = count;
        }
        return count;
    }

    /**
     * dfs
     * ######## 草草草，太强了，简直就是智商碾压 ##########
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        //xyzcba
        int ba = num % 100;
        if (ba <= 9 || ba >= 26) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }


    public static void main(String[] args) {
//        int num = translateNum(12258);
        int num = translateNum(25);
        System.out.println(num);
    }

}
