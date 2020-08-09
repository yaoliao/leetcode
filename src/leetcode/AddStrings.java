package leetcode;

/**
 * 415. 字符串相加
 * <p>
 * num:415
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author: TuGai
 * @createTime: 2020-07-10 22:12
 **/
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (i >= 0 || j >= 0 || pre != 0) {
            int res = 0;
            if (i >= 0) {
                res += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                res += num2.charAt(j) - '0';
                j--;
            }
            res += pre;
            sb.append(res % 10);
            pre = res / 10;

        }
        return sb.reverse().toString();
    }

}
