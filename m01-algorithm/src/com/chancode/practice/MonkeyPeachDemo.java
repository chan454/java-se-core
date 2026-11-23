package com.chancode.practice;

/**
 * 猴子吃桃：猴子摘了一堆桃，每天吃掉当天存量的一半再多一个，
 * 到第 10 天早上只剩 1 个。问第 1 天摘了多少个。
 *
 * <p>正向关系：后一天存量 = 前一天存量 ÷ 2 - 1；本题从结果倒推，反解得
 * 前一天存量 = (后一天存量 + 1) × 2。
 * 设 f(day) 为第 day 天早上的存量：f(10) = 1，f(day) = (f(day+1) + 1) × 2（day &lt; 10）。
 *
 * <p>与 Fibonacci 递归不同，这里每层只发起一次递归调用（线性链而非二叉树），
 * 时间 O(总天数)、空间 O(总天数)（栈深），不存在重复子问题。
 *
 * <p>溢出边界：存量每天约翻倍，int 撑到约 30 天就会溢出，天数更多时改用 long。
 */
public class MonkeyPeachDemo {

    /**
     * 最后一天编号：当天早上剩 LAST_DAY_PEACHES 个
     */
    private static final int LAST_DAY = 10;

    /**
     * 第 LAST_DAY 天早上的存量
     */
    private static final int LAST_DAY_PEACHES = 1;

    public static void main(String[] args) {
        // f(1) 是第 1 天早上（刚摘完）的存量，即摘的总数；
        // 第 1 天「吃掉」的数量应为 f(1) - f(2) = 1534 - 766 = 768
        System.out.println("第 1 天共摘了 " + getPeaches(1) + " 个桃");
    }

    /**
     * 递归求第 day 天早上的桃子存量。
     * 1、找规律：f(day) = (f(day+1) + 1) × 2，从第 10 天往第 1 天递推
     * 2、定出口：day == LAST_DAY 时返回存量 1
     *
     * @param day 天数，取值范围 1 ~ LAST_DAY
     * @return 第 day 天早上的桃子存量
     * @throws IllegalArgumentException day 超出 1 ~ LAST_DAY 时抛出
     */
    public static int getPeaches(int day) {
        // 非法值防线：day > LAST_DAY 时 day + 1 永远碰不到出口，会无限递归直至 StackOverflowError；
        // day < 1 则是无意义的负向调用，同样拦截
        if (day < 1 || day > LAST_DAY) {
            throw new IllegalArgumentException(
                    "day 必须在 1~" + LAST_DAY + " 之间，当前 day = " + day);
        }

        if (day == LAST_DAY) {
            return LAST_DAY_PEACHES;
        }
        return (getPeaches(day + 1) + 1) * 2;
    }
}
