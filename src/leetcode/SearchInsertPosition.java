package leetcode;

/**
 * 35. 搜索插入位置
 * <p>
 * num:35
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author: TuGai
 * @createTime: 2020-07-17 00:05
 **/
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int i = binarySearch(nums, 0, nums.length - 1, target);
        return i >= 0 ? i : -i - 1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int l = left, r = right;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (midVal == target) return mid;
            if (midVal > target) r = mid - 1;
            else l = mid + 1;
        }
        return -(l + 1);
    }

    public static void main(String[] args) {
        SearchInsertPosition position = new SearchInsertPosition();
        int[] ints = {1, 2, 4, 5};
        System.out.println(position.searchInsert(ints, 3));
        System.out.println(position.searchInsert(ints, 2));
    }

}
