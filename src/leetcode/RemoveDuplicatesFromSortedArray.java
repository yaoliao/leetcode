package leetcode;

/**
 * 26. 删除排序数组中的重复项
 * <p>
 * num:26
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author: TuGai
 * @createTime: 2020-06-26 00:01
 **/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
