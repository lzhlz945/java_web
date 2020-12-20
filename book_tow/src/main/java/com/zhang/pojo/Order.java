package com.zhang.pojo;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String bookName;
    private int count;
    private int bookId;
}
