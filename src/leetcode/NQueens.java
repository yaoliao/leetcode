package leetcode;

import java.util.*;

/**
 * num:51
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author: TuGai
 * @createTime: 2020-06-07 22:16
 **/
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        if (n == 0) return Collections.emptyList();
        List<List<String>> list = new ArrayList<>();
        dfs(0, new String[n], new HashSet<>(), new HashSet<>(), new HashSet<>(), list, n);
        return list;
    }

    /**
     * 从上到下逐层判断
     * <p>
     * 因为 Q 的 横、竖、斜 都不能有棋子，所以这里用 vertical pie na 分别表示当落下一个 Q 后对应的 横、竖、斜（
     * 在同一条斜线上，x+y 或 x-y 都是相同的，所以可以用 set 来判断这个斜线是否被占用）
     *
     * @param dep      深度
     * @param res      当前行的结果
     * @param vertical 列
     * @param pie      撇
     * @param na       捺
     * @param list     结果
     * @param n        总的行数
     */
    public static void dfs(int dep, String[] res, Set<Integer> vertical, Set<Integer> pie, Set<Integer> na, List<List<String>> list, int n) {
        if (dep == n) {
            list.add(Arrays.asList(res.clone()));
            return;
        }
        // i 表示行数
        for (int i = 0; i < n; i++) {
            // 判断当前的 行和正反斜线是否被占用
            if (!vertical.contains(i) && !pie.contains(dep - i) && !na.contains(dep + i)) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                res[dep] = new String(chars);
                // 添加被当前这个棋子占用的 列，撇和捺
                vertical.add(i);
                pie.add(dep - i);
                na.add(dep + i);
                dfs(dep + 1, res, vertical, pie, na, list, n);
                // 跳出递归时，要清除本次记录
                vertical.remove(i);
                pie.remove(dep - i);
                na.remove(dep + i);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("=========");
        }
    }

}
