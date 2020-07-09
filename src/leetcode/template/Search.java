package leetcode.template;

/**
 * 二分查找
 *
 * @author: TuGai
 * @createTime: 2020-06-18 20:08
 **/
public class Search {

    /**
     * 二分查找 时间复杂度 O(logN)
     * <p>
     * 注意：数组 array 需要已经排好序
     * <p>
     * copyfrom: Arrays.binarySearch()
     *
     * @param array     已经排序好的数据，注意这里是要 ### 排序好的 ###
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int fromIndex, int toIndex, int key) {
        int l = fromIndex;
        int r = toIndex - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midVal = array[mid];

            if (key > midVal) {
                l = mid + 1;
            } else if (key < midVal) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -(l + 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 6, 8, 23, 45, 134};
        System.out.println(Search.binarySearch(array, 0, array.length, 4)); // 2
        System.out.println(Search.binarySearch(array, 0, array.length, 3)); // -3
    }

}
