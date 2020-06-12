package leetcode;

/**
 * 爬楼梯
 * <p>
 * num:70
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author: TuGai
 * @createTime: 2020-06-13 00:10
 **/
public class ClimbingStairs {

    // ====================== 垃圾写法， 又难看又慢 =====================

    private int num = 0;

    public int climbStairsV1(int n) {
        if (n == 0) return 0;
        recursive(0, n);
        return num;
    }

    private void recursive(int count, int n) {
        if (count == n) num++;
        if (count > n) return;
        recursive(count + 1, n);
        recursive(count + 2, n);
    }


    // =========================== 递归，有很多重复计算，还是慢 ==================

    public int climbStairsV2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairsV2(n - 1) + climbStairsV2(n - 2);
    }

    // =========================== 递归，加上缓存，减少重复计算，代码还是不好看 ==================


    public int climbStairsV3(int n) {
        return rec(n, new int[n + 1]);
    }

    private int rec(int n, int[] ints) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (ints[n] != 0) {
            return ints[n];
        }
        int i = rec(n - 1, ints) + rec(n - 2, ints);
        ints[n] = i;
        return i;
    }


    // ===========================  动态规划 空间复杂度 O(n) 还可以优化================

    public int climbStairsV4(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    // ===========================  动态规划 空间复杂度 O(1)  完美 ！！！！！！================

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(6));
        System.out.println(climbingStairs.climbStairs(44));
    }


}
