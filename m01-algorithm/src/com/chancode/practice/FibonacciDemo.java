package com.chancode.practice;

/**
 * 斐波那契数列：F(1) = F(2) = 1，F(n) = F(n-1) + F(n-2)（n > 2），
 * 即 1, 1, 2, 3, 5, 8, 13, 21, ...
 *
 * <p>两种解法对比（以第 12 项 = 144 为例）：
 * <p>解法 1 数组迭代：自底向上逐格填值，每格只算一次，时间 O(n)、空间 O(n)。
 * <p>解法 2 朴素递归：自顶向下拆子问题，同一子问题被重复展开成二叉调用树，
 * 时间 O(2ⁿ)、空间 O(n)（递归栈深）；n 超过 40 左右会明显变慢，
 * 工程上要么用解法 1，要么加记忆化。
 *
 * <p>溢出边界：int 只能精确存到第 46 项（1836311903），第 47 项起溢出，
 * 求更大项需改用 long（到第 91 项）或 BigInteger。
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        int n = 12;

        System.out.println("第 " + n + " 项（迭代）= " + fibByLoop(n));
        System.out.println("第 " + n + " 项（递归）= " + fibByRecursion(n));
    }

    /**
     * 解法 1：数组迭代。
     * 循环不变量：每轮开始时 arr[0..i-1] 已填好，即 arr[j] = F(j+1)。
     *
     * @param n 待求项数（从 1 开始计数）
     * @return 第 n 项的值
     * @throws IllegalArgumentException n 不是正整数时抛出
     */
    public static int fibByLoop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("项数 n 必须 >= 1，当前 n = " + n);
        }

        int[] arr = new int[n];
        arr[0] = 1;
        // n == 1 时数组长度为 1，给 arr[1] 赋值会越界，故单独守卫
        if (n >= 2) {
            arr[1] = 1;
        }

        // 从第 3 项（下标 2）起填表：当前格 = 前两格之和
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        // 第 n 项落在下标 n - 1，避免写死 arr[11] 这类魔法下标
        return arr[n - 1];
    }

    /**
     * 解法 2：递归。
     * 1、看规律：F(n) = F(n-1) + F(n-2)
     * 2、找出口：F(1) = F(2) = 1
     *
     * @param n 待求项数（从 1 开始计数）
     * @return 第 n 项的值
     * @throws IllegalArgumentException n 不是正整数时抛出
     */
    public static int fibByRecursion(int n) {
        // 出口前置校验：n <= 0 若不拦，会沿负方向无限递归直至 StackOverflowError
        if (n < 1) {
            throw new IllegalArgumentException("项数 n 必须 >= 1，当前 n = " + n);
        }
        if (n <= 2) {
            return 1;
        }
        return fibByRecursion(n - 1) + fibByRecursion(n - 2);
    }
}
