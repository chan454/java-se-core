package com.chancode.sort;

/**
 * 选择排序（标准写法：轮内仅记录最小元素下标，轮末统一交换一次）。
 *
 * <p>不变量：第 i 轮结束后，arr[0..i] 恰为全局最小的 i+1 个元素且升序就位，
 * arr[i+1..n-1] 仍未排序。
 * <p>时间复杂度恒为 O(n²)：比较次数固定为 n(n-1)/2，与输入无关；交换次数至多 n-1。
 * 不稳定排序。
 */
public class SelectionDemo {
    static void main() {

        int[] arr = {2, 1, 5, 3, 4};
        // 外层控制轮数：只需为前 n-1 个位置各选出最小值，最后一个位置自然就位
        // （i < length - 1 是减少一轮无效遍历，并非防越界）
        for (int i = 0; i < arr.length - 1; i++) {
            // 先假设位置 i 即为最小元素；内层扫描全程只更新下标、不做交换
            int minIndex = i;
            // 未排序区为 [i+1, n)，j 直接访问 arr[j] 本身，故上界取 arr.length
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 轮末统一交换：最小元素归位到 i，每轮至多交换 1 次
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
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
