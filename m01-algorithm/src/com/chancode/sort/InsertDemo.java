package com.chancode.sort;

/**
 * 插入排序（Insertion Sort）演示。
 *
 * <p>把数组看作「有序前缀 + 待插入后缀」两部分，每轮从后缀取第一个元素，
 * 插入到前缀中的正确位置，使有序前缀向右扩展一位。
 *
 * <p>实现要点：先取出待插入值 key，比较过程中只做「元素右移」而不做交换，
 * 最后把 key 落进腾出的空穴，写次数比交换式实现更少。
 *
 * <p>循环不变量：外层每轮开始时，arr[0..i-1] 非递减。
 *
 * <p>复杂度：时间最优 O(n)、最坏与平均 O(n²)；空间 O(1)；稳定排序。
 */
public class InsertDemo {
    public static void main(String[] args) {

        int[] arr = {3, 44, 38, 5, 47, 15};

        // 外层：arr[0..i-1] 已有序，取出 arr[i] 作为待插入值
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            // 内层：空穴下标 j 从 i 出发，只要左邻大于 key 就把它右移填进空穴，
            // 空穴随之左移；遇到不大于 key 的元素或到达队首（j == 0）时停止。
            // 条件用 > 而不是 >=：相等时不移动，这是本算法稳定性的来源
            int j = i;
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }

            // key 落入空穴，有序前缀扩展到 arr[0..i]
            arr[j] = key;
        }

        printArr(arr);
    }

    /**
     * 打印数组，元素间以空格分隔。
     *
     * @param arr 待打印的数组
     */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
