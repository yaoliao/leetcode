package leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * num:20
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author: TuGai
 * @createTime: 2020-06-25 23:45
 **/
public class ValidParentheses {

    // '('，')'，'{'，'}'，'['，']'
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                Character popChar = stack.pop();
                if (c == ')' && !popChar.equals('(')) return false;
                if (c == '}' && !popChar.equals('{')) return false;
                if (c == ']' && !popChar.equals('[')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid("()"));
    }
}
