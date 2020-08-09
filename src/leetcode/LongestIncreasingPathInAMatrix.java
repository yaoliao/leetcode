package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 329. 矩阵中的最长递增路径
 * <p>
 * num:329
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 *
 * @author: TuGai
 * @createTime: 2020-07-26 21:44
 **/
public class LongestIncreasingPathInAMatrix {

    private final int[][] ints = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private final Map<Integer, Integer> map = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        Integer res = map.get(i * matrix[0].length + j);
        int now = matrix[i][j];
        if (res != null) return res;
        int max = 0;
        for (int[] anInt : ints) {
            int m = anInt[0] + i;
            int n = anInt[1] + j;
            if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length) continue;
            int next = matrix[m][n];
            if (next > now) {
                max = Math.max(max, dfs(matrix, m, n));
            }
        }
        map.put(i * matrix[0].length + j, max + 1);
        return max + 1;
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix path = new LongestIncreasingPathInAMatrix();
        int[][] ints = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        System.out.println(path.longestIncreasingPath(ints));
    }

}
