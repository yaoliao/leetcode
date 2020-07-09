package leetcode;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * num:33
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author: TuGai
 * @createTime: 2020-07-05 20:57
 **/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int l = 0, r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            // mid 在左半段，则 0-mid 是有序的
            if (nums[mid] >= nums[0]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 在右半段，怎 mid - len 是有序的
                if (target > nums[mid] && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sortedArray = new SearchInRotatedSortedArray();
        System.out.println(sortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

}
