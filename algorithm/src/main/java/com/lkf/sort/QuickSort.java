package com.lkf.sort;

import java.util.Arrays;

/**
 * 快速排序，使用递归实现
 *
 * @author kaifeng
 */
public class QuickSort {
    public static void main( String[] args ) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param first 指向数组第一个元素的下标
     * @param end   指向数组最后一个元素的下标
     */
    public static void quickSort( int[] arr, int first, int end ) {
        int i = first;
        int j = end;

        //中间数值
        int pivot = arr[(first + end) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比中间数值大的数
            while (pivot > arr[i]) {
                i++;
            }

            //寻找直到比中间数值小的数
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
        //上面while保证了第一趟排序中间数的左边比中间数小，中间数的右边比中间数大


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (first < j) {
            quickSort(arr, first, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < end) {
            quickSort(arr, i, end);
        }
    }


    private static void quickSort2( int[] arr, int low, int high ) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort2(arr, 0, index - 1);
            quickSort2(arr, index + 1, high);
        }

    }

    private static int getIndex( int[] arr, int low, int high ) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

}
