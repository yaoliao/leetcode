package leetcode;

/**
 * 28. 实现 strStr()
 * <p>
 * num:28
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author: TuGai
 * @createTime: 2020-06-27 23:17
 **/
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (haystack.length() == 0 && needle.length() != 0) return -1;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int pointer1 = i, pointer2 = 0;
            boolean res = true;
            while (pointer1 < haystack.length() && pointer2 < needle.length()) {
                if (haystack.charAt(pointer1) != needle.charAt(pointer2)) {
                    res = false;
                    break;
                }
                pointer1++;
                pointer2++;
            }
            if (res) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr str = new ImplementStrStr();
//        System.out.println(str.strStr("mississippi", "issipi"));
        System.out.println(str.strStr("abdc", "cd"));
    }

}
