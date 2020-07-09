package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * num:153
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author: TuGai
 * @createTime: 2020-07-06 22:47
 **/
public class FindMinimumInRotatedSortedArray {

    public int findMinV1(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midNum = nums[mid];
            if ((nums[0] > midNum && nums[mid - 1] > midNum)) return midNum;
            if (nums[0] <= midNum) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[0];
    }

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray minimum = new FindMinimumInRotatedSortedArray();
        System.out.println(minimum.findMin(new int[]{1, 2}));
    }

}
