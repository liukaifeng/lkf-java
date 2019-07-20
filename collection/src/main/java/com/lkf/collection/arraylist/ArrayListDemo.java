package com.lkf.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        for (int i = 0; i < 5; i++) {
            list.add(String.valueOf(i));
        }

//        Iterator iter = list.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        for (String s:list)        {
//            System.out.println(s);
//        }


    }
}
