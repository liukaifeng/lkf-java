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
        System.out.println("第二最小值：" + method1(arr));
    }

    /**
     * 在一次遍历中找到最小的两个数，时间复杂度为O(n)
     * 定义一个长度为2的数组，用来存放两个最小的数字，默认两个元素值都为 Integer.MAX_VALUE
     *
     * @param arr 原始数组
     */
    public static Integer method1(int[] arr) {
        //存放最小的两个数值
        Integer[] minNum = new Integer[2];
        //最小数值
        minNum[0] = Integer.MAX_VALUE;
        //第二小数值
        minNum[1] = Integer.MAX_VALUE;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //如果（minNum[0]）预设最小值，大于原数组索引为 i 的元素，则将该元素赋值给 minNum[0]
            //将 minNum[0] 值赋给 minNum[1]（第二最小值）
            if (minNum[0] > arr[i]) {
                minNum[1] = minNum[0];
                minNum[0] = arr[i];
            } else if (minNum[1] > arr[i]) {
                minNum[1] = arr[1];
            }
        }
        return minNum[1];
    }

    /**
     * 在一次遍历中找到最小的两个数，时间复杂度为O(n)
     * <p>
     * 初始化2个最小值:min1、min2
     * 遍历所有元素,如果当前元素小于min1,那么将更新 min1、min2.如果大于 min1 小于 min2 直接更新 min2
     */
    public static int method2(int[] arr) {
        int min1; //存储最小的数值
        int min2; //存储第二小的数值

        //判断前两个大小
        if (arr[0] >= arr[1]) {
            min2 = arr[0];
            min1 = arr[1];
        } else {
            min2 = arr[1];
            min1 = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            //比最小值小的情况
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            }
            //大于最小值且小于第二最小值
            if (arr[i] > min1 && arr[i] < min2) {
                min2 = arr[i];
            }
        }
        return min2;
    }

}



