package leetcode;

/**
 * 1518. 换酒问题
 * <p>
 * num:1518
 * https://leetcode-cn.com/problems/water-bottles/
 *
 * @author: TuGai
 * @createTime: 2020-07-20 22:11
 **/
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int pre = 0;
        while (numBottles > 0) {
            count += numBottles;
            numBottles = (numBottles + pre) / numExchange;
            pre = numBottles % numExchange;
        }
        return count;
    }

}
