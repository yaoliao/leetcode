package leetcode;

/**
 * 67. 二进制求和
 * <p>
 * num:67
 * https://leetcode-cn.com/problems/add-binary/
 *
 * @author: TuGai
 * @createTime: 2020-06-23 00:08
 **/
public class AddBinary {

    // ===================  太复杂了 =====================
    public String addBinaryV1(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        StringBuilder sb = new StringBuilder();
        int max = Math.max(len_a, len_b);
        int pre = 0;
        for (int i = 0; i < max; i++) {
            int int_a = i < len_a ? a.charAt(len_a - i - 1) - '0' : 0;
            int int_b = i < len_b ? b.charAt(len_b - i - 1) - '0' : 0;
            int sum = int_a + int_b + pre;
            if (sum == 0) {
                sb.append(0);
                pre = 0;
            } else if (sum == 1) {
                sb.append(1);
                pre = 0;
            } else if (sum == 2) {
                sb.append(0);
                pre = 1;
            } else {
                sb.append(1);
                pre = 1;
            }
        }
        if (pre == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    // =================== 直接用 carry 来记录就可以了  =====================
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
