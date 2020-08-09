package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * <p>
 * num:347
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author: TuGai
 * @createTime: 2020-07-14 23:32
 **/
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        int finalK = k;
        map.forEach((key, v) -> {
            if (queue.size() < finalK) {
                queue.add(key);
            } else {
                if (v > map.get(queue.peek())) {
                    queue.poll();
                    queue.add(key);
                }
            }
        });
        int[] res = new int[k];
        while (!queue.isEmpty()) {
            res[k - 1] = queue.poll();
            k--;
        }
        return res;
    }
}
