package com.zhang;

import java.util.Vector;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/9
 */
public class Test {
    public static void main(String[]args) {
        Vector<String> list= new Vector<String>();
        list.add("aa");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        for(String s:list)
        {
            if(s.equals("b"))
            {
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
