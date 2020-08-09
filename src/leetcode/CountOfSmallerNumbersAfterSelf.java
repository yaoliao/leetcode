package leetcode;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 * <p>
 * num:315
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 *
 * @author: TuGai
 * @createTime: 2020-07-11 00:14
 **/
public class CountOfSmallerNumbersAfterSelf {

    /**
     * ====================================  TODO   大佬的五种解法 orz =====================================
     *
     *  https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/cong-you-wang-zuo-cha-ru-pai-xu-by-utopiahiker/
     *
     *
     */


    /**
     * =============== 超时 ===============
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmallerV(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        // key: 值  value：下标
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int count = 0;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getKey() >= num) break;
                int c = Collections.binarySearch(entry.getValue(), i, ((a, b) -> b - a));
                if (c <= 0) c = -c - 1;
                count += c;
            }
            list.add(count);
        }
        list.add(0);
        return list;
    }

    /**
     * 利用二叉树
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmallerTree(int[] nums) {
        //初始化
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        //反向构造二叉树，统计右边的较小数
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = addAndCount(root, new TreeNode(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }

    public TreeNode addAndCount(TreeNode root, TreeNode node, Integer[] res, int i) {
        if (root == null) {
            root = node;
            return root;
        }
        //根节点的左边保存不大于根节点的元素
        if (root.val >= node.val) {
            //统计左节点的元素个数
            root.count++;
            root.left = addAndCount(root.left, node, res, i);
        } else {
            //走到右边获取该元素左边的个数（根节点 1 + 左节点 root.count）
            res[i] += 1 + root.count;
            //统计右边是否还有更小的元素
            root.right = addAndCount(root.right, node, res, i);
        }
        return root;
    }

    class TreeNode {
        int val;
        int count;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.count = 0;
            left = null;
            right = null;
        }
    }


    /**
     * =================    线段数组
     * <p>
     * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/cong-you-wang-zuo-cha-ru-pai-xu-by-utopiahiker/
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return res;
        //将nums中的元素排序，记录每个元素对应的索引
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // key：具体的值  value：排序后的 index
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (Integer n : set) {
            map.put(n, index);
            index++;
        }
        //利用索引更新并统计
        FenwickTree fenwickTree = new FenwickTree(len + 1);
        for (int i = len - 1; i >= 0; i--) {
            index = map.get(nums[i]);
            //在索引位置添加计数1
            fenwickTree.update(index, 1);
            //统计比索引对应元素小的个数
            res.addFirst(fenwickTree.query(index - 1));
        }
        return res;
    }

    //树状数组，O(logn)实现单点更新和前缀和计算
    private static class FenwickTree {

        private final int[] tree;
        private final int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        //更新本节点和父节点
        public void update(int i, int delta) {
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        //求和，找到对应树的节点
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        //计算第一个非0的位置，2的幂
        // x 这个数的二进制表示下最低位 1 所对应的十进制数值。
        // 6 - 110 => 10 -> 2
        // 8 - 100 => 100 -> 8
        public int lowbit(int x) {
            return x & (-x);
        }
    }


    // =======================================

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf count = new CountOfSmallerNumbersAfterSelf();

        int x = 6;
        System.out.println(Integer.toBinaryString((x & (-x))));

        System.out.println(count.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(count.countSmaller(new int[]{-1, -1}));


        /*List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(7);
        list.add(4);
        list.add(2);
        list.add(1);

        System.out.println(Collections.binarySearch(list, 3, ((a, b) -> b - a)));
        System.out.println(Collections.binarySearch(list, 4, ((a, b) -> b - a)));
        System.out.println(Collections.binarySearch(list, 5, ((a, b) -> b - a)));

        System.out.println(Collections.binarySearch(list, 9, ((a, b) -> b - a)));
        System.out.println(Collections.binarySearch(list, 10, ((a, b) -> b - a)));*/
    }


}
