package com.lkf.collection.map;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/2
 */

import java.util.*;

public class Employees implements Iterable {

    private List<Employee> emps = null;

    public Employees() {
        emps = new ArrayList<>();
        emps.add(new Employee(1001, "张三", "组长", 250000L));
        emps.add(new Employee(1002, "李四", "开发", 150000L));
        emps.add(new Employee(1003, "网二", "测试", 150000L));
    }

    @Override
    public Iterator<Employee> iterator() {
        return emps.iterator();
    }

}


