package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * num:120
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author: TuGai
 * @createTime: 2020-06-14 16:01
 **/
public class Triangle {

    /**
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     *
     * @param triangle
     * @return
     */
    public int minimumTotalV(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] ints = new int[size];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                ints[j] = Math.min(ints[j], ints[j + 1]) + triangle.get(i).get(j);
            }
        }
        return ints[0];
    }


    /**
     * 再次尝试，还是垃圾。。。。。。。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else if (i == j) {
                    dp[j] = triangle.get(i).get(j) + dp[j - 1];
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = Math.min(min, i);
        }
        return min;
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));

        /*List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3));*/
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(lists));

    }


}
