package com.lkf.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 实现思路：
 * 1、使用两层for循环完成数值比较
 * 2、外层for循环控制比较的趟数
 * 3、内存for循环控制每趟比较的次数
 * 4、维护一个变量flag，标识每趟是否进行了位置互换，如果没有说明已经有序无需继续循环比较
 * <p>
 * 第 1 趟：[1, 8, 9, 3, 5, 6]
 * 第 2 趟：[1, 8, 3, 5, 6, 9]
 * 第 3 趟：[1, 3, 5, 6, 8, 9]
 * 冒泡排序结果：[1, 3, 5, 6, 8, 9]
 * </p>
 *
 * @author kaifeng
 */
public class BubbleSort {

    public static void main( String[] args ) {
        //待排序数组
        int[] arrays = {1, 8, 9, 3, 5, 6};
        System.out.println("冒泡排序结果：" + Arrays.toString(sort(arrays)));
    }


    public static int[] sort( int[] arrays ) {
        //外层循环控制排序的趟数
        for (int i = 0; i < arrays.length - 1; i++) {
            System.out.println("第 " + (i + 1) + " 趟：" + Arrays.toString(arrays));
            // 设定一个标记，若为true，则表示此次循环没有进行交换，说明待排序列已经有序，排序已经完成。
            boolean flag = true;
            //内层循环是当前趟数需要比较的次数
            for (int j = 0; j < arrays.length - i - 1; j++) {
                int temp = arrays[j];
                //与后一位进行比较，如果比后边大则互换位置
                if (arrays[j] > arrays[j + 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    //发生了位置交换
                    flag = false;
                }
            }
            //如果比较完一趟没有发生置换，说明已经排好序了
            if (flag) {
                break;
            }
        }
        return arrays;
    }
}
