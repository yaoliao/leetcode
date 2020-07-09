package leetcode.template;

/**
 * 快速幂
 *
 * @author: TuGai
 * @createTime: 2020-06-28 21:40
 **/
public class BinaryExponentiation {

    public long binPow(int a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = res * a;
            }
            a = a * a;
            b >>= 1;
        }
        return res;
    }

    public long binPowRecursive(int a, int b) {
        if (b == 0) return 1;
        long res = binPowRecursive(a, b / 2);
        if (b % 2 != 0)
            return res * res * a;
        else
            return res * res;
    }

    public static void main(String[] args) {
        BinaryExponentiation binaryExponentiation = new BinaryExponentiation();
//        System.out.println(binaryExponentiation.binPow(2, 3));
        System.out.println(binaryExponentiation.binPowRecursive(2, 3));
    }

}
