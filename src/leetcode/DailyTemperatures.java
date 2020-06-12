package leetcode;

import java.util.Arrays;

/**
 * 739. 每日温度
 * <p>
 * num:739
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author: TuGai
 * @createTime: 2020-06-11 13:01
 **/
public class DailyTemperatures {

    /**
     * 从后往前的遍历法
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return new int[]{0};
        int length = T.length;
        int[] index = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j <= length - 1) {
                if (T[i] < T[j]) {
                    index[i] = j - i;
                    break;
                }
                if (index[j] == 0) break;
                j = j + index[j];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

}
