package com.zhang;

import com.google.gson.Gson;
import com.zhang.proj.Person;
import org.junit.jupiter.api.Test;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/21
 */
public class TestJson {

    @Test
    public void test01(){

        Person person = new Person(1,"星儿");
        Gson gson=new Gson();
        String s = gson.toJson(person);
        System.out.println(s);
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }

}
