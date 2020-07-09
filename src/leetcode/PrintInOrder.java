package leetcode;

/**
 * 1114. 按序打印
 * <p>
 * num:1114
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @author: TuGai
 * @createTime: 2020-07-07 22:25
 **/
public class PrintInOrder {

    private final Object lock = new Object();
    private int count = 1;

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (true) {
            Thread.yield();
            synchronized (lock) {
                if (count != 1) continue;
                count++;
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                break;
            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            Thread.yield();
            synchronized (lock) {
                if (count != 2) continue;
                count++;
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                break;
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            Thread.yield();
            synchronized (lock) {
                if (count != 3) continue;
                count++;
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                break;
            }
        }
    }

}
