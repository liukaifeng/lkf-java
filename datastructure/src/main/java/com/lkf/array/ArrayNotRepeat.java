package com.lkf.array;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/17
 */
public class ArrayNotRepeat {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 6, 5};
        System.out.println(findNotRepeat(arr));

    }

    public static int findNotRepeat(int[] arr) {
        int len = arr.length;
        int res = -1;
        if (len > 1) {
            res = arr[0];
            for (int i = 1; i < len; i++) {
                res = res ^ arr[i];
            }
        }
        return res;
    }

    public static void getTheTwo(int[] arr,int num1,int num2){
        if(arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int tmp = arr[0];
        for(int i = 1; i < len; i++){
            tmp ^= arr[i];
        }
        int index = findFirstOne(tmp);
        for(int i = 0; i < len; i++){
            if(isOne(arr[i],index)){
                num1 ^= arr[i];
            }else{
                num2 ^= arr[i];
            }
        }
    }
    public static int findFirstOne(int n){
        int i = 0;
        while((n & 1) == 0){
            i++;
            n = n >> 1;
        }
        return i;
    }
    public static boolean isOne(int num,int index){
        return ((num >> index) & 1) == 1;
    }



}
