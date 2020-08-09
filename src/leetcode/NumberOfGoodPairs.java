package leetcode;

/**
 * 5460. 好数对的数目
 * <p>
 * num:5460
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 *
 * @author: TuGai
 * @createTime: 2020-07-12 22:16
 **/
public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) res += 1;
            }
        }
        return res;
    }

}
