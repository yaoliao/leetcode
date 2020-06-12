package leetcode;

/**
 * 79. 单词搜索
 * <p>
 * num:79
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author: TuGai
 * @createTime: 2020-06-09 23:38
 **/
public class WordSearch {

    private static final int move[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m;
    private static int n;

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        boolean[][] exist = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(0, i, j, word, board, exist)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int deep, int i, int j, String word, char[][] board, boolean[][] exist) {
        if (word.length() - 1 == deep) {
            return board[i][j] == word.charAt(deep);
        }
        if (board[i][j] == word.charAt(deep)) {
            exist[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int i1 = move[k][0];
                int j1 = move[k][1];
                if (checkArea(i + i1, j + j1) && !exist[i + i1][j + j1]) {
                    if (dfs(deep + 1, i + i1, j + j1, word, board, exist)) {
                        return true;
                    }
                }
            }
            exist[i][j] = false;
        }
        return false;
    }

    private static boolean checkArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    /**
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {
                {
                        'A', 'B', 'C', 'E'
                },
                {
                        'S', 'F', 'C', 'S'
                },
                {
                        'A', 'D', 'E', 'E'
                }
        };

        System.out.println(board.length);
        System.out.println(board[0].length);

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

    }


}
