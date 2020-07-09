package leetcode;

import java.util.Arrays;

/**
 * 面试题 16.11. 跳水板
 * <p>
 * num:16.11
 * https://leetcode-cn.com/problems/diving-board-lcci/
 *
 * @author: TuGai
 * @createTime: 2020-07-08 00:30
 **/
public class DivingBoardLCCI {

    /**
     * 递归超时 ============  憨憨写法  =================
     *
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoardDfs(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{k * shorter};
        ints = new int[k + 1];
        dfs(shorter, longer, k, 0);
        return ints;
    }

    int i = 0;
    int[] ints = null;
    boolean needShort = true;

    private void dfs(int shorter, int longer, int k, int sum) {
        if (k == 0) {
            needShort = false;
            if (i != 0 && sum <= ints[i - 1]) return;
            ints[i] = sum;
            i++;
            return;
        }
        if (needShort) {
            dfs(shorter, longer, k - 1, sum + shorter);
        }
        dfs(shorter, longer, k - 1, sum + longer);
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{k * shorter};
        int[] res = new int[k + 1];
        res[0] = shorter * k;
        for (int j = 1; j < res.length; j++) {
            res[j] = res[j - 1] - shorter + longer;
        }
        return res;
    }

    public static void main(String[] args) {
        DivingBoardLCCI lcci = new DivingBoardLCCI();
        System.out.println(Arrays.toString(lcci.divingBoard(1, 2, 3)));
    }

}
