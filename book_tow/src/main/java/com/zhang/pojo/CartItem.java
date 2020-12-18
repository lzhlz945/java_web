package com.zhang.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.pojo
 * @date:2020/12/18
 */
@Data
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}
