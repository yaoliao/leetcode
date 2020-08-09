package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * <p>
 * num:93
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author: TuGai
 * @createTime: 2020-07-29 23:35
 **/
public class RestoreIPAddresses {

    private List<String> results;
    private StringBuilder sb;
    private char[] chars;

    public List<String> restoreIpAddresses(String s) {
        results = new ArrayList<>();
        sb = new StringBuilder();
        chars = s.toCharArray();
        dfs(0, 0);
        return this.results;
    }

    /**
     * @param count 已经确定的数量
     * @param i     下一个要处理的 index
     */
    private void dfs(int count, int i) {
        if (count == 4 && i == chars.length) {
            results.add(sb.toString());
            return;
        }

        int lastCount = 4 - count;
        int lastI = chars.length - i;
        if (lastCount * 3 < lastI || lastCount > lastI) {
            return;
        }

        int len = sb.length();
        char c = chars[i];
        int j = c == '0' ? 1 : 3;
        for (int k = 0; k < j && (k + i < chars.length); k++) {

            if (k == 2 && ((chars[i] - '0') * 100 + (chars[i + 1] - '0') * 10 + chars[i + 2] - '0' > 255)) {
                continue;
            }

            for (int l = 0; l <= k; l++) {
                sb.append(chars[i + l]);
            }

            if (count < 3) {
                sb.append('.');
            }

            dfs(count + 1, i + k + 1);

            sb.delete(len, count < 3 ? len + j + 2 : len + j + 1);
        }
    }

    /**
     * 暴力解法，还很快。。。。 暴力美学
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddressesViolence(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder ip = new StringBuilder();

        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        /*
                         * 1、保障下面subString不会越界
                         * 2、保障截取的字符串与输入字符串长度相同
                         * //1、2比较好理解，3比较有意思
                         * 3、不能保障截取的字符串转成int后与输入字符串长度相同
                         * 如：字符串010010，a=1，b=1，c=1，d=3，对应字符串0，1，0，010
                         * 转成int后seg1=0，seg2=1，seg3=0，seg4=10
                         * //所以需要下面这处判断if (ip.length() == s.length() + 3)
                         */
                        if (a + b + c + d == s.length()) {
                            int seg1 = Integer.parseInt(s.substring(0, a));
                            int seg2 = Integer.parseInt(s.substring(a, a + b));
                            int seg3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int seg4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            // 四个段数值满足0~255
                            if (seg1 <= 255 && seg2 <= 255 && seg3 <= 255 && seg4 <= 255) {
                                ip.append(seg1).append(".").append(seg2).append(".").
                                        append(seg3).append(".").append(seg4);
                                // 保障截取的字符串转成int后与输入字符串长度相同
                                if (ip.length() == s.length() + 3) {
                                    result.add(ip.toString());
                                }
                                ip.delete(0, ip.length());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
