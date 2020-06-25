package leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: TuGai
 * @createTime: 2020-06-25 22:17
 **/
public class InsertionSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 1, 6, 67, 34, 12, 765};
        InsertionSort sort = new InsertionSort();
        sort.sort(ints);

        System.out.println(Arrays.toString(ints));
    }
}
