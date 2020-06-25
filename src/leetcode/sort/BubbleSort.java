package leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: TuGai
 * @createTime: 2020-06-25 21:34
 **/
public class BubbleSort {

    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 1, 6, 67, 34, 12, 765};
        BubbleSort sort = new BubbleSort();
        sort.sort(ints);

        System.out.println(Arrays.toString(ints));
    }

}
