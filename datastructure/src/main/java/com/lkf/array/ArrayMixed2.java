package com.lkf.array;

import java.util.*;

/**
 * leetcode-350
 * 两个数组的交集 II
 *
 * @author kaifeng
 * @date 2019/3/18
 */
public class ArrayMixed2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.print(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(nums1.length + nums2.length);
        //遍历数组1
        for (Integer num : nums1) {
            //如果不存在，添加该元素到map，并计数为1;如果存在计数累加1
            map.merge(num, 1, (a, b) -> a + b);
        }
        for (Integer num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return resList.stream().mapToInt(integer -> integer).toArray();
    }
}
