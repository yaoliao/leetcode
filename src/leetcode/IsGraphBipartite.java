package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 785. 判断二分图
 * <p>
 * num:785
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 *
 * @author: TuGai
 * @createTime: 2020-07-16 00:19
 **/
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] marks = new int[graph.length];
        int mark = 1;
        for (int k = 0; k < graph.length; k++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(k);
            Set<Integer> set = new HashSet<>();
            set.add(k);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer index = queue.poll();
                    if (marks[index] == 0) {
                        marks[index] = mark;
                    }
                    for (int j : graph[index]) {
                        if (marks[j] != 0 && marks[j] != -marks[index]) return false;
                        if (!set.contains(j)) {
                            queue.add(j);
                            set.add(j);
                        }
                    }
                }
                mark = -mark;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite bipartite = new IsGraphBipartite();
        /*int[][] ints = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };*/
        int[][] ints = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(bipartite.isBipartite(ints));
    }

}
