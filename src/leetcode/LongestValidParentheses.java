package leetcode;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * <p>
 * num:32
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author: TuGai
 * @createTime: 2020-07-01 22:48
 **/
public class LongestValidParentheses {

    /**
     * dp
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesDp(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] chars = s.toCharArray();

        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            char c = chars[i];
            if (c == '(') continue;
            if (chars[i - 1] == '(') {
                dp[i] = i - 2 < 0 ? 2 : dp[i - 2] + 2;
            } else {
                if (i - dp[i - 1] - 1 < 0) continue;
                char c1 = chars[i - dp[i - 1] - 1];
                if (c1 == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }

    /**
     * 这个方法牛皮啊，相当于在栈中一定保存一个最近未被匹配的括号的下标
     * <p>
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesV1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    /**
     * 更简单的方法。。。。
     * 双指针 l,r ，一个记录 '(' 的数量，一个记录 '）' 的数量
     * 从左往右遍历一边，当 l == r 记录括号数量
     * 然后再从右往左来一遍，记录数量，取两次遍历的最大值
     * <p>
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParenthesesNDp(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                char c = s.charAt(i - 1);
                if (c == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (c == ')' && (i - dp[i - 1] - 1) >= 0) {
                    char c1 = s.charAt(i - dp[i - 1] - 1);
                    if (c1 == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestValidParentheses parentheses = new LongestValidParentheses();
//        System.out.println(parentheses.longestValidParentheses("(()"));
//        System.out.println(parentheses.longestValidParentheses(")()())"));
//        System.out.println(parentheses.longestValidParentheses("())"));
//        System.out.println(parentheses.longestValidParentheses("(()())"));
        System.out.println(parentheses.longestValidParentheses("))(())(((()"));
        System.out.println(parentheses.longestValidParenthesesNDp("))(())(((()"));
    }

}
