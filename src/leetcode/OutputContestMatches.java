package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 544. 输出比赛匹配对
 * <p>
 * num:544
 * https://leetcode-cn.com/problems/output-contest-matches/
 *
 * @author: TuGai
 * @createTime: 2020-07-10 10:57
 **/
public class OutputContestMatches {

    //输入: 8n
    //输出: (((1,8),(4,5)),((2,7),(3,6)))
    //解析:
    //第一轮: (1,8),(2,7),(3,6),(4,5)
    //第二轮: ((1,8),(4,5)),((2,7),(3,6))
    //第三轮 (((1,8),(4,5)),((2,7),(3,6)))
    //由于第三轮会决出最终胜者，故输出答案为(((1,8),(4,5)),((2,7),(3,6)))。

    /**
     * BFS
     *
     * @param n
     * @return
     */
    public String findContestMatchBfs(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        while (list.size() > 1) {
            int size = list.size();
            int i = 0, j = size - 1;
            while (i < j) {
                String l = list.remove(i);
                String r = list.remove(--j);
                list.add("(" + l + "," + r + ")");
                j--;
            }
        }
        return list.get(0);
    }


    // =============================  TODO 下面几种都看不懂。。。。。。。。。。。。。。

    /**
     * bfs
     *
     * @param n
     * @return
     */
    public String findContestMatchBfs1(int n) {
        String[] team = new String[n];
        for (int i = 1; i <= n; ++i)
            team[i - 1] = "" + i;

        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; ++i)
                team[i] = "(" + team[i] + "," + team[n - 1 - i] + ")";

        return team[0];
    }

    public String findContestMatchV1(int n) {
        return helper(n, 1, 1);
    }

    private String helper(int n, int i, int d) {
        if (Math.pow(2, d) == n) {
            return "(" + i + "," + (n + 1 - i) + ")";
        }
        return "(" + helper(n, i, d + 1) + ","
                + helper(n, (int) Math.pow(2, d) + 1 - i, d + 1) + ")";
    }

    /**
     * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
     */

    int[] team;
    int t;
    StringBuilder ans;

    public String findContestMatch(int n) {
        team = new int[n];
        t = 0;
        ans = new StringBuilder();
        write(n, Integer.numberOfTrailingZeros(n));
        return ans.toString();
    }

    public void write(int n, int round) {
        if (round == 0) {
            int w = Integer.lowestOneBit(t);
            team[t] = w > 0 ? n / w + 1 - team[t - w] : 1;
            ans.append("" + team[t++]);
        } else {
            ans.append("(");
            write(n, round - 1);
            ans.append(",");
            write(n, round - 1);
            ans.append(")");
        }
    }


    public static void main(String[] args) {
        OutputContestMatches matches = new OutputContestMatches();
        System.out.println(matches.findContestMatch(16));
    }
}
