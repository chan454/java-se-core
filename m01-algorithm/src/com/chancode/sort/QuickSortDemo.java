package com.chancode.sort;

/**
 * 快速排序（双指针分区版，基准取区间首元素）。
 *
 * <p>每轮以 pivot 把闭区间 arr[left..right] 重排成「左半边都 ≤ pivot | pivot | 右半边都 ≥ pivot」，
 * pivot 由此落到最终位置，再对左右两个子区间递归做同样的事。
 *
 * <p>时间复杂度：平均 O(n log n)；最坏 O(n²)，出现在每次分区都极不均衡时
 * （典型输入是已排序数组，此时每次只切掉一个元素）。空间复杂度 O(log n)（递归栈）。
 * 分区中的交换会跳过相等元素，因此是不稳定排序。
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

        quickSort(arr, 0, arr.length - 1);

        printArr(arr);
    }

    /**
     * 对闭区间 arr[left..right] 原地升序排序。
     *
     * @param arr   待排序数组
     * @param left  区间左边界（含）
     * @param right 区间右边界（含）；区间至多一个元素时直接返回，不做任何交换
     */
    public static void quickSort(int[] arr, int left, int right) {
        int start = left;
        int end = right;

        // 递归出口：区间长度 <= 1，天然有序
        if (start >= end) {
            return;
        }

        int pivot = arr[left];

        // 两端相向逼近，直到相遇于 pivot 的最终位置
        while (start != end) {
            // end 从右往左找第一个小于 pivot 的元素（相等时继续左移）
            while (start < end && arr[end] >= pivot) {
                end--;
            }
            // start 从左往右找第一个大于 pivot 的元素（相等时继续右移）
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            // 两个「站错队」的元素互换；若已相遇则是自交换，无副作用
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        // 相遇点的元素一定不大于 pivot（因为每轮先移动 end），所以把 pivot 换到此处后，
        // 左半区全部 <= pivot、右半区全部 >= pivot 同时成立；
        // 若把两个扫描循环的先后顺序调换，相遇点可能落在大值上，分区即被破坏
        int temp = arr[start];
        arr[start] = arr[left];
        arr[left] = temp;

        // pivot 已就位，递归排序它两侧不含自身的子区间
        quickSort(arr, left, start - 1);
        quickSort(arr, start + 1, right);
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
