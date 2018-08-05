package com.lkf.sort;

import java.util.Arrays;

/**
 * 快速排序，使用递归实现
 *
 * @author kaifeng
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrays = {1, 8, 9, 3, 5, 6};
        quickSort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }


    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param first 指向数组第一个元素
     * @param end   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int first, int end) {
        int i = first;
        int j = end;

        //中间点
        int pivot = arr[(first + end) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比中间点大的数
            while (pivot > arr[i]) {
                i++;
            }

            //寻找直到比中间点小的数
            while (pivot < arr[j]) {
                j--;
            }

            //此时已经分别找到了比中间点的数(右边)、比中间点的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序中间点的左边比中间点小，中间点的右边比中间点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (first < j) {
            quickSort(arr, first, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < end) {
            quickSort(arr, i, end);
        }
    }
}
