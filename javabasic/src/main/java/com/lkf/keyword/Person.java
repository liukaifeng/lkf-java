package com.lkf.keyword;

import lombok.Data;
import lombok.ToString;

@Data
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
        this.age = 10;
    }

    public Person(String name, Integer sex, Integer age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void whoAmI() {
        System.out.println("我是父类Person");
    }
}
