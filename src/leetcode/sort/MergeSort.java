package leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: TuGai
 * @createTime: 2020-06-25 22:27
 **/
public class MergeSort {

    public void margeSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) >>> 1;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int r1 = mid + 1;
        int tIndex = 0;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        // 将左边剩余的归并
        while (left <= mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while (r1 <= right) {
            tmp[tIndex++] = a[r1++];
        }

        //从临时数组拷贝到原数组
        int tmpLeft = cIndex;
        while (cIndex <= right) {
            a[cIndex] = tmp[cIndex - tmpLeft];
            //输出中间归并排序结果
            cIndex++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 4, 1, 6, 67, 34, 12, 765};

        MergeSort mergeSort = new MergeSort();
        mergeSort.margeSort(ints);

        System.out.println(Arrays.toString(ints));
    }
}
