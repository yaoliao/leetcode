package leetcode;

/**
 * num:625
 *
 * @author: TuGai
 * @createTime: 2020-07-10 14:08
 **/
public class MinimumFactorization {

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/minimum-factorization/solution/zui-xiao-yin-shi-fen-jie-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param a
     * @return
     */
    public int smallestFactorization(int a) {
        if (a < 2) return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }

    public static void main(String[] args) {
        MinimumFactorization factorization = new MinimumFactorization();
        System.out.println(factorization.smallestFactorization(10002));
    }

}
