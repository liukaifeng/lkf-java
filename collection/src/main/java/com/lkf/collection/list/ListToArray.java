package com.lkf.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/6
 */
public class ListToArray {
    public static void main(String[] args) {

        List<String> letters = new ArrayList<String>();
        letters.add("A");
        letters.add("B");
        letters.add("C");

        //将列表转换为数组
        String[] strArray = new String[letters.size()];
        strArray = letters.toArray(strArray);
        System.out.println(Arrays.toString(strArray));
    }
}
