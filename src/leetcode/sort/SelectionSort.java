package leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author: TuGai
 * @createTime: 2020-06-25 22:03
 **/
public class SelectionSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 1, 6, 67, 34, 12, 765};
        SelectionSort sort = new SelectionSort();
        sort.sort(ints);

        System.out.println(Arrays.toString(ints));
    }
}
