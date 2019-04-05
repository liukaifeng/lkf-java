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
public class SetCommonOperations {
    public static void main(String args[]) {
        Set<String> vowels = new HashSet<>();

        //add
        vowels.add("H");
        vowels.add("E");
        vowels.add("L");

        System.out.println("vowels:" + Arrays.toString(vowels.toArray()));

        Set<String> set = new HashSet<>();
        set.add("O");
        set.add("U");

        //将集合Set 中的元素全部添加到集合 vowels 中
        vowels.addAll(set);
        System.out.println("vowels.addAll(set):" + Arrays.toString(vowels.toArray()));

        //清空set
        set.clear();

        //set size
        System.out.println("vowels size : " + vowels.size());

        vowels.clear();
        vowels.add("E");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        System.out.println("判断集合 vowels 中是否包含 E = " + vowels.contains("E"));

    }
}
