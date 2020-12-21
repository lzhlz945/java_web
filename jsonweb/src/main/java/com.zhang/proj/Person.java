package com.zhang.proj;

import lombok.Data;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.proj
 * @date:2020/12/21
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
