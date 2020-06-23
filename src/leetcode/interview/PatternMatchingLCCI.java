package leetcode.interview;

/**
 * 面试题 16.18. 模式匹配
 * <p>
 * num:16.18
 * https://leetcode-cn.com/problems/pattern-matching-lcci/
 *
 * @author: TuGai
 * @createTime: 2020-06-22 10:06
 **/
public class PatternMatchingLCCI {

    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;
        if (pattern.equals("a") || pattern.equals("b")) return true;

        // 求 a b 各自的数量
        char[] pChars = pattern.toCharArray();
        int aCount = 0, bCount = 0;
        for (char c : pChars) {
            if (c == 'a') aCount++;
            else bCount++;
        }

        if (aCount < bCount) {
            int tmp = aCount;
            aCount = bCount;
            bCount = tmp;
            char[] chars = new char[pChars.length];
            for (int i = 0; i < pChars.length; i++) {
                chars[i] = pChars[i] == 'a' ? 'b' : 'a';
            }
            pChars = chars;
        }

        int vLen = value.length();
        for (int aLen = 0; aLen * aCount <= vLen; aLen++) {
            int otherLen = vLen - aLen * aCount;
            if (bCount != 0 && otherLen % bCount != 0) continue;
            int bLen = bCount != 0 ? otherLen / bCount : 0;
            int point = 0;
            String value_a = "", value_b = "";
            boolean res = true;
            for (char pChar : pChars) {
                if (pChar == 'a') {
                    String sub = value.substring(point, point + aLen);
                    if (value_a.equals("")) value_a = sub;
                    if (!value_a.equals(sub)) {
                        res = false;
                        break;
                    }
                    point += aLen;
                } else {
                    String sub = value.substring(point, point + bLen);
                    if (value_b.equals("")) value_b = sub;
                    if (!value_b.equals(sub)) {
                        res = false;
                        break;
                    }
                    point += bLen;
                }
            }
            if (res && !value_a.equals(value_b)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        PatternMatchingLCCI lcci = new PatternMatchingLCCI();
        /*System.out.println(lcci.patternMatching("abba", "dogcatcatdog"));
        System.out.println(lcci.patternMatching("abba", "dogcatcatfish"));
        System.out.println(lcci.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(lcci.patternMatching("abba", "dogdogdogdog"));
        System.out.println(lcci.patternMatching("bbbaa", "xxxxxxy"));*/
        System.out.println(lcci.patternMatching("aaaaab", "xahnxdxyaahnxdxyaahnxdxyaahnxdxyaauxuhuo"));
    }
}
