package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * num:3
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author: TuGai
 * @createTime: 2020-06-11 20:05
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstringV(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int b = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                Integer a = map.get(c);
                if (a >= b)  // 注意这里的边界 是 >= 不是 >
                    b = a + 1;
            }
            map.put(c, i);
            if (max < (i - b + 1)) max = (i - b + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("pabwcdwkpe"));
        System.out.println(lengthOfLongestSubstring("0123456789"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring(" a"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));


    }

}
