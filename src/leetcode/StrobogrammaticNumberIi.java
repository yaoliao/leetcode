package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 247. 中心对称数 II
 * <p>
 * num:247
 * https://leetcode-cn.com/problems/strobogrammatic-number-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 16:11
 **/
public class StrobogrammaticNumberIi {

    // 输入:  n = 2
    // 输出: ["11","69","88","96"]

    public List<String> findStrobogrammaticV1(int n) {
        if (n == 0) return Collections.emptyList();
        int[] num = {0, 1, 6, 8, 9};
        int[] ints = new int[n];
        List<String> res = new ArrayList<>();
        dfs(num, 0, ints, res);
        return res;
    }


    private void dfs(int[] num, int dep, int[] res, List<String> list) {
        int len = res.length;
        if (len % 2 == 0 && dep == (len) / 2) {
            help(res, list);
            return;
        } else if (len % 2 == 1 && dep == (len / 2) + 1) {
            help(res, list);
            return;
        }

        for (int j = 0; j < num.length; j++) {
            if (dep == 0 && j == 0 && res.length != 1) continue;
            int c = num[j];
            if (len % 2 == 1 && dep == len / 2 && (c == 6 || c == 9)) continue;
            res[dep] = num[j];
            res[len - dep - 1] = change(num[j]);
            dfs(num, dep + 1, res, list);
        }
    }

    private void help(int[] res, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int re : res) {
            sb.append(re);
        }
        list.add(sb.toString());
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


    /**
     * ================================= 简单明了
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    // n表示，当前循环中，求得字符串长度； m表示题目中要求的字符串长度
    public List<String> helper(int n, int m) {
        // 第一步：判断输入或者状态是否合法
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("invalid input");
        }
        // 第二步：判断递归是否应当结束
        if (n == 0)
            return new ArrayList<>(Collections.singletonList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));

        // 第三步：缩小问题规模
        List<String> list = helper(n - 2, m);

        // 第四步：整合结果
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (n != m)
                // n=m时，表示最外层处理。
                // 例如：原始需求n=m=2, '00'不合法
                // 若原始需求n=m=4, 内层循环n=2,m=4,'00';最外层循环，n=m=4时，'1001'
                res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }


    public static void main(String[] args) {
        StrobogrammaticNumberIi numberIi = new StrobogrammaticNumberIi();
        System.out.println(numberIi.findStrobogrammatic(1));
    }

}
