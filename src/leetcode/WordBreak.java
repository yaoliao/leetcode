package leetcode;

import java.util.*;

/**
 * 139. 单词拆分
 * <p>
 * num:139
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author: TuGai
 * @createTime: 2020-06-25 00:00
 **/
public class WordBreak {

    // ===============  dfs =====================
    public boolean wordBreakWithDp(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // ===================  递归 ==================
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return recursive(s, wordDictSet, map);
    }

    private boolean recursive(String s, Set<String> wordDict, Map<String, Boolean> map) {
        if (s == null || s.length() == 0) return false;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            map.put(s, true);
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (wordDict.contains(left) && recursive(right, wordDict, map)) {
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcodeleet", Arrays.asList("leet", "code")));
    }

}
