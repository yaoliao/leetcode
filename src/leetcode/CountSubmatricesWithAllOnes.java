package leetcode;

/**
 * 1504. 统计全 1 子矩形
 * <p>
 * num:1504
 * https://leetcode-cn.com/problems/count-submatrices-with-all-ones/
 *
 * @author: TuGai
 * @createTime: 2020-07-06 21:13
 **/
public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                int max_j = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        if (l >= max_j) break;
                        if (mat[k][l] == 0) {
                            max_j = Math.min(max_j, l);
                            break;
                        }
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubmatricesWithAllOnes ones = new CountSubmatricesWithAllOnes();
        System.out.println(ones.numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }


}
