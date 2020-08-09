package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * <p>
 * num:217
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author: TuGai
 * @createTime: 2020-07-10 22:56
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int a : nums) {
            if (!set.add(a)) {
                return true;
            }
        }
        return false;
    }
}
