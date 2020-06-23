package leetcode;

/**
 * 547. 朋友圈
 * <p>
 * num:547
 * https://leetcode-cn.com/problems/friend-circles/
 *
 * @author: TuGai
 * @createTime: 2020-06-20 20:36
 **/
public class FriendCircles {

    // ====================== 使用并查集 =======================

    public int findCircleNum(int[][] M) {
        if (M == null) return 0;
        int m = M.length;
        int n = M[0].length;

        UnionFind unionFind = new UnionFind(M);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind {

        private int count;
        private int[] roots;

        public UnionFind(int[][] M) {

            int m = M.length;
            count = m;
            roots = new int[m];

            for (int i = 0; i < m; i++) {
                roots[i] = i;
            }
        }

        /**
         * 没有路径压缩的 find
         *
         * @param i
         * @return
         */
        public int find(int i) {
            while (roots[i] != i) {
                i = roots[i];
            }
            return roots[i];
        }

        public void union(int i, int j) {
            int ri = find(i);
            int rj = find(j);
            if (ri != rj) {
                roots[rj] = ri;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        FriendCircles circles = new FriendCircles();
        int[][] ints = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        /*int[][] ints = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};*/

        System.out.println(circles.findCircleNum(ints));
    }
}
