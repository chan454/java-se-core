package com.chancode.sort;

/**
 * 冒泡排序：相邻元素两两比较，每轮把未排序区的最大值「冒泡」到其末尾。
 *
 * <p>空间复杂度 O(1)，稳定排序；时间复杂度平均/最坏 O(n²)，
 * 已加 swapped 提前退出——数组本来有序时一轮零交换即结束，最优 O(n)。
 */
public class BubbleDemo {

    static void main() {
        int[] arr = {2, 1, 5, 3, 4};

        // 外层控制轮数：n 个元素最多比较 n - 1 轮，第 i 轮结束后 arr[length - 1 - i] 就位
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            // 内层只在未就位区 [0, length - 1 - i) 内比较
            // -1：比较的是 arr[j] 与 arr[j + 1]，防止 j + 1 越界
            // -i：末尾 i 个元素已由前几轮冒泡就位，无需重复比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 必须在内层「完整跑完一轮」之后再判断：
            // 一轮零交换 = 整段已就位；放在循环体内会在首个不交换的比较处误 break
            if (!swapped) {
                break;
            }
        }

        printArr(arr);
    }

    /**
     * 打印数组，元素间以空格分隔。
     */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
