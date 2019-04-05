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
public class ArrayToSet {
    public static void main(String[] args) {

        String[] vowels = {"h", "e", "l", "l", "o"};

        Set<String> vowelsSet = new HashSet(Arrays.asList(vowels));
        System.out.println(vowelsSet);
    }
}
