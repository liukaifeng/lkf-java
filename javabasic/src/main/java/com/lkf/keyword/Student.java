package com.lkf.keyword;

public class Student extends Person {

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 联系地址
     */
    private String address;

    public Student(String name, Integer sex, Integer age, String mobile, String address) {
        //调用父类三个参数的构造函数
        super(name, sex, age);
        this.mobile = mobile;
        this.address = address;
    }

    public Student(String name, Integer sex){
        //调用父类两个参数的构造函数
        super(name,sex);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
