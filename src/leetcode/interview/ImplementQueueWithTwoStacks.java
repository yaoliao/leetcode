package leetcode.interview;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author: TuGai
 * @createTime: 2020-06-30 00:03
 **/
public class ImplementQueueWithTwoStacks {

    Stack<Integer> stack_1 = new Stack<>();
    Stack<Integer> stack_2 = new Stack<>();

    public void appendTail(int value) {
        stack_1.add(value);
    }

    public int deleteHead() {
        if (!stack_2.isEmpty()) return stack_2.pop();
        while (!stack_1.isEmpty()) stack_2.add(stack_1.pop());
        if (stack_2.isEmpty()) return -1;
        return stack_2.pop();
    }
}
