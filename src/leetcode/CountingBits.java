package leetcode;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * <p>
 * num:338
 * https://leetcode-cn.com/problems/counting-bits/
 *
 * @author: TuGai
 * @createTime: 2020-06-13 22:24
 **/
public class CountingBits {

    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] ints = new int[num + 1];
        for (int i = 1; i < ints.length; i++) {
            ints[i] = ints[i & (i - 1)] + 1;
        }
        return ints;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(5)));
    }

}
