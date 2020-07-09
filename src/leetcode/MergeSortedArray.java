package leetcode;

/**
 * 88. 合并两个有序数组
 * <p>
 * num:88
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author: TuGai
 * @createTime: 2020-07-06 22:19
 **/
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point_1 = m - 1, point_2 = n - 1;
        int point = m + n - 1;
        while (point_1 >= 0 && point_2 >= 0) {
            nums1[point--] = nums1[point_1] > nums2[point_2] ? nums1[point_1--] : nums2[point_2--];
        }
        while (point_2 >= 0) {
            nums1[point--] = nums2[point_2--];
        }
    }
}
