package com.chancode.practice;

/**
 * 爬楼梯：共 n 阶，每次只能跨 1 阶或 2 阶，问登顶共有多少种不同走法。
 *
 * <p>考虑登顶前的最后一步，只有两种互斥来源：
 * 从第 n-1 阶跨 1 步上来，或从第 n-2 阶跨 2 步上来，故 f(n) = f(n-1) + f(n-2)。
 * 出口：f(1) = 1（{1}），f(2) = 2（{1+1, 2+0}）。
 *
 * <p>规律与 Fibonacci 同构、只是初值不同：f(n) = Fib(n+1)，
 * 所以 f(20) = Fib(21) = 10946，与 FibonacciDemo 的第 12 项 = Fib(12) 属同一数列。
 *
 * <p>两种解法对比：
 * <p>解法 1 递归：二叉调用树，同一子问题的整棵子树被反复展开，时间 O(φⁿ)≈O(2ⁿ)。
 * n = 20 约 2 万次调用尚可瞬间完成，n 到 45 就要秒级起步，不宜工程使用。
 * <p>解法 2 迭代滚动变量：f(n) 只依赖前两项，连 Fibonacci 题里的整数组都不必存，
 * 两个变量滚动推进，时间 O(n)、空间 O(1)。
 *
 * <p>溢出边界：与 Fibonacci 同步，int 最多撑到 n = 45（f(46) 起溢出），更大改用 long。
 */
public class ClimbStairsDemo {

    public static void main(String[] args) {
        int n = 20;

        System.out.println("第 " + n + " 阶共 " + countByLoop(n) + " 种走法（迭代）");
        System.out.println("第 " + n + " 阶共 " + countByRecursion(n) + " 种走法（递归校验）");
    }

    /**
     * 解法 1：滚动变量迭代（自底向上填表）。
     * 循环不变量：每轮结束时 prev = f(i-1)，curr = f(i)。
     *
     * @param n 台阶数，必须 >= 1
     * @return 登顶的走法总数
     * @throws IllegalArgumentException n 不是正整数时抛出
     */
    public static int countByLoop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("台阶数 n 必须 >= 1，当前 n = " + n);
        }

        int prev = 1; // f(1)
        int curr = 2; // f(2)
        if (n == 1) {
            return prev;
        }

        // 从第 3 阶起滚动：新值 = 前两项之和，随后窗口整体右移一格
        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * 解法 2：递归（自顶向下拆子问题）。
     * 1、看规律：最后一步来自 n-1 或 n-2，f(n) = f(n-1) + f(n-2)
     * 2、找出口：f(1) = 1，f(2) = 2
     *
     * @param n 台阶数，必须 >= 1
     * @return 登顶的走法总数
     * @throws IllegalArgumentException n 不是正整数时抛出
     */
    public static int countByRecursion(int n) {
        // 防线同 Fibonacci：n <= 0 不拦截会沿负方向无限递归直至 StackOverflowError
        if (n < 1) {
            throw new IllegalArgumentException("台阶数 n 必须 >= 1，当前 n = " + n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return countByRecursion(n - 1) + countByRecursion(n - 2);
    }
}
