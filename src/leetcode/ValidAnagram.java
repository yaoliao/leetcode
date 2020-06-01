package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * num:242
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author: TuGai
 * @createTime: 2020-06-01 21:32
 **/
public class ValidAnagram {


    /**
     * 利用 hash 的方法，时间复杂度 o(N)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer integer = count1.get(c);
            if (integer == null) {
                count1.put(c, 1);
            } else {
                count1.put(c, integer + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (count1.get(c) == null) return false;
            Integer integer = count2.get(c);
            if (integer == null) {
                count2.put(c, 1);
            } else {
                count2.put(c, integer + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (!v.equals(count2.get(k))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用 排序 的方法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramWithSort(String s, String t) {
        if (s == null || t == null) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        return Arrays.equals(schars, tchars);
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

}
