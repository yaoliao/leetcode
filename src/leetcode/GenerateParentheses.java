package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * num：22
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author: TuGai
 * @createTime: 2020-06-07 21:43
 **/
public class GenerateParentheses {

    /**
     * 将题目想成一个树的遍历。
     * 利用分叉来表示填左括号还是右括号
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 0) return Collections.emptyList();

        List<String> list = new ArrayList<>();
        generate("", n, n, list);
        return list;
    }

    public static void generate(String s, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > right) return;

        if (left > 0)
            generate(s + "(", left - 1, right, list);

        if (right > 0)
            generate(s + ")", left, right - 1, list);
    }


    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }
}
