package com.lkf.sort;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author kaifeng
 */
public class SelectSort {
    public static void main(String[] args) {
        //待排序数组
        int[] arrays = {1, 8, 9, 3, 5, 6};
        int pos = 0;
        //外层循环控制需要排序的趟数
        for (int i = 0; i < arrays.length - 1; i++) {

            int temp = 0;
            //新的趟数重新赋值为0
            pos = 0;

            //内层循环控制遍历数组的个数并得到最大数的下标
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[pos]) {
                    pos = j;
                }
            }
            //交换
            temp = arrays[pos];
            arrays[pos] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;

        }

        System.out.println("选择排序结果：" + Arrays.toString(arrays));
    }
}
