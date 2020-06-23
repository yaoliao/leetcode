package leetcode;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * <p>
 * num:17
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 21:15
 **/
public class LetterCombinationsOfAPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        dfs(digits, 0, list, new StringBuilder());
        return list;
    }

    private void dfs(String digits, int dep, List<String> res, StringBuilder sb) {
        if (dep == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(dep);
        String s = phone.get(String.valueOf(c));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, dep + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber number = new LetterCombinationsOfAPhoneNumber();
//        System.out.println(number.letterCombinations("23"));
        System.out.println(number.letterCombinations("7"));
    }
}
