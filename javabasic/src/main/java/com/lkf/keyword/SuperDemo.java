package com.lkf.keyword;

public class SuperDemo {
    public static void main(String[] args) {
        //全量构造函数
        Student student = new Student("张胖子", 1, 10, "15062598456", "中国");
        //部分属性的构造函数
        Student student1 = new Student("张胖子", 1);
        student1.setMobile("18695468795");
        student1.setAddress("中国北京");
    }
}
