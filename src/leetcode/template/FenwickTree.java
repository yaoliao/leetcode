package leetcode.template;

/**
 * 树状数组
 * <p>
 * 求前缀和 和 修改 的时间复杂度都在 O(logN)
 * <p>
 * https://www.cnblogs.com/xenny/p/9739600.html
 *
 * @author: TuGai
 * @createTime: 2020-07-13 10:17
 **/
public class FenwickTree {

    private int[] tree;
    private int len;

    public FenwickTree(int n) {
        this.len = n;
        this.tree = new int[n + 1];
    }

    // 求和
    private int query(int i) {
        i = i + 1;
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowBit(i);
        }
        return res;
    }

    // 更新本节点和父节点
    private void update(int i, int x) {
        i = i + 1;
        while (i <= this.len) {
            tree[i] += x;
            i += lowBit(i);
        }
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {

        int[] source = new int[]{2, 4, 1, 5, 7, 3, 5};
        FenwickTree tree = new FenwickTree(source.length);
        for (int i = 0; i < source.length; i++) {
            tree.update(i, source[i]);
            System.out.println(tree.query(i));
        }

    }
}
