package leetcode;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * <p>
 * num:378
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author: TuGai
 * @createTime: 2020-07-02 00:13
 **/
public class KthSmallestElementInASortedMatrix {

    public int kthSmallestV1(int[][] matrix, int k) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[] ints = new int[len1 * len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                ints[j * len1 + i] = matrix[i][j];
            }
        }

        quickSort(ints, 0, ints.length - 1);

        return ints[k - 1];
    }

    public void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int l = leftIndex, r = rightIndex;
        int mid = l + (r - l) / 2;
        int tmp = arr[mid];
        arr[mid] = arr[l];
        arr[l] = tmp;
        while (l < r) {
            while (l < r && arr[r] >= tmp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= tmp) l++;
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        quickSort(arr, leftIndex, l - 1);
        quickSort(arr, r + 1, rightIndex);
    }

    //
    public int kthSmallest(int[][] matrix, int k) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        PriorityQueue<Integer> MaxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (maxQueue.size() < k) {
                    maxQueue.add(matrix[i][j]);
                } else {
                    if (maxQueue.peek() > matrix[i][j]) {
                        maxQueue.poll();
                        maxQueue.add(matrix[i][j]);
                    }
                }
            }
        }
        return maxQueue.peek();
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }


}
