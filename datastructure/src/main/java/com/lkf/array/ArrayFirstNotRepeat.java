package com.lkf.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/17
 */
public class ArrayFirstNotRepeat {


    private static int firstNonRepeating(int[] arr, int n) {
        //外层循环逐个遍历元素
        for (int i = 0; i < n; i++) {
            int j;
            //内层循环判断元素是否存在
            for (j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == n) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * @param arr 数组
     * @param n   数组长度
     */
    public static int findFirstNotRepeat(int[] arr, int n) {
        //对每个元素进行计数
        Map<Integer, Integer> map = new LinkedHashMap<>();
        //遍历数组
        for (int i = 0; i < n; i++) {
            //如果map中存在该元素，则对应的数量加1
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], value + 1);
            } else {
                //每个元素初始次数为0
                map.put(arr[i], 0);
            }
        }
        //值为0的便是不重复的数
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(0)) {
                return key;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {9, 4, 9, 6, 7, 4};
        int n = arr.length;

        System.out.print(findFirstNotRepeat(arr, n));
    }

}
