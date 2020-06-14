package leetcode;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * <p>
 * num:1300
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 *
 * @author: TuGai
 * @createTime: 2020-06-14 00:47
 **/
public class SumOfMutatedArrayClosestToTarget {

    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);
        int len = arr.length;

        int[] sum = new int[len + 1];
        for (int i = 1; i <= arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        if (sum[len] <= target) return arr[len - 1];

        int l = 0, r = arr[len - 1], res = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int i = Arrays.binarySearch(arr, mid);
            if (i < 0) i = -i - 1;
            int num = sum[i] + (len - i) * mid;
            if (num < target) {
                l = mid + 1;
                res = mid;
            } else if (num > target) {
                r = mid;
            } else {
                return mid;
            }
        }
        int small = check(arr, sum, res);
        int big = check(arr, sum, res + 1);
        return Math.abs(small - target) <= Math.abs(big - target) ? res : res + 1;
    }

    private int check(int[] arr, int[] sum, int mid) {
        int i = Arrays.binarySearch(arr, mid);
        if (i < 0) i = -i - 1;
        return sum[i] + (arr.length - i) * mid;
    }

    public static void main(String[] args) {
        /*SumOfMutatedArrayClosestToTarget sum = new SumOfMutatedArrayClosestToTarget();
        int[] ints = new int[]{60864, 25176, 27249, 21296, 20204};
        System.out.println(sum.findBestValue(ints, 56803));*/

        SumOfMutatedArrayClosestToTarget sum = new SumOfMutatedArrayClosestToTarget();
        int[] ints = new int[]{1,2,3};
        System.out.println(sum.findBestValue(ints, 5));

    }

}
