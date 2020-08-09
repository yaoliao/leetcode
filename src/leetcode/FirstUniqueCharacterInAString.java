package leetcode;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * num:387
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author: TuGai
 * @createTime: 2020-07-14 23:54
 **/
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
