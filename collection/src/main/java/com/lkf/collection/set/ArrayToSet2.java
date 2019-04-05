package com.lkf.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/5
 */
public class ArrayToSet2 {
    public static void main(String[] args) {

        String[] vowels = {"h", "e", "l", "l", "o"};

        Set<String> vowelsSet = new HashSet<>();
        Collections.addAll(vowelsSet, vowels);
        System.out.println(vowelsSet);
    }
}
