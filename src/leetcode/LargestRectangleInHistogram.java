package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * num:84
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author: TuGai
 * @createTime: 2020-07-19 23:45
 **/
public class LargestRectangleInHistogram {

    public int largestRectangleAreaV(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积 ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return area;
    }

    // ======================
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] ints = new int[len + 2];

        for (int i = 0; i < len; i++) {
            ints[i + 1] = heights[i];
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ints.length; i++) {
            while (!stack.isEmpty() && ints[stack.peek()] > ints[i]) {
                int high = ints[stack.pop()];
                max = Math.max(max, high * (i - stack.peek() - 1));
            }
            stack.add(i);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
