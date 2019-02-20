package com.lkf.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/2/17
 */
public class PhoneNumber {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    public static void main(String[] args) {
        // 1）初始化
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        // 2）put存储
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        // 3）get获取
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
