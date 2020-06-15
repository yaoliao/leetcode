package leetcode;

/**
 * 14. 最长公共前缀
 * <p>
 * num:14
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author: TuGai
 * @createTime: 2020-06-15 00:10
 **/
public class LongestCommonPrefix {

    // =========================  冗余的代码  ===================
    public String longestCommonPrefixV1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean end = false;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    end = true;
                    break;
                }
            }
            if (end) break;
            sb.append(c);
        }
        return sb.toString();
    }

    // ========================  精简的代码  ===================
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // ================  冗余的代码  ===================


    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
//        String[] strings = {"flower", "flow", "flight"};
        String[] strings = {"dog", "racecar", "car"};
        System.out.println(prefix.longestCommonPrefix(strings));

    }

}
