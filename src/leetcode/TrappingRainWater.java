package leetcode;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 * num:42
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author: TuGai
 * @createTime: 2020-07-04 21:54
 **/
public class TrappingRainWater {

    /**
     * 单调栈
     *
     * @param height
     * @return
     */
    public int trapStack(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int preIndex = stack.pop();

                while (!stack.isEmpty() && height[stack.peek()] == height[preIndex]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    sum += (Math.min(height[peek], height[i]) - height[preIndex]) * (i - peek - 1);
                }
            }
            stack.add(i);
        }
        return sum;
    }


    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;

        int maxLeft = 0, maxRight = 0;
        int l = 1, r = len - 2, sum = 0;
        while (l <= r) {
            if (height[l - 1] < height[r + 1]) {
                maxLeft = Math.max(maxLeft, height[l - 1]);
                if (maxLeft > height[l]) {
                    sum += (maxLeft - height[l]);
                }
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r + 1]);
                if (maxRight > height[r]) {
                    sum += (maxRight - height[r]);
                }
                r--;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
//        System.out.println(water.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(water.trap(new int[]{2, 0, 2}));
    }

}
