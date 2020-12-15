package com.zhang;

import lombok.Data;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/15
 */
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private int score;

    public Student(int id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
