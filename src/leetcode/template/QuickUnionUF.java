package leetcode.template;

/**
 * ###########################    快速合并的并查集（在进行 find 的时候会进行路径压缩，使得所有的子节点都指向最上层的父节点）   ##########################
 * <p>
 * 可以用来解决 200. 岛屿数量 等问题
 *
 * @author: TuGai
 * @createTime: 2020-06-18 23:28
 **/
public class QuickUnionUF {

    private int[] roots;

    public QuickUnionUF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    /**
     * 查找某个节点的最上面的父节点
     *
     * @param i
     * @return
     */
    public int findRoot(int i) {
        int root = i;

        // 找到最上面的父节点
        while (root != roots[root]) {
            root = roots[root];
        }

        // 将所有的子节点都指向最上面的父节点
        while (i != roots[i]) {
            int tmp = roots[root];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    /**
     * 判读两个数是有拥有共同的父节点
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connection(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    /**
     * 合并两个节点
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        roots[pRoot] = qRoot;
    }

}
