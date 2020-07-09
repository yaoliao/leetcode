package leetcode;

/**
 * 509. 斐波那契数
 * <p>
 * num:509
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author: TuGai
 * @createTime: 2020-06-28 22:12
 **/
public class FibonacciNumber {

    // ===============  动态规划 ===============
    public int fibDp(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }


    /**
     * ！！！！！！！！！！！！   看不懂 看不懂 看不懂    ！！！！！！！！
     * <p>
     * https://leetcode-cn.com/problems/fibonacci-number/solution/fei-bo-na-qi-shu-by-leetcode/
     *
     * @param N
     * @return
     */
    int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        matrixPower(A, N - 1);

        return A[0][0];
    }

    void matrixPower(int[][] A, int N) {
        if (N <= 1) {
            return;
        }
        matrixPower(A, N / 2);
        multiply(A, A);

        int[][] B = new int[][]{{1, 1}, {1, 0}};
        if (N % 2 != 0) {
            multiply(A, B);
        }
    }

    void multiply(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }


    public static void main(String[] args) {
        FibonacciNumber number = new FibonacciNumber();
        System.out.println(number.fib(2));
        System.out.println(number.fib(3));
        System.out.println(number.fib(4));
        System.out.println(number.fib(0));
        System.out.println(number.fib(1));
    }


}
