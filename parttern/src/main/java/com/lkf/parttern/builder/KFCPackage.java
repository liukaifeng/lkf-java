package com.lkf.parttern.builder;

import lombok.Data;
import lombok.ToString;

/**
 * 肯德基套餐实体
 *
 * @author kaifeng
 * @date 2018/8/19
 */
@ToString
@Data
public class KFCPackage {
    /**
     * 食物
     */
    private String food;
    /**
     * 饮料
     */
    private String drink;
}
