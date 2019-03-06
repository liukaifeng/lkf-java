package com.lkf.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * <p>
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * @author kaifeng
 */
public class InsertSort {
    public static void main( String[] args ) {

        int[] arrays = {1, 8, 9, 3, 5, 6};

        System.out.println("结果：" + Arrays.toString(insertSort2(arrays)));
    }

    public static int[] sort( int[] arr ) {
        for (int i = 1; i < arr.length; i++) {
            //准备插入的值
            int insertVal = arr[i];
            //预想插入的位置
            int index = i - 1;
            //如果插入的数比预想插入的位置的数小
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

    public static int[] sort1( int[] arr ) {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
            System.out.println("第 " + i + " 趟：" + Arrays.toString(arr));

        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @return
     * @paramarr
     */
    private static int[] insertSort( int[] arr ) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //外层循环控制比较趟数
        for (int i = 1; i < arr.length; i++) {
            //内层循环控制每趟比较次数
            for (int j = i; j > 0; j--) {
                //如果当前数小于前面的数，则交换位置
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
            System.out.println(String.format("第 %s 趟 %s：%s", i, arr[i], Arrays.toString(arr)));
        }
        return arr;
    }

    private static int[] insertSort2( int[] arr ) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
