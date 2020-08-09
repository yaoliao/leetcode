package leetcode;

/**
 * 248. 中心对称数 III
 * <p>
 * num:248
 * https://leetcode-cn.com/problems/strobogrammatic-number-iii/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 17:42
 **/
public class StrobogrammaticNumberIii {

    private int max = 0;
    private String low;
    private String high;

    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;
        int[] num = {0, 1, 6, 8, 9};
        int low_len = low.length();
        int hig_len = high.length();
        for (int i = low_len; i <= hig_len; i++) {
            int[] ints = new int[i];
            dfs(num, 0, ints);
        }
        return max;
    }

    private void dfs(int[] num, int dep, int[] res) {
        int len = res.length;
        if (len % 2 == 0 && dep == (len) / 2) {
            help(res);
            return;
        } else if (len % 2 == 1 && dep == (len / 2) + 1) {
            help(res);
            return;
        }

        for (int j = 0; j < num.length; j++) {
            if (dep == 0 && j == 0 && res.length != 1) continue;
            int c = num[j];
            if (len % 2 == 1 && dep == len / 2 && (c == 6 || c == 9)) continue;
            res[dep] = num[j];
            res[len - dep - 1] = change(num[j]);
            dfs(num, dep + 1, res);
        }
    }

    private void help(int[] res) {
        StringBuilder sb = new StringBuilder();
        for (int re : res) {
            sb.append(re);
        }
        String num = sb.toString();
        if (compare(num, low) && compare(high, num)) {
            max++;
        }
    }

    private boolean compare(String str1, String str2) {
        if (str1.length() > str2.length()) return true;
        return str1.compareTo(str2) >= 0;
    }

    private int change(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 6:
                return 9;
            case 8:
                return 8;
            case 9:
                return 6;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumberIii numberIii = new StrobogrammaticNumberIii();
        System.out.println(numberIii.strobogrammaticInRange("50", "100"));
    }
}
