package leetcode;

/**
 * 208. 实现 Trie (前缀树)
 * <p>
 * num:208
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @author: TuGai
 * @createTime: 2020-06-08 23:22
 **/
public class ImplementTrie {


    static class Trie {

        Trie[] children = new Trie[26];
        boolean isEnd = false;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie[] children = this.children;
            for (int i1 = 0; i1 < chars.length; i1++) {
                char aChar = chars[i1];
                int i = aChar - 'a';
                if (children[i] == null) children[i] = new Trie();
                if (i1 == chars.length - 1) {
                    children[i].isEnd = true;
                }
                children = children[i].children;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Trie[] children = this.children;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                int j = aChar - 'a';
                if (children[j] == null) {
                    return false;
                }
                if (i == chars.length - 1 && children[j].isEnd) {
                    return true;
                }
                children = children[j].children;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Trie[] children = this.children;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                int j = aChar - 'a';
                if (children[j] == null) {
                    return false;
                }
                children = children[j].children;
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apps");
        trie.insert("apple");
        System.out.println(trie.search("apps"));
    }

}
