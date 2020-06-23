package leetcode;

/**
 * 11. 盛最多水的容器
 * <p>
 * num:11
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 20:29
 **/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, min);
            // 每次移动较小的一边
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(water.maxArea(ints));
    }
}
