package com.lkf.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/5
 */
public class SetToArray {
    public static void main(String[] args) {
        Set<String> vowelsSet = new HashSet<>();
        vowelsSet.add("h");
        vowelsSet.add("e");
        vowelsSet.add("l");
        vowelsSet.add("l");
        vowelsSet.add("o");

        //将 set 转换为 array
        String strArray[] = vowelsSet.toArray(new String[vowelsSet.size()]);
        System.out.println(Arrays.toString(strArray));
    }
}
