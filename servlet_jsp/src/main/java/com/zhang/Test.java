package com.zhang;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/15
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"x"+j+"="+i*j);
            }
            System.out.println();
        }
        System.out.println("_____________________________________________");
        for (int i = 9; i >=1; i--) {
            for (int j = 9; j >=i ; j--) {
                System.out.print(i+"x"+j+"="+i*j);
            }
            System.out.println();
        }

    }
}
