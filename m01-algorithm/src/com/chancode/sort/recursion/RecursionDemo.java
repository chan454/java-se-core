package com.chancode.sort.recursion;

/**
 * 递归入门：用递归求 1 + 2 + ... + n。
 *
 * <p>写递归只有两件事——先定「递归出口」（最小规模下能直接给出答案的情形），
 * 再定「递推关系」（当前规模如何化简为一个更小的同形子问题）。
 *
 * <p>代价：Java 虚拟机不做尾调用优化，递归深度与 n 成正比，n 过大（约数万级）
 * 会抛 StackOverflowError。真正的求和场景应改用公式 n * (n + 1) / 2 或循环。
 */
public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(getSum(100));
    }

    /**
     * 递归求 1 到 number 的累加和。
     *
     * <p>出口条件写成 {@code number <= 0} 而非 {@code number == 1}：
     * 后者在传入 0 或负数时永远不成立，递归会一路朝负方向深入直至栈溢出。
     *
     * @param number 求和上界；小于等于 0 时视为空区间，返回 0
     * @return 1 + 2 + ... + number
     */
    public static int getSum(int number) {
        // 递归出口：规模为 0 时和为 0，不再继续展开
        if (number <= 0) {
            return 0;
        }

        // 递推关系：sum(1..n) = n + sum(1..n-1)，每轮把问题规模减 1
        return number + getSum(number - 1);
    }
}
