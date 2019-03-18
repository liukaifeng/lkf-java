package com.lkf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/13
 */
public class SearchDemo {
    public static void main(String[] args) {
        int[] nums = {0, 4, 6, 7, 8, 9, 12, 17, 23, 35};
        int target = 35;
        System.out.println(binarySearch2(nums, target));

    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){

        }
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left:" + left + "   right:" + right + " mid:" + mid + "");
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }
}
