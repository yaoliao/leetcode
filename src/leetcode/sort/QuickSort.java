package leetcode.sort;

/**
 * @author: TuGai
 * @createTime: 2020-06-23 23:54
 **/
public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        int left = l;
        int right = r;
        int temp = 0;
        if (left <= right) {   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while (left != right) {   //从左右两边交替扫描，直到left = right

                while (right > left && arr[right] >= temp)
                    right--;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

                while (left < right && arr[left] <= temp)
                    left++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            arr[right] = temp;    //基准元素归位
            quickSort(arr, l, left - 1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, left + 1, r);  //对基准元素右边的进行递归排序
        }
    }

    // =============== 自己写一遍 ==================
    public static void quickSortTryAgain(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int l = leftIndex, r = rightIndex;
        int tmp = arr[l];
        while (l < r) {
            while (r > l && arr[r] >= tmp) r--;
            arr[l] = arr[r];

            while (l < r && arr[l] <= tmp) l++;
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        quickSortTryAgain(arr, leftIndex, l - 1);
        quickSortTryAgain(arr, r + 1, rightIndex);
    }

    public static void quickSortTryAgainTwice(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int l = leftIndex, r = rightIndex;
        int tmp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tmp) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= tmp) l++;
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        quickSortTryAgainTwice(arr, leftIndex, l - 1);
        quickSortTryAgainTwice(arr, r + 1, rightIndex);
    }


    public static void main(String[] args) {
        int[] array = {10, 5, 3, 1, 7, 2, 8};
        System.out.println("排序之前：");
        for (int element : array) {
            System.out.print(element + " ");
        }

        quickSortTryAgainTwice(array, 0, array.length - 1);

        System.out.println("\n排序之后：");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
