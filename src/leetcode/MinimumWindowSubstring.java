package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * <p>
 * num:76
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author: TuGai
 * @createTime: 2020-07-17 00:17
 **/
public class MinimumWindowSubstring {

    private Map<Character, Integer> map = new HashMap<>();
    private Map<Character, Integer> checkMap = new HashMap<>();

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        for (int i = 0; i < t.length(); i++) {
            checkMap.put(t.charAt(i), checkMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int prel = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            add(c);
            r++;
            while (check()) {
                char c1 = s.charAt(l);
                if (len > r - l) {
                    len = r - l;
                    prel = l;
                }
                l++;
                if (checkMap.containsKey(c1)) {
                    int i = map.get(c1) - 1;
                    if (i == 0) {
                        map.remove(c1);
                    } else {
                        map.put(c1, i);
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(prel, prel + len);
    }

    private void add(Character c) {
        if (checkMap.containsKey(c)) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }

    private boolean check() {
        if (map.isEmpty() || map.keySet().size() != checkMap.keySet().size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            Integer integer = checkMap.get(k);
            if (integer > v) return false;
        }
        return true;
    }

    // ==============

    public String minWindowV(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("") || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring substring = new MinimumWindowSubstring();
        System.out.println(substring.minWindow("ADOBECODEBANC", "ABC"));
    }

}
