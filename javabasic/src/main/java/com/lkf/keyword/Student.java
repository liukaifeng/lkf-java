package com.lkf.keyword;

import lombok.Data;
import lombok.ToString;

@Data
public class Student extends Person {

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 名字
     */
    private String name;
    public  Student(){}

    public Student(String parentName,String name, Integer sex, Integer age, String mobile, String address) {
        //引用父类实例变量
        super.setName(parentName);
        super.setSex(sex);
        super.setAge(age);
        this.name=name;
        this.mobile = mobile;
        this.address = address;
    }

    @Override
    public void whoAmI(){
        super.whoAmI();
        System.out.println("我是子类Student");
    }


}
