package com.lkf.array;

import java.util.Arrays;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/17
 */
public class ArrayRemove {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates2(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (j + 1 < len) {
                if (nums[j] != nums[j + 1]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    
}
