package leetcode;

/**
 * 287. 寻找重复数
 * <p>
 * num:287
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author: TuGai
 * @createTime: 2020-07-17 22:10
 **/
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int s = nums[0], f = nums[nums[0]];
        while (s != f) {
            s = nums[s];
            f = nums[nums[f]];
        }
        s = 0;
        while (s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber number = new FindTheDuplicateNumber();
        System.out.println(number.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

}
