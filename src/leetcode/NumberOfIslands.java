package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * <p>
 * num:200
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author: TuGai
 * @createTime: 2020-06-17 22:58
 **/
public class NumberOfIslands {

    //=================  bfs ====================

    public int numIslandsV1(char[][] grid) {
        if (grid == null) return 0;

        int len1 = grid.length;
        if (len1 == 0) return 0;
        int len2 = grid[0].length;

        int[][] ints = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean[][] exit = new boolean[len1][len2];
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (!exit[i][j] && grid[i][j] == '1') {
                    // 小技巧：把坐标转换为一个数字
                    queue.add(i * len2 + j);
                    while (!queue.isEmpty()) {
                        Integer cur = queue.poll();
                        int curX = cur / len2;
                        int curY = cur % len2;

                        for (int k = 0; k < ints.length; k++) {
                            int x = curX + ints[k][0];
                            int y = curY + ints[k][1];
                            if (x >= 0 && x < len1 && y >= 0 && y < len2 && grid[x][y] == '1' && !exit[x][y]) {
                                exit[x][y] = true;
                                queue.add(x * len2 + y);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }


    // TODO
    // ====================  使用 dfs =======================================
    // ====================  使用 并查集 =======================================

    class UnionFind {
        int count; // 父节点个数
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        NumberOfIslands number = new NumberOfIslands();
        System.out.println(number.numIslands(grid));

    }

}
