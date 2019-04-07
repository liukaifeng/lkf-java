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
public class ArrayToList {
    public static void main(String[] args) {

        String[] hellos = {"h","e","l","l","o"};
        List<String> hellosList = Arrays.asList(hellos);
        System.out.println("Arrays.asList 数组转为列表："+hellosList);

        /**
         * List是由数组支持的，我们不能做结构修改
         * 以下两个语句都将抛出java.lang.UnsupportedOperationException
         */
        //hellosList.remove("l");
        //hellosList.clear();

        //使用for循环将元素从数组复制到列表，可以安全地修改列表
        List<String> myList = new ArrayList<>();
        for(String s : hellos){
            myList.add(s);
        }
        System.out.println("for 循环遍历元素添加到新列表："+myList);
        myList.clear();
    }
}
