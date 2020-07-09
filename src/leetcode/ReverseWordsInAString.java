package leetcode;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * num:151
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author: TuGai
 * @createTime: 2020-07-08 22:20
 **/
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s.length() == 0 || s.trim().length() == 0) return "";
        s = s.trim();
        int len = s.length();
        int r = len - 1;
        int pre = len;
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        while (r >= 0) {
            char c = s.charAt(r);
            if (c != ' ' && !first) {
                pre = r + 1;
                first = true;
            } else if (first) {
                sb.append(s, r + 1, pre).append(" ");
                first = false;
            }
            r--;
        }
        sb.append(s, 0, pre);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString words = new ReverseWordsInAString();
        System.out.println(words.reverseWords("the    sky is blue"));
    }
}
