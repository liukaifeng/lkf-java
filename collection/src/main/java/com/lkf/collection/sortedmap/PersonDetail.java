package com.lkf.collection.sortedmap;

import java.time.LocalDate;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/13
 */
public class PersonDetail {
    String name;
    LocalDate birthday;
    String address;

    public PersonDetail(String name, LocalDate birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + ", from " + this.address;
    }
}
