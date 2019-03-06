package com.lkf.array;

/**
 * 找出数组中第二小的数值
 * 1、把数组排序。排序算法中效率最高的时间复杂度为O(nlnogn)
 * <p>
 * 2、遍历数组,找出最小的两个数字。时间复杂度为O(n)
 *
 * @author kaifeng
 * @date 2019/3/5
 */
public class ArraySecondMinNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 7, 66, 5, 4, 3, 2, 9, 0, 1, 4};
        System.out.println(method(arr));
        System.out.println(method2(arr));
    }

    public static int method(int[] arr) {
        //存放最小的两个数值
        Integer[] minNum = new Integer[2];
        //最小数值
        minNum[0] = Integer.MAX_VALUE;
        //第二小数值
        minNum[1] = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (minNum[0] > arr[i]) {
                minNum[1] = minNum[0];
                minNum[0] = arr[i];
            } else if (minNum[1] > arr[i]) {
                minNum[1] = arr[1];
            }
        }
        return minNum[1];
    }

    public static int method2(int[] arr) {

        int min; //存储最小的数值
        int min2; //存储第二小的数值

        //判断前两个大小
        if (arr[0] >= arr[1]) {
            min2 = arr[0];
            min = arr[1];
        } else {
            min2 = arr[1];
            min = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            //比最小值小的情况
            if (arr[i] < min) {
                min2 = min;
                min = arr[i];
            }
            //大于最小值且小于第二最小值
            if (arr[i]>min&&arr[i]<min2) {
                min2 = arr[i];
            }
        }
        return min2;
    }

}



