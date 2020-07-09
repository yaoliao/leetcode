package leetcode;

/**
 * 91. 解码方法
 * <p>
 * num:91
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author: TuGai
 * @createTime: 2020-06-26 22:53
 **/
public class DecodeWays {

    public int numDecodings(String s) {
        char[] chrs = s.toCharArray();
        int len = chrs.length;
        if (len == 0) {
            return 0;
        }

        int[] table = new int[len];
        if (chrs[0] == '0') {
            table[0] = 0;
        } else {
            table[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (chrs[i] != '0') {
                table[i] = table[i - 1];
            }
            int temp = 10 * (chrs[i - 1] - '0') + chrs[i] - '0';
            if (temp >= 10 && temp <= 26) {
                if (i == 1) {
                    table[i]++;
                } else {
                    table[i] += table[i - 2];
                }
            }
        }
        return table[len - 1];
    }

    public static void main(String[] args) {
        DecodeWays ways = new DecodeWays();
//        System.out.println(ways.numDecodings("12"));
        System.out.println(ways.numDecodings("2212"));
//        System.out.println(ways.numDecodings("10"));
//        System.out.println(ways.numDecodings("30"));
    }
}
