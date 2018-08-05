package com.lkf.sort;

import java.util.Arrays;

/**
 * @author kaifeng
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arrays = {1, 8, 9, 3, 5, 6};
        sort(arrays, 0, arrays.length - 1);

        System.out.println("归并排序结果" + Arrays.toString(arrays));
    }

    /**
     * 归并排序
     *
     * @param arrays 待排序数组
     * @param first  指向数组第一个元素
     * @param end    指向数组最后一个元素
     */
    public static void sort(int[] arrays, int first, int end) {

        //如果只有一个元素，那就不用排序了
        if (first == end) {
            return;
        } else {

            //取中间的数，进行拆分
            int middle = (first + end) / 2;

            //左边的数不断进行拆分
            sort(arrays, first, middle);

            //右边的数不断进行拆分
            sort(arrays, middle + 1, end);

            //合并
            merge(arrays, first, middle + 1, end);

        }
    }


    /**
     * 合并数组
     *
     * @param arrays
     * @param first  指向数组第一个元素
     * @param middle 指向数组分隔的元素
     * @param end    指向数组最后的元素
     */
    public static void merge(int[] arrays, int first, int middle, int end) {

        //左边的数组的大小
        int[] leftArray = new int[middle - first];

        //右边的数组大小
        int[] rightArray = new int[end - middle + 1];

        //两个数组填充数据
        for (int i = first; i < middle; i++) {
            leftArray[i - first] = arrays[i];
        }
        for (int i = middle; i <= end; i++) {
            rightArray[i - middle] = arrays[i];
        }


        int i = 0, j = 0;
        // arrays数组的第一个元素
        int k = first;


        //比较这两个数组的值
        while (i < leftArray.length && j < rightArray.length) {

            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];

                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数放到大数组中
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];

            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数放到大数组中
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];

            k++;
            j++;
        }
    }
}
