package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 面试题 17.13. Re-Space LCCI
 * <p>
 * num:17.13
 * https://leetcode-cn.com/problems/re-space-lcci/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 00:07
 **/
public class ReSpaceLCCI {

    public int respace(String[] dictionary, String sentence) {

        Arrays.sort(dictionary, (Comparator.comparingInt(String::length)));

        int len = sentence.length();
        if (len < dictionary[0].length()) return len;

        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < dictionary.length && dictionary[j].length() <= i; j++) {
                String dic = dictionary[j];
                if (sentence.startsWith(dic, i - dic.length())) {
                    dp[i] = Math.min(dp[i - dic.length()], dp[i]);
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        ReSpaceLCCI lcci = new ReSpaceLCCI();
        System.out.println(lcci.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
    }

}
