package leetcode;

import java.util.*;

/**
 * 279. 完全平方数
 * <p>
 * num:279
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * @author: TuGai
 * @createTime: 2020-06-30 23:15
 **/
public class PerfectSquares {

    /**
     * bfs
     *
     * @param n
     * @return
     */
    public int numSquaresBfs(int n) {
        if (n == 0) return 0;
        List<Integer> list = new ArrayList<>();
        int i = 1, j;
        while ((j = i * i++) <= n) list.add(j);

        Set<Integer> set = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int dep = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Integer poll = queue.poll();
                for (Integer integer : list) {
                    int z = poll - integer;
                    if (z == 0) return dep;
                    if (z < 0) break;
                    if (set.contains(z)) continue;
                    set.add(z);
                    queue.add(z);
                }
            }
            dep++;
        }
        return dep;
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares squares = new PerfectSquares();
        System.out.println(squares.numSquaresBfs(0));
        System.out.println(squares.numSquaresBfs(13));
        System.out.println(squares.numSquaresBfs(156));

        System.out.println("===============");
        System.out.println(squares.numSquares(0));
        System.out.println(squares.numSquares(13));
        System.out.println(squares.numSquares(156));
    }

}
