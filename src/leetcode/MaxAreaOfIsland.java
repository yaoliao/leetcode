package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 695. 岛屿的最大面积
 * <p>
 * num:695
 * https://leetcode-cn.com/problems/max-area-of-island/
 *
 * @author: TuGai
 * @createTime: 2020-07-15 23:22
 **/
public class MaxAreaOfIsland {

    public int maxAreaOfIslandV(int[][] grid) {
        helper(grid, 0, 0, 0);
        return max;
    }

    Set<Integer> exist = new HashSet<>();
    private int[][] ints = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int num = 0;
    int max = 0;

    private void helper(int[][] grid, int m, int n, int dep) {
        label:
        for (int i = m; i < grid.length; i++) {
            for (int j = n; j < grid[0].length; j++) {
                int k = grid[i][j];
                if (k == 1 && !exist.contains(i * grid[0].length + j)) {
                    exist.add(i * grid[0].length + j);
                    num++;

                    for (int[] anInt : ints) {
                        if (m + anInt[0] < 0 || m + anInt[0] >= grid.length || n + anInt[1] < 0 || n + anInt[1] >= grid[0].length)
                            continue;
                        helper(grid, i + anInt[0], j + anInt[1], dep + 1);
                    }
                } else {
                    exist.add(i * grid[0].length + j);
                }
                if (dep == 0) {
                    max = Math.max(max, num);
                    num = 0;
                } else {
                    break label;
                }
            }
        }
    }

    /**
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int num = dfs(grid, i, j);
                max = Math.max(max, num);
            }
        }
        return max;
    }


    private int dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        for (int[] anInt : ints) {
            count += dfs(grid, i + anInt[0], j + anInt[1]);
        }
        return count;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland area = new MaxAreaOfIsland();

        int[][] ints = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(area.maxAreaOfIsland(ints));
    }

}
