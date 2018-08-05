package com.lkf.parttern.proxy.dynamic;

import java.util.UUID;

/**
 * 营业员
 *
 * @author kaifeng
 */
public class SalesPerson {
    private String jobNum = String.valueOf(UUID.randomUUID());

    public String getJobNum() {
        return jobNum;
    }
}
