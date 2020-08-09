package leetcode;

import java.util.*;

/**
 * 1514. 概率最大的路径
 * <p>
 * num:1514
 * https://leetcode-cn.com/problems/path-with-maximum-probability/
 * <p>
 * 相当于求图的最短路径
 *
 * @author: TuGai
 * @createTime: 2020-07-13 21:20
 **/
public class PathWithMaximumProbability {

    /**
     * Bellman-Ford算法
     * <p>
     * https://juejin.im/post/5b77fec1e51d4538cf53be68
     *
     * <p>
     * https://leetcode-cn.com/problems/path-with-maximum-probability/solution/bellman-fordsuan-fa-by-zbw666/
     *
     * @param n
     * @param edges
     * @param succProb
     * @param start
     * @param end
     * @return
     */
    public double maxProbabilityBF(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dist = new double[n];
        dist[start] = 1;//起点
        while (true) {
            boolean k = false;
            for (int j = 0; j < edges.length; j++) {
                if (dist[edges[j][0]] * succProb[j] > dist[edges[j][1]]) {
                    dist[edges[j][1]] = dist[edges[j][0]] * succProb[j];
                    k = true;
                }//因为是无向图,所以再反向遍历
                if (dist[edges[j][1]] * succProb[j] > dist[edges[j][0]]) {
                    dist[edges[j][0]] = dist[edges[j][1]] * succProb[j];
                    k = true;
                }
            }
            if (!k) break;//一遍未修改则表示图已遍历完成
        }
        return dist[end];
    }


    /**
     * 狄克斯特拉算法(Dijkstra algorithm)
     * <p>
     * 相当于贪心算法，从 头节点开始以此遍历能访问到的节点，并选出最大的概率的节点作为头节点，然后继续访问
     * <p>
     * https://www.cnblogs.com/biyeymyhjob/archive/2012/07/31/2615833.html
     *
     * @param n
     * @param edges
     * @param succProb
     * @param start
     * @param end
     * @return
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            // 保存节点 edges[i][0] 能够到达的节点 和 到达该节点的概率
            graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(new Node(edges[i][1], succProb[i]));
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(new Node(edges[i][0], succProb[i]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((Node a, Node b) -> Double.compare(b.prob, a.prob));

        // 从 start 节点开始遍历, start 的初始概率为 1
        queue.offer(new Node(start, 1.0));

        // 保存访问过的节点，访问过就不需要访了
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.node == end) return cur.prob;
            else {
                if (!visited[cur.node]) {
                    visited[cur.node] = true;
                    // 找出 cur 节点可以访问到的所有的下一个节点，放入优先队列，由于队列是有序的，所以队列头部的是概率最大的值
                    List<Node> nodes = graph.get(cur.node);
                    if (nodes == null) continue;
                    for (Node nei : nodes) {
                        queue.offer(new Node(nei.node, nei.prob * cur.prob));
                    }
                }
            }
        }
        return 0;
    }

    class Node {
        int node;
        double prob;

        public Node(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        PathWithMaximumProbability probability = new PathWithMaximumProbability();
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        System.out.println(probability.maxProbability(3, edges, succProb, 0, 2));
    }
}
