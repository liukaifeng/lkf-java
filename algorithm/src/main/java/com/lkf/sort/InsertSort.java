package com.lkf.sort;

import java.util.Arrays;

/**
 * @author kaifeng
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] arrays = {1, 8, 9, 3, 5, 6};

        System.out.println("选择排序结果：" + Arrays.toString(sort(arrays)));
    }

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                //将把 arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
        return arr;
    }

    public int[] sort2(int[] arrays) {
        //临时变量
        int temp;

        //外层循环控制需要排序的趟数,下标从1开始
        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];

            //如果前一位数比当前大，则进入循环比较
            int j = i - 1;

            while (j >= 0 && arrays[j] > temp) {

                //往后退一个位置，让当前数据与之前前位进行比较
                arrays[j + 1] = arrays[j];

                //不断往前，直到退出循环
                j--;

            }
            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[j + 1] = temp;

        }
        return arrays;
    }
}
